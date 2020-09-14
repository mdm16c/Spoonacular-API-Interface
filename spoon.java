import javax.swing.*;
import java.awt.event.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import org.json.*;
import java.awt.Desktop;
import java.io.File;
import java.net.URI;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.io.FileOutputStream; 
import java.io.PrintStream;

public class spoon {

    private static JFrame f = new JFrame("Spoonacular API Interface");

    public static void createAndShowGUI() throws IOException {

        // setup comboBox, submit button, and api key field
        JComboBox<String> cb = new JComboBox<>(new String[] { "Select an Option", "Search for a Recipe",
                "Get a Random Recipe", "Get a Recipe based on Nutrients", "Get a Recipe based on Ingredients" });
        cb.setBounds(25, 25, 200, 25);

        JButton submitButton = new JButton("Get Recipe!");
        submitButton.setBounds(250, 25, 100, 25);

        JLabel apiKeyLabel = new JLabel("API Key:");
        apiKeyLabel.setBounds(25, 325, 50, 25);

        String apiKey = readAPIKey();
        JTextField apiKeyTextField = new JTextField(apiKey);
        apiKeyTextField.setBounds(75, 325, 275, 25);

        // setup all param options

        // search
        JTextField searchTextField = new JTextField("ex. \"spaghetti and meatballs\"");
        searchTextField.setBounds(25, 75, 325, 25);
        searchTextField.setVisible(false);

        // random
        JLabel randomLabel = new JLabel("No parameters needed. Just get your recipe!");
        randomLabel.setBounds(25, 75, 325, 25);
        randomLabel.setVisible(false);

        // nutrients
        JSpinner maxCalsSpinner = new JSpinner();
        maxCalsSpinner.setBounds(25, 100, 75, 50);
        maxCalsSpinner.setVisible(false);
        JLabel maxCalsLabel = new JLabel("Max Calories");
        maxCalsLabel.setBounds(25, 75, 75, 25);
        maxCalsLabel.setVisible(false);

        JSpinner maxCarbsSpinner = new JSpinner();
        maxCarbsSpinner.setBounds(150, 100, 75, 50);
        maxCarbsSpinner.setVisible(false);
        JLabel maxCarbsLabel = new JLabel("Max Carbs");
        maxCarbsLabel.setBounds(150, 75, 75, 25);
        maxCarbsLabel.setVisible(false);

        JSpinner maxSugarSpinner = new JSpinner();
        maxSugarSpinner.setBounds(275, 100, 75, 50);
        maxSugarSpinner.setVisible(false);
        JLabel maxSugarLabel = new JLabel("Max Sugar");
        maxSugarLabel.setBounds(275, 75, 75, 25);
        maxSugarLabel.setVisible(false);

        JSpinner minProteinSpinner = new JSpinner();
        minProteinSpinner.setBounds(25, 200, 75, 50);
        minProteinSpinner.setVisible(false);
        JLabel minProteinLabel = new JLabel("Min Protein");
        minProteinLabel.setBounds(25, 175, 75, 25);
        minProteinLabel.setVisible(false);

        JSpinner maxFatSpinner = new JSpinner();
        maxFatSpinner.setBounds(150, 200, 75, 50);
        maxFatSpinner.setVisible(false);
        JLabel maxFatLabel = new JLabel("Max Fat");
        maxFatLabel.setBounds(150, 175, 75, 25);
        maxFatLabel.setVisible(false);

        JSpinner maxSatFatSpinner = new JSpinner();
        maxSatFatSpinner.setBounds(275, 200, 75, 50);
        maxSatFatSpinner.setVisible(false);
        JLabel maxSatFatLabel = new JLabel("Max Sat Fat");
        maxSatFatLabel.setBounds(275, 175, 75, 25);
        maxSatFatLabel.setVisible(false);

        JLabel noPrefLabel = new JLabel("For no preference, leave value at 0.");
        noPrefLabel.setBounds(90, 275, 195, 25);
        noPrefLabel.setVisible(false);

        // ingredients
        JTextField ingredientsTextField = new JTextField("ex. \"beef,sugar,salt,onion powder\" or ex. \"beef\"");
        ingredientsTextField.setBounds(25, 75, 325, 25);
        ingredientsTextField.setVisible(false);

        // add everything to the frame
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.add(cb);
        f.add(submitButton);
        f.add(apiKeyLabel);
        f.add(apiKeyTextField);
        f.add(searchTextField);
        f.add(randomLabel);
        f.add(maxCalsSpinner);
        f.add(maxCalsLabel);
        f.add(maxCarbsSpinner);
        f.add(maxCarbsLabel);
        f.add(maxSugarSpinner);
        f.add(maxSugarLabel);
        f.add(minProteinSpinner);
        f.add(minProteinLabel);
        f.add(maxFatSpinner);
        f.add(maxFatLabel);
        f.add(maxSatFatSpinner);
        f.add(maxSatFatLabel);
        f.add(noPrefLabel);
        f.add(ingredientsTextField);
        f.setLayout(null);
        f.setSize(390, 400);
        f.setVisible(true);

        // combo box change listener
        cb.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int index = cb.getSelectedIndex();
                if (index == 0) {
                    searchTextField.setVisible(false);
                    randomLabel.setVisible(false);
                    maxCalsSpinner.setVisible(false);
                    maxCalsLabel.setVisible(false);
                    maxCarbsSpinner.setVisible(false);
                    maxCarbsLabel.setVisible(false);
                    maxSugarSpinner.setVisible(false);
                    maxSugarLabel.setVisible(false);
                    minProteinSpinner.setVisible(false);
                    minProteinLabel.setVisible(false);
                    maxFatSpinner.setVisible(false);
                    maxFatLabel.setVisible(false);
                    maxSatFatSpinner.setVisible(false);
                    maxSatFatLabel.setVisible(false);
                    noPrefLabel.setVisible(false);
                    ingredientsTextField.setVisible(false);
                }
                else if (index == 1) {
                    searchTextField.setVisible(true);
                    randomLabel.setVisible(false);
                    maxCalsSpinner.setVisible(false);
                    maxCalsLabel.setVisible(false);
                    maxCarbsSpinner.setVisible(false);
                    maxCarbsLabel.setVisible(false);
                    maxSugarSpinner.setVisible(false);
                    maxSugarLabel.setVisible(false);
                    minProteinSpinner.setVisible(false);
                    minProteinLabel.setVisible(false);
                    maxFatSpinner.setVisible(false);
                    maxFatLabel.setVisible(false);
                    maxSatFatSpinner.setVisible(false);
                    maxSatFatLabel.setVisible(false);
                    noPrefLabel.setVisible(false);
                    ingredientsTextField.setVisible(false);
                }
                else if (index == 2) {
                    searchTextField.setVisible(false);
                    randomLabel.setVisible(true);
                    maxCalsSpinner.setVisible(false);
                    maxCalsLabel.setVisible(false);
                    maxCarbsSpinner.setVisible(false);
                    maxCarbsLabel.setVisible(false);
                    maxSugarSpinner.setVisible(false);
                    maxSugarLabel.setVisible(false);
                    minProteinSpinner.setVisible(false);
                    minProteinLabel.setVisible(false);
                    maxFatSpinner.setVisible(false);
                    maxFatLabel.setVisible(false);
                    maxSatFatSpinner.setVisible(false);
                    maxSatFatLabel.setVisible(false);
                    noPrefLabel.setVisible(false);
                    ingredientsTextField.setVisible(false);
                }
                else if (index == 3) {
                    searchTextField.setVisible(false);
                    randomLabel.setVisible(false);
                    maxCalsSpinner.setVisible(true);
                    maxCalsLabel.setVisible(true);
                    maxCarbsSpinner.setVisible(true);
                    maxCarbsLabel.setVisible(true);
                    maxSugarSpinner.setVisible(true);
                    maxSugarLabel.setVisible(true);
                    minProteinSpinner.setVisible(true);
                    minProteinLabel.setVisible(true);
                    maxFatSpinner.setVisible(true);
                    maxFatLabel.setVisible(true);
                    maxSatFatSpinner.setVisible(true);
                    maxSatFatLabel.setVisible(true);
                    noPrefLabel.setVisible(true);
                    ingredientsTextField.setVisible(false);
                }
                else {
                    searchTextField.setVisible(false);
                    randomLabel.setVisible(false);
                    maxCalsSpinner.setVisible(false);
                    maxCalsLabel.setVisible(false);
                    maxCarbsSpinner.setVisible(false);
                    maxCarbsLabel.setVisible(false);
                    maxSugarSpinner.setVisible(false);
                    maxSugarLabel.setVisible(false);
                    minProteinSpinner.setVisible(false);
                    minProteinLabel.setVisible(false);
                    maxFatSpinner.setVisible(false);
                    maxFatLabel.setVisible(false);
                    maxSatFatSpinner.setVisible(false);
                    maxSatFatLabel.setVisible(false);
                    noPrefLabel.setVisible(false);
                    ingredientsTextField.setVisible(true);
                }
            }
        });

        // submit button press listener
        submitButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                if (apiKeyTextField.getText().length() < 1) {
                    JOptionPane.showMessageDialog(f,"Please enter your API Key for the Spoonacular API.");
                    throw new RuntimeException("API Key field is empty");
                }

                try {
                    saveAPIKey(apiKeyTextField.getText());
                } catch (IOException e1) {
                    e1.printStackTrace();
                }

                int index = cb.getSelectedIndex();
                if (index == 1) {
                    try {
                        searchCall(apiKeyTextField.getText(),searchTextField.getText());
                    } catch (IOException e1) {
                        e1.printStackTrace();
                    }
                }
                else if (index == 2) {
                    try {
                        randomCall(apiKeyTextField.getText());
                    } catch (IOException e1) {
                        e1.printStackTrace();
                    }
                }
                else if (index == 3) {
                    try {
                        nutrientsCall(apiKeyTextField.getText(), maxCalsSpinner.getValue().toString(), maxCarbsSpinner.getValue().toString(), maxSugarSpinner.getValue().toString(), minProteinSpinner.getValue().toString(), maxFatSpinner.getValue().toString(), maxSatFatSpinner.getValue().toString());
                    } catch (IOException e1) {
                        e1.printStackTrace();
                    }
                }
                else if (index == 4) {
                    try {
                        ingredientsCall(apiKeyTextField.getText(), ingredientsTextField.getText());
                    } catch (IOException e1) {
                        e1.printStackTrace();
                    }
                }
                else {
                    JOptionPane.showMessageDialog(f,"Please select an option.");
                }
            }
        });
    }

    private static void saveAPIKey(String apiKey) throws IOException {
        String currentDir = System.getProperty("user.dir");
        File f = new File(currentDir+"\\api.settings");
        if (!f.exists()) {
            f.createNewFile();
        }
        writeFile(f.getAbsolutePath(), apiKey);
    }

    private static String readAPIKey() throws IOException {
        String currentDir = System.getProperty("user.dir");
        File f = new File(currentDir+"\\api.settings");
        String content = "";
        if (f.exists()) {
            content = readFile(f.getAbsolutePath());
        }
        return content;
    }

    private static String readFile(String filePath) throws IOException {
        String content = "";
        content = new String(Files.readAllBytes(Paths.get(filePath)));
        return content;
    }

    private static void writeFile(String filePath, String content) throws IOException {
        try (PrintStream out = new PrintStream(new FileOutputStream(filePath))) {
            out.print(content);
            out.close();
        }
    }

    private static void openURLInBrowser(String url) {
        try {
            URI uri= new URI(url);
            java.awt.Desktop.getDesktop().browse(uri);
        }
        catch (Exception e) {
            JOptionPane.showMessageDialog(f,"Failed to open link in browser.");
            e.printStackTrace();
        }
    }

    private static String getURLById(String apikey, int id) throws IOException {

        //setup connection
        URL url = new URL("https://api.spoonacular.com/recipes/"+id+"/information?apiKey="+apikey+"&includeNutrition=false");
        
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod("GET");

        //check that API call did not fail
        if (con.getResponseCode() != 200) {
            con.disconnect();
            JOptionPane.showMessageDialog(f,"API Call Failed.");
            throw new RuntimeException("API call failed!");
        }

        //retrieve info
        BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
        String inputLine;
        StringBuffer content = new StringBuffer();
        while ((inputLine = in.readLine()) != null) {
            content.append(inputLine);
        }

        //close connections
        in.close();
        con.disconnect();

        //save JSON to string
        String jsonString = content.toString();
        JSONObject obj = new JSONObject(jsonString);
        String recipeURLString = obj.getString("sourceUrl");

        return recipeURLString;
    }

    private static void searchCall(String apikey, String searchContent) throws IOException {

        //sanitize user input
        searchContent = searchContent.toLowerCase();
        
        //setup connection
        URL url = new URL("https://api.spoonacular.com/recipes/complexSearch?apiKey="+apikey+"&query="+searchContent+"&number=1");
        
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod("GET");

        //check that API call did not fail
        if (con.getResponseCode() != 200) {
            con.disconnect();
            JOptionPane.showMessageDialog(f,"API Call Failed.");
            throw new RuntimeException("API call failed!");
        }

        //retrieve info
        BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
        String inputLine;
        StringBuffer content = new StringBuffer();
        while ((inputLine = in.readLine()) != null) {
            content.append(inputLine);
        }

        //close connections
        in.close();
        con.disconnect();

        //save JSON to string
        String jsonString = content.toString();
        JSONObject obj = new JSONObject(jsonString);
        if (obj.getInt("totalResults") == 0) {
            JOptionPane.showMessageDialog(f,"The searched recipe does not exist.");
            throw new RuntimeException("Recipe does not exist.");
        }
        int id = obj.getJSONArray("results").getJSONObject(0).getInt("id");

        //get url for recipe
        String recipeURL = getURLById(apikey,id);

        //open URL
        openURLInBrowser(recipeURL);
    }

    private static void randomCall(String apikey) throws IOException {
        
        //setup connection
        URL url = new URL("https://api.spoonacular.com/recipes/random?apiKey="+apikey+"&number=1");
        
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod("GET");

        //check that API call did not fail
        if (con.getResponseCode() != 200) {
            con.disconnect();
            JOptionPane.showMessageDialog(f,"API Call Failed.");
            throw new RuntimeException("API call failed!");
        }

        //retrieve info
        BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
        String inputLine;
        StringBuffer content = new StringBuffer();
        while ((inputLine = in.readLine()) != null) {
            content.append(inputLine);
        }

        //close connections
        in.close();
        con.disconnect();

        //save JSON to string
        String jsonString = content.toString();
        JSONObject obj = new JSONObject(jsonString);
        String recipeURL = obj.getJSONArray("recipes").getJSONObject(0).getString("sourceUrl");

        //open URL
        openURLInBrowser(recipeURL);
    }

    private static void nutrientsCall(String apikey, String cals, String carbs, String sugar, String protein, String fat, String satFat) throws IOException {
        
        //format values
        if (cals.equals("0")) {
            cals = "";
        }
        else {
            cals = "&maxCalories="+cals;
        }
        if (carbs.equals("0")) {
            carbs = "";
        }
        else {
            carbs = "&maxCarbs="+carbs;
        }
        if (sugar.equals("0")) {
            sugar = "";
        }
        else {
            sugar = "&maxSugar="+sugar;
        }
        if (protein.equals("0")) {
            protein = "";
        }
        else {
            protein = "&minProtein="+protein;
        }
        if (fat.equals("0")) {
            fat = "";
        }
        else {
            fat = "&maxFat="+fat;
        }
        if (satFat.equals("0")) {
            satFat = "";
        }
        else {
            satFat = "&maxSaturatedFat="+satFat;
        }

        //setup connection
        URL url = new URL("https://api.spoonacular.com/recipes/findByNutrients?apiKey="+apikey+cals+carbs+sugar+protein+fat+satFat+"&number=1");

        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod("GET");

        //check that API call did not fail
        if (con.getResponseCode() != 200) {
            con.disconnect();
            JOptionPane.showMessageDialog(f,"API Call Failed.");
            throw new RuntimeException("API call failed!");
        }

        //retrieve info
        BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
        String inputLine;
        StringBuffer content = new StringBuffer();
        while ((inputLine = in.readLine()) != null) {
            content.append(inputLine);
        }

        //close connections
        in.close();
        con.disconnect();

        //save JSON to string
        String jsonString = content.toString();

        if (jsonString.equals("[]")) {
            JOptionPane.showMessageDialog(f,"There are no recipes with these nutrient requirements.");
            throw new RuntimeException("Recipe does not exist.");
        }

        jsonString = jsonString.substring(1, jsonString.length()-1);
        jsonString = jsonString.trim();

        JSONObject obj = new JSONObject(jsonString);
        int id = obj.getInt("id");

        //get url for recipe
        String recipeURL = getURLById(apikey,id);

        //open URL
        openURLInBrowser(recipeURL);
    }

    private static void ingredientsCall(String apikey, String searchContent) throws IOException {

        //sanitize ingredients list
        if (searchContent.length() > 0) {
            searchContent = searchContent.trim();
            searchContent = searchContent.toLowerCase();
            boolean checkAgain = false;
            if (searchContent.charAt(0) == ',') {
                searchContent = searchContent.substring(1);
                checkAgain = true;
            }
            if (searchContent.charAt(searchContent.length()-1) == ',') {
                searchContent = searchContent.substring(0, searchContent.length()-1);
                checkAgain = true;
            }
            if (checkAgain) {
                searchContent = searchContent.trim();
            }
            for (int i = 1; i < searchContent.length()-1; i++) {
                if (searchContent.charAt(i) == ' ') {
                    if (searchContent.charAt(i-1) == ',' || searchContent.charAt(i+1) == ',' || searchContent.charAt(i-1) == ' ') {
                        searchContent = searchContent.substring(0, i) + searchContent.substring(i+1);
                        i--;
                        if (searchContent.charAt(i+1) == ',') {
                            i--;
                        }
                    }
                }
                if (searchContent.charAt(i) == ',') {
                    if (searchContent.charAt(i-1) == ',') {
                        searchContent = searchContent.substring(0, i) + searchContent.substring(i+1);
                        i--;
                    }
                }
            }
            searchContent = searchContent.replace(' ', '_');
            searchContent = "&ingredients=" + searchContent;
        }

        //setup connection
        URL url = new URL("https://api.spoonacular.com/recipes/findByIngredients?apiKey="+apikey+searchContent+"&number=1&ranking=2");
        
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod("GET");

        //check that API call did not fail
        if (con.getResponseCode() != 200) {
            con.disconnect();
            JOptionPane.showMessageDialog(f,"API Call Failed.");
            throw new RuntimeException("API call failed!");
        }

        //retrieve info
        BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
        String inputLine;
        StringBuffer content = new StringBuffer();
        while ((inputLine = in.readLine()) != null) {
            content.append(inputLine);
        }

        //close connections
        in.close();
        con.disconnect();

        //save JSON to string
        String jsonString = content.toString();

        if (jsonString.equals("[]")) {
            JOptionPane.showMessageDialog(f,"There are no recipes with these ingredient requirements.");
            throw new RuntimeException("Recipe does not exist.");
        }

        jsonString = jsonString.substring(1, jsonString.length()-1);
        jsonString = jsonString.trim();

        JSONObject obj = new JSONObject(jsonString);
        int id = obj.getInt("id");

        //get url for recipe
        String recipeURL = getURLById(apikey,id);

        //open URL
        openURLInBrowser(recipeURL);
    }

    public static void main(String[] args) throws IOException {
        createAndShowGUI();
    }
}
# Spoonacular-API-Interface
A simple, user friendly Java GUI for the Spoonacular REST API

## Motivation
I started this project in an effort to really expand my knowledge of what was possible with REST API calls, and I also was curious to see how Java GUIs work. I was not sure exactly what I wanted to do until one night when I was making dinner and only had a few ingredients. I was not sure what I could make out of them, so I did some research into APIs with this functionality and found Spoonacular. I regularly use this app to determine what to eat just to keep some variety in my cooking.

## Code style
[![js-standard-style](https://img.shields.io/badge/code%20style-standard-brightgreen.svg?style=flat)](https://github.com/feross/standard)
 
## Example Usage
![Spoonacular Example Usage gif](https://s8.gifyu.com/images/ezgif-3-3a9589a1441b.gif)

## Technology Used
[Spoonacular API](https://spoonacular.com/food-api)

## Features
This project is unique in that while the Spoonacular API is very powerful, it does not have a way to use it consistently on their website. With my implementation, there now exists an interface for the API that I was not able to find anywhere else.

## Installation
1. Download or clone this repository into an empty directory
2. Make an account with Spoonacular to recieve your API Key
3. Run the **Spoonacular_API_Interface.jar** file
4. Refer to the section below for usage

## Usage Walkthrough
* With the **Search for a Recipe** option selected, the user can search anything from the example that is shown to [more advanced searches with optional parameters](https://spoonacular.com/food-api/docs#Search-Recipes-Complex)
* With the **Get a Random Recipe** option selected, the user does not need to pass in any parameters as it is completely random
* With the **Get a Recipe based on Nutrients** option selected, the user can set the minimum or maximum of several different common nutrients for 1 serving of the suggested recipe, or for no preference, they can leave the field at 0
* With the **Get a Recipe based on Ingredients** option selected, the user can pass in a comma-separated list of the ingredients they have on hand already. The API will prioritize these ingredients and attempt to minimize any other ingredients that may be needed for a recipe.
* When the user is ready, they can click the **Get Recipe!** button which will search for a recipe that most similarly matches the parameters and open the link to it in their default browser

MIT © [Matthew McCracken](https://github.com/mdm16c)

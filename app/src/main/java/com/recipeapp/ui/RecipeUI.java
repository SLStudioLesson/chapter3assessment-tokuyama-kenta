package com.recipeapp.ui;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import com.recipeapp.datahandler.CSVDataHandler;
import com.recipeapp.datahandler.DataHandler;
import java.util.ArrayList;
import java.util.List;

import com.recipeapp.model.Ingredient;
import com.recipeapp.model.Recipe;

public class RecipeUI {
    private BufferedReader reader;
    private DataHandler dataHandler;

    public RecipeUI(DataHandler dataHandler) {
        reader = new BufferedReader(new InputStreamReader(System.in));
        this.dataHandler = dataHandler;
    }

    public void displayMenu() {

        System.out.println("Current mode: " + dataHandler.getMode());

        while (true) {
            try {
                System.out.println();
                System.out.println("Main Menu:");
                System.out.println("1: Display Recipes");
                System.out.println("2: Add New Recipe");
                System.out.println("3: Search Recipe");
                System.out.println("4: Exit Application");
                System.out.print("Please choose an option: ");

                String choice = reader.readLine();

                switch (choice) {
                    case "1":
                        displayRecipes();
                        break;
                    case "2":
                        addNewRecipe();
                        break;
                    case "3":
                        break;
                    case "4":
                        System.out.println("Exiting the application.");
                        return;
                    default:
                        System.out.println("Invalid choice. Please select again.");
                        break;
                }
            } catch (IOException e) {
                System.out.println("Error reading input from user: " + e.getMessage());
            }
        }
    }

    private void displayRecipes() {

        try {
            ArrayList<Recipe> recipes = dataHandler.readData();

            if (recipes.isEmpty()) {
                System.out.println("No recipes available.");
                return;
            }
            System.out.println();
            System.out.println("Recipes:");
            System.out.println("-----------------------------------");
            for (Recipe recipe : recipes) {
                System.out.println("Recipe Name: " + recipe.getName());
                System.out.print("Main Ingredients: ");
                for (Ingredient ingredient : recipe.getIngredients()) {
                    System.out.print(ingredient.getName() + ",");
                }
                System.out.println();
                System.out.println("-----------------------------------");
            }
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());

        }
    }

    private void addNewRecipe() throws IOException {
        System.out.println("Adding a new recipe.");
        System.out.print("Enter recipe name:");
        String recipeName = reader.readLine();
        recipeName = recipeName + ",";
        String ingredientInput;

        ArrayList<Ingredient> ingredients = new ArrayList<>();
        System.out.println("Enter ingredients (type 'done' when finished):");
        while (true) {
            System.out.print("Ingredient: ");
            ingredientInput = reader.readLine();
            if (ingredientInput.equals("done")) {
                break;
            }
            Ingredient ingredient = new Ingredient(ingredientInput);
            ingredients.add(ingredient);
        }
        Recipe recipe = new Recipe(recipeName, ingredients);
        CSVDataHandler csvDataHandler = new CSVDataHandler();
        csvDataHandler.writeData(recipe);
        System.out.println("Recipe added successfully.");

    }

}

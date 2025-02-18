package com.recipeapp.datahandler;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

import com.recipeapp.model.Ingredient;
import com.recipeapp.model.Recipe;

public class CSVDataHandler implements DataHandler {
    private String filePath;

    public CSVDataHandler() {
        this.filePath = "app/src/main/resources/recipes.csv";
    }

    public CSVDataHandler(String filePath) {
        this.filePath = filePath;
    }

    @Override
    public String getMode() {
        return "CSV";
    }

    @Override
    public ArrayList<Recipe> readData() throws IOException {
        ArrayList<Recipe> recipes = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] lineArray = line.split(",", 2);
                String name = lineArray[0];
                String ingredientsStr = lineArray[1];
                ArrayList<Ingredient> ingredients = new ArrayList<>();
                String[] strArray = ingredientsStr.split(",");
                for (String str : strArray) {
                    Ingredient ingredient1 = new Ingredient(str);
                    ingredients.add(ingredient1);

                }
                Recipe recipe = new Recipe(name, ingredients);
                recipes.add(recipe);

            }
        }
        return recipes;
    }

    @Override
    public void writeData(Recipe name) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath, true))) {
            writer.append(name.getName());
            ArrayList<Ingredient> ingredients = name.getIngredients();
            for (int i = 0; i < ingredients.size(); i++) {
                if (i > 0) {
                    writer.append(", ");
                }
                Ingredient ingredient = ingredients.get(i);
                String ingredientName = ingredient.getName();
                writer.append(ingredientName);
            }
        }
    }

    @Override
    public ArrayList<Recipe> searchData(String keyword) {
        return null;
    }
}

package com.recipeapp.datahandler;

import java.util.ArrayList;

    public interface IDataHandlerable {
    public String getMode();

    public ArrayList<Recipe> readData();

    public void writeData(Recipe recipe);

    public ArrayList<Recipe> searchData(String keyword);
}


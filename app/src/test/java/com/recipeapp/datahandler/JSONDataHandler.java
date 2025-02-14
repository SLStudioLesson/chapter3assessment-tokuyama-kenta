package com.recipeapp.datahandler;

import java.util.ArrayList;

public class JSONDataHandler  implements IDataHandlerable{
    @Override
    public String getMode(){
        return "JSON";
    }

    @Override
    public ArrayList<Recipe> readData(){
            return null;
    }

    @Override
    public void writeData(Recipe recipe){

    }

    @Override
    public ArrayList<Recipe> searchData(String keyword){
        return null;
    }




    
}

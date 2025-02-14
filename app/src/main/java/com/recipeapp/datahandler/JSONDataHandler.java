package com.recipeapp.datahandler;

import java.util.ArrayList;
import com.recipeapp.model.Recipe;


public class JSONDataHandler  implements IDataHandlerable,IDataHandlerable1,IDataHandlerable2,IDataHandlerable3{
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

import com.recipeapp.datahandler.CSVDataHandler;
import com.recipeapp.datahandler.DataHandler;
import com.recipeapp.datahandler.JSONDataHandler;
import com.recipeapp.model.Recipe;
import com.recipeapp.ui.RecipeUI;
import java.io.*;
import java.util.ArrayList;

public class App {

    public static void main(String[] args) {
        String filepath = "recipes.csv";

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            System.out.println("Choose the file format:");
            System.out.println("1. CSV");
            System.out.println("2. JSON");
            System.out.print("Select (1/2): ");
            String choice = reader.readLine();

            DataHandler dataHandler;
            switch (choice) {
                case "1":
                    dataHandler = new CSVDataHandler();
                    break;
                case "2":
                    dataHandler = new JSONDataHandler();

                    break;
                default:
                    dataHandler = new CSVDataHandler();
            }
            RecipeUI recipe = new RecipeUI(dataHandler);
            recipe.displayMenu();

        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
        }

    }

}

import com.recipeapp.datahandler.CSVDataHandler;
import com.recipeapp.datahandler.DataHandler;
import com.recipeapp.datahandler.JSONDataHandler;
import com.recipeapp.ui.RecipeUI;
import java.io.*;

public class App {

    public static void main(String[] args) {

        
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            System.out.println("Choose the file format:");
            System.out.println("1. CSV");
            System.out.println("2. JSON");
            System.out.print("Select (1/2): ");
            String choice = reader.readLine();
            switch (choice) {
                case "1":
                CSVDataHandler csv = new CSVDataHandler();
                break;

                case "2":
                JSONDataHandler jso = new JSONDataHandler();
                System.out.println("Current mode: JSON" );
                break;

                default:
                CSVDataHandler csv2 = new CSVDataHandler();
                System.out.println("Current mode: CSV");

                    break;
            }
        }
            } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
        }
    }

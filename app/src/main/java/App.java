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
            if(choice.equals("1. CSV")){
                CSVDataHandler csv = new CSVDataHandler();
            }else if(choice.equals("2. JSON")){
                    JSONDataHandler jso = new JSONDataHandler();
            }else{
                    CSVDataHandler csv = new CSVDataHandler();
            }
        }
            } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
        }
    }

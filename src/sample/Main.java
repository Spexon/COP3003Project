/**
 * @Author Vladimir Hardy
 * @brief This project gives the user the ability to create and log products to a database. A view of all the products
 * created is displayed on the third tab on the GUI.
 * @TODO change statements into prepared statements
 * @BUGS Clicking products in the item tab before submitting causes a null pointer exception
 */
package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.util.HashMap;

public class Main extends Application {


    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("Production Line");
        primaryStage.setScene(new Scene(root, 423, 403));
        primaryStage.show();

    }

    /**
     * @param args
     * @brief driver class that calls all other classes and launches the GUI
     */
    public static void main(String[] args) {
        launch(args);

        Screen myScreen = new Screen("1980x800", 60, 20);
        MoviePlayer mp = new MoviePlayer("1980x900", "Windows", "Visual");
        System.out.println(mp);
        System.out.println(myScreen + "\n");
        GenericsPractice<Integer, String> mixCell = new GenericsPractice<>();
        GenericsPractice<Integer, Integer> integerCell = new GenericsPractice<>();

        mixCell.setValue(1, "4");
        integerCell.setValue(45, 60);
        int mcType1 = mixCell.getT1Value();
        String mcType2 = mixCell.getT2Value();

        int icType1 = integerCell.getT1Value();
        int icType2 = integerCell.getT2Value();

        System.out.println(mixCell);
        System.out.println(integerCell);
        System.out.println("Numerical value: " + mcType1 + ", String value: " + mcType2);
        System.out.println("First numerical value: " + icType1 + ", Second numerical value: " + icType2 + "\n");

        HashMap<String, String> fruitBowl = new HashMap<>();
        HashMapsPractice.addElements(fruitBowl);
        System.out.println(fruitBowl + "\n");

        System.out.println(RegexPractice.getAnimal("dOg"));
        System.out.println(RegexPractice.checkRhyme("boat"));
    }
}


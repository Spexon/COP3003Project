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
        System.out.println(myScreen);
    }
}


/**
 * @Author Vladimir Hardy
 * @TODO Clean up unused imports for final submission
 */
package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.util.Scanner;

public class Main extends Application {



    @Override
    /**
     * @brief titles a 350 by 318 box with Production Line, and adds the attributes from sample.fxml
     */
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("Production Line");
        primaryStage.setScene(new Scene(root, 350, 318));
        primaryStage.show();

    }

    /**
     * @param args
     * @brief driver class that calls all other classes and launches the GUI
     */
    public static void main(String[] args) {
        launch(args);

        Screen myScreen = new Screen("1980x800",60,20);
        MoviePlayer mp = new MoviePlayer("1980x900","Windows","Visual");
        System.out.println(mp);
        System.out.println(myScreen);
    }
}


/**
 * @Author Vladimir Hardy
 */
package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.sql.*;
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
     * @throws SQLException
     * @brief driver class that calls all other classes and launches the GUI
     */
    public static void main(String[] args) throws SQLException {

        launch(args);

        Scanner input = new Scanner(System.in);
        AudioPlayer ap = new AudioPlayer("", "", "");
        Production pd = new Production();
        pd.produce(input); // <-- this will be displayed in a GUI later
        ap.audioPlayer();
        input.close();
    }
}


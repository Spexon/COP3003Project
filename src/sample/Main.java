package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.sql.DriverManager;
import java.sql.SQLException;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("Hello World");
        primaryStage.setScene(new Scene(root, 300, 275));
        primaryStage.show();
    }


    public static void main(String[] args) throws SQLException {
        launch(args);

        ProductManager pm = new ProductManager();
        pm.selectAll();

        // Finally let's insert some data
        // Will use stringBuilder or similar in video to build/map this
        // Main point for both: USE PLACEHOLDERS
        String insertQuery = "INSERT INTO employee " +
                "(uid, name)" +
                " VALUES (?, ?)";
        String[] itemp = {"12", "Andrew"};

        pm.insertProd(insertQuery, itemp);
        pm.selectAll();


        // And close our connection at end
        pm.closeCon();


    }

}

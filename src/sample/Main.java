/**
 * @Author Vladimir Hardy
 */
package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.stage.Stage;

import javax.swing.*;
import javax.xml.transform.Result;
import java.net.URL;
import java.sql.*;
import java.util.ResourceBundle;
import java.util.Scanner;

public class Main extends Application {



    @Override
    /**
     * @brief titles a 300 by 275 box with Production Line, and adds the attributes from sample.fxml
     */
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("Production Line");
        primaryStage.setScene(new Scene(root, 300, 275));
        primaryStage.show();

    }

    /**
     * @param args
     * @throws SQLException
     * @brief Connects to the database, selects values into the columns uin, fname and lname, and closes the connection
     */
    public static void main(String[] args) throws SQLException {

        launch(args);
        final String JDBC_DRIVER = "org.h2.Driver"; //Only works on local computer
        final String DB_URL = "jdbc:h2:C:/Users/Windows/OneDrive - Florida Gulf Coast University/COP 3003/COP3003Project/res";
        //  Database credentials
        final String USER = "";
        final String PASS = "";
        Connection conn;
        Statement stmt;

        try {
            // STEP 1: Register JDBC driver
            Class.forName(JDBC_DRIVER);

            //STEP 2: Open a connection
            conn = DriverManager.getConnection(DB_URL, USER, PASS);

            //STEP 3: Execute a query
            stmt = conn.createStatement();
            String sql = "SELECT * FROM EMPLOYEE";
            ResultSet rs = stmt.executeQuery(sql);

            /*while (rs.next()) {
                System.out.printf("Uin: %d%n", rs.getInt("uin"));
                System.out.printf("First Name: %s%n", rs.getString("fname"));
                System.out.printf("Last Name: %s%n", rs.getString("lname"));
            }*/

            // STEP 4: Clean-up environment
            stmt.close();
            conn.close();

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        Scanner input = new Scanner(System.in);
        AudioPlayer ap = new AudioPlayer("", "", "");
        Production pd = new Production();
        System.out.println("Please select an option below: ");
        System.out.println("1. Add a new item to the produce line \n2. Log items produced");
        int choice = input.nextInt();
        switch(choice) {
            case 1:
                pd.createNewItem(input);
                break;
            case 2:
                pd.produce(input);
                break;
            default:
                System.out.println("Please select an item in the given range and try again");
        }


        System.out.println(ap.returnToString("", "", ""));
        ap.audioplayer();
        input.close();
    }
}

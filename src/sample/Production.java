/**
 * @Author Vladimir Hardy
 * @TODO Create a database Table for Production, display available products to record
 */
package sample;

import java.sql.*;
import java.util.Scanner;
import java.time.LocalDate;

public class Production implements Item {

    public void produce(Scanner input) {

        String[] sampleItems = {"Apple, iPod, AU", "Windows, Macbook, VI"}; //Pull from DB
        for (int i = 0; i<sampleItems.length; i++) {
            System.out.println(i + 1 + ". " + sampleItems[i]);
        }
        System.out.println("Select an item to produce: ");
        int itemChoice = input.nextInt();
        //Produce that item x number of times and save to a Database
        System.out.println("Enter the amount of items that have been produced: ");
        int numItemsToProduce = input.nextInt();

        LocalDate date = LocalDate.now();
        String manufacturedOn = date.toString();
        System.out.println(manufacturedOn);
        String productionRun;
        for(int i = 1; i<=numItemsToProduce; i++) {
            productionRun = i + ". " + sampleItems[itemChoice-1];
            System.out.println(productionRun); //Save to DB
        }
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
            //String insert = "INSERT INTO PRODUCTION VALUES (1,'iPod','Apple','AU')";
            //ResultSet rs1 = stmt.executeQuery(insert);

            String select = "SELECT * FROM PRODUCTION";
            ResultSet rs2 = stmt.executeQuery(select);

            while (rs2.next()) {
                System.out.printf("%d. %s, %s, %s\n", rs2.getInt("id"),
                        rs2.getString("manufacturer"), rs2.getString("name"), rs2.getString("type"));
            }

            // STEP 4: Clean-up environment
            stmt.close();
            conn.close();

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void createNewItem(Scanner input) {


        System.out.println("Type the manufacturer of the product:");
        input.nextLine();
        String manufacturer = input.nextLine();
        System.out.println("Now type the name of the product:");
        String name = input.nextLine();
        System.out.println("Select an item type: ");
        System.out.println("1. Audio \n2. Visual \n3. Audio Mobile \n4. Visual Mobile");
        String type;
        int choice = input.nextInt();
        switch(choice) {
            case 1:
                type = "Audio";
                break;
            case 2:
                type = "Visual";
                break;
            case 3:
                type = "Audio Mobile";
                break;
            case 4:
                type = "Visual Mobile";
                break;
            default:
                System.out.println("Please select the choice in the given range");
        }
        try {
            final String JDBC_DRIVER = "org.h2.Driver"; //Only works on local computer
            final String DB_URL = "jdbc:h2:C:/Users/Windows/OneDrive - Florida Gulf Coast University/COP 3003/COP3003Project/res";
            //  Database credentials
            final String USER = "";
            final String PASS = "";
            Connection conn;
            PreparedStatement stmt;

            // STEP 1: Register JDBC driver
            Class.forName(JDBC_DRIVER);

            //STEP 2: Open a connection
            conn = DriverManager.getConnection(DB_URL, USER, PASS);

            //STEP 3: Execute a query
            stmt = conn.prepareStatement("INSERT INTO PRODUCTION VALUES (?,?,?,?)");

            stmt.setInt(1,3);
            //stmt.setString(2, "iPod", "Apple", "AU");  //Insert Into doesnt work cant understand why <---
            int rs1 = stmt.executeUpdate();


            // STEP 4: Clean-up environment
            stmt.close();
            conn.close();

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public int getId() {
        return 0;
    }

    @Override
    public void setName(String name) {

    }

    @Override
    public String getName() {
        return null;
    }

    @Override
    public void setManufacturer(String manufacturer) {

    }

    @Override
    public String getManufacturer() {
        return null;
    }
}

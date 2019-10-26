/**
 * @Author Vladimir Hardy
 * @TODO Display available products to record
 */
package sample;

import java.sql.*;
import java.util.Scanner;
import java.time.LocalDate;

public class Production implements Item {

    /**
     * @brief Allows the user to select an item to produce however many times they desire (will change to GUI later)
     * @param input scanner that is brought from Main
     */
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

    /**
     * @brief creates a new item with the information passed and saves to a database table called PRODUCTION
     * @param prodName Name of the product
     * @param manufact Manufacturer's name
     * @param type Product type (Audio, Visual, Audio Mobile, Visual Mobile)
     */
    public void createNewItem(String prodName, String manufact, String type) {

        try {
            final String JDBC_DRIVER = "org.h2.Driver";
            final String DB_URL = "jdbc:h2:C:/Users/Windows/OneDrive - Florida Gulf Coast University/COP 3003/COP3003Project/res";
            //  Database credentials
            final String USER = "";
            final String PASS = "";
            Connection conn;
            PreparedStatement  pstmt; //Use prepared statement to allow variables to work in insert statements
            Statement stmt;

            // STEP 1: Register JDBC driver
            Class.forName(JDBC_DRIVER);

            //STEP 2: Open a connection
            conn = DriverManager.getConnection(DB_URL, USER, PASS);

            //STEP 3: Execute a query
            String SQL = "INSERT INTO PRODUCTION VALUES (?,?,?,?)";
            String SQL2 = "SELECT id FROM PRODUCTION ORDER BY ID DESC LIMIT 1"; //Gets the last id
            String SQL3 = "DELETE * FROM PRODUCTION WHERE TYPE = null";
            stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(SQL2);
            int id = 1;
            while(rs.next()) {
                id = rs.getInt("id") + 1; //Increments the last id by 1
            }

            pstmt = conn.prepareStatement(SQL);
            pstmt.setInt(1, id);
            pstmt.setString(2,prodName);
            pstmt.setString(3,manufact);
            pstmt.setString(4,type);

            pstmt.executeUpdate();
            /* if(!type.equals("null")) { // <-- this is the error
                System.out.println("Data successfully inserted");
            }
            else {
                System.out.println("Error occurred while inserting data");
                //stmt.executeQuery(SQL3);
            }*/

            // STEP 4: Clean-up environment
            pstmt.close();
            stmt.close();
            conn.close();

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Implemented getters and setters
     */
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

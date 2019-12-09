/**
 * @Author Vladimir Hardy
 */
package sample;

import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;

import java.sql.*;
import java.util.ArrayList;
import java.util.Date;

public class Production {

    /**
     * @brief Allows the user to select an item to produce however many times they desire (will change to GUI later)
     */
    public void produce(String itemsToProduce, int numItemsToProduce) {

        final String DB_URL = "jdbc:h2:./res/ProductionLog";
        //  Database credentials
        final String USER = "";
        final String PASS = "";

        DBConnection db = new DBConnection();
        Connection conn;
        Statement stmt = db.stmt();
        PreparedStatement pstmt;
        PreparedStatement pstmt2;

        try {
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            String firstThreeLetters = itemsToProduce.substring(0, 3);
            String SQL = "INSERT INTO PRODUCTIONRECORD VALUES (?,?,?)";
            String SQL2 = "SELECT PRODUCTIONNUMBER FROM PRODUCTIONRECORD ORDER BY PRODUCTIONNUMBER DESC LIMIT 1";
            String SQL3 = "SELECT COUNT(serialNumber) FROM PRODUCTIONRECORD WHERE serialNumber LIKE ?";

            ResultSet rs = stmt.executeQuery(SQL2); //Should change to pstmt for security reasons
            pstmt = conn.prepareStatement(SQL);
            int serialCount = 1;
            while (rs.next()) {
                serialCount = rs.getInt("productionNumber") + 1;
            }
            pstmt2 = conn.prepareStatement(SQL3);
            pstmt2.setString(1, "%" + firstThreeLetters + "%");
            ResultSet rs2 = pstmt2.executeQuery();
            ArrayList<Integer> numOfExistingProducts = new ArrayList<>();

            while (rs2.next()) {
                //System.out.println(rs2.getInt(1)); //Gets amount of columns already existing
                for (int i = 1; i <= numItemsToProduce; i++) {
                    //for (int i = rs2.getInt(1); i <= numItemsToProduce+rs2.getInt(1); i++) {
                    numOfExistingProducts.add(rs2.getInt(1) + i);
                }
            }
            String serialNum;
            Date date = new Date();
            for (int i = 0; i < numItemsToProduce; i++) {

                //System.out.println(serialCount + "_" + firstThreeLetters + "_" + padLeft(numOfExistingProducts.get(i).toString()));
                serialNum = serialCount + "_" + firstThreeLetters + "_" + padLeft(numOfExistingProducts.get(i).toString());
                pstmt.setInt(1, serialCount);
                pstmt.setString(2, serialNum);
                pstmt.setString(3, date.toString());
                pstmt.executeUpdate();
                serialCount++;
            }
            pstmt.close();


        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * @param str string that will be padded left
     * @return the padded string
     * @brief returns a string of zeros padded to a string of numbers
     * Followed tutorial https://www.javacodeexamples.com/java-string-pad-zero-example/855
     */
    public String padLeft(String str) {
        String serialSize = "00000";
        int serialLength = 10;
        if (str.length() < serialLength) {
            return serialSize.substring(str.length()) + str;
        } else {
            return str;
        }
    }

    /**
     * @param prodName Name of the product
     * @param manufact Manufacturer's name
     * @param type     Product type (Audio, Visual, Audio Mobile, Visual Mobile)
     * @brief creates a new item with the information passed and saves to a database table called PRODUCTION
     */
    public void createNewItem(String prodName, String manufact, String type) {

        try {
            final String JDBC_DRIVER = "org.h2.Driver";
            final String DB_URL = "jdbc:h2:C:/Users/Windows/OneDrive - Florida Gulf Coast University/COP 3003/COP3003Project/res/ProductionLog";
            //  Database credentials
            final String USER = "";
            final String PASS = "";

            Connection conn;
            PreparedStatement pstmt; //Use prepared statement to allow variables to work in insert statements
            DBConnection db = new DBConnection();
            Statement stmt = db.stmt();

            // STEP 1: Register JDBC driver
            Class.forName(JDBC_DRIVER);

            //STEP 2: Open a connection
            conn = DriverManager.getConnection(DB_URL, USER, PASS);

            //STEP 3: Execute a query
            String SQL = "INSERT INTO PRODUCTION VALUES (?,?,?,?)";
            String SQL2 = "SELECT id FROM PRODUCTION ORDER BY ID DESC LIMIT 1"; //Gets the last id
            String SQL3 = "DELETE * FROM PRODUCTION WHERE TYPE = null";
            ResultSet rs = stmt.executeQuery(SQL2);
            int id = 1;
            while (rs.next()) {
                id = rs.getInt("id") + 1; //Increments the last id by 1
            }

            pstmt = conn.prepareStatement(SQL);
            pstmt.setInt(1, id);
            pstmt.setString(2, prodName);
            pstmt.setString(3, manufact);
            pstmt.setString(4, type);

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
            Alert alert = new Alert(Alert.AlertType.ERROR, "Error, class not found: " + e, ButtonType.OK);
            alert.show();
        } catch (SQLException e) {
            Alert alert = new Alert(Alert.AlertType.ERROR, "Error: " + e, ButtonType.OK);
            alert.show();
        }
    }
}

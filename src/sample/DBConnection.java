/**
 * @Author Vladimir Hardy
 */
package sample;

import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import java.sql.*;

public class DBConnection {

    public Statement stmt() {

        final String JDBC_DRIVER = "org.h2.Driver";
        final String DB_URL = "jdbc:h2:./res/ProductionLog";
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

            //Return stmt for use elsewhere
            return stmt;
        } catch (ClassNotFoundException e) {
            Alert alert = new Alert(Alert.AlertType.ERROR, "Error, class not found: " + e, ButtonType.OK);
            alert.show();
        } catch (SQLException e) {
            Alert alert = new Alert(Alert.AlertType.ERROR, "Error: " + e, ButtonType.OK);
            alert.show();
        }
        return null;
    }
}

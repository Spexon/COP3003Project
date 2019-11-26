/**
 * @Author Vladimir Hardy
 * @TODO Figure out how to return connection
 */
package sample;

import java.sql.*;

public class DBConnection {

    public Statement stmt() {

        final String JDBC_DRIVER = "org.h2.Driver"; //Only works on local computer
        final String DB_URL = "jdbc:h2:C:/Users/Windows/OneDrive - Florida Gulf Coast University/COP 3003/COP3003Project/res/ProductionLog";
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
        }
        catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}

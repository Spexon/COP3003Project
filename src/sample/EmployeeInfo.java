/**
 * @Author Vladimir Hardy
 */
package sample;

import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;
import java.util.regex.Pattern;

public class EmployeeInfo {

    private String fName;
    private String lName;
    private String code;
    private String deptId;
    private Pattern p;
    private Scanner in;

    /**
     * @param fName Employer's first name
     * @param lName Employer's last name
     * @brief gets the first and last name and calls to create an employee code
     */
    EmployeeInfo(String fName, String lName) {
        in = new Scanner(System.in);
        this.fName = fName;
        this.lName = lName;
        if (checkName(fName, lName)) {
            System.out.println("Error, please enter a first and last name");
            return;
        }
        createEmployeeCode(fName, lName);
        deptId = reverseString(code);
        if (validId(deptId)) {
            print();
            System.out.println(toString());
        }
        in.close();
    }

    private void print() {

        try {
            DBConnection db = new DBConnection();
            String SQL = "SELECT * FROM PRODUCTION";
            Statement stmt = db.stmt();
            ResultSet rs = stmt.executeQuery(SQL);
            while (rs.next()) {
                System.out.printf("Id: %d, Product Name: %s, Manufacturer: %s, Type: %s\n", rs.getInt(1),
                        rs.getString(2), rs.getString(3), rs.getString(4));
            }
        } catch (SQLException e) {
            Alert alert = new Alert(Alert.AlertType.ERROR, "Error: " + e, ButtonType.OK);
            alert.show();
        }
    }

    /**
     * @param fName Employer's first name
     * @param lName Employer's last name
     * @brief creates the code for the employer using their first and last name
     */
    private void createEmployeeCode(String fName, String lName) {
        code = (fName.substring(0, 1) + "" + lName).toLowerCase();
    }

    private boolean checkName(String fName, String lName) {
        return fName.equals("") || lName.equals("");
    }

    /**
     * @param id first initial and last name
     * @return true if the id length is larger than four
     * @brief returns true only if the id is long enough
     */
    private boolean validId(String id) {
        return id.length() >= 2;
    }

    /**
     * @param str String that will have its order reversed
     * @return a reversed string
     * @brief reverses the order of a string
     */
    private String reverseString(String str) {
        //System.out.println(str);
        if (str.length() == 1) {
            return str;
        }
        return reverseString(str.substring(1)) + str.substring(0, 1);
    }

    @Override
    public String toString() {
        return "EmployeeInfo{ code='" + code + '\'' + ", deptId='" + deptId + '\'' + '}';
    }

    /**
     * Getters and setters
     */

    public String getDeptId() {
        return deptId;
    }

    private void setDeptId(String deptId) {
        this.deptId = deptId;
    }

    public String getfName() {
        return fName;
    }

    public String getlName() {
        return lName;
    }

    public String getCode() {
        return code;
    }

    private void setfName(String name) {
        this.fName = name;
    }

    private void setlName(String name) {
        this.lName = name;
    }
}

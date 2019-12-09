/**
 * @Author Vladimir Hardy
 */
package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.text.Text;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;

public class Controller implements Initializable {


    public TableView productsTable;
    public TableColumn<DisplayTable, Integer> displayID;
    public TableColumn<DisplayTable, String> displaySerialNum;
    public TableColumn<DisplayTable, String> displayDate;
    public Text employeeCode;
    public ComboBox sortItemsBy;
    @FXML
    private ComboBox<?> items;
    public ComboBox itemsInDisplay;
    public TextField manufact;
    public TextField prod;
    public TextField numItemsToProduce;
    public Button btn;
    public Button btn1;
    private String type;
    private String itemsToProduce = "PENDING INPUT";
    private String sortCode = "Product Name";
    private int showComboString = 1;
    private static ObservableList<DisplayTable> data;
    private static ObservableList<String> comboStringProdName;
    private static ObservableList<String> comboStringManufact;
    private static ObservableList<String> comboStringType;

    public Controller() {
    }

    enum ItemType {
        AU,  //Audio
        VI,  //Visual
        AM,  //Audio Mobile
        VM   //Visual Mobile
    }

    /**
     * @brief gets the value the user chooses and saves the value
     */
    @FXML
    private void handleTypeCombobox() {

        ItemType audio = ItemType.AU;
        ItemType visual = ItemType.VI;
        ItemType audioMobile = ItemType.AM;
        ItemType visualMobile = ItemType.VM;
        items.valueProperty().addListener((obs, oldVal, newVal) -> type = newVal.toString());
    }

    /**
     * @brief gets the value that the user logs and saves to itemsToProduce
     */
    @FXML
    private void handleItemCombobox() {
        itemsInDisplay.getItems().removeAll(comboStringProdName);
        itemsInDisplay.getItems().removeAll(comboStringManufact);
        itemsInDisplay.getItems().removeAll(comboStringType);
        switch (showComboString) {
            case 1:
                itemsInDisplay.getItems().addAll(comboStringProdName);
                break;
            case 2:
                itemsInDisplay.getItems().addAll(comboStringManufact);
                break;
            case 3:
                itemsInDisplay.getItems().addAll(comboStringType);
                break;
            default:
                Alert alert = new Alert(Alert.AlertType.ERROR, "Something went wrong", ButtonType.OK);
                alert.show();
        }
        itemsInDisplay.valueProperty().addListener((obs, oldVal, newVal) -> {
            itemsToProduce = newVal.toString();
        });
    }

    /**
     * @brief sorts the item combobox based on what sort category is chosen
     */
    @FXML
    private void handleSortCombobox() {
        sortItemsBy.valueProperty().addListener((obs, oldVal, newVal) -> {
            sortCode = newVal.toString();
        });
    }

    /**
     * @param event
     * @brief calls createNewItem and passes the values the user selected from the GUI
     */
    private void handleButtonAction(ActionEvent event) {
        // Button was clicked, do something...
        try {
            if (type.equals("") || prod.getText().equals("") || manufact.getText().equals("")) {
                Alert alert = new Alert(Alert.AlertType.ERROR, "Please enter information in the fields provided", ButtonType.OK);
                alert.show();
                return;
            }
            Production pd = new Production();
            btn.setText("Submitted");
            pd.createNewItem(prod.getText(), manufact.getText(), type);
            productsTable.setItems(data);
            populateList();
        } catch (NullPointerException ex) {
            Alert alert = new Alert(Alert.AlertType.ERROR, "Please enter information in the fields provided", ButtonType.OK);
            alert.show();
        } catch (Exception ex) {
            Alert alert = new Alert(Alert.AlertType.ERROR, "Something went wrong \nError Code: " + ex, ButtonType.OK);
            alert.show();
        }

    }

    /**
     * @param event
     * @brief Calls produce in class production once all fields are entered for producing a new item
     */
    private void handleButtonAction2(ActionEvent event) {
        // Button was clicked, do something...
        Production pd = new Production();
        try {
            if (numItemsToProduce.getText().equals("")) {
                Alert alert = new Alert(Alert.AlertType.ERROR, "Please enter information in the fields provided", ButtonType.OK);
                alert.show();
                return;
            } else if (Integer.parseInt(numItemsToProduce.getText()) < 1) {
                Alert alert = new Alert(Alert.AlertType.ERROR, "Please enter a positive integer number", ButtonType.OK);
                alert.show();
                return;
            }
            btn.setText("Submitted");
            pd.produce(itemsToProduce, Integer.parseInt(numItemsToProduce.getText()));
            productsTable.setItems(data);
            populateList();
        } catch (NumberFormatException ex) {
            if (!(Math.floor(Double.parseDouble(numItemsToProduce.getText())) == Double.parseDouble(numItemsToProduce.getText()))) {
                Alert alert = new Alert(Alert.AlertType.ERROR, "Please enter a positive whole number", ButtonType.OK);
                alert.show();
            } else {
                Alert alert = new Alert(Alert.AlertType.ERROR, "Please enter information in the fields provided", ButtonType.OK);
                alert.show();
            }
        } catch (Exception ex) {
            Alert alert = new Alert(Alert.AlertType.ERROR, "Something went wrong \nError Code: " + ex, ButtonType.OK);
            alert.show();
        }
    }

    /**
     * @brief applies the information to sort the item combobox
     */
    @FXML
    private void handleApplySortButton() {
        System.out.println(sortCode);
        switch (sortCode) {
            case "Product Name":
                showComboString = 1;
                break;
            case "Manufacturer":
                showComboString = 2;
                break;
            case "Type":
                showComboString = 3;
                break;
            default:
                Alert alert = new Alert(Alert.AlertType.ERROR, "Something went wrong \nError Code: ", ButtonType.OK);
                alert.show();
        }
    }

    /**
     * @param location
     * @param resources
     * @brief when the button action gets called, send the program to the specified method
     */
    @Override
    public void initialize(URL location, ResourceBundle resources) {

        btn.setOnAction(this::handleButtonAction);
        btn1.setOnAction(this::handleButtonAction2);
        data = FXCollections.observableArrayList();
        displayID.setCellValueFactory(new PropertyValueFactory<>("id")); //THIS HAS TO MATCH DISPLAYTABLE FIELD VARIABLES!
        displaySerialNum.setCellValueFactory(new PropertyValueFactory<>("serialNumber"));
        displayDate.setCellValueFactory(new PropertyValueFactory<>("date"));
        EmployeeInfo ei = new EmployeeInfo("Vladimir", "Hardy");
        employeeCode.setText("Employee: " + ei.getCode());
        productsTable.setItems(data);
        populateList();
    }

    /**
     * @brief fetches data from database and sends it to Display Table, which then gets formatted into an observable list called data
     */
    private static void populateList() {

        DBConnection db = new DBConnection();
        Statement stmt = db.stmt();

        try {
            String select = "SELECT  * FROM PRODUCTION";
            ResultSet rs = stmt.executeQuery(select);
            int tempId;
            String tempSerialNum;
            String tempDate;
            comboStringProdName = FXCollections.observableArrayList();
            comboStringManufact = FXCollections.observableArrayList();
            comboStringType = FXCollections.observableArrayList();
            while (rs.next()) {
                comboStringProdName.add(rs.getString("prodName"));
                comboStringManufact.add(rs.getString("manufacturer"));
                comboStringType.add(rs.getString("type"));
            }
            String select2 = "SELECT * FROM PRODUCTIONRECORD";
            ResultSet rs2 = stmt.executeQuery(select2);
            data.clear();
            while (rs2.next()) {
                tempId = rs2.getInt("productionNumber");
                tempSerialNum = rs2.getString("serialNumber");
                tempDate = rs2.getString("date");
                DisplayTable dt = new DisplayTable(tempId, tempSerialNum, tempDate);
                data.add(dt);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

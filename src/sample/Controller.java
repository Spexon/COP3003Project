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
    public TableColumn<DisplayTable, String> displayManufacturer;
    public TableColumn<DisplayTable, String> displayProdName;
    public TableColumn<DisplayTable, String> displayType;
    public Text employeeCode;
    @FXML
    private ComboBox<?> items;
    public ComboBox itemsInDisplay;
    public TextField manufact;
    public TextField prod;
    public TextField numItemsToProduce;
    public Button btn;
    public Button btn1;
    private String type;
    private String itemsToProduce;
    private static ObservableList<DisplayTable> data;

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
    private void handleComboBox() {

        ItemType audio = ItemType.AU;
        ItemType visual = ItemType.VI;
        ItemType audioMobile = ItemType.AM;
        ItemType visualMobile = ItemType.VM;
        items.valueProperty().addListener((obs, oldVal, newVal) -> {
            type = newVal.toString();
        });
        /*switch(type) {
            case "Audio":
                type = audio.toString();
                break;
            case "Visual":
                type = visual.toString();
                break;
            case "Audio Mobile":
                type = audioMobile.toString();
                break;
            case "Visual Mobile":
                type = visualMobile.toString();
                break;
            default:
                System.out.println("Something went wrong in ItemType Combobox");

        }*/
    }

    /**
     * @brief gets the value that the user logs and saves to itemsToProduce
     */
    @FXML
    private void handleComboBox2() {
        System.out.println(data);
        itemsInDisplay.getItems().addAll(data);
        //itemsInDisplay.setItems(data);
        itemsInDisplay.valueProperty().addListener((obs, oldVal, newVal) -> {
            itemsToProduce = newVal.toString();
        });
    }

    /**
     * @param event
     * @brief calls createNewItem and passes the values the user selected from the GUI
     */
    private void handleButtonAction(ActionEvent event) {
        // Button was clicked, do something...
        if (type.equals("")) {
            return;
        }
        Production pd = new Production();
        pd.createNewItem(prod.getText(), manufact.getText(), type);
        btn.setText("Submitted");

    }

    private void handleButtonAction2(ActionEvent event) {
        // Button was clicked, do something...
        Production pd = new Production();
        pd.produce(itemsToProduce, Integer.parseInt(numItemsToProduce.getText()));
        btn.setText("Submitted");
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
        displayManufacturer.setCellValueFactory(new PropertyValueFactory<>("manufact"));
        displayProdName.setCellValueFactory(new PropertyValueFactory<>("productName"));
        displayType.setCellValueFactory(new PropertyValueFactory<>("type"));
        EmployeeInfo ei = new EmployeeInfo("Vladimir", "Hardy");
        employeeCode.setText("Employee: " + ei.getCode());
        productsTable.setItems(data);
        populateList();
    }

    private static void populateList() {

        DBConnection db = new DBConnection();
        Statement stmt = db.stmt();

        try {
            String select = "SELECT * FROM PRODUCTION";
            ResultSet rs2 = stmt.executeQuery(select);
            int tempId;
            String tempManufact;
            String tempProdname;
            String tempType;
            while (rs2.next()) {
                tempId = rs2.getInt("id");
                tempManufact = rs2.getString("manufacturer");
                tempProdname = rs2.getString("prodname");
                tempType = rs2.getString("type");
                DisplayTable dt = new DisplayTable(tempId, tempManufact, tempProdname, tempType);
                data.add(dt);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

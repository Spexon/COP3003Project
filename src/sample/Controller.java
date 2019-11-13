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

import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class Controller implements Initializable, Item {


    public TableView productsTable;
    public TableColumn<?, ?> displayID;
    public TableColumn<?, ?> displayManufacturer;
    public TableColumn<?, ?> displayProdName;
    public TableColumn<?, ?> displayType;
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
        items.valueProperty().addListener((obs, oldVal, newVal) ->   {
            type = newVal.toString();
        });
    }

    @FXML
    private void handleComboBox2() {
        itemsInDisplay.valueProperty().addListener((obs, oldVal, newVal) -> {
            itemsToProduce = newVal.toString();
        });
    }

    /**
     * @brief calls createNewItem and passes the values the user selected from the GUI
     * @param event
     */
    private void handleButtonAction(ActionEvent event) {
        // Button was clicked, do something...
        Production pd = new Production();
        pd.createNewItem(prod.getText(), manufact.getText(), type);
        btn.setText("Submitted\n");
    }

    private void handleButtonAction1(ActionEvent event) {
        // Button was clicked, do something...
        Production pd = new Production();
        pd.produce(itemsToProduce, Integer.parseInt(numItemsToProduce.getText()));
        btn.setText("Submitted\n");
    }

    /**
     * @brief when the button action gets called, send the program to the specified method
     * @param location
     * @param resources
     */
    @Override
    public void initialize(URL location, ResourceBundle resources) {

        btn.setOnAction(this::handleButtonAction);
        btn1.setOnAction(this::handleButtonAction1);
        final ObservableList<DisplayTable> data = populateList();

        productsTable.getColumns().clear();
        displayID.setCellValueFactory(new PropertyValueFactory("id")); //THIS HAS TO MATCH DISPLAYTABLE VARIABLES !
        displayManufacturer.setCellValueFactory(new PropertyValueFactory("manufact"));
        displayProdName.setCellValueFactory(new PropertyValueFactory("productName"));
        displayType.setCellValueFactory(new PropertyValueFactory("Type"));

        productsTable.setItems(data);
        productsTable.getColumns().addAll(displayID, displayManufacturer, displayProdName, displayType);

    }

    public static ObservableList<DisplayTable> populateList() {

        ArrayList<String> DBdataRow = new ArrayList<>();
        DBConnection db = new DBConnection();
        Statement stmt = db.stmt();

        try {
            String select = "SELECT * FROM PRODUCTION";
            ResultSet rs2 = stmt.executeQuery(select);

            while(rs2.next()) {
                DBdataRow.add(Integer.toString(rs2.getInt("id")));
                DBdataRow.add(rs2.getString("Manufacturer"));
                DBdataRow.add(rs2.getString("name"));
                DBdataRow.add(rs2.getString("type"));

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println(DBdataRow);
        /*for(int i = 0; i < DBdataRow.size(); i++) {
            return FXCollections.observableArrayList(
                    new DisplayTable(Integer.parseInt(DBdataRow.get(i)), DBdataRow.get(i+1), DBdataRow.get(i+2), DBdataRow.get(i+3)));
        }*/
        return FXCollections.observableArrayList(
                new DisplayTable(DBdataRow));
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

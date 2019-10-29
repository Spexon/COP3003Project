/**
 * @Author Vladimir Hardy
 */
package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable, Item {

    @FXML
    private ComboBox<?> items;
    public TextField manufact;
    public TextField prod;
    public Button btn;
    private String type;

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
        items.valueProperty().addListener((obs, oldVal, newVal) ->   { // -> Functional: no name and no return type (but can still return something)
            type = newVal.toString();
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

    /**
     * @brief when the button action gets called, send the program to the specified method
     * @param location
     * @param resources
     */
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        btn.setOnAction(this::handleButtonAction);
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

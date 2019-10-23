package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;

import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable, Item {

    enum ItemType {
        AU,  //Audio
        VI,  //Visual
        AM,  //Audio Mobile
        VM   //Visual Mobile
    }

    public Button btn;
    @FXML
    private ComboBox<?> items;
    private String tempVal;

    private void handleComboBox(ActionEvent event) {
        ItemType audio = ItemType.AU;
        ItemType visual = ItemType.VI;
        ItemType audioMobile = ItemType.AM;
        ItemType visualMobile = ItemType.VM;
        items.valueProperty().addListener((obs, oldVal, newVal) ->   {
            tempVal = newVal.toString();
        });

    }

    private void handleButtonAction(ActionEvent event) {
        // Button was clicked, do something...
        System.out.println(tempVal);
        btn.setText(tempVal + " Submitted\n");
    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        items.setOnAction(this::handleComboBox);
        btn.setOnAction(this::handleButtonAction);
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

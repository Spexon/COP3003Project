/**
 * @Author Vladimir Hardy
 */
package sample;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

import java.util.ArrayList;

public class DisplayTable {

    private String productName;
    private String manufact;
    private String type;
    private int id;

    public DisplayTable(ArrayList<String> data) {

        for(int i = 0; i<data.size(); i++) {
            int j = i+1;
            this.id = Integer.parseInt(data.get(0));
            this.manufact = data.get(1);
            this.productName = data.get(2);
            this.type = data.get(3);
        }
    }

    /*public DisplayTable(int id, String manufact, String name, String type) {

            this.productName = name;
            this.manufact = manufact;
            this.type = type;
            this.id = id;
        }*/

            public String getProductName() {
        return productName;
    }

    public void setProductName(String name) {
        this.productName = name;
    }

    public String getManufact() {
        return manufact;
    }

    public void setManufact(String manufact) {
        this.manufact = manufact;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

}

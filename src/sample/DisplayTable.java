package sample;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
//s
public class DisplayTable extends Product {

    private final SimpleStringProperty productName;
    private final SimpleStringProperty manufact;
    private final SimpleStringProperty type;
    private final SimpleIntegerProperty id;

    public DisplayTable(String name, String manufact, String type, int id) {
        super(name);
        this.productName = new SimpleStringProperty(getName());
        this.manufact = new SimpleStringProperty(manufact);
        this.type = new SimpleStringProperty(type);
        this.id = new SimpleIntegerProperty(id);

        }
    public String getProductName() {
        return productName.get();
    }

    public void setProductName(String name) {
        productName.set(name);
    }

    public String getManufact() {
        return manufact.get();
    }

    public void setManufact(String manufact) {
        this.manufact.set(manufact);
    }

    public String getType() {
        return type.get();
    }

    public void setType(String type) {
        this.type.set(type);
    }

    @Override
    public int getId() {
        return id.get();
    }

    public void setId(int id) {
        this.id.set(id);
    }

}

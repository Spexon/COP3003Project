/**
 * @Author Vladimir Hardy
 * @TODO Create database table for Product
 */
package sample;

public abstract class Product implements Item {
    private int id;
    private String type;
    private String manufacturer;
    private String name;

    public Product(String name) {
        this.name = name;
    }

    public String returnToString(String name, String manufacturer, String type) {

        return ("Name: " + name + "\nManufacturer: " + manufacturer + "\nType: " + type);
    }

    public int getId() {
        return id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getManufacturer() {
        return manufacturer;
    }
}

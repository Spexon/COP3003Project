/**
 * @Author Vladimir Hardy
 */
package sample;

public abstract class Product implements Item {
    private int id;
    private String type;
    private String manufacturer;
    private String name;

    /**
     * @param name the product name
     * @brief constructor that sets name equal to what comes in
     */
    public Product(String name, String manufacturer, String type) {
        this.name = name;
        this.manufacturer = manufacturer;
        this.type = type;
    }

    /**
     * @param name         the product name
     * @param manufacturer manufacturer name
     * @param type         product item type
     * @return returns data passed to it in string format concatenated together
     */
    public String toString(String name, String manufacturer, String type) {
        return ("Name: " + name + "\nManufacturer: " + manufacturer + "\nType: " + type);
    }

    /**
     * Implemented getters and setters
     */
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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}

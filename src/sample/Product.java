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
     * @brief constructor that sets name equal to what comes in
     * @param name
     */
    public Product(String name) {
        this.name = name;
    }

    /**
     * @brief returns data passed to it in string format concatenated together
     * @param name
     * @param manufacturer
     * @param type
     * @return
     */
    public String returnToString(String name, String manufacturer, String type) {

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
}

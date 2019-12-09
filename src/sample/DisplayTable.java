/**
 * @Author Vladimir Hardy
 */
package sample;

public class DisplayTable {

    private String serialNumber;
    private String date;
    private int id;

    /**
     * @param id           Production number from the database
     * @param serialNumber serialNumber from the database
     * @param date         Product date from the database
     * @brief gathers information sent from the controller to be returned later
     */
    DisplayTable(int id, String serialNumber, String date) {

        this.id = id;
        this.serialNumber = serialNumber;
        this.date = date;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

}

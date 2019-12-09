/**
 * @Author Vladimir Hardy
 */
package sample;

public class MoviePlayer extends Product implements MultiMediaControl {

    private String screen;
    private String monitorType;

    /**
     * @brief constructor that sets name equal to what comes in
     * @param screen The size of the screen provided
     * @param manufacturer manufacturer name
     * @param type the type of product (Audio, Visual etc...)
     */
    MoviePlayer(String screen, String manufacturer, String type) {
        super(screen, manufacturer, type);
        this.screen = screen;
        this.monitorType = type;
    }

    /**
     * @return the screen size and monitor type
     */
    public String toString() {
        return "Screen: " + screen + "\nMonitor Type: " + monitorType;
    }

    /**
     * @brief code that runs when audio movie player is playing
     */
    @Override
    public void play() {
        System.out.println("Playing");
    }

    /**
     * @brief code that runs when audio movie player is stopping
     */
    @Override
    public void stop() {
        System.out.println("Stopping");
    }

    /**
     * @brief code that runs when audio movie player returns to a previous track
     */
    @Override
    public void previous() {
        System.out.println("Previous track");
    }

    /**
     * @brief code that runs when audio movie player moves to the next track
     */
    @Override
    public void next() {
        System.out.println("Next track");
    }
}

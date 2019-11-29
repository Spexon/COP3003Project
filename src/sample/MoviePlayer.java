package sample;

public class MoviePlayer extends Product implements MultiMediaControl {

    private String screen;
    private String monitorType;

    /**
     * @param screen
     * @param manufacturer
     * @param type
     * @brief constructor that sets name equal to what comes in
     */
    public MoviePlayer(String screen, String manufacturer, String type) {
        super(screen, manufacturer, type);
        this.screen = screen;
        this.monitorType = type;
    }

    public String toString() {
        return "Screen: " + screen + "\nMonitor Type: " + monitorType;
    }


    @Override
    public void play() {
        System.out.println("Playing");
    }

    @Override
    public void stop() {
        System.out.println("Stopping");
    }

    @Override
    public void previous() {
        System.out.println("Previous track");
    }

    @Override
    public void next() {
        System.out.println("Next track");
    }
}

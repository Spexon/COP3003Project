/**
 * @Author Vladimir Hardy
 * @TODO Create a driver class for AudioPlayer
 */
package sample;

public class AudioPlayer extends Product implements MultiMediaControl {

    private String audioSpecification;
    private String mediaType;

    public AudioPlayer(String name, String manufacturer, String audioSpecification) {
        super(name);
        getManufacturer();
        mediaType = audioSpecification;
    }

    public void audioplayer() {
        play();
        stop();
        previous();
        next();
    }

    @Override
    public String returnToString(String name, String manufacturer, String type) {
        return super.returnToString(name, manufacturer, type + "\nAudio Specification: " + audioSpecification + "\nMedia Type:" + mediaType);
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

/**
 * @Author Vladimir Hardy
 * @TODO Create a driver class for AudioPlayer
 */
package sample;

public class AudioPlayer extends Product implements MultiMediaControl {

    private String audioSpecification;
    private String mediaType;

    /**
     * @brief child constructor of Product thats suppose to overload the specified parameters
     * @param name Name of the product
     * @param manufacturer Manufacturer's name
     * @param audioSpecification (play, stop, previous, next)
     */
    public AudioPlayer(String name, String manufacturer, String audioSpecification) {
        super(name, manufacturer, audioSpecification);
        mediaType = audioSpecification;
    }

    /**
     * @brief the different functionality for an audio player
     */
    public void audioPlayer() {
        play();
        stop();
        previous();
        next();
    }

    /**
     * @brief suppose to overwrite the parent constructor with extra fields of data
     * @param name Name of the product
     * @param manufacturer Manufacturer's name
     * @param type Product type (Audio, Visual, Audio Mobile, Visual Mobile)
     * @return specified fields get returned as a string
     */
    @Override
    public String toString(String name, String manufacturer, String type) {
        return super.toString(name, manufacturer, type + "\nAudio Specification: " + audioSpecification + "\nMedia Type:" + mediaType);
    }

    /**
     * @brief code that runs when audio player is playing
     */
    @Override
    public void play() {
        System.out.println("Playing");
    }

    /**
     * @brief code that runs when audio player is stopping
     */
    @Override
    public void stop() {
        System.out.println("Stopping");
    }

    /**
     * @brief code that runs when audio player returns to a previous track
     */
    @Override
    public void previous() {
        System.out.println("Previous track");
    }

    /**
     * @brief code that runs when audio player moves to the next track
     */
    @Override
    public void next() {
        System.out.println("Next track");
    }
}

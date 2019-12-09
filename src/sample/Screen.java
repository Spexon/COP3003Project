/**
 * @Author Vladimir Hardy
 */
package sample;

public class Screen implements ScreenSpec {

    enum MonitorType {
        Type,
        LCD,
        LED
    }

    private String resolution;
    private int refreshRate;
    private int responseTime;

    /**
     * @param res      resolution rate for monitor
     * @param refresh  refresh rate for monitor
     * @param response response time for monitor
     * @brief constructor for a monitor
     */
    public Screen(String res, int refresh, int response) {
        resolution = res;
        refreshRate = refresh;
        responseTime = response;
    }

    /**
     * @return formatted string with a monitors resolution, refresh rate and response time
     */
    public String toString() {
        return ("Resolution: " + resolution + "\nRefresh Rate: " + refreshRate + "\nResponse Time: " + responseTime);
    }

    /**
     * Implemented getters and setters
     */
    @Override
    public String getResolution() {
        return resolution;
    }

    @Override
    public int getRefreshRate() {
        return refreshRate;
    }

    @Override
    public int getResponseTime() {
        return responseTime;
    }
}

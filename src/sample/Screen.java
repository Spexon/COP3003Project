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

    public Screen(String res, int refresh, int response) {
        resolution = res;
        refreshRate = refresh;
        responseTime = response;
    }

    public String toString() {
        return ("Resolution: " + resolution + "\nRefresh Rate: " + refreshRate + "\nResponse Time: " + responseTime);
    }

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

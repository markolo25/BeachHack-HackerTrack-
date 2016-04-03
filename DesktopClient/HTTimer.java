import java.util.Date;

/*
 * Timer class to be used by HackerTracker desktop client
 * By: Jenny Wong
 */
public class HTTimer {


    /* Fields */
    int time;
    boolean isGoing;

    /*
     * HTTime constructor
     *
     * @param time - time spent on program already
     */
    public HTTimer(int time) {

        this.time = time;
        this.isGoing = false;
    }

    /*
     * Collects start time
     *
     * @return true if successful, false if not
     */
    public boolean go() {
        if (isGoing) {
            return false;
        }
        this.isGoing = true;
        return true;
    }

    /*
     * Collects stop time
     *
     * @return true if successful, false if not
     */
    public boolean stop() {
        if (!isGoing) {
            return false;
        }
        this.isGoing = false;
        return true;
    }

    /*
     * Calculates time elapsed
     *
     * @return String time elapsed in the following format:
     *                             [hour]:[minute]:[second]
     */
    public String getTime() {

        if (isGoing) {
            this.stop();
            this.time = this.time + 1;
            this.go();
            return formatter(this.time);
        }
        
        return formatter(this.time);
    }


    /*
     * Converts minutes to hour:minute:second
     *
     * @param seconds - time elapsed
     * @return string time elapsed in new format
     */
    private static String formatter(int seconds) {
        int minutes = 0;
        int hours = 0;
        if (seconds >= 60) {
            minutes = seconds/60;
            seconds = seconds%60;
        }
        if (minutes >= 60) {
            hours = minutes/60;
            minutes = minutes%60;
        }
        return hours+":"+minutes+":"+seconds;
    }
}

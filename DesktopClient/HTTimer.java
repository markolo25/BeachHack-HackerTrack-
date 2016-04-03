/*
 * Timer class to be used by HackerTracker desktop client
 * By: Jenny Wong
 */

import java.util.Date;

public class HTTimer {


    /* Fields */
    Date startTime;
    Date endTime;
    int time;
    boolean isGoing;


    /*
     * HTTime constructor
     *
     * @param time - time spent on program already
     */
    public HTTimer(int time) {

        this.startTime = null;
        this.endTime = null;
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
        this.startTime = new Date();
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
        this.endTime = new Date();
        return true;
    }

    /*
     * Calculates time elapsed
     *
     * @return int time elapsed
     */
    public int getTime() {
        if (isGoing) {
            this.stop();
            this.time = (int)((endTime.getTime() - startTime.getTime())/1000);
            this.go();
            return this.time;
        }
        
        this.time = (int)((endTime.getTime() - startTime.getTime())/1000);
        return this.time;
    }
}

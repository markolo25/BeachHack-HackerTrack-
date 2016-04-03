import java.util.Date;

public class HTTimer {

    int startTime;
    int endTime;
    int time;

    boolean isGoing;


    /*
     * HTTime constructor
     * @param time - time spent on program already
     */
    public HTTimer(int time) {

        this.time = time;
        this.isGoing = false;

    }


    public void go() {
        Date currTime = new Date();
    }

    public void stop() {

    }

    public int getTime() {

    }
}

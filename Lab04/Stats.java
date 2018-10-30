package cs2030.simulator;

/**
 *  Stats class manages the statistics of a simulation.
 *
 *  @author Ahmed Bahajjaj
 */
public class Stats {
    private int leaveCnt;
    private int serveCnt;
    private double waitTime;

    /**
     *  Constructor initialises to 0 the leave count, serve count, and total wait time.
     */
    public Stats() {
        leaveCnt = 0;
        serveCnt = 0;
        waitTime = 0;
    }

    public int getLeaveCnt() {
        return leaveCnt;
    }

    public int getServeCnt() {
        return serveCnt;
    }

    public double getWaitTime() {
        return waitTime;
    }

    public void addLeaveCnt() {
        leaveCnt++;
    }

    public void addServeCnt() {
        serveCnt++;
    }

    public void addWaitTime(double t) {
        waitTime += t;
    }
}

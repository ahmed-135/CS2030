package cs2030.simulator;

/**
 *  Server class represents a server.
 *
 *  @author Ahmed Bahajjaj
 */
public class Server implements Comparable<Server> {
    //private double serveTime;
    private double nextTime;
    private int space;
    private int queue;
    private final int id;
    private static int count = 1;
    private boolean state;

    /**
     *  Unique id is generated for each server. Time reference of server initialised to 0.
     *
     *  @param  s   Space of the queue a server can manage.
     */
    public Server(int s) {
        //serveTime = t;
        nextTime = 0;
        space = s + 1;
        queue = space;
        id = count;
        count++;
        state = false;
    }

    @Override
    public int compareTo(Server svr) {
        if (this.space > svr.space) {
            return -1;
        } else if (this.space == svr.space) {
            if (this.id < svr.id) {
                return -1;
            } else if (this.id > svr.id) {
                return 1;
            } else {
                return 0;
            }
        } else {
            return 1;
        }
    }

    public void setState(boolean b) {
        state = b;
    }

    public boolean getState() {
        return state;
    }

    /*
    public double getServeTime() {
        return serveTime;
    }*/

    public double getNextTime() {
        return nextTime;
    }

    public int getId() {
        return id;
    }

    public int getSpace() {
        return space;
    }

    public int getQueue() {
        return queue;
    }

    public void setNextTime(double t) {
        nextTime = t;
    }

    public void upSpace() {
        space++;
    }

    public void downSpace() {
        space--;
    }
}

package cs2030.simulator;

/**
 *  Server class represents a server.
 *
 *  @author Ahmed Bahajjaj
 */
public class Server {
    //private double serveTime;
    private double nextTime;
    private int space;
    private final int id;
    private static int count = 1;

    /**
     *  Unique id is generated for each server. Time reference of server initialised to 0.
     *
     *  @param  s   Space of the queue a server can manage.
     */
    public Server(int s) {
        //serveTime = t;
        nextTime = 0;
        space = s;
        id = count;
        count++;
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

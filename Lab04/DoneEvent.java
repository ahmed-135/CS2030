package cs2030.simulator;

/**
 *  Done Event represents a customer who is done being served.
 *
 *  @author Ahmed Bahajjaj
 */
public class DoneEvent extends Event {
    private double time;
    private Customer cust;
    private int svrId;

    /**
     *  Constructor takes reference from previous event.
     *
     *  @param  t       Time reference of this event.
     *  @param  cust    Customer to be referenced.
     *  @param  i       ID of Server managing this event.
     */
    public DoneEvent(double t, Customer cust, int i) {
        time = t;
        this.cust = cust;
        svrId = i;
    }
    
    public double getTime() {
        return time;
    }
    
    public Customer getCust() {
        return cust;
    }

    public int getServerId() {
        return svrId;
    }
    
    @Override
    public String toString() {
        return String.format("%.3f",time) + " " + cust.getId() + " done serving by " + svrId;
    }

    /**
     *  Method to execute the event.
     *  <p>In the case of a done event, the server's queue is freed up by one space.</p>
     *
     *  @param  shp Shop reference pointer.
     *  @param  st  Stats reference pointer.
     *  @return null
     */
    public Event execute(Shop shp, Stats st) {
        System.out.println(this);
        shp.getServer(svrId).upSpace();
        return null;
    }
}

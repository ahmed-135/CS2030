package cs2030.simulator;

/**
 *  Wait Event represents a customer waiting.
 *
 *  @author Ahmed Bahajjaj
 */
public class WaitEvent extends Event {
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
    public WaitEvent(double t, Customer cust, int i) {
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
        return String.format("%.3f",time) + " " + cust.getId() + " waits to be served by " + svrId;
    }

    /**
     *  Method to execute the event.
     *  <p>In the case of an wait event, the server's queue is shortened.
     *  The customer's projected waiting time is added to the statistics.</p>
     *
     *  @param  shp Shop reference pointer.
     *  @param  st  Stats reference pointer.
     *  @return A new serve event.
     */
    public Event execute(Shop shp, Stats st) {
        System.out.println(this);
        shp.getServer(svrId).downSpace();
        st.addWaitTime(shp.getServer(svrId).getNextTime() - time);

        return new ServeEvent(shp.getServer(svrId).getNextTime(), cust, svrId, false);
    }
}

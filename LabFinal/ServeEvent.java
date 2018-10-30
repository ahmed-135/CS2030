package cs2030.simulator;

/**
 *  Serve Event represents a customer being served.
 *
 *  @author Ahmed Bahajjaj
 */
public class ServeEvent extends Event {
    private double time;
    private Customer cust;
    private int svrId;
    private boolean newCus;

    /**
     *  Constructor takes reference from previous event.
     *
     *  @param  t       Time reference of this event.
     *  @param  cust    Customer to be referenced.
     *  @param  i       ID of Server managing this event.
     *  @param  nc      Whether this object was created from an arrive event. 
     */
    public ServeEvent(double t, Customer cust, int i, boolean nc) {
        time = t;
        this.cust = cust;
        svrId = i;
        newCus = nc;
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
        return String.format("%.3f",time) + " " + cust.getId() + " served by " + svrId;
    }

    /**
     *  Method to execute the event.
     *  <p>In the case of an serve event, the server is updated with a new time refernce.
     *  Server's queue is shortened if the customer being handled was not previously waiting.</p>
     *
     *  @param  shp Shop reference pointer.
     *  @param  st  Stats reference pointer.
     *  @return A new done event.
     */
    public Event execute(Shop shp, Stats st) {
        if (!shp.getServer(svrId).getState()) {
        System.out.println(this);
        shp.getServer(svrId).setNextTime(time + shp.getServeTime());
        if (newCus) {
            shp.getServer(svrId).downSpace();
        }
        st.addServeCnt();
        shp.getServer(svrId).setState(true);

        return new DoneEvent(shp.getServer(svrId).getNextTime(), cust, svrId);
        } else {
            st.addWaitTime(shp.getServer(svrId).getNextTime() - time);
            return new ServeEvent(shp.getServer(svrId).getNextTime(), cust, svrId, false);
        }
    }
}

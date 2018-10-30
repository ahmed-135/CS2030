package cs2030.simulator;

/**
 *  Leave Event represents a customer leaving.
 *
 *  @author Ahmed Bahajjaj
 */
public class LeaveEvent extends Event {
    private double time;
    private Customer cust;

    /**
     *  Constructor takes reference from previous event.
     *
     *  @param  t       Time reference of this event.
     *  @param  cust    Customer to be referenced.
     */
    public LeaveEvent(double t, Customer cust) {
        time = t;
        this.cust = cust;
    }
    
    public double getTime() {
        return time;
    }
    
    public Customer getCust() {
        return cust;
    }
    
    @Override
    public String toString() {
        return String.format("%.3f",time) + " " + cust.getId() + " leaves";
    }
    
    /**
     *  Method to execute the event.
     *  <p>In the case of an leave event, the statistics is updated.</p>
     *
     *  @param  shp Shop reference pointer.
     *  @param  st  Stats reference pointer.
     *  @return null
     */
    public Event execute(Shop shp, Stats st) {
        System.out.println(this);
        st.addLeaveCnt();
        return null;
    }
}

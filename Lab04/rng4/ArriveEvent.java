package cs2030.simulator;

/**
 *  Arrive Event represents an customer arriving.
 *
 *  @author Ahmed Bahajjaj
 */
public class ArriveEvent extends Event {
    private double time;
    private Customer cust;

    /**
     *  Constructor creates a new customer.
     *
     *  @param  t   Time reference of this event.
     */
    public ArriveEvent(double t) {
        time = t;
        cust = new Customer();
    }
    
    public double getTime() {
        return time;
    }
    
    public Customer getCust() {
        return cust;
    }
    
    @Override
    public String toString() {
        return String.format("%.3f",time) + " " + cust.getId() + " arrives";
    }

    /**
     *  Method to execute the event.
     *  <p>In the case of an arrival event, customer either leaves, waits, or is served immediately.
     *  Depending on availability of a Server.</p>
     *
     *  @param  shp Shop reference pointer.
     *  @param  st  Stats reference pointer.
     *  @return Either a serve, wait, or leave event.
     */
    public Event execute(Shop shp, Stats st) {
        System.out.println(this);
        int i = shp.findServer();

        if (i > 0) {
            if (shp.getServer(i).getSpace() == 2) {
                //Serve
                return new ServeEvent(time, cust, i, true);
            } else if (shp.getServer(i).getSpace() == 1) {
                //Wait
                return new WaitEvent(time, cust, i);
            } else {
                return null;
            }
        } else {
            //Leave
            return new LeaveEvent(time, cust);
        }
    }
}

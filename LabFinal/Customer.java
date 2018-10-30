package cs2030.simulator;

/**
 *  Customer class represents a customer.
 *
 *  @author Ahmed Bahajjaj
 */
public class Customer {
    //private double time;
    private final int id;
    private static int count = 1;

    /**
     *  Unique customer id is generated for each customer.
     */
    public Customer() {
        //time = t;
        id = count;
        count++;
    }
    
    /*
    public double getTime() {
        return time;
    }*/

    public int getId() {
        return id;
    }
    
    /*
    public void setTime(double t) {
        time = t;
    }*/
}

package cs2030.simulator;

/**
 *  Abstract Event class to represent an event.
 *
 *  @author Ahmed Bahajjaj
 */
public abstract class Event {
    protected Customer cust;
    protected double time;
    
    abstract double getTime();

    abstract Customer getCust();

    abstract Event execute(Shop shp, Stats st);
}

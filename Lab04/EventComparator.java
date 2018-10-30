package cs2030.simulator;

import java.util.Comparator;

/**
 *  Comparator class to manage queueing of Events.
 *
 *  @author Ahmed Bahajjaj
 */
public class EventComparator implements Comparator<Event> {
    
    /**
     *  Compare method looks at first the event time, 
     *  and second the customer ID associated to an event if the time is equal.
     */
    @Override
    public int compare(Event e1, Event e2) {
        if (e1.getTime() < e2.getTime()) {
            return -1;
        } else if (e1.getTime() == e2.getTime()) {
            if (e1.getCust().getId() < e2.getCust().getId()) {
                return -1;
            } else if (e1.getCust().getId() > e2.getCust().getId()) {
                return 1;
            } else {
                return 0;
            }
        } else {
            return 1;
        }
    }
}

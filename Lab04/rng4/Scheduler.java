package cs2030.simulator;

import java.util.PriorityQueue;

/**
 *  Scheduler creates and runs the simulation.
 *
 *  @author Ahmed Bahajjaj
 */
public class Scheduler {
    private Stats st;
    private Shop shp;
    private RandomGenerator rng;
    private PriorityQueue<Event> queue;
    private static double time = 0;

    /**
     *  Constructor receives variables required to create a simulation.
     *
     *  @param  s   Seed value of RandomGenerator.
     *  @param  sv  Number of Servers in the simulation.
     *  @param  cst Number of Customers in the simulation.
     *  @param  ar  Arrival Rate for use in RandomGenerator.
     *  @param  sr  Service Rate for use in RandomGenerator.
     */
    public Scheduler(int s, int sv, int cst, double ar, double sr) {
        rng = new RandomGenerator(s, ar, sr, 0);
        shp = new Shop(sv, rng);
        queue = new PriorityQueue<>(new EventComparator());
        st = new Stats();

        for (int i = 0; i < cst; i++) {
            queue.add(new ArriveEvent(time));
            time += rng.genInterArrivalTime();
        }
    }
    
    /**
     *  Method to run simulation.
     *  <p>Runs through the priority queue and executes events.
     *  New events created are added back into the queue.
     *  Statistics are printed out at the end of the simulation.</p>
     */
    public void simulate() {
        while (!queue.isEmpty()) {
            Event e = queue.poll();
            e = e.execute(shp, st);

            if (e != null) {
                queue.add(e);
            }
        }
        System.out.println("[" + String.format("%.3f",(st.getWaitTime() / st.getServeCnt())) 
            + " " + st.getServeCnt() + " " + st.getLeaveCnt() + "]");
    }
}

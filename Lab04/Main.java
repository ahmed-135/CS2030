import java.util.Scanner;
import cs2030.simulator.Scheduler;

/**
 *  Main class handles input and output. A Scheduler is created to run the simulation.
 *
 *  @author Ahmed Bahajjaj
 */
public class Main {

    /**
    *   Main method.
    *   @param  args    Arguments.
    */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int seed = sc.nextInt();
        int servers = sc.nextInt();
        int customers = sc.nextInt();
        double arriveRate = sc.nextDouble();
        double serveRate = sc.nextDouble();

        Scheduler sch = new Scheduler(seed, servers, customers, arriveRate, serveRate);
        sch.simulate();
    }
}

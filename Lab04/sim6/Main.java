import java.util.Scanner;
import java.util.LinkedList;

/** Main class handles input and runs simulation.
*   CS2030: Ahmed Bahajjaj
*/
public class Main {
    public static void main(String[] args) { 

        LinkedList<Customer> queue = new LinkedList<>();
        Scanner sc = new Scanner(System.in);
        int i = sc.nextInt();

        while(sc.hasNext()){
            queue.add(new Customer(sc.nextDouble()));
        }

        Simulator sim = new Simulator(queue, i);
        sim.simulate();
    }
}

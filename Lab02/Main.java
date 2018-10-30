/* Ahmed Bahajjaj - A0140051A
@@ CS2030 Lab02 - Discrete Event Simulator
@@ Main instantiates: Customer Queue, Scheduler
*/
import java.util.Scanner;
import java.util.LinkedList;

public class Main {
    public static void main(String[] args) { 

        LinkedList<Customer> queue = read();
        Scheduler sch = new Scheduler(queue);
        sch.simulate();
    }

    public static LinkedList<Customer> read(){

        LinkedList<Customer> queue = new LinkedList<>();
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            queue.add(new Customer(sc.nextDouble()));
        }
        return queue;
    }
}

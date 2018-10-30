import java.util.*;

public class Main {
    public static void main(String[] args) { 
        LinkedList<Customer> queue = read();
        double time = 0;

        for (int i=0; i < queue.size(); i++){
            Customer custom = queue.get(i);
            System.out.println(custom.getId()+" arrives at "+String.format("%.3f",custom.getArrive()));

            if (custom.getArrive() >= time){
                time = custom.getArrive()+1;
                System.out.println("Customer served; next service @ "+String.format("%.3f",time));
            }
            else{
                System.out.println("Customer leaves");
            }
        }
        System.out.println("Number of customers: "+queue.size());
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

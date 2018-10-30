/* Ahmed Bahajjaj - A0140051A
@@ CS2030 Lab02 - Discrete Event Simulator
*/
import java.util.Arrays;

public class Customer implements Comparable<Customer> {
    private double arrive;
    private int id;
    private Event evt;
    private int server;
    private static int count = 1;
    
    public Customer(double time){
        this.arrive = time;
        this.id = count;
        this.evt = Event.ARRIVES;
        server = 0;
        count++;
    }

    @Override
    public int compareTo(Customer other){
        if (this.arrive < other.arrive){
            return -1;
        }
        else if (this.arrive == other.arrive){
            if (this.id < other.id){
                return -1;
            }
            else if (this.id > other.id){
                return 1;
            }
            else{
                return 0;
            }
        }
        else{
            return 1;
        }
    }

    @Override
    public String toString(){
        return String.format("%.3f",this.arrive)+" "+this.id+" "+this.getEventStr();
    }

    public double getArrive(){
        return arrive;
    }

    public void setArrive(double t){
        this.arrive = t;
    }

    public int getId(){
        return id;
    }

    
    public Event getEvent(){
       return this.evt;
    }

    public void setEvent(Event e){
        this.evt = e;   
    }

    public void setServe(int i){
        server = i;
    }

    public int getServe(){
        return server;
    }

    public String getEventStr(){
        switch(this.evt){
            case ARRIVES:
            return "arrives";
            case SERVED:
            return "served";
            case WAITS:
            return "waits";
            case LEAVES:
            return "leaves";
            case DONE:
            return "done";
            default:
            return "";
        }
    }
}

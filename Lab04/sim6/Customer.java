import java.util.Arrays;

/** Customer object class implementing Comparable for Sorting.
*   CS2030: Ahmed Bahajjaj
*/
public class Customer implements Comparable<Customer> {
    private double arrive;  //Customer's time reference for next event    
    private int id;         //Customer's unique id
    private Event evt;      //Customer's next event state
    private int server;     //ID of server associated to Customer
    private static int count = 1;   //Static variable to assign Customer's ID
    
    /** Customer constructed using primarily static values.
    *   @param time Customer's arrival time
    */
    public Customer(double time){
        this.arrive = time;
        this.id = count;
        this.evt = Event.ARRIVES;
        server = 0;
        count++;
    }
    
    @Override
    /** Compares this customer with 'input' Customer for sorting.
    *   Compares (1) Time reference first, then (2) ID if time is equal.
    *   @param  other   The 'other' object to be compared to.
    *   @return a negative integer, zero, or a positive integer; as this object is less than, equal to, or greater than the 'other' object.
    */
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

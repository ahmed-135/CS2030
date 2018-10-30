/* Ahmed Bahajjaj - A0140051A
@@ CS2030 Lab02 - Discrete Event Simulator
@@ Customer class is base, event enumerated
*/
public class Customer {
    private double arrive;
    private int id;
    private Event evt;
    private static int count = 1;
    
    enum Event {
        ARRIVES, SERVED, WAITS, LEAVES, DONE;
    }

    public Customer(double time){
        this.arrive = time;
        this.id = count;
        this.evt = Event.ARRIVES;
        count++;
    }

    @Override
    public String toString(){
        return String.format("%.3f",this.arrive)+" "+this.id+" "+this.getEvent();
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

    public String getEvent(){
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

    public void setEvent(int i){
        switch(i){
            case 1:
            this.evt = Event.ARRIVES;
            break;
            case 2:
            this.evt = Event.SERVED;
            break;
            case 3:
            this.evt = Event.WAITS;
            break;
            case 4:
            this.evt = Event.LEAVES;
            break;
            case 5:
            this.evt = Event.DONE;
            break;
            default:
            this.evt = null;
            break;
        }
    }
}

import java.util.LinkedList;
import java.util.Collections;

/** Simulator Class to run simuation.
*   CS2030: Ahmed Bahajjaj
*/
public class Simulator {
    private Stats st;   //Stats to keep track of simulation's stats
    private Server[] svr;   //Server array for server initialisation
    private LinkedList<Customer> queue; //Customer queue

    /** Constructor to create a new simulation.
    *   @param q    LinkedList of customers to be simulated
    *   @param s    Number of servers to be simulated
    */
    public Simulator(LinkedList<Customer> q, int s){
        this.queue = q;
        svr = new Server[s];

        for (int i = 0; i < s; i++) {
            svr[i] = new Server(1);
        }
        st = new Stats();
    }

    /** Runs the simulation.
    *   Simulation is run by first sorting the queue, then polling the queue, then handling the customer polled.
    *   Prints out the statistics afterwards.
    */
    public void simulate(){

        while(!queue.isEmpty()){

            Collections.sort(queue);
            Customer cust = queue.poll();
            handleEvent(cust);
        }

        System.out.println("["+String.format("%.3f",(st.getWaitTime()/st.getServeCnt()))+" "+st.getServeCnt()+" "+st.getLeaveCnt()+"]");
    }

    /** Method to find available server.
    *   Checks first if any are idle, then if any have available space in their queue if all are busy.
    *   @param  s   Array of servers in simulation
    *   @return ID of next available server
    */
    public int findServer(Server[] s){
        int x = 0;

        for (Server sev : s){
            if (sev.getWait() == 2){
                x = sev.getId();
                break;
            }
        }

        if (x == 0){
            for (Server sev : s){
                if (sev.getWait() == 1){
                    x = sev.getId();
                    break;
                }
            }
        }

        return x;
    }

    /** Method to manage arriving customer.
    *   Customers arriving are filtered into one of three states depending on server availability at time of Customer arrival.
    *   @param  cust Customer to be managed.
    *   @param  i   ID of available server (if any)
    */
    public void eventArrive(Customer cust, int i){
        System.out.println(cust);
        int j = i-1;

        if (i > 0){
            if (svr[j].getWait() == 2){
                eventServe(cust, j, true);
            }
            else{
                st.addWaitTime(eventWait(cust, j));
            }
        }
        else{
            eventLeave(cust);
            st.addLeaveCnt();
        }
    }

    /** Method to serve a Customer.
    *   (1) Server's next available time gets updated.
    *   (2) Customer's next (a) time reference and (b) event reference gets updated.
    *   (3) Statistics updated
    *   (4) Server + Customer get updated depending on whether it's a new Customer or one already in the queue.
    *   (5) After printing, customer is set to 'Done' and added back into the queue.
    *   @param  cust    Customer to be served.
    *   @param  a   Server array index to be referenced (-1 of Server ID).
    *   @param  n   Whether customer to be served is new (true) or has been waiting in the queue (false).
    */
    public void eventServe(Customer cust, int a, boolean n){

        svr[a].setNextTime(cust.getArrive()+svr[a].getServeTime());
        cust.setEvent(Event.SERVED);
        st.addServeCnt();

        if(n){
            svr[a].downWait();
            cust.setServe(svr[a].getId());
        }
        
        System.out.println(cust+" by "+svr[a].getId());

        cust.setArrive(svr[a].getNextTime());
        cust.setEvent(Event.DONE);
        queue.add(cust);
    }

    /** Method to make a Customer wait.
    *   Modifies customer's (1) time reference, (2) server reference, and (3) Event reference.
    *   Modifies server's (a) time reference and (b) available space.
    *   Customer is then added back into the 'queue'.
    *   @param  cust    Customer to make wait
    *   @param  a   Server array index to be referenced (-1 of Server ID).
    *   @return Waiting time.
    */
    public double eventWait(Customer cust, int a){
        
        cust.setEvent(Event.WAITS);
        cust.setServe(svr[a].getId());
        svr[a].downWait();

        double waitTime = svr[a].getNextTime() - cust.getArrive();

        System.out.println(cust+" to be served by "+svr[a].getId());

        cust.setArrive(svr[a].getNextTime());
        queue.add(cust);

        return waitTime;
    }

    /** Method for a Customer to leave.
    *   @param  cust    Customer leaving.
    */
    public void eventLeave(Customer cust){
        cust.setEvent(Event.LEAVES);
        System.out.println(cust);
    }

    /** Method for a Customer to be 'done'.
    *   @param  cust    Customer done.
    */
    public void eventDone(Customer cust){
        svr[cust.getServe()-1].upWait();
        System.out.println(cust+" serving by "+svr[cust.getServe()-1].getId());
    }
    
    /** Method to handle a Customer from one of three states.
    *   Customer is either new, has been waiting, or is done.
    *   @param  cust    Customer to be handled.
    */
    public void handleEvent(Customer cust){
        switch(cust.getEvent()){
            case ARRIVES:
                int w = findServer(svr);
                eventArrive(cust, w);
                break;
            case WAITS:
                int y = cust.getServe()-1;
                eventServe(cust, y, false);
                break;
            default:
                eventDone(cust);
                break;
        }
    }
}

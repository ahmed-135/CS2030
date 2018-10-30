/** Ahmed Bahajjaj - A0140051A
*@@ CS2030 Lab02 - Discrete Event Simulator
*@@ Simulator instantiates: ServerArray, Stats
*/
import java.util.LinkedList;
import java.util.Collections;

public class Simulator {
    private Stats st;
    private Server[] svr;
    private LinkedList<Customer> queue;

    public Simulator(LinkedList<Customer> q, int s){
        this.queue = q;
        svr = new Server[s];

        for (int i = 0; i < s; i++) {
            svr[i] = new Server(1);
        }
        st = new Stats();
    }

    public void simulate(){

        while(!queue.isEmpty()){

            Collections.sort(queue);
            Customer cust = queue.poll();
            handleEvent(cust);
        }

        System.out.println("["+String.format("%.3f",(st.getWaitTime()/st.getServeCnt()))+" "+st.getServeCnt()+" "+st.getLeaveCnt()+"]");
    }

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

    public void eventArrive(Customer cust, int i){
        System.out.println(cust);
        int j = i-1;

        if (i > 0){
            if (svr[j].getWait() == 2){
                eventServe(cust, j, true);
            }
            else{
                eventWait(cust, j);
            }
        }
        else{
            eventLeave(cust);
        }
    }

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

    public void eventWait(Customer cust, int a){

        cust.setEvent(Event.WAITS);
        cust.setServe(svr[a].getId());
        svr[a].downWait();

        st.addWaitTime(svr[a].getNextTime() - cust.getArrive());

        System.out.println(cust+" to be served by "+svr[a].getId());

        cust.setArrive(svr[a].getNextTime());
        queue.add(cust);
    }

    public void eventLeave(Customer cust){
        cust.setEvent(Event.LEAVES);
        st.addLeaveCnt();
        System.out.println(cust);
    }

    public void eventDone(Customer cust){
        svr[cust.getServe()-1].upWait();
        System.out.println(cust+" serving by "+svr[cust.getServe()-1].getId());
    }
    
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

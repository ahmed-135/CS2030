/* Ahmed Bahajjaj - A0140051A
@@ CS2030 Lab02 - Discrete Event Simulator
@@ Scheduler instantiates: Server, Stats
@@ Scheduler functions: simulator
*/
import java.util.LinkedList;

public class Scheduler {
    private static Stats st;
    private static Server svr;
    private static LinkedList<Customer> queue;

    public Scheduler(LinkedList<Customer> q){
        this.queue = q;
        svr = new Server(1);
        st = new Stats();
    }

    public static void put (Customer cust){
        System.out.println(cust.toString());
    }
    
    public static void simulate(){
        do{
            Customer cust = queue.poll();

            if(queue.peek() == null){
                statChk(cust);
            }
            else if((cust.getArrive() >= queue.peekLast().getArrive()) && 
            (cust.getId() > queue.peekLast().getId())){
                queue.add(cust);
            }
            else{
                statChk(cust);
            }
        }while(queue.isEmpty() == false);

        System.out.println("["+String.format("%.3f",(st.getWaitTime()/st.getServeCnt()))+" "+
        st.getServeCnt()+" "+st.getLeaveCnt()+"]");
    }

    public static void statChk(Customer cust){
        if(cust.getEvent() != "done"){

            if(cust.getEvent() == "arrives"){
                put(cust);                        
            }
            if (svr.getBusy(cust.getArrive()) != true){

                svr.setNextTime(cust.getArrive()+svr.getServeTime());
                cust.setEvent(2);
                st.addServeCnt();

                put(cust);

                cust.setArrive(svr.getNextTime());
                cust.setEvent(5);
                queue.add(cust);
            }
            else if (queue.peekLast().getEvent() != "waits"){
                cust.setEvent(3);

                put(cust);
                            
                st.addWaitTime(svr.getNextTime() - cust.getArrive());
                cust.setArrive(svr.getNextTime());
                queue.add(cust);
            }
            else{
                cust.setEvent(4);
                st.addLeaveCnt();
                put(cust);
            }
        }
        else{
            put(cust); 
        }
    }
}

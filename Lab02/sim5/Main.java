import java.util.*;

public class Main {
    public static void main(String[] args) { 
        LinkedList<Customer> queue = read();
        Server svr = new Server(1);
        simulate(queue, svr);
    }

    public static LinkedList<Customer> read(){
        LinkedList<Customer> queue = new LinkedList<>();
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            queue.add(new Customer(sc.nextDouble()));
        }
        return queue;
    }

    public static void put (Customer cust){
        System.out.println(String.format("%.3f",cust.getArrive())+" "+
        cust.getId()+" "+cust.getEvent());
    }
    
    public static void simulate(LinkedList<Customer> queue, Server svr){
        Stats st = new Stats();
        do{
            Customer cust = queue.poll();
            
            if((queue.peek() != null) || (cust.getEvent() != "done")){
                if(queue.peek() == null){
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
                else if((cust.getArrive() >= queue.peekLast().getArrive()) && 
                    (cust.getId() > queue.peekLast().getId())){

                    queue.add(cust);
                }else{
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
            else{
                put(cust);
            }
        }while(queue.isEmpty() != true);

        System.out.println("["+String.format("%.3f",(st.getWaitTime()/st.getServeCnt()))+" "+
        st.getServeCnt()+" "+st.getLeaveCnt()+"]");
    }
}

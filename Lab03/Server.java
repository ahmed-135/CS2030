/** Server object class.
*   CS2030: Ahmed Bahajjaj
*/
public class Server {
    private double serveTime;   //Server's time taken to serve
    private double nextTime;    //Server's time reference for next available serve time
    private int id;     //Server's unique ID
    private int space;      //Amount of space available in server's queue
    private static int count = 1;   //Static variable used to assign Server's unique ID

    /** Server constructed primarily with static variables.
    *   @param  serveTime   Initialises serve duration of server
    */
    public Server (double serveTime){
        this.serveTime = serveTime;
        nextTime = 0;
        space = 2;
        id = count;
        count++;
    }

    public double getServeTime(){
        return serveTime;
    }

    public double getNextTime(){
        return nextTime;
    }

    public void setNextTime(double time){
        this.nextTime = time;
    }

    public void setServeTime(double time){
        this.serveTime = time;
    }

    public int getId(){
        return id;
    }

    public void setId(int i){
        this.id = i;
    }

    public int getWait(){
        return space;
    }

    public void upWait(){
        this.space++;
    }

    public void downWait(){
        this.space--;
    }
}

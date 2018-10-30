/* Ahmed Bahajjaj - A0140051A
@@ CS2030 Lab02 - Discrete Event Simulator
@@ Server class is base
*/
public class Server {
    private double serveTime;
    private double nextTime;
    private int id;
    private int space;
    private static int count = 1;

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

    /* Method no longer relevant
    public boolean getBusy(double time){
        if (time >= this.nextTime){
            return false;
        }else{
            return true;
        }
    }*/

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

/* Ahmed Bahajjaj - A0140051A
@@ CS2030 Lab02 - Discrete Event Simulator
@@ Server class is base
*/
public class Server {
    private double serveTime;
    private double nextTime;

    public Server (double serveTime){
        this.serveTime = serveTime;
        nextTime = 0;
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

    public boolean getBusy(double time){
        if (time >= this.nextTime){
            return false;
        }else{
            return true;
        }
    }
}

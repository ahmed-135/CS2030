public class Server {
    private double serveTime;
    private double nextTime;
    //private boolean busy;

    public Server (double serveTime){
        this.serveTime = serveTime;
        nextTime = 0;
        //busy = false;
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

    public boolean getBusy(double time){
        if (time >= this.nextTime){
            return false;
        }else{
            return true;
        }
    }

    /*public boolean getBusy(){
        return busy;
    }

    public void setBusy(boolean b){
        this.busy = b;
    }*/
}

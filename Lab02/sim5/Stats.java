public class Stats {
    private int leaveCnt;
    private int serveCnt;
    private double waitTime;
    
    public Stats(){
        leaveCnt = 0;
        serveCnt = 0;
        waitTime = 0;
    }

    public int getLeaveCnt(){
        return leaveCnt;
    }

    public int getServeCnt(){
        return serveCnt;
    }

    public double getWaitTime(){
        return waitTime;
    }

    public void addLeaveCnt(){
        this.leaveCnt++;
    }

    public void addServeCnt(){
        this.serveCnt++;
    }

    public void addWaitTime(double t){
        this.waitTime += t;
    }
}

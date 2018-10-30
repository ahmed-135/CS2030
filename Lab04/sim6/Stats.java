/** Stats class used to manage Statistics.
*   CS2030: Ahmed Bahajjaj
*/
public class Stats {
    private int leaveCnt;   //Used to track Leave Count
    private int serveCnt;   //Used to track Served Count
    private double waitTime;    //Used to track total Waiting Time
    
    /** Constructor initialised with static values.
    */
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

public class Customer {
    private double arrive;
    private int id;
    private static int count = 1;
    
    public Customer(double time){
        this.arrive = time;
        this.id = count;
        count++;
    }

    public double getArrive(){
        return arrive;
    }

    public int getId(){
        return id;
    }
}

//Point class - Ahmed
public class Point {
    private double x;
    private double y;
    
    public Point(){}

    //constructor
    public Point (double x, double y) {
        this.x = x;
        this.y = y;
    }

    //getters
    public double getX () {
        return x;
    }

    public double getY () {
        return y;
    }

    //find distance to another point
    public double distTo (Point q){
        double dispX = this.x - q.x;
        double dispY = this.y - q.y;
        return Math.sqrt(dispX * dispX + dispY * dispY);
    }

    //find angle to another point
    public double angleTo (Point q){
        return Math.atan2(q.y - this.y, q.x - this.x);
    }

    //move point
    public void move(double a, double d){
      this.x = this.x + (d * Math.cos(a));
      this.y = this.y + (d * Math.sin(a));
    }
}

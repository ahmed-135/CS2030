public class Point {
    private double x;
    private double y;
    
    public Point(){}

    public Point (double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double getX () {
        return x;
    }

    public double getY () {
        return y;
    }

    public double distTo (Point q){
        double dispX = this.x - q.x;
        double dispY = this.y - q.y;
        return Math.sqrt(dispX * dispX + dispY * dispY);
    }

    public double angleTo (Point q){
        return Math.atan2(q.y - this.y, q.x - this.x);
    }
}

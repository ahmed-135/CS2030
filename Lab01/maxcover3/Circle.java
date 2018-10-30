public class Circle {
  private Point c;
  private double r;

  public Circle(Point c, double r){
    this.c = c;
    this.r = r;
  }

  public Point getCentre(){
    return c;
  }

  public double getRadius(){
    return r;
  }
}

/*
@ CS2030 Lab01 A0140051A Ahmed
@ Main class
*/
import java.util.Scanner;
public class Main {

  public static void main (String[] args) {
    //initalise scanner + define number of points
    Scanner sc = new Scanner(System.in);  
    int num = sc.nextInt();

    //initialise arrays & point holders
    double pts[] = new double[2];
    Point[] pointAr = new Point[num];
    Point[] midAr = new Point[num-1];
    double[] angleAr = new double[num-1];

    //read points
    for (int n = 0; n < num; n++){
      pts[0] = sc.nextDouble();//Double.parseDouble(sc.next());
      pts[1] = sc.nextDouble();//Double.parseDouble(sc.next());

      pointAr[n] = new Point(pts[0],pts[1]); 
    }

    //find all mid points & angles + Print
    for (int n = 0; n < (num-1); n++){
      midAr[n] = midPoint(pointAr[n], pointAr[n+1]);
      angleAr[n] = pointAr[n].angleTo(pointAr[n+1]);
      double dis = pointAr[n].distTo(pointAr[n+1]) / 2;
      if (dis <= 1){
        double d = Math.sqrt(1-(dis*dis));
        midAr[n].move(angleAr[n]+(Math.PI/2), d);

        String prPts = "("+String.format("%.3f", pointAr[n].getX())+", "+String.format("%.3f", pointAr[n].getY())+") and "+"("+String.format("%.3f", pointAr[n+1].getX())+", "+String.format("%.3f", pointAr[n+1].getY())+")";

      //String prMid = " has mid-point "+"("+String.format("%.3f", midAr[n].getX())+", "+String.format("%.3f", midAr[n].getY())+") and angle "+String.format("%.3f", angleAr[n]);

        String prCoin = " coincides with circle of centre ("+String.format("%.3f", midAr[n].getX())+", "+String.format("%.3f", midAr[n].getY())+")";

        System.out.println(prPts+prCoin);
      }
    }
  }
  
  //method to find mid point
  public static Point midPoint(Point p, Point q){
    double mx = (p.getX() + q.getX())/2;
    double my = (p.getY() + q.getY())/2;

    Point mid = new Point(mx, my);

    return mid;
  }
}

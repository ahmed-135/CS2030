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

    //initialise global variables
    double pts[] = new double[2];
    Point[] pointAr = new Point[num];
    Point[][] midAr = new Point[num][num];
    double[][] angleAr = new double[num][num];
    Circle[][] cirAr = new Circle[num][num];
    int maxDis = 0;

    //read points
    for (int n = 0; n < num; n++){
      pts[0] = sc.nextDouble();
      pts[1] = sc.nextDouble();

      pointAr[n] = new Point(pts[0],pts[1]); 
    }

    //Read all points, instantiate all eligible Circles
    for (int i = 0; i < num; i++){      
      for (int n = 0; n < num; n++){
        if (n != i){
          midAr[i][n] = midPoint(pointAr[i], pointAr[n]);
          double dis = pointAr[i].distTo(pointAr[n]) / 2;

          if (dis <= 1){
            angleAr[i][n] = pointAr[i].angleTo(pointAr[n]);
            double d = Math.sqrt(1-(dis*dis));
            midAr[i][n].move(angleAr[i][n]+(Math.PI/2), d);
            cirAr[i][n] = new Circle(midAr[i][n], 1);
          }
        }
      }
    }

    //Find max coverage, print
    maxDis = solve(pointAr, cirAr, num);
    if (maxDis > 0){
      System.out.println("Maximum Disc Coverage: "+maxDis);
    }
  }
  
  //method to find mid point
  public static Point midPoint(Point p, Point q){
    double mx = (p.getX() + q.getX())/2;
    double my = (p.getY() + q.getY())/2;

    Point mid = new Point(mx, my);

    return mid;
  }

  //method to iterate all circles with all points
  public static int solve(Point[] pt, Circle[][] cir, int cn){
    int max = 0;
    int chk = 0;

    for (int i=0; i < cn; i++){
      for (int n=0; n < cn; n++){
        chk = 0;
        if (cir[i][n] != null){
          for (Point pp : pt){
            if (cir[i][n].contains(pp)){
              chk++;
            }
          }
          if (chk > max){
            max = chk;
          }
        }
      }
    }

    return max;
  }
}

import java.util.Scanner;
public class Main {

  public static void main (String[] args) { 
    Scanner sc = new Scanner(System.in);  
    int num = sc.nextInt();
    double pts[] = new double[2];
    Point[] pointAr = new Point[num];

    for (int n = 0; n < num; n++){
        pts[0] = Double.parseDouble(sc.next());
        pts[1] = Double.parseDouble(sc.next());

        pointAr[n] = new Point(pts[0],pts[1]); 
    }

    for (int n = 0; n < num; n++){
    System.out.println("("+String.format("%.3f", pointAr[n].getX())+", "+String.format("%.3f", pointAr[n].getY())+")");
    }
  }
}

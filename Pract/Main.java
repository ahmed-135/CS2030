import java.util.Scanner;

public class Main {
    public static void main(String[] args){ 
        Scanner sc = new Scanner(System.in);

        while (sc.hasNext()) {
            City city1 = new City(sc.next());
            City city2 = new City(sc.next());
            Route route = new Route(city1, city2, sc.nextDouble());
            Manager.addRoute(route);
            Manager.addCity(city1);
            Manager.addCity(city2);
        }
        Manager.calculate();
        Manager.print();
    }
}

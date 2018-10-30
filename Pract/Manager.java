import java.util.ArrayList;
import java.util.Collections;

public class Manager {
    private static ArrayList<City> cities = new ArrayList<>();
    private static ArrayList<Route> routes = new ArrayList<>();
    private static ArrayList<String> mostCity = new ArrayList<>();
    private static ArrayList<Route> maxRoute = new ArrayList<>();

    public Manager() {}

    public static double maxDist() {
        double d = 0;
        for (int i = 0; i < routes.size(); i++) {
            if (routes.get(i).getDist() > d) {
                d = routes.get(i).getDist();
            }
        }
        return d;
    }

    public static int access() {
        int a = 0;
        int b = 0;
        
        for (City city : cities) {
            b = 0;
            for (Route route : routes) {
                if (city.toString().equals(route.getSrc().toString()) || 
                city.toString().equals(route.getDest().toString())) {
                    b++;
                }
            }
            if (b > a) {
                a = b;
            }
        }
        return a;
    }

    public static void calMax() {
        double d = maxDist();
        for (int i = 0; i < routes.size(); i++) {
            if (routes.get(i).getDist() == d) {
                maxRoute.add(routes.get(i));
            }
        }
    }

    public static void calMost() {
        int a = access();
        int b = 0;
        for (City city : cities) {
            b = 0;
            for (Route route : routes) {
                if (city.toString().equals(route.getSrc().toString()) || 
                city.toString().equals(route.getDest().toString())) {
                    b++;
                }
            }
            if (a == b) {
                mostCity.add(city.toString());
            }
        }
    }

    public static void calculate() {
        calMost();
        calMax();
        Collections.sort(mostCity);
        Collections.sort(maxRoute);
    }

    public static void addRoute(Route route) {
        if (routes.size() > 0) {
            if (checkDup(route)) {
                routes.add(route);
            }
        } else {
            routes.add(route);
        }
    }

    public static void addCity(City city) {
        int a = 0;

        if (cities.size() > 0) {
            for (int i = 0; i < cities.size(); i++) {
                String name1 = cities.get(i).toString();
                if (name1.equals(city.toString())) {
                   a = 1;
                   break;
                }
            }
        } 

        if (a == 0) {
            cities.add(city);
        }
    }

    public static void print() {
        System.out.println("Number of cities: " + cities.size());
        System.out.println("Number of routes: " + routes.size());
        System.out.println();

        System.out.println("List of cities:");
        for (int i = 0; i < cities.size(); i++) {
            System.out.println(cities.get(i));
        }
        System.out.println();

        System.out.println("List of routes:");
        for (int i = 0; i < routes.size(); i++) {
            System.out.println(routes.get(i));
        }
        System.out.println();

        System.out.println("Most accessible cities (sorted):");
        for (int i = 0; i < mostCity.size(); i++) {
            System.out.println(mostCity.get(i));
        }
        System.out.println();

        System.out.println("Longest routes (sorted):");
        for (int i = 0; i < maxRoute.size(); i++) {
            System.out.println(maxRoute.get(i));
        }
    }

    public static boolean checkDup(Route route) {
        for (int i = 0; i < routes.size(); i++) {
            String src = routes.get(i).getSrc().toString();
            String dest = routes.get(i).getDest().toString();

            if ((src.equals(route.getSrc().toString()) && 
                dest.equals(route.getDest().toString())) || 
                (dest.equals(route.getSrc().toString()) && 
                src.equals(route.getDest().toString()))) {
                return false;
            } 
        }

        if (route.getDest().toString().equals(route.getSrc().toString())) {
            return false;
        } else {
            return true;
        }
    }
}

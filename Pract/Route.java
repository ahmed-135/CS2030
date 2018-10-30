import java.util.Arrays;

public class Route implements Comparable<Route> {
    private double dist;
    private City src;
    private City dest;
    private int id;
    private static int count = 0;

    public Route(City src, City dest, double dist) {
        this.src = src;
        this.dest = dest;
        this.dist = dist;
        id = count;
        count++;
    }

    @Override
    public int compareTo(Route route) {
        String[] c1 = new String[2];
        c1[0] = this.src.toString();
        c1[1] = route.src.toString();
        Arrays.sort(c1);
        if (c1[0].equals(c1[1])) {
            String[] c2 = new String[2];
            c2[0] = this.dest.toString();
            c2[1] = route.dest.toString();
            Arrays.sort(c2);
            if (c2[0].equals(this.dest.toString()) && c2[1].equals(route.dest.toString())) {
                return -1;
            } else {
                return 1;
            }
        } else if (c1[0].equals(this.src.toString()) && c1[1].equals(route.src.toString())) {
            return -1;
        } else {
            return 1;
        }      
    }

    @Override
    public String toString() {
        return src + " and " + dest + " is " + String.format("%.1f", dist) + "km apart";
    }

    public City getSrc() {
        return src;
    }

    public int getId() {
        return id;
    }

    public City getDest() {
        return dest;
    }

    public double getDist() {
        return dist;
    }
}

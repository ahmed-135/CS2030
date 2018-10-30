public class City {
    private String name;
    private int id;
    private static int count = 0;

    public City(String name) {
        this.name = name;
        id = count;
        count++;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return name;
    }
}

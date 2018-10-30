public abstract class Food {
    protected String cat;
    protected String name;
    protected int price;
    protected int id;
    protected static int count = 0;

    abstract String getCat();

    abstract String getName();

    abstract int getPrice();

    abstract int getId();
}

import java.util.ArrayList;

public class Combo extends Food {
    private Food item1;
    private Food item2;
    private Food item3;
    private int price;
    private int id;
    private String cat;

    public Combo (ArrayList<Food> menu) {
        cat = "Combo";
        id = super.count;
        super.count++;
        item1 = menu.get(0);
        item2 = menu.get(1);
        item3 = menu.get(2);

        price = item1.getPrice() + item2.getPrice() + item3.getPrice() - 50;
    }

    public int getId() {
        return id;
    }

    public int getPrice() {
        return price;
    }

    public String getCat() {
        return cat;
    }
/*
    public void print() {
        System.out.println(this);

        System.out.println("   " + item1.toString());
        System.out.println("   " + item2.toString());
        System.out.println("   " + item3.toString());
    }*/

    @Override
    public String toString() {
        return "#" + id + " " + cat + " (" + price + ")\n   " +
        item1 + "\n   " + item2 + "\n   " + item3;
    }
}

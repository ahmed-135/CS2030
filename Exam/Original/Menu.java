//import java.util.PriorityQueue;
import java.util.ArrayList;

public class Menu {
    //private static PriorityQueue<Food> menu = new PriorityQueue<Food>(new MenuComparator());
    private static ArrayList<Food> menu = new ArrayList<Food>();
    private static ArrayList<Burger> burgers = new ArrayList<Burger>();
    private static ArrayList<Drink> drinks = new ArrayList<Drink>();
    private static ArrayList<Snack> snacks = new ArrayList<Snack>();
    private static ArrayList<Integer> orders = new ArrayList<Integer>();
    private static ArrayList<Combo> combos = new ArrayList<Combo>();

    public Menu() {}

    public static void addFood(String cat, String desc, int price) {
        if (cat.equals("Burger")) {
            burgers.add(new Burger(cat, desc, price));
        } else if (cat.equals("Snack")) {
            snacks.add(new Snack(cat, desc, price));
        } else if (cat.equals("Drink")) {
            drinks.add(new Drink(cat, desc, price));
        } else { }
    }

    public static void addCombo(int c1, int c2, int c3) {
        combos.add(new Combo(c1, c2, c3, menu));
    }

    public static void execute() {
        for (int i = 0; i < burgers.size(); i++) {
            Food f = burgers.get(i);
            System.out.println("#" + f.getId() + " " + f.getCat() + ": " + f.getName() + " (" + f.getPrice() + ")");
        }
        for (int i = 0; i < snacks.size(); i++) {
            Food f = snacks.get(i);
            System.out.println("#" + f.getId() + " " + f.getCat() + ": " + f.getName() + " (" + f.getPrice() + ")");
        }
        for (int i = 0; i < drinks.size(); i++) {
            Food f = drinks.get(i);
            System.out.println("#" + f.getId() + " " + f.getCat() + ": " + f.getName() + " (" + f.getPrice() + ")");
        }
        /*while(!menu.isEmpty()) {
            Food f = menu.poll();
            System.out.println("#" + f.getId() + " " + f.getCat() + ": " + f.getName() + " (" + f.getPrice() + ")");
        }*/
    }

    public static void addOrder(int num) {
        //orders.add(num);
        for (int i = 0; i < burgers.size(); i++) {
            if (num == burgers.get(i).getId()) {
                menu.add(burgers.get(i));
                break;
            }
        }
        for (int i = 0; i < snacks.size(); i++) {
            if (num == snacks.get(i).getId()) {
                menu.add(snacks.get(i));
                break;
            }        }
        for (int i = 0; i < drinks.size(); i++) {
            if (num == drinks.get(i).getId()) {
                menu.add(drinks.get(i));
                break;
            }
        }
    }

    public static void order() {
        System.out.println("--- Order ---");
        int total = 0;
        for (int i = 0; i < menu.size(); i++) {
            Food f = menu.get(i);
            total += f.getPrice();
            System.out.println("#" + f.getId() + " " + f.getCat() + ": " + f.getName() + " (" + f.getPrice() + ")");
        }
        System.out.println("Total: " + total);
    }
}

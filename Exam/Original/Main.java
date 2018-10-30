import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //int x = 0;

        while(sc.next().equals("add")) {
            String type = sc.next();
            if (type != "Combo") {
                String desc = sc.next();
                int price = sc.nextInt();

                Menu.addFood(type, desc, price);
                //System.out.println("#" + x + " " + type + ": " + desc + " (" + price + ")");
                //x++;
            } else {
                int c1 = sc.nextInt();
                int c2 = sc.nextInt();
                int c3 = sc.nextInt();

                Menu.addCombo(c1, c2, c3);
            }
        }

        Menu.execute();

        while(sc.hasNext()) {
            Menu.addOrder(sc.nextInt());
        }

        Menu.order();
    }
}

import java.util.Comparator;

public class MenuComparator implements Comparator<Food> {

    @Override
    public int compare(Food f1, Food f2) {
        if (f1.getCat().equals("Burger")) {
            if (!f2.getCat().equals("Burger")) {
                return 1;
            } else if (f1.getId() < f2.getId()) {
                return -1;
            } else if (f1.getId() > f2.getId()) {
                return 1;
            } else {
                return 0;
            }
        } else if (f1.getCat().equals("Drink")) {
            if (!f2.getCat().equals("Drink")) {
                return -1;
            } else if (f1.getId() < f2.getId()) {
                return -1;
            } else if (f1.getId() > f2.getId()) {
                return 1;
            } else {
                return 0;
            }
        } else {
            return 0;
        }
    }
}

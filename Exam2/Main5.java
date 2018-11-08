import java.util.Scanner;
import java.util.ArrayList;
import java.util.stream.IntStream;
import java.util.*;

class Main {
    static Scanner sc = new Scanner(System.in);
    static ArrayList<Student> stu = new ArrayList<Student>();
    static ArrayList<Mark> mar = new ArrayList<Mark>();

    public static void main(String[] args) {
        ArrayList<String> plab = new ArrayList<>();
        ArrayList<String> id = new ArrayList<>();
        ArrayList<Integer> group = new ArrayList<>();
        ArrayList<String> mlab = new ArrayList<>();
        ArrayList<Integer> marks = new ArrayList<>();
        ArrayList<Student> abs = new ArrayList<>();
        int b = 0;

        while (!sc.hasNext("end")) {
            plab.add(sc.next());
            id.add(sc.next());
            group.add(sc.nextInt());
        }
        for (int i = 0; i < group.size(); i++) {
            stu.add(new Student(plab.get(i), id.get(i), group.get(i)));
        }
        Collections.sort(group);
        int[] grp = group.stream().distinct().mapToInt(x -> x).sequential().toArray();
        
        sc.next();
        //plab.clear();
        while (!sc.hasNext("end")) {
            mlab.add(sc.next());
            marks.add(sc.nextInt());
        }
        for (int i = 0; i < mlab.size(); i++) {
            mar.add(new Mark(mlab.get(i), marks.get(i)));
            /*for (int x = 0; x < stu.size(); x++) {
                if (plab.get(i).getPlab() ==
            }*/
        }
        
        System.out.print("Groups(" + grp.length + "):[");
        for (int i = 0; i < grp.length; i++) {
            System.out.print(grp[i]);
            if (i != grp.length-1) {
                System.out.print(", ");
            }
        }
        System.out.println("]");
        for (int i = 0; i < stu.size(); i++) {
            System.out.print(stu.get(i));
            boolean t = false;
            for (int x = 0; x < mar.size(); x++) {
                if (mar.get(x).getPlab().equals(stu.get(i).getPlab())) {
                    t = true;
                    System.out.println("," + mar.get(x).getMark());
                    break;
                }
            }
            if (!t) {
                abs.add(stu.get(i));
                System.out.println(",0");
            }
        }
        System.out.println("List of absentees:");
        //boolean at = false;
        if (abs.size() > 0) {
            for (int i = 0; i < abs.size(); i++) {
                //at = true;
                System.out.println(abs.get(i));
            }
        } else {
            System.out.println("None");
        }

        int[] freq = new int[2];
        /*if (at) {
            freq[0] = marks.stream().mapToInt(x -> x).min().getAsInt();
        } else {
            freq[0] = 0;
        }*/
        freq[0] = marks.stream().mapToInt(x -> x).min().getAsInt();
        freq[1] = marks.stream().mapToInt(x -> x).max().getAsInt();
        long a = IntStream.rangeClosed(freq[0], freq[1]).count();
        System.out.println("Mark frequency from " + freq[0] + " to " + freq[1]);
        for (int i = freq[0]; i < a; i++) {
            b = 0;
            for (int y = 0; y < marks.size(); y++) {
                if (marks.get(i) == i) {
                    b++;
                }
            }
            System.out.println(i + " : " + b;//marks.stream().mapToInt(x -> x).filter(x -> x == b).count());
        }
    }
}

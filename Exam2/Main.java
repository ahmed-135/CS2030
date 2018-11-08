import java.util.Scanner;
import java.util.ArrayList;
import java.util.stream.IntStream;
import java.util.Collections;

class Main {
    static Scanner sc = new Scanner(System.in);
    static ArrayList<Student> stu = new ArrayList<Student>();
    static ArrayList<Mark> mar = new ArrayList<Mark>();
    static ArrayList<String> plab = new ArrayList<>();
    static ArrayList<String> id = new ArrayList<>();
    static ArrayList<Integer> group = new ArrayList<>();
    static ArrayList<String> mlab = new ArrayList<>();
    static ArrayList<Integer> marks = new ArrayList<>();
    static ArrayList<Student> abs = new ArrayList<>();
    
    public static void read() {
        while (!sc.hasNext("end")) {
            plab.add(sc.next());
            id.add(sc.next());
            group.add(sc.nextInt());
        }
        for (int i = 0; i < group.size(); i++) {
            stu.add(new Student(plab.get(i), id.get(i), group.get(i)));
        }
        sc.next();
        while (!sc.hasNext("end")) {
            mlab.add(sc.next());
            marks.add(sc.nextInt());
        }
        for (int i = 0; i < mlab.size(); i++) {
            mar.add(new Mark(mlab.get(i), marks.get(i)));
        }
    }
    
    public static int[] sortGrps() {
        Collections.sort(group);
        int[] grp = group.stream().distinct().mapToInt(x -> x).toArray();
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
        return grp;
    }
    
    public static void absent() {
        System.out.println("List of absentees:");
        if (abs.size() > 0) {
            for (int i = 0; i < abs.size(); i++) {
                System.out.println(abs.get(i));
            }
        } else {
            System.out.println("None");
        }
    }
    
    public static void mFreq(int g) {
        int[] freq = new int[2];
        freq[0] = marks.stream().mapToInt(x -> x).min().getAsInt();
        freq[1] = marks.stream().mapToInt(x -> x).max().getAsInt();
        int a = (int) IntStream.rangeClosed(freq[0], freq[1]).count();
        System.out.println("Mark frequency from " + freq[0] + " to " + freq[1]);
        int b = 0;
        for (int i = freq[0]; i < (freq[0] + a); i++) {
            b = 0;
            for (int y = 0; y < marks.size(); y++) {
                if (marks.get(y) == i && g == 0) {
                    b++;
                } else if (marks.get(y) == i && g != 0) {
                    for (int x = 0; x < stu.size(); x++) {
                        Student s = stu.get(x);
                        if (mlab.get(y).equals(s.getPlab()) && s.getGroup() == g) {
                            b++;
                        }
                    }
                }
            }
            System.out.println(i + " : " + b);
        }
    }
    
    public static void grpFreq(int[] dg) {
        for (int n = 0; n < dg.length; n++) {
            boolean t = false;
            for (int i = 0; i < stu.size(); i++) {
                for (int x = 0; x < mar.size(); x++) {
                    if (mar.get(x).getPlab().equals(stu.get(i).getPlab())
                        && stu.get(i).getGroup() == dg[n]) {
                        t = true;
                        break;
                    }
                }
            }
            if (t) {
                System.out.print("Group #" + dg[n] + "...");
                mFreq(dg[n]);
            }
        }
    }

    public static void main(String[] args) {
        read();
        int[] distGrp = sortGrps();
        absent();
        mFreq(0);
        grpFreq(distGrp);
    }
}

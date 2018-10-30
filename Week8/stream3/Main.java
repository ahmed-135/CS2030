import java.util.Scanner;
import java.util.stream.IntStream;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //System.out.println(isPerfect(sc.nextInt()));
        //System.out.println(isSquare(sc.nextInt()));
        System.out.println(reverse(sc.nextInt()));
;
        /*ArrayList<Integer> list = new ArrayList<Integer>();
        while (sc.hasNext()) {
            list.add(sc.nextInt());
        }
        int[] array = list.stream().mapToInt(Integer::intValue).toArray();
        System.out.println("Number of occurrences: " + countRepeats(array));*/
    }

    public static boolean isPerfect(int n) {
        return n == IntStream
            .range(1,n)
            .filter(x -> n % x == 0)
            .sum();
    }

    public static boolean isSquare(int n) {
        return IntStream
            .range(1,n)
            .map(x -> x * x)
            .anyMatch(y -> y == n);
    }

    public static int reverse(int n) {
        return IntStream
            .iterate(n, x -> x / 10)
            .limit(String.valueOf(n).length())
            .map(x -> x % 10)
            .reduce(0, (a,b) -> (a * 10) + b);
    }

    public static long countRepeats(int[] array) {
        return IntStream
            .range(1,array.length)
            .filter(y -> array[y - 1] == array[y])
            .filter(y -> (y == array.length - 1) || (array[y] != array[y + 1]))
            .count();
    }
}

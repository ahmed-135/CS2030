import java.util.Scanner;
import java.util.stream.IntStream;
import java.util.ArrayList;
import java.util.OptionalDouble;
import java.util.NoSuchElementException;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //System.out.println(isPerfect(sc.nextInt()));
        //System.out.println(isSquare(sc.nextInt()));
        //System.out.println(reverse(sc.nextInt()));
        /*
        ArrayList<Integer> list = new ArrayList<Integer>();
        while (sc.hasNext()) {
            list.add(sc.nextInt());
        }
        int[] array = list.stream().mapToInt(Integer::intValue).toArray();
        System.out.println("Number of occurrences: " + countRepeats(array));
        System.out.println("Variance: " + variance(array));
        */
        int x = sc.nextInt();
        System.out.print("Prime factors of " + x + " are:");
        primeFactors(x).forEach(y -> System.out.print(" " + y));
        System.out.println();
    }

    public static IntStream primeFactors(int x) {
        return IntStream
            .rangeClosed(2, x)
            .filter(y -> (x % y) == 0)
            .filter(y -> IntStream.range(2,y).noneMatch(i -> (y % i) == 0));
    }

    public static boolean isPerfect(int n) {
        return n == IntStream
            .range(1,n)
            .filter(x -> n % x == 0)
            .sum();
    }

    public static boolean isSquare(int n) {
        return IntStream
            .rangeClosed(0,n)
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

    public static OptionalDouble variance(int[] array) {
        try {
            double avg = IntStream
                .of(array)
                .average()
                .getAsDouble();
            double total = IntStream
                .range(0,array.length)
                .mapToDouble(x -> array[x] - avg)
                .map(y -> y * y)
                .sum();
            
            if (array.length > 1) {
                return OptionalDouble.of(total/(array.length-1));
            } else {
                return OptionalDouble.empty();
            }
        } catch (NoSuchElementException e) {
            return OptionalDouble.empty();
        }
    }
}

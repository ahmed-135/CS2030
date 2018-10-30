import cs2030.mystream.InfiniteList;
import java.util.stream.*;

public class Main {
    public static void main(String[] args){ 
        //IntStream.generate( () -> 1).count();
        //System.out.println(InfiniteList.iterate(0, x -> x + 1).limit(2).limit(4).count());
        //System.out.println(InfiniteList.iterate(0, x -> x + 1).limit(4).filter(x -> x < 2).count());
        /*InfiniteList
        .iterate(1, x -> x+1)
        .filter(x -> x % 2 == 0)
        .limit(10)
        .takeWhile(x -> x < 15)
        .forEach(System.out::println);*/
        //System.out.println(InfiniteList.iterate(0, x -> x + 1).limit(4).filter(x -> x < 2).count());
        //IntStream.iterate(1, x -> x+1).takeWhile(x -> x < 2).forEach(System.out::println);
        //long i = InfiniteList.iterate(0, x -> x + 1).map(x -> 2 * x).map(x -> x / 2).limit(8).filter(x -> x % 3 == 0).map(x -> x * x).count();//forEach(System.out::println);
        //System.out.println(i);
        System.out.println(InfiniteList
        .iterate(0, x -> x + 1)
        .map(x -> x * x)
        .limit(5)
        .reduce(0, (x, y) -> x + y));
    }
}

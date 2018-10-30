import cs2030.mystream.MyIntStream;

public class Main {

    public static void main(String[] args){
        System.out.println(MyIntStream.of(1,1,2,3,3,4).distinct().sum());
    }
}

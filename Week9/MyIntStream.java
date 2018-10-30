package cs2030.mystream;

import java.util.OptionalDouble;
import java.util.OptionalInt;
import java.util.function.IntPredicate;
import java.util.function.IntUnaryOperator;
import java.util.function.IntBinaryOperator;
import java.util.function.IntConsumer;

public interface MyIntStream {

    public static MyIntStream of(int... values) {
        return new Ahmed(values);
    }

    public static MyIntStream of(int i) {
        return new Ahmed(i);
    }

    public static MyIntStream range(int start, int end) {
        return new Ahmed(start, end, false);
    }

    public static MyIntStream rangeClosed(int start, int end) {
        return new Ahmed(start, end, true);
    }

    //Terminal
    public abstract int count();

    public abstract int sum();

    public abstract OptionalDouble average();

    public abstract OptionalInt max();

    public abstract OptionalInt min();

    public abstract void forEach(IntConsumer action);

    //Intermediate
    public abstract MyIntStream limit(int max);

    public abstract MyIntStream distinct();

    public abstract MyIntStream filter(IntPredicate p);

    public abstract MyIntStream map(IntUnaryOperator mapper);

    //Reduce Terminal
    public abstract int reduce(int iden, IntBinaryOperator op);

    public abstract OptionalInt reduce(IntBinaryOperator op);
}

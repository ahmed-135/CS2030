package cs2030.mystream;

import java.util.ArrayList;
import java.util.TreeSet;
import java.util.OptionalDouble;
import java.util.OptionalInt;
import java.util.function.IntPredicate;
import java.util.function.IntUnaryOperator;
import java.util.function.IntBinaryOperator;
import java.util.function.IntConsumer;

public class Ahmed implements MyIntStream {
    private ArrayList<Integer> list;

    public Ahmed(int i) {
        list = new ArrayList<>();
        list.add(i);
    }

    public Ahmed(int... values) {
        list = new ArrayList<>();
        for (int i = 0; i < values.length; i++) {
            list.add(values[i]);
        }
    }

    public Ahmed(Integer[] val) {
        list = new ArrayList<>();
        for (int i = 0; i < val.length; i++) {
            list.add(val[i]);
        }
    }

    public Ahmed(int start, int end, boolean closed) {
        list = new ArrayList<>();
        for (int i = start; i < end; i++) {
            list.add(i);
        }
        if (closed) {
            list.add(end);
        }
    }

    public int count() {
        return list.size();
    }

    public int sum() {
        int sum = 0;
        for (int i = 0; i < list.size(); i++) {
            sum += list.get(i);
        }
        return sum;
    }

    public OptionalDouble average() {
        if (list.size() > 1) {
            double sum = 0;
            for (int i = 0; i < list.size(); i++) {
                sum += list.get(i);
            }
            return OptionalDouble.of(sum / list.size());
        } else {
            return OptionalDouble.empty();
        }
    }

    public OptionalInt max() {
        if (list.isEmpty()) {
            return OptionalInt.empty();
        } else {
            int x = 0;
            for (int i = 0; i < list.size(); i++) {
                if (list.get(i) > x) {
                    x = list.get(i);
                }
            }
            return OptionalInt.of(x);
        }
    }

    public OptionalInt min() {
        if (list.isEmpty()) {
            return OptionalInt.empty();
        } else {
            int x = max().getAsInt();
            for (int i = 0; i < list.size(); i++) {
                if (list.get(i) < x) {
                    x = list.get(i);
                }
            }
            return OptionalInt.of(x);
        }
    }

    public void forEach(IntConsumer action) {
        for (int i = 0; i < list.size(); i++) {
            action.accept(list.get(i));
        }
    }

    public MyIntStream limit(int max) {
        Integer[] temp = new Integer[max];
        return new Ahmed(this.list.subList(0, max).toArray(temp));
    }

    public MyIntStream distinct() {
        TreeSet<Integer> set = new TreeSet<>(list);
        Integer[] temp = new Integer[set.size()];
        return new Ahmed(set.toArray(temp));
    }

    public MyIntStream filter(IntPredicate p) {
        ArrayList<Integer> pred = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            if (p.test(list.get(i))) {
                pred.add(list.get(i));
            }
        }
        Integer[] temp = new Integer[pred.size()];
        return new Ahmed(pred.toArray(temp));
    }

    public MyIntStream map(IntUnaryOperator mapper) {
        Integer[] temp = new Integer[list.size()];
        for (int i = 0; i < list.size(); i++) {
            temp[i] = mapper.applyAsInt(list.get(i));
        }
        return new Ahmed(temp);
    }

    public int reduce(int iden, IntBinaryOperator op) {
        int x = iden;
        for (int i = 0; i < list.size(); i++) {
            x = op.applyAsInt(x, list.get(i));
        }
        return x;
    }

    public OptionalInt reduce(IntBinaryOperator op) {
        if (list.size() > 1) {
            int x = list.get(0);
            for (int i = 1; i < list.size(); i++) {
                x = op.applyAsInt(x, list.get(i));
            }
            return OptionalInt.of(x);
        } else {
            return OptionalInt.empty();
        }
    }
}

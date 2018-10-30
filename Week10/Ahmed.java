package cs2030.mystream;

//import java.util.Scanner;
import java.util.function.Supplier;
import java.util.function.Consumer;
import java.util.function.UnaryOperator;
import java.util.function.Predicate;
import java.util.function.Function;
import java.util.function.BinaryOperator;
import java.util.Optional;
import java.util.ArrayList;

/**
 * Ahmed is the implementation class for InifiniteList.
 *
 * @author Ahmed Bahajjaj
 */

public class Ahmed<T> implements InfiniteList<T> {
    protected Supplier<? extends T> head;
    protected Supplier<Ahmed<T>> tail;
    //protected Predicate<? super T> pred;
    //protected T test;

    public Ahmed () {}

    public Ahmed(Supplier<? extends T> s, Supplier<Ahmed<T>> t) {
        head = s;
        tail = t;
        //pred = null;
        //test = null;
    }
   
    /*
    public Ahmed(Supplier<? extends T> s, Supplier<Ahmed<T>> t, Predicate<? super T> p) {
        head = s;
        tail = t;
        pred = p;
        //test = null;
    }

    public T get() {
        return head.get();
    }*/

    public static <T> Ahmed<T> generate(Supplier<? extends T> supplier) {
		return new Ahmed<T>(supplier,
			() -> Ahmed.generate(supplier));
	}

	public static <T> Ahmed<T> iterate(T seed, UnaryOperator<T> next) {
		return new Ahmed<T>(() -> seed,
			() -> Ahmed.iterate(next.apply(seed), next));
	}

    public boolean isEmpty() {
       return false;
    }

    /*
    public boolean isFiltered() {
        if (pred != null && head != null) {
            return !pred.test(head.get());
        } else {
            return false;
        }
    }

    public boolean isTailEmpty() {
        if (tail != null) {
            return false;
        } else {
            return true;
        }
    }
    */

    /**
    *   Terminal Operations.
    */
    public long count() {
        Ahmed<T> list = this;
        long i = 0;
        while (!list.isEmpty()) {
            if(list.head.get() != null) {
                i++;
            }
            //System.out.println(i);
            //(new Scanner(System.in)).nextLine();
            list = list.tail.get();
        }
        return i;
    }

    public void forEach(Consumer<? super T> a) {
        Ahmed<T> list = this;
        while (!list.isEmpty()) {
            T t = list.head.get();
            if (t != null) {
                a.accept(t);
            }
            //System.out.println(list);
            //(new Scanner(System.in)).nextLine();
            list = list.tail.get();
        }
    }

    public Optional reduce(BinaryOperator<T> accum) {
        Ahmed<T> list = this;
        if(list.head != null && list.tail != null) {
            T i = list.head.get();
            list = list.tail.get();
            while (!list.isEmpty()) {
                T t = list.head.get();
                if (t != null) {
                    i = accum.apply(i, t);
                }
                //System.out.println(list);
                //(new Scanner(System.in)).nextLine();
                list = list.tail.get();
            }
            return Optional.of(i);
        } else {
            return Optional.empty();
        }
    }

    public T reduce(T identity, BinaryOperator<T> accum) {
        Ahmed<T> list = this;
        T i = identity;
        while (!list.isEmpty()) {
            T t = list.head.get();
            if (t != null) {
                i = accum.apply(i, t);
            }
            //System.out.println(i);
            //(new Scanner(System.in)).nextLine();
            list = list.tail.get();
        }
        return i;
    }

    public Object[] toArray() {
        Ahmed<T> list = this;
        ArrayList<T> i = new ArrayList<T>();
        while (!list.isEmpty()) {
            T t = list.head.get();
            if (t != null) {
                i.add(t);
            }
            //System.out.println(i);
            //(new Scanner(System.in)).nextLine();
            list = list.tail.get();
        }
        return i.toArray();
    }

    /**
    *   Intermediate Operations.
    */
    public Ahmed<T> filter(Predicate<? super T> predicate) {
        if (head == null) {
            return new Empty<T>();
        }
        Wrapper<T> ref = new Wrapper<>();
        ref.data = this;
        return new Ahmed<T>(
        () -> {
            while (true) {
                if (ref.data.head != null) {
                    T t = ref.data.head.get();
                    //System.out.println(t);
                    if (t != null) { 
                        //System.out.println(predicate.test(t));
                        if (predicate.test(t)) {
                            return t;
                        }
                        ref.data = ref.data.tail.get();
                    } else {
                        return null;
                    }
                } else {
                    return null;
                }
            }
        }, 
        () -> {
            if (ref.data.head != null) {
                return ref.data.tail.get().filter(predicate);
            } else {
                return new Empty<T>();
            }
        });//, predicate);
    }


    public Ahmed<T> limit(long maxSize) {
        if (head == null) {
            return new Empty<T>();
        }
        if (maxSize > 1) {
            return new Ahmed<T>(head, () -> tail.get().limit(maxSize - 1));//, pred);
        } else if (maxSize == 1) {
            return new Ahmed<T>(head, () -> new Empty<T>());//, pred);
        } else {
            return new Empty<T>();
        }
    }

    public <R> Ahmed<R> map(Function<? super T, ? extends R> mapper) {
        //Predicate<R> p = (Predicate<R>) pred;
        if (head == null) {
            return new Empty<R>();
        }
        /*
        T t = head.get();
        //System.out.println(t);
        if (t != null) {
            //System.out.println(mapper.apply(t));
            return new Ahmed<R>(() -> mapper.apply(t), () -> tail.get().map(mapper));
        } else {
            return new Empty<R>();
        }*/
        Wrapper<T> ref = new Wrapper<>();
        ref.data = this;
        return new Ahmed<R>(
        () -> {
            if (ref.data.head != null) {
                T t = ref.data.head.get();
                //System.out.println(t);
                if (t != null) {
                    return mapper.apply(t);
                } else {
                    return null;
                }
            } else {
                return null;
            }
        }, () -> tail.get().map(mapper));
    }

    public Ahmed<T> takeWhile(Predicate<? super T> predicate) {
        /*if (head != null && predicate.test(head.get())) {
            return new Ahmed<T>(head, () -> tail.get().takeWhile(predicate));
        } else {
            return new Empty<T>();
        }*/
        if (head == null) {
            return new Empty<T>();
        }
        Wrapper<T> ref = new Wrapper<>();
        ref.data = this;
        return new Ahmed<T>(
        () -> {
            if (ref.data.head != null) {
                T t = ref.data.head.get();
                //System.out.println(t);
                if (t != null) { 
                    //System.out.println(predicate.test(t));
                    if (predicate.test(t)) {
                        return t;
                    } else {
                        ref.data.tail = () -> new Empty<T>();
                        return null;
                    }
                } else {
                    ref.data.tail = () -> new Empty<T>();
                    return null;
                }
            } else {
                ref.data.tail = () -> new Empty<T>();
                return null;
            }
        }, () -> ref.data.tail.get().takeWhile(predicate));
        /*
        T t = ref.data.head.get();
        boolean pass = false;
        if (t != null) {
            pass = predicate.test(t);
        }
        if (pass) {
            return new Ahmed<T>(() -> t, () -> ref.data.tail.get().takeWhile(predicate));
        } else {
            return new Empty<T>();
        }*/
    } 
}

package cs2030.mystream;

import java.util.function.Supplier;
import java.util.function.Consumer;
import java.util.function.UnaryOperator;
import java.util.function.Predicate;
import java.util.function.Function;
import java.util.function.BinaryOperator;
import java.util.Optional;

public interface InfiniteList<T> {
    public static <T> InfiniteList<T> generate(Supplier<? extends T> supplier) {
		return Ahmed.generate(supplier);
	}

	public static <T> InfiniteList<T> iterate(T seed, UnaryOperator<T> next) {
		return Ahmed.iterate(seed, next);
	}

    public abstract boolean isEmpty();

    //Terminal
    public abstract void forEach(Consumer<? super T> action);

    public abstract long count();

    public abstract Optional reduce(BinaryOperator<T> accum);

    public abstract T reduce(T identity, BinaryOperator<T> accum);

    public abstract Object[] toArray();
    
    //Intermediate
    public abstract InfiniteList<T> limit(long maxSize);

    public abstract InfiniteList<T> filter(Predicate<? super T> predicate);

    public abstract <R> InfiniteList<R> map(Function<? super T, ? extends R> mapper);

    public abstract InfiniteList<T> takeWhile(Predicate<? super T> predicate);
}

package velox.api.layer1.providers.data;

/**
 * Class Combination<T, M> represents a pair of values, similar to std::pair in C++.
 *
 * @param <T> the type of the first value
 * @param <M> the type of the second value
 */
public class Combination<T, M> {

    public final T first;
    public final M second;

    /**
     * Constructor for Combination.
     *
     * @param first  the first value
     * @param second the second value
     */
    public Combination(T first, M second) {
        this.first = first;
        this.second = second;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Combination)) return false;
        Combination<?, ?> that = (Combination<?, ?>) o;
        return first.equals(that.first) && second.equals(that.second);
    }

    @Override
    public int hashCode() {
        return 31 * first.hashCode() + second.hashCode();
    }
}
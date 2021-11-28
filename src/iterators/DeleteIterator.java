package iterators;

/**
 * The interface for iterator with delete possibility during iteration.
 *
 * @param <T> Type of objects of iterable collection
 */
public interface DeleteIterator<T> {
    boolean hasNext();
    T getNext();
    T getNextAndDelete() throws Exception;
    void reset();
}

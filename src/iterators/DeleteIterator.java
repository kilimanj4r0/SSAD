package iterators;

public interface DeleteIterator<T> {
    boolean hasNext();
    T getNext();
    T getNextAndDelete() throws Exception;
    void reset();
}

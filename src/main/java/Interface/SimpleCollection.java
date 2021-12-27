package Interface;

import java.util.Collection;

public interface SimpleCollection<T> {
    int size();

    boolean isEmpty();

    boolean contains(T o);

    T[] toArray();

    boolean add(T t);

    boolean remove(T o);

    boolean addAll(Collection<T> c);

    boolean removeAll(Collection<T> c);

    void clear();
}
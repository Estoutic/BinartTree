package Interface;

import java.util.ArrayList;
import java.util.Collection;

public interface SimpleCollection<T> {
    int size();

    boolean isEmpty();

    boolean contains(T o);

    ArrayList<T> toArray();

    boolean add(T t);

    boolean remove(T o);

    void addAll(Collection<T> c);

    void removeAll(Collection<T> c);

    void clear();
}
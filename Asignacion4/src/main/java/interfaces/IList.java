package interfaces;

import excepciones.ListException;
import java.util.Iterator;

public interface IList<T> {
    void append(T o) throws ListException;
    void insert(T o, int i) throws ListException;
    T get(int i) throws ListException;
    T remove(int i) throws ListException;
    boolean empty();
    int size();
    Iterator<T> iterator();
}

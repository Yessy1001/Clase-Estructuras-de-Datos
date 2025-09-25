package implementaciones;

import excepciones.ListException;
import interfaces.IList;
import java.util.Iterator;

public class ArrayList<T> implements IList<T>, Iterable<T> {
    protected int nElementos;
    private final int tamLista;
    private final T[] lista;

    private class ListIterator implements Iterator<T> {
        private int actual = 0;
        @Override
        public boolean hasNext() {
            return actual < nElementos;
        }
        @Override
        public T next() {
            return lista[actual++];
        }
    }

    public ArrayList(Class<T> tipoDato, int tamLista) {
        this.tamLista = tamLista;
        this.nElementos = 0;
        this.lista = (T[]) java.lang.reflect.Array.newInstance(tipoDato, tamLista);
    }

    @Override
    public void append(T o) throws ListException {
        if (nElementos >= tamLista)
            throw new ListException("Lista llena");
        lista[nElementos++] = o;
    }

    @Override
    public void insert(T o, int i) throws ListException {
        if (nElementos >= tamLista)
            throw new ListException("Lista llena");
        if (i < 0 || i > nElementos)
            throw new ListException("Índice fuera de límites");
        for (int j = nElementos; j > i; j--) {
            lista[j] = lista[j - 1];
        }
        lista[i] = o;
        nElementos++;
    }

    @Override
    public T get(int i) throws ListException {
        if (empty())
            throw new ListException("Lista vacía");
        if (i < 0 || i >= nElementos)
            throw new ListException("Índice fuera de límites");
        return lista[i];
    }

    @Override
    public T remove(int i) throws ListException {
        T o = get(i);
        for (int j = i; j < nElementos - 1; j++) {
            lista[j] = lista[j + 1];
        }
        nElementos--;
        return o;
    }

    @Override
    public boolean empty() {
        return nElementos == 0;
    }

    @Override
    public int size() {
        return nElementos;
    }

    @Override
    public Iterator<T> iterator() {
        return new ListIterator();
    }

    @Override
    public String toString() {
        StringBuilder s = new StringBuilder("[");
        for (int i = 0; i < nElementos; i++) {
            s.append(lista[i]);
            if (i < nElementos - 1) s.append(", ");
        }
        s.append("]");
        return s.toString();
    }
}

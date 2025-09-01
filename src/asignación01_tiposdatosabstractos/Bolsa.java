package asignación01_tiposdatosabstractos;

import java.util.*;

public class Bolsa<T> {
    private int tamBolsa;
    private ArrayList<T> objetos;


    // Constructor
    public Bolsa(int tamBolsa) {
        this.tamBolsa = tamBolsa;
        this.objetos = new ArrayList<>();
    }


    public int obtenNumObjetos() {
        return objetos.size();
    }


    public boolean vacia() {
        return objetos.isEmpty();
    }


    public boolean agrega(T objeto) {
        if (objetos.size() < tamBolsa) {
            objetos.add(objeto);
            return true;
    }
    return false;
    }


    public T remueve() {
        if (objetos.isEmpty()) return null;
        Random rand = new Random();
        int index = rand.nextInt(objetos.size());
        return objetos.remove(index);
    }


    public T remueve(T objeto) {
        if (objetos.contains(objeto)) {
            objetos.remove(objeto);
            return objeto;
        }
        return null;
    }


    public void limpia() {
     objetos.clear();
    }


    public int cuenta(T objeto) {
        int count = 0;
        for (T o : objetos) {
            if (o.equals(objeto)) count++;
        }
        return count;
    }


    public boolean contiene(T objeto) {
        return objetos.contains(objeto);
    }


    public ArrayList<T> obtenObjetos() {
        return new ArrayList<>(objetos);
    }
}
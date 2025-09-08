package implementaciones;

import abstractas.Bolsa;
import excepciones.BolsaException;
import java.util.Random;

public class BolsaImp extends Bolsa {

    public BolsaImp(int tamBolsa) {
        super(validarTamano(tamBolsa));
    }

    private static int validarTamano(int tamBolsa) {
        if (tamBolsa < 0) {
            throw new BolsaException("El tamaño de la bolsa no puede ser negativo");
        }
        return tamBolsa;
    }

    @Override
    public int obtenNumObjetos() {
        return numObjetos;
    }

    @Override
    public boolean vacia() {
        return numObjetos == 0;
    }

    @Override
    public void agrega(Integer objeto) {
        if (numObjetos >= tamBolsa) {
            throw new BolsaException("La bolsa está llena");
        }
        objetos[numObjetos++] = objeto;
    }

    @Override
    public Integer remueve() {
        if (vacia()) {
            throw new BolsaException("La bolsa está vacía");
        }
        Random rand = new Random();
        int idx = rand.nextInt(numObjetos);
        Integer eliminado = objetos[idx];
        for (int i = idx; i < numObjetos - 1; i++) {
            objetos[i] = objetos[i + 1];
        }
        objetos[--numObjetos] = null;
        return eliminado;
    }

    @Override
    public Integer remueve(Integer objeto) {
        if (vacia()) {
            throw new BolsaException("La bolsa está vacía");
        }
        for (int i = 0; i < numObjetos; i++) {
            if (objetos[i].equals(objeto)) {
                Integer eliminado = objetos[i];
                for (int j = i; j < numObjetos - 1; j++) {
                    objetos[j] = objetos[j + 1];
                }
                objetos[--numObjetos] = null;
                return eliminado;
            }
        }
        return null;
    }

    @Override
    public void limpia() {
        for (int i = 0; i < numObjetos; i++) {
            objetos[i] = null;
        }
        numObjetos = 0;
    }

    @Override
    public int cuenta(Integer objeto) {
        int count = 0;
        for (int i = 0; i < numObjetos; i++) {
            if (objetos[i].equals(objeto)) {
                count++;
            }
        }
        return count;
    }

    @Override
    public boolean contiene(Integer objeto) {
        for (int i = 0; i < numObjetos; i++) {
            if (objetos[i].equals(objeto)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public Integer[] obtenObjetos() {
        Integer[] copia = new Integer[numObjetos];
        for (int i = 0; i < numObjetos; i++) {
            copia[i] = objetos[i];
        }
        return copia;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        for (int i = 0; i < numObjetos; i++) {
            sb.append(objetos[i]);
            if (i < numObjetos - 1) sb.append(", ");
        }
        sb.append("]");
        return sb.toString();
    }
}
package main;

import implementaciones.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<Integer> numeros = new ArrayList<>(Integer.class, 10);

        System.out.println("Lista inicial (vacia): " + numeros);
        System.out.println("La lista esta vacia? " + numeros.empty());
        System.out.println("Tamano actual de la lista: " + numeros.size());

        numeros.append(10);
        System.out.println("Despues de append(10): " + numeros);
        numeros.append(20);
        System.out.println("Despues de append(20): " + numeros);
        numeros.append(30);
        System.out.println("Despues de append(30): " + numeros);

        numeros.insert(15, 1);
        System.out.println("Despues de insert(15, 1): " + numeros);

        numeros.remove(2);
        System.out.println("Despues de remove(2): " + numeros);

        int elem = numeros.get(1);
        System.out.println("Elemento en posicion 1: " + elem);

        System.out.println("La lista esta vacia? " + numeros.empty());
        System.out.println("Tamano actual de la lista: " + numeros.size());

        System.out.print("Iterando sobre la lista: ");
        for (Integer numero : numeros) {
            System.out.print(numero + " ");
        }
        System.out.println();
    }
}

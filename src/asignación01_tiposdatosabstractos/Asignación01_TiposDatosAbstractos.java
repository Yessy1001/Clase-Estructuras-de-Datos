
package asignaci�n01_tiposdatosabstractos;

import javax.swing.*;


public class Asignaci�n01_TiposDatosAbstractos {
    public static void main(String[] args) {
        String menu = "Seleccione una opci�n:\n" +
                "1. Probar Cilindro\n" +
                "2. Probar Bolsa\n" +
                "3. Salir";

    int opcion;
    do {
        opcion = Integer.parseInt(JOptionPane.showInputDialog(menu));


        switch (opcion) {
            case 1: // Probar Cilindro
                double radio = Double.parseDouble(JOptionPane.showInputDialog("Ingrese el radio del cilindro:"));
                double altura = Double.parseDouble(JOptionPane.showInputDialog("Ingrese la altura del cilindro:"));


                Cilindro c = new Cilindro(radio, altura);
                JOptionPane.showMessageDialog(null, "�rea del cilindro: " + c.area() +
                        "\nVolumen del cilindro: " + c.volumen());
                break;


            case 2: // Probar Bolsa
                int tam = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el tama�o m�ximo de la bolsa:"));
                Bolsa<String> bolsa = new Bolsa<>(tam);


                int opcionBolsa;
                do {
                    opcionBolsa = Integer.parseInt(JOptionPane.showInputDialog(
                        "Men� Bolsa:\n" +
                        "1. Agregar objeto\n" +
                        "2. Remover objeto al azar\n" +
                        "3. Remover objeto espec�fico\n" +
                        "4. Ver n�mero de objetos\n" +
                        "5. Ver si est� vac�a\n" +
                        "6. Contar un objeto\n" +
                        "7. Ver si contiene un objeto\n" +
                        "8. Ver todos los objetos\n" +
                        "9. Limpiar bolsa\n" +
                        "10. Salir del men� Bolsa"));

                    switch (opcionBolsa) {
                        case 1:
                            String obj = JOptionPane.showInputDialog("Ingrese el objeto a agregar:");
                            JOptionPane.showMessageDialog(null, bolsa.agrega(obj) ? "Agregado" : "No se pudo agregar (bolsa llena)");
                            break;
                        case 2:
                            JOptionPane.showMessageDialog(null, "Removido: " + bolsa.remueve());
                            break;
                        case 3:
                            String objRem = JOptionPane.showInputDialog("Ingrese el objeto a remover:");
                            JOptionPane.showMessageDialog(null, "Removido: " + bolsa.remueve(objRem));
                            break;
                        case 4:
                            JOptionPane.showMessageDialog(null, "N�mero de objetos: " + bolsa.obtenNumObjetos());
                            break;
                        case 5:
                            JOptionPane.showMessageDialog(null, bolsa.vacia() ? "La bolsa est� vac�a" : "La bolsa no est� vac�a");
                            break;
                        case 6:
                            String objContar = JOptionPane.showInputDialog("Ingrese el objeto a contar:");
                            JOptionPane.showMessageDialog(null, "Aparece: " + bolsa.cuenta(objContar) + " veces");
                            break;
                        case 7:
                            String objBuscar = JOptionPane.showInputDialog("Ingrese el objeto a buscar:");
                            JOptionPane.showMessageDialog(null, bolsa.contiene(objBuscar) ? "S� est� en la bolsa" : "No est� en la bolsa");
                            break;
                        case 8:
                            JOptionPane.showMessageDialog(null, "Objetos: " + bolsa.obtenObjetos());
                            break;
                        case 9:
                            bolsa.limpia();
                            JOptionPane.showMessageDialog(null, "Bolsa vaciada");
                             break;
                    }
                } while (opcionBolsa != 10);
                break;
            }
        } while (opcion != 3);
    }
}
    


package asignación01_tiposdatosabstractos;

import javax.swing.*;
import java.util.*;

public class Cilindro {
    private double radio;
    private double altura;


    // Constructor
    public Cilindro(double radio, double altura) {
        this.radio = radio;
        this.altura = altura;
    }


    // Área del cilindro (2?r² + 2?rh)
    public double area() {
        return 2 * Math.PI * radio * radio + 2 * Math.PI * radio * altura;
    }


    // Volumen del cilindro (?r²h)
    public double volumen() {
        return Math.PI * radio * radio * altura;
    }
}

package implementaciones;

import abstractas.Cilindro;

public class CilindroImp extends Cilindro {

    public CilindroImp(double radio, double altura) {
        super(validarRadio(radio), validarAltura(altura));
    }

    private static double validarRadio(double radio) {
        if (radio < 0) {
            throw new IllegalArgumentException("El radio debe ser no negativo");
        }
        return radio;
    }

    private static double validarAltura(double altura) {
        if (altura < 0) {
            throw new IllegalArgumentException("La altura debe ser no negativa");
        }
        return altura;
    }

    @Override
    public double area() {
        return 2 * Math.PI * radio * (radio + altura);
    }

    @Override
    public double volumen() {
        return Math.PI * radio * radio * altura;
    }

    @Override
    public String toString() {
        return "Cilindro(" + radio + ", " + altura + ")";
    }
}

package abstractas;

public abstract class Cilindro {
    protected double radio;
    protected double altura;

    public Cilindro(double radio, double altura) {
        this.radio = radio;
        this.altura = altura;
    }

    public abstract double area();
    public abstract double volumen();
}

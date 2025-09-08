package abstractas;

public abstract class Bolsa {
    protected int tamBolsa;
    protected int numObjetos;
    protected Integer[] objetos;

    public Bolsa(int tamBolsa) {
        this.tamBolsa = tamBolsa;
        this.numObjetos = 0;
        this.objetos = new Integer[tamBolsa];
    }

    public abstract int obtenNumObjetos();
    public abstract boolean vacia();
    public abstract void agrega(Integer objeto);
    public abstract Integer remueve();
    public abstract Integer remueve(Integer objeto);
    public abstract void limpia();
    public abstract int cuenta(Integer objeto);
    public abstract boolean contiene(Integer objeto);
    public abstract Integer[] obtenObjetos();
}

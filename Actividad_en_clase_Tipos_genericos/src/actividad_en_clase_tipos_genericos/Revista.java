
package actividad_en_clase_tipos_genericos;

public class Revista extends MaterialDigital {

    public String fotografo;

    public Revista(String titulo, String autor, int a�o, String fotografo) {
        super(titulo, autor, a�o);
        this.fotografo = fotografo;
    }

    @Override
    public void showInfo() {
        System.out.println("Revista -> Titulo: " + this.titulo +
                           " | Autor: " + this.autor +
                           " | A�o: " + this.a�oPublicacion +
                           " | Fot�grafo: " + this.fotografo);
    }
}



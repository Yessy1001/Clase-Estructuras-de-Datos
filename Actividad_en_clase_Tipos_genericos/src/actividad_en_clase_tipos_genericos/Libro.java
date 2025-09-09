package actividad_en_clase_tipos_genericos;

public class Libro extends MaterialDigital {

    public Libro(String titulo, String autor, int a�o) {
        super(titulo, autor, a�o);
    }

    @Override
    public void showInfo() {
        System.out.println("Libro -> Titulo: " + this.titulo +
                           " | Autor: " + this.autor +
                           " | A�o: " + this.a�oPublicacion);
    }
}
   

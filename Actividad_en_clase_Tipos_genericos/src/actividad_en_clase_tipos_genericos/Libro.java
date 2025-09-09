package actividad_en_clase_tipos_genericos;

public class Libro extends MaterialDigital {

    public Libro(String titulo, String autor, int año) {
        super(titulo, autor, año);
    }

    @Override
    public void showInfo() {
        System.out.println("Libro -> Titulo: " + this.titulo +
                           " | Autor: " + this.autor +
                           " | Año: " + this.añoPublicacion);
    }
}
   


package actividad_en_clase_tipos_genericos;

public class Revista extends MaterialDigital {

    public String fotografo;

    public Revista(String titulo, String autor, int año, String fotografo) {
        super(titulo, autor, año);
        this.fotografo = fotografo;
    }

    @Override
    public void showInfo() {
        System.out.println("Revista -> Titulo: " + this.titulo +
                           " | Autor: " + this.autor +
                           " | Año: " + this.añoPublicacion +
                           " | Fotógrafo: " + this.fotografo);
    }
}



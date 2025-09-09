
package actividad_en_clase_tipos_genericos;

public class Actividad_en_clase_Tipos_genericos {

    public static void main(String[] args) {
        System.out.println("Hello World!");

        Inventario<Revista> inventario = new Inventario<>();
        Revista rev = new Revista("Forbes", "Alguien", 2025, "Alfonso");

        inventario.Agregar(rev);
        inventario.mostrarInventario();
    }
    
}
    
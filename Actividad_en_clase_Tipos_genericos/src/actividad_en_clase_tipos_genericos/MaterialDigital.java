
package actividad_en_clase_tipos_genericos;


public abstract class MaterialDigital {
    public String titulo;
    public String autor;
    public int a�oPublicacion;
    
    public MaterialDigital(String titulo, String autor, int a�o){
        this.titulo = titulo;
        this.autor = autor;
        this.a�oPublicacion = a�o;
    }    
    
    public abstract void showInfo();    
        
    
}

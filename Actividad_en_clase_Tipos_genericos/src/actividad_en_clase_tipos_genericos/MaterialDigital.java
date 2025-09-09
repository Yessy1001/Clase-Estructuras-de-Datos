
package actividad_en_clase_tipos_genericos;


public abstract class MaterialDigital {
    public String titulo;
    public String autor;
    public int añoPublicacion;
    
    public MaterialDigital(String titulo, String autor, int año){
        this.titulo = titulo;
        this.autor = autor;
        this.añoPublicacion = año;
    }    
    
    public abstract void showInfo();    
        
    
}

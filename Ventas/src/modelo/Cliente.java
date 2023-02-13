package modelo;

/**
 *
 * @author josea
 */
public class Cliente {
    
    private int id;
    private String nombre;
    private String apellido;
    
    public Cliente(){
        
    }
    public Cliente(int id, String nom, String apell){
        this.id = id;
        this.nombre = nom;
        this.apellido = apell;
    }

    public int getId() {
        return id;
    }
    
    /* No se recomienta permiso para editar ID
    public void setId(int id) {
        this.id = id;
    }*/

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    @Override
    public String toString() {
        return  id + " nombre=" + nombre + " "+ apellido;
    }
}

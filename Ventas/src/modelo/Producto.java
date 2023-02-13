package modelo;

/**
 *
 * @author josea
 */
public class Producto {
    
    private int id;
    private String nombre;
    private int cantidad;
    private int precioPromedio;
    
    public Producto(){
        
    }
    
    public Producto(int id, String nom, int precioPromedio, int cantidad){
        this.id = id;
        this.nombre = nom;
        this.cantidad = cantidad;
        this.precioPromedio = precioPromedio;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    } 

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public int getPrecioPromedio() {
        return precioPromedio;
    }

    public void setPrecioPromedio(int precioPromedio) {
        this.precioPromedio = precioPromedio;
    }
    

    @Override
    public String toString() {
        return  "id :" + id + " nombre: " + nombre + " cantidad: " + cantidad + " precio: " + precioPromedio ;
    }
}

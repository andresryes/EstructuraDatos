public class Producto {
    private int precio;
    private String nombre;
    private int codigo;

    public Producto(){

    }

    public Producto(int precio, String nombre, int codigo){
        this.precio = precio;
        this.nombre = nombre;
        this.codigo = codigo;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public int getPrecio() {
        return precio;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre(){
        return nombre;
    }

    public void setCodigo(int codigo){
        this.codigo = codigo;
    }

    public int getCodigo(){
        return codigo;
    }
}

public class Transaccion{
    private int suma;
    private String categoria;

    public void setSuma(int suma){
        this.suma = suma;
    }

    public int getSuma(){
        return this.suma;
    }

    public void setCategoria(String categoria){
        this.categoria = categoria;
    }

    public String getCategoria(){
        return this.categoria;
    }
}
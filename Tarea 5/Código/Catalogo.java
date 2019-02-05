public class Catalogo {
    private Producto[] catalogo = new Producto[10];

    public Producto[] getCatalogo(){
        return catalogo;
    }

    public Catalogo(){
        //Ingresa 10 productos iniciales
        for(int i = 0; i<10 ; i++){
            catalogo[i] = new Producto((i+1)*100, "Producto" + (i+1), i+1);
        }
    }

    public void imprimirLista(){
        for(int i = 0; i < 10 ; i++){
            System.out.println(catalogo[i].getCodigo() + " " + catalogo[i].getNombre() + " Q." +catalogo[i].getPrecio());
        }
    }

    public int getPrecioIdProducto(int codigo){
        int precio = 0;
        for(int i = 0; i <10 ; i++){
            if(catalogo[i].getCodigo()==codigo){
                precio = catalogo[i].getPrecio();
            }
        }
        return precio;
    }

    public int promedioPrecios(){
        int total = 0;
        for(int i = 0; i < 10 ; i++){
            total+=catalogo[i].getPrecio();
        }
        return total/catalogo.length;
    }

    public int precioProductoMasCaro(){
        Producto masCaro = new Producto();
        for(int i = 0; i < catalogo.length-1; i++){
            if(catalogo[i].getPrecio() > catalogo[i+1].getPrecio()){
                masCaro = catalogo[i];
            }else{
                masCaro = catalogo[i+1];
            }
        }

        if(masCaro.getPrecio()>catalogo[catalogo.length-1].getPrecio()){
            return  masCaro.getPrecio();
        }else{
            return catalogo[catalogo.length-1].getPrecio();
        }
    }
}

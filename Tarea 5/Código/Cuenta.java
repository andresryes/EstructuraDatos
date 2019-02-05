public class Cuenta {
    public static Transaccion[] cuenta = new Transaccion[100];

    private int cantidad = 0;

    private int saldoCompra = 0;
    private int saldoPagos=0;

    public void setCantidad(int cantidad){
        this.cantidad = cantidad;
    }

    public int getCantidad(){
        return this.cantidad;
    }

    public void agregarTransaccion(int precio, String categoria){
        Transaccion transaccion = new Transaccion();
        transaccion.setCategoria(categoria);
        transaccion.setSuma(precio);
        this.cuenta[this.getCantidad()] = transaccion;
        this.setCantidad(this.getCantidad()+1);
        if(categoria.equals("compra")){
            this.saldoCompra += precio;
        }
        else{
            this.saldoPagos += precio;
        }

    }

    public int getTotalCompras(){
        /*
        int total = 0;
        for(int i = 0; i<getCantidad(); i++){
            if(cuenta[i].getCategoria().equals("compra")){
                total+=cuenta[i].getSuma();
            }
        }
        return total;*/
        return saldoCompra;
    }

    public int getTotalPagos(){
        return saldoPagos;
    }

    public int getSaldo(){
        return this.saldoCompra-saldoPagos;
    }

    public void imprimirRecibo(){
        System.out.println("Recibo de compra");

    }
}

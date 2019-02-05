import java.util.*;
public class Main {
    public static Catalogo catalogo;
    public static Scanner sc;
    public static Cuenta cuenta;
    public static void main(String[] args) {
        System.out.println("Hello World!");
        catalogo = new Catalogo();
        sc = new Scanner (System.in);
        cuenta = new Cuenta();
        menu();
    }
    public static void menu() {
        Scanner sc = new Scanner(System.in);

        int opcion = 1;

        while (opcion != 10) {
            System.out.println("1. Ingresar una compra");
            System.out.println("2. Ingresar un pago");
            System.out.println("3. Mostrar el total de Compras");
            System.out.println("4. Mostrar el total de Pagos");
            System.out.println("5. Mostrar saldo");
            System.out.println("6. Mostrar promedio items");
            System.out.println("7. Producto mas caro");
            System.out.println("8. Mostrar recibo de pago");
            System.out.println("9. Eliminar pagos y ejecutar metodos");
            System.out.println("10. Salir");
            System.out.print("Ingrese una opcion: ");
            opcion = sc.nextInt();
            switch (opcion) {
                case 1:
                    catalogo.imprimirLista();
                    System.out.print("Ingrese el codigo del producto: ");
                    int precio = catalogo.getPrecioIdProducto(sc.nextInt());
                    cuenta.agregarTransaccion(precio, "compra");
                    menu();
                    break;
                case 2:
                    System.out.print("Ingrese la cantidad a pagar: ");
                    int cantidadAPagar = sc.nextInt();
                    cuenta.agregarTransaccion(cantidadAPagar, "pago");
                    menu();
                    break;
                case 3:
                    System.out.println(cuenta.getTotalCompras());
                    menu();
                    break;
                case 4:
                    System.out.println(cuenta.getTotalPagos());
                    menu();
                    break;
                case 5:
                    System.out.println(cuenta.getSaldo());
                    menu();
                    break;
                case 6:
                    System.out.println(catalogo.promedioPrecios());
                    menu();
                    break;
                case 7:
                    System.out.println(catalogo.precioProductoMasCaro());
                    menu();
                    break;
                case 8:
                    cuenta.imprimirRecibo();
                    menu();
                    break;
                case 9:
                    cuenta.eliminarPago(2);
                    cuenta.eliminarPago(4);
                    System.out.println(cuenta.getTotalCompras());
                    System.out.println(cuenta.getTotalPagos());
                    System.out.println(cuenta.getSaldo());
                    System.out.println(catalogo.promedioPrecios());
                    System.out.println(catalogo.precioProductoMasCaro());
                    cuenta.imprimirRecibo();
                    menu();
                    break;

                case 10:
                    System.out.println("Adios");
                    break;
            }
        }
    }
}

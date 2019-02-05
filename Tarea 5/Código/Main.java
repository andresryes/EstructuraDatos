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

        while (opcion != 0) {
            System.out.println("1. Ingresar una compra");
            System.out.println("2. Ingresar un pago");
            System.out.println("3. Mostrar el total de Compras");
            System.out.println("4. Mostrar el total de Pagos");
            System.out.println("5. Mostrar saldo");
            System.out.println("6. Mostrar promedio items");
            System.out.println("7. Debito mas grande");
            System.out.println("8. Mostrar cuantas operaciones se tiene");
            System.out.println("9. Imprimir los elementos de los arreglos");
            System.out.println("10. Eliminar creditos y ejecutar metodos");
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

                    menu();
                    break;
                case 9:

                    menu();
                    break;
                case 10:

                    menu();
                    break;
            }
        }
    }
}

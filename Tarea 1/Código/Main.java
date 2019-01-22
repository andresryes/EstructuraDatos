import java.io.*;
import java.util.Scanner;

public class Main{
    public static void main(String args[]){
        Sum s = new Sum();
        System.out.print("Ingrese un número:");
        Scanner sc = new Scanner(System.in);

        int numero = sc.nextInt();

        System.out.println(s.suma(numero, 1));
        int n = sc.nextInt();
        sc.close();

    }

}
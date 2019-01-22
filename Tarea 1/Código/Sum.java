import java.io.*;
import java.util.Scanner;
public class Sum{
    public int suma(int numero, int suma){
        if(numero==1){
            return suma;
        }
        else {
            suma+=numero;
            return suma(numero-1, suma);
        }
    }
}
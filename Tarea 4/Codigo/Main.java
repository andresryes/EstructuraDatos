import java.io.*;
import java.util.*;

public class Main{
	public static Transaccion[] debitos = new Transaccion[10];
	public static Transaccion[] creditos = new Transaccion[10];
	
	public static int conteoDebitos =0;
	public static int conteoCreditos=0;
	
	public static void main(String[] args){
		menu();
	}	
	
	public static void addDebit(){
		Transaccion t = new Transaccion();
		Scanner s = new Scanner(System.in);
		System.out.print("Ingrese el total:");
		t.setSuma(s.nextInt());
		t.setCat("debit");
		debitos[conteoDebitos] = t;
		conteoDebitos++;
		
	}
	
	public static void addCredit(){
		Transaccion t = new Transaccion();
		Scanner s = new Scanner(System.in);
		System.out.print("Ingrese el total:");
		t.setSuma(s.nextInt());
		t.setCat("credit");
		creditos[conteoCreditos] = t;
		conteoCreditos++;		
	}
	
	public static int calcularDebitos(){
		int total = 0;
		for(int i = 0; i<conteoDebitos; i++){
			total+=debitos[i].getSuma();
		}
		return total;
	}
	
	public static int calcularCreditos(){
		int total = 0;
		for(int i = 0; i<conteoCreditos; i++){
			total+=creditos[i].getSuma();
		}
		return total;	}
	
	public static int calcularSaldo(){
		return calcularCreditos()-calcularDebitos();
	}
	
	public static int calcularPromedio(){
		return calcularDebitos()/conteoDebitos;
	}
	
	public static int debitoMasGrande(){
		Transaccion t = new Transaccion();
		Transaccion masGrande;
		for(int i = 0; i<conteoDebitos-1; i++){
			if(debitos[i].getSuma()>debitos[i+1].getSuma()){
				t = debitos[i];
			}else{
				t = debitos[i+1];
			}
		}
		
		if (debitos[conteoDebitos-1].getSuma()>t.getSuma()){
			return debitos[conteoDebitos-1].getSuma();
		}else{
			return t.getSuma();
		}
	}
	
	public static int conteo(){
		return conteoCreditos+conteoDebitos;
	}
	
	public static void eliminar(int posicion){
		for(int i = posicion-1; i<creditos.length-1; i++){
			creditos[i] = creditos[i+1];
		}
		conteoCreditos--;
		creditos[creditos.length-2] = creditos[creditos.length-1];
	}
	
	public static void menu(){
		Scanner sc = new Scanner(System.in);
		
		int opcion = 1;
		
		while(opcion != 0){
			System.out.println("1. Ingresar un debito");
			System.out.println("2. Ingresar un credito");
			System.out.println("3. Mostrar el total de debitos");
			System.out.println("4. Mostrar el total de creditos ");
			System.out.println("5. Mostrar saldo");
			System.out.println("6. Mostrar promedio debitos");
			System.out.println("7. Debito mas grande");
			System.out.println("8. Mostrar cuantas operaciones se tiene");	
			System.out.println("9. Imprimir los elementos de los arreglos");
			System.out.println("10. Eliminar creditos y ejecutar metodos");
			System.out.print("Ingrese una opcion: ");
			opcion=sc.nextInt();
			switch(opcion){
				case 1:
					addDebit();
					menu();
				break;
				case 2:
					addCredit();
					menu();
				break;
				case 3:
					System.out.println(calcularDebitos());
					menu();
				break;
				case 4:
					System.out.println(calcularCreditos());
					menu();
				break;
				case 5:
					System.out.println(calcularSaldo());
					menu();
				break;
				case 6:
					System.out.println(calcularPromedio());
					menu();
				break;
				case 7:
					System.out.println(debitoMasGrande());
					menu();
				break;
				case 8:
					System.out.println(conteo());
					menu();
				break;
				case 9:
					for(int i=0; i<conteoCreditos;i++){
					System.out.println(creditos[i].getCategoria() + " " + creditos[i].getSuma());
					}
					for(int i=0; i<conteoDebitos;i++){
					System.out.println(debitos[i].getCategoria() + " " + debitos[i].getSuma());
					}
					menu();
				break;
				case 10:
					eliminar(3);
					eliminar(5);
					eliminar(7);
					System.out.println(calcularDebitos());
					System.out.println(calcularCreditos());
					System.out.println(calcularSaldo());
					System.out.println(calcularPromedio());
					System.out.println(debitoMasGrande());
					System.out.println(conteo());
					menu();
				break;
			}
		}
		
		
	};
}
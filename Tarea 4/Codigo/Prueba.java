import org.junit.Test;
import org.junit.Ignore;
import static org.junit.Assert.assertEquals;

public class Prueba {

   @Test
   public void esNegativo(int numero) {
      if(numero>=0){
         System.out.printl("el numero es positivo");
      }else{
         System.out.println("el numero es negativo");
      }
   }
   
   @Test
   public void afueraDeLosLimites(Transaccion[] transaccion, int cantidadIngresada) {
      if(transaccion.length >= cantidadIngresada){
         System.out.println("Aun se puede ingresar");
      }else{
         System.out.println("La cantidad ingresada ha rebasado el limite permitido")
      }
   }
   
   @Test
   public void verificarCorrimiento(Transaccion[] transaccion, int cantidadIngresada) {
      for(int i = 0; i < cantidadIngresada; i++){
         if(transaccion[i+1] == null && transaccion[i] == null){
            System.out.printl("no se ha generado el corrimiento");
         }
      }
   }
   
   
}

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CatalogoTest {

   @Test
   public void esNegativo(int numero) {
      if(numero>=0){
         System.out.printl("el numero es positivo");
      }else{
         System.out.println("el numero es negativo");
      }
   }
   
   @Test
   public void afueraDeLosLimites(Catalogo[] transaccion, int cantidadIngresada) {
      if(transaccion.length >= cantidadIngresada){
         System.out.println("Aun se puede ingresar");
      }else{
         System.out.println("La cantidad ingresada ha rebasado el limite permitido")
      }
   }
   
   @Test
   public void verificarCorrimiento(Catalogo[] transaccion, int cantidadIngresada) {
      for(int i = 0; i < cantidadIngresada; i++){
         if(transaccion[i+1] == null && transaccion[i] == null){
            System.out.printl("no se ha generado el corrimiento");
         }
      }
   }
   

}

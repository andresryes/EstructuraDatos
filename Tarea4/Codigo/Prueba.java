import org.junit.Test;
import org.junit.Ignore;
import static org.junit.Assert.assertEquals;

public class Prueba {
	Main m = new Main();

   @Test
   public void esNegativo() {
      System.out.println("Inside testSalutationMessage()");
      message = "Hi!" + "Robert";
      assertEquals(message,messageUtil.salutationMessage());
   }
   
   @Test
   public void afueraDeLosLimites() {
      System.out.println("Inside testSalutationMessage()");
      message = "Hi!" + "Robert";
      assertEquals(message,messageUtil.salutationMessage());
   }
   
   @Test
   public void verificarCorrimiento() {
      System.out.println("Inside testSalutationMessage()");
      message = "Hi!" + "Robert";
      assertEquals(message,messageUtil.salutationMessage());
   }
   
   
}

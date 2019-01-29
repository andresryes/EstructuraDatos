import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.*;

public class Test {

  @Rule
  public ExpectedException exception = ExpectedException.none();

  @Test
  public void throwsIllegalArgumentExceptionIfParameterIsNotAnInt() {
    exception.expect(IllegalArgumentException.class);
    exception.expectMessage("Only integer data allowed");
    Stack t = new Stack();
    t.push(new int[0], 1);
    assertTrue('it is a number', true);
  }
  
  @Test
  public void testExtensionElements() {
    Stack t = new Stack();
    int[] uno = new int[0];
    int length1 = uno.length;
    t.push(uno, 1);
    int length2 = uno.length;
    assertTrue('element has been added an array changed size', length2>length1);
  }
  
  @Test
  public void vaciarLista() {
    Stack t = new Stack();
    for(int i = 0; i<100; i++){
        t.setStack(t.push(t.getStack(), i));
    }
    
    for(int i = 0; i < 100; i++){
        t.setStack(t.pop(t.getStack()));
    }
    
    assertTrue('list is empty', t.getStack().length == 0);
  }
}

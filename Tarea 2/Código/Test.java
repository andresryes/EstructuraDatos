
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
    Methods t = new Methods();
    t.push(new int[0], 1);
  }
}
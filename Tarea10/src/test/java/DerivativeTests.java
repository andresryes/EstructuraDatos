import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


public class DerivativeTests {

    @DataProvider(name = "verify_constant", parallel = true)
    public Object[][] check_if_constant(){
        return new Object[][]{
                {'a'},
                {'c'},
                {'1'},
                {'8'}
        };
    }

    @Test(dataProvider = "check_if_constant", groups = {"All"}, description = "input es constante")
    public void check_if_constant(char tree_value){
       // Differentiate diff = new Differentiate();
       // Assert.assertTrue(diff.check_if_constant(tree_value));
    }

    @DataProvider(name = "isNumeric", parallel = true)
    public Object[][] isNumeric(){
        return new Object[][]{
                {"2837628"},
                {"234234"},
                {"34"},
                {"1"},
                {"2"}
        };
    }

    @Test(dataProvider = "isNumeric", groups = {"All", "Differentiate"}, description = "Test isNumeric(): ve si es el input es número. ")
    public void isNumeric(String maybe_number) {
        //Differentiate diff = new Differentiate();
     //   Assert.assertTrue(diff.isNumeric(maybe_number));
    }

    @DataProvider(name = "restar_",parallel = true)
    public Object[][] restar_exp(){
        return new Object[][]{
                {"B"},
                {"a"},
                {"34"},
                {"1"},
                {"2"}
        };
    }

    /*@Test(DifferentiateTests = "restar_exp", groups = {"All", "Differentiate"}, description = "Test restar_exp(): ve si es el input es número. ")
    public void restar_exp(String exp){
        Differentiate diff = new Differentiate();
        if (exp.contains("(?<=\\s|^)\\d+(?=\\s|$)")){
            int new_exp = Integer.parseInt(exp) - 1;
//            String _new_exp = String.valueOf(new_exp);
            Assert.assertEquals(new_exp, restar_exp(exp));
        }
    }*/

}
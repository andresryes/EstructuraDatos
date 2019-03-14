import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class ExpressionTreeTests {
    @DataProvider(name = "isOperator", parallel = true)
    public Object[][] isOperator(){
        return new Object[][]{
                {'+'},
                {'-'},
                {'*'},
                {'/'},
                {'^'}
        };
    }

    @Test(dataProvider = "isOperator", groups = {"All", "ExpressionTree"}, description = "Test isOperator(): Ve si el input es operador")
    public void check_if_constant(char maybe_operator){

    }

}

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
        /*ExpressionTree ET = new ExpressionTree();
        switch (maybe_operator){
            case '+':
                Assert.assertTrue(ET.isOperator(maybe_operator));
                break;

            case '-':
                Assert.assertTrue(ET.isOperator(maybe_operator));
                break;

            case '*':
                Assert.assertTrue(ET.isOperator(maybe_operator));
                break;

            case '/':
                Assert.assertTrue(ET.isOperator(maybe_operator));
                break;

            case '^':
                Assert.assertTrue(ET.isOperator(maybe_operator));
                break;
        }*/
    }

    /*@DataProvider(name = "inorder", parallel = true)
    public Object[][] inorder(){
        return new Object[][]{
                {"2837628"},
                {"234234"},
                {"34"},
                {"1"},
                {"2"}
        };
    }
    @Test(dataProvider = "inorder", groups = {"All", "ExpressionTree"}, description = "Test isNumeric(): ve si es el input es número. ")
    public void isNumeric(String maybe_number) {
        ExpressionTree ET = new ExpressionTree();
        Assert.assertTrue(ET.inorder(maybe_number););
    }*/

}

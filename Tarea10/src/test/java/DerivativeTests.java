import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


public class DerivativeTests {

    @DataProvider(name = "verify", parallel = true)
    public Object[][] constant(){
        return new Object[][]{
                {'a'},
                {'c'},
                {'1'},
                {'8'}
        };
    }

    @Test(groups = {"All", "Derivative"}, description = "Test isOperator(): Ve si el input es operador")
    public void verifyDerivative(){
        ExpressionTree expressionTree = new ExpressionTree("3x2^*");
        expressionTree.createExpressionTree();
        //Assert.assertEquals("((3)*((x)^(2)))",expressionTree.infix());
        Derivative derivative = new Derivative();
        derivative.derivative(expressionTree.getExpressionTree());
        Assert.assertEquals("+(3*2)*x^1", derivative.derivative);
    }


}
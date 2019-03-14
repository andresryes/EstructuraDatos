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
    public void verifyTree(char maybe_operator){
        ExpressionTree expressionTree = new ExpressionTree("3x2^*");
        expressionTree.createExpressionTree();
        Assert.assertEquals("((3)*((x)^(2)))",expressionTree.infix());
    }

}

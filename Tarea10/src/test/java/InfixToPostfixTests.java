import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class InfixToPostfixTests {

    @DataProvider(name = "infixToPostfix", parallel = true)
    public Object[][] infixToPostfix(){
        return new Object[][]{
                {" A + B "},
                {" A + B ^ 2"},
                {"( 2 * x ^ 2 ) + ( 3 * B ) + 4"},
                {"( A ^ 2 ) + B * X + ( C ^ 2 )"}
        };
    }

    @Test(dataProvider = "infixToPostfix", groups = {"All", "ShuntingYard"}, description = "Test infoxToPostfix(): Traduce de infix a postfix")
    public void infixToPostfix(String infix){
        //ShuntingYard.infixToPostfix(infix);
        /*switch (infix){
            case " A + B ":
               // Assert.assertEquals("A B + ", ShuntingYard.infixToPostfix(infix));
                break;

            case " A + B ^ 2":
               // Assert.assertEquals("A B 2 ^ + ", ShuntingYard.infixToPostfix(infix));
                break;

            case "( 2 * x ^ 2 ) + ( 3 * B ) + 4":
               // Assert.assertEquals("2 x 2 ^ * 3 B * + 4 + ", ShuntingYard.infixToPostfix(infix));
                break;

            case "( A ^ 2 ) + B * X + ( C ^ 2 )":
               // Assert.assertEquals("A 2 ^ B X * + C 2 ^ + ", ShuntingYard.infixToPostfix(infix));
        }*/
    }

}

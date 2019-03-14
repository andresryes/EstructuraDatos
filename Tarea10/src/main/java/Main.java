import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

public class Main {
    public static VerifyString verifyString = new VerifyString();

    public static void main(String[] args) {

        //Stack<TreeNode> stack = new Stack<TreeNode>();
        System.out.println("Hello World!");
        Scanner scanner = new Scanner(System.in);
        //String function = "3*x^2*(x^2+1)^3+(e^(2*x))";
        String function = "3*x^5+3*x^3+x+1+2*x+3*x^5+3^x+e^(2*x)+e^x";
        if(verifyString.checkParentheses(function)){
            System.out.println("you can continue");
            System.out.println("function: " + function);
            InfixToPostfix infixToPostfix = new InfixToPostfix();
            String postfix = infixToPostfix.getPostFix(function);
            System.out.println("postfix: " + postfix);
            ExpressionTree expressionTree = new ExpressionTree(postfix);
            expressionTree.createExpressionTree();
            System.out.println("printed tree:" + expressionTree.infix());

            Derivative derivative = new Derivative();
            derivative.derivative(expressionTree.getExpressionTree());
            System.out.println("derivative: "+ derivative.derivative);

            String wait = scanner.next();
        }
    }
}

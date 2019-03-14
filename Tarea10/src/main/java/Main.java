import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

public class Main {
    public static VerifyString verifyString = new VerifyString();

    public static void main(String[] args) {

        //Stack<TreeNode> stack = new Stack<TreeNode>();
        System.out.println("Hello World!");
        Scanner scanner = new Scanner(System.in);
        String function = scanner.next();
        if(verifyString.checkParentheses(function)){
            System.out.println("you can continue");




        }
    }
}

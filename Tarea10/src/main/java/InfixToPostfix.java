import java.util.Stack;

class InfixToPostfix
{

    // return precedence of a char, higher == more precedence
    static int Prec(char ch)
    {
        switch (ch)
        {
            case '+':
            case '-':
                return 1;

            case '*':
            case '/':
                return 2;

            case '^':
                return 3;
        }
        return -1;
    }

    // infix to postfix expression using Shunting yard
    static String infixToPostfix(String exp)
    {
        // result
        String result = new String("");

        // stack
        Stack<Character> stack = new Stack<Character>();

        for (int i = 0; i<exp.length(); ++i)
        {
            char c = exp.charAt(i);

            // operand goes to the output
            if (Character.isLetterOrDigit(c))
                result += c;

                // If the scanned character is an '(', push it to the stack.
            else if (c == '(')
                stack.push(c);

                //  If the scanned character is an ')', pop and output from the stack
                // until an '(' is encountered.
            else if (c == ')')
            {
                while (!stack.isEmpty() && stack.peek() != '(')
                    result += stack.pop();

                if (!stack.isEmpty() && stack.peek() != '(')
                    return "Invalid Expression"; // invalid expression
                else
                    stack.pop();
            }
            else // an operator is encountered
            {
                while (!stack.isEmpty() && Prec(c) <= Prec(stack.peek()))
                    result += stack.pop();
                stack.push(c);
            }

        }

        // pop all the operators from the stack
        while (!stack.isEmpty())
            result = result + stack.pop();

        return result;
    }

    public static String getPostFix(String infix){
        return infixToPostfix(infix);
    }
}
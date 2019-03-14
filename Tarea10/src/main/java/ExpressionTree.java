import java.util.*;
public class ExpressionTree {

    private final String postfix;
    private TreeNode root;

    /**
     * Takes in a valid postfix expression and later its used to construct the expression tree.
     * The posfix expression, if invalid, leads to invalid results
     *
     * @param postfix   the postfix expression.
     */
    public ExpressionTree(String postfix) {
        if (postfix == null) { throw new NullPointerException("The posfix should not be null"); }
        if (postfix.length() == 0)  { throw new IllegalArgumentException("The postfix should not be empty"); }
        this.postfix = postfix;
    }


    private boolean isOperator(char c) {
        return c == '+' || c == '-' || c == '*' || c == '/' || c == '^';
    }


    /**
     * Constructs an expression tree, using the postfix expression
     */
    public void createExpressionTree() {
        final Stack<TreeNode> nodes = new Stack<TreeNode>();
        for (int i = 0; i < postfix.length(); i++) {
            char ch  = postfix.charAt(i);
            if (isOperator(ch)) {
                TreeNode rightNode = nodes.pop();
                TreeNode leftNode = nodes.pop();
                nodes.push(new TreeNode(leftNode, ch, rightNode));
            } else {
                nodes.add(new TreeNode(null, ch, null));
            }
        }
        root = nodes.pop();
    }

    /**
     * Returns the prefix notation
     *
     * @return the prefix notation
     */
    /*public String prefix() {
        if (root == null) {
            throw new NoSuchElementException("The root is empty, the tree has not yet been constructed.");
        }

        final StringBuilder prefix = new StringBuilder();
        preOrder(root, prefix);
        return prefix.toString();
    }

    private void preOrder(TreeNode node, StringBuilder prefix) {
        if (node != null) {
            prefix.append(node.ch);
            preOrder(node.left, prefix);
            preOrder(node.right, prefix);
        }
    }
    /**
     * Returns the infix expression
     *
     * @return  the string of infix.
     */
    public String infix() {
        if (root == null) {
            throw new NoSuchElementException("The root is empty, the tree has not yet been constructed.");
        }
        final StringBuilder infix = new StringBuilder();
        inOrder(root, infix);
        return infix.toString();
    }

    private void inOrder(TreeNode node, StringBuilder infix) {
        if (node != null) {
            infix.append("(");
            inOrder(node.left, infix);
            infix.append(node.ch);
            inOrder(node.right, infix);
            infix.append(")");
        }
    }

    /*public static void main(String[] args) {
        ExpressionTree expressionTree1 = new ExpressionTree("3x2^*x2^1+3^*e2^x*+");
        expressionTree1.createExpressionTree();
        System.out.println(expressionTree1.infix());
    }*/

    public TreeNode getExpressionTree(){
        return root;
    }
}


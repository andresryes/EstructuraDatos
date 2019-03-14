import java.util.*;
public class ExpressionTree {

    private final String postfix;
    private TreeNode root;

    public ExpressionTree(String postfix) {
        if (postfix == null) { throw new NullPointerException("The posfix should not be null"); }
        if (postfix.length() == 0)  { throw new IllegalArgumentException("The postfix should not be empty"); }
        this.postfix = postfix;
    }


    //check if the char is an operator
    private boolean isOperator(char c) {
        return c == '+' || c == '-' || c == '*' || c == '/' || c == '^';
    }

    //create the tree, with the postfix expression
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

    public String infix() {
        if (root == null) {
            throw new NoSuchElementException("The root is empty, the tree has not yet been constructed.");
        }
        final StringBuilder infix = new StringBuilder();
        inOrder(root, infix);
        return infix.toString();
    }

    //make the String with parenthesis in infix notation
    private void inOrder(TreeNode node, StringBuilder infix) {
        if (node != null) {
            infix.append("(");
            inOrder(node.left, infix);
            infix.append(node.ch);
            inOrder(node.right, infix);
            infix.append(")");
        }
    }

    public TreeNode getExpressionTree(){
        return root;
    }
}


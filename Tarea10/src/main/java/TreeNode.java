public class TreeNode {

    private TreeNode left;
    private TreeNode right;
    private Object value;
    private TreeNode parent;

    public TreeNode(TreeNode left, TreeNode right, Object value, TreeNode parent) {
        this.left = left;
        this.right = right;
        this.value = value;
        this.parent = parent;
    }

    public TreeNode getLeft() {
        return left;
    }

    public void setLeft(TreeNode left) {
        this.left = left;
    }

    public TreeNode getRight() {
        return right;
    }

    public void setRight(TreeNode right) {
        this.right = right;
    }

    public Object getValue() {
        return value;
    }

    public void setValue(Object value) {
        this.value = value;
    }

    public TreeNode getParent() {
        return parent;
    }

    public void setParent(TreeNode parent) {
        this.parent = parent;
    }
}

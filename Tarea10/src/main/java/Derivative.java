public class Derivative {

    String derivative = "";

    public String getDerivative(){
        return  derivative;
    }

    public void printNode(TreeNode node, StringBuilder infix){
        if (node != null) {
            infix.append("(");
            printNode(node.left, infix);
            infix.append(node.ch);
            printNode(node.right, infix);
            infix.append(")");
        }
    }

    public void derivative(TreeNode node) {
        if (node != null) {
            //infix.append("(");
            //System.out.println(node.ch);
            switch (node.ch){
                case '+':
                case '-':
                    derivative(node.left);
                    //derivative += node.ch;
                    derivative(node.right);
                    //System.out.println("R"+node.right.ch);
                    //System.out.println("L"+node.right.ch);

                    break;

                case '*':
                    //System.out.println("L"+node.left.ch);

                    if(Character.isDigit(node.left.ch)){
                        if((node.right.ch)=='^')
                        derivative+= "+(" + node.left.ch + "*" + node.right.right.ch + ")" + "*" + node.right.left.ch + "^" + (Integer.parseInt(node.right.right.ch+"")-1);
                        else{
                            derivative+= "+"+node.left.ch;
                        }
                    }


                    /*derivative(node.left);
                    StringBuilder mult = new StringBuilder();
                    printNode(node.right, mult);
                    derivative+=mult;

                    System.out.println("R"+node.right.ch);
                    derivative(node.right);
                    StringBuilder mult2 = new StringBuilder();
                    printNode(node.left, mult2);
                    derivative+=mult2;*/

                    break;

                case '/':

                    derivative+=("(");

                    derivative(node.left);
                    StringBuilder div = new StringBuilder();
                    printNode(node.right, div);
                    derivative+=div;

                    derivative(node.right);
                    StringBuilder div2 = new StringBuilder();
                    printNode(node.left, div2);
                    derivative+=div2;
                    derivative+=(")");
                    derivative+=("/(" + div2+")^2");
                    break;

                case 'x':
                    derivative+="+1";
                    break;

                case '^':
                    //derivative = derivative +"+"+node.right.ch+"^"+(node.left.ch-1);

                    System.out.println("R"+node.right.ch);
                    System.out.println("L"+node.left.ch);
                    //derivative+= "(" + node.left.ch + "*" + node.right.right.ch + ")" + "*" + node.right.left.ch + "^" + (Integer.parseInt(node.right.right.ch+"")-1);
                    if(!Character.isDigit(node.left.ch)){
                        derivative+= "+(" + node.right.ch + ")" + "*" + node.left.ch + "^" + (Integer.parseInt(node.right.ch+"")-1);
                    }
                    break;
                default:
                    derivative+="+0";
                    break;

            }

            /*loopTree(node.left, infix);
            infix.append(node.ch);
            loopTree(node.right, infix);
            //infix.append(")");*/
        }
    }

    public void PowerRule(TreeNode node){

    }

}

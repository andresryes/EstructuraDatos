import com.sun.org.apache.xpath.internal.operations.Quo;

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

    public String printFunction(TreeNode node){
        String result = "";
        if (node != null) {
            result += "(";
            printFunction(node.left);
            result += node.ch;
            printFunction(node.right);
            result += ")";
        }
        return result;
    }

    public void Product(TreeNode node, char operator){
        StringBuilder product1 = new StringBuilder(0);
        printNode(node.left, product1);
        StringBuilder product2 = new StringBuilder(0);
        printNode(node.right, product2);
        if(operator == '*')
            derivative+= ("("+derivative(node.right)+")*("+product1+")+("+product2+")*("+derivative(node.left)+")");
        else
            derivative +=  ("(("+derivative(node.right)+")*("+product1+")+("+product2+")*("+derivative(node.left)+"))/("+derivative(node.right)+")^2");

    }

    public void Sum(TreeNode node, char operador){
        derivative += ("("+derivative(node.right)+")"+operador+"("+derivative(node.left)+")");
    }


    public void Power(TreeNode node){
        StringBuilder stringBuilder = new StringBuilder(0);
        printNode(node.left, stringBuilder);
        derivative += printFunction(node.right)+"*("+stringBuilder+")^("+printFunction(node.right)+"-1)*("+derivative(node.left)+")";
    }

    public void X(TreeNode node){
        derivative+="1";
        //System.out.println("x2");
    }

    public void Number(TreeNode node){
       derivative+="0";
    }

    public String derivative(TreeNode node){
        if (node != null) {
            switch (node.ch){
                case '+':
                case '-':
                    //System.out.println("xxx" + node.right.ch);
                    return ("("+derivative(node.left)+")"+node.ch+"("+derivative(node.right)+")");
                case '*':
                case '/':
                    StringBuilder product1 = new StringBuilder(0);
                    printNode(node.left, product1);
                    StringBuilder product2 = new StringBuilder(0);
                    printNode(node.right, product2);
                    if(node.ch == '*')
                        return ("("+derivative(node.right)+")*("+product1+")+("+product2+")*("+derivative(node.left)+")");
                    else
                        return ("(("+derivative(node.left)+")*("+product2+")-("+product1+")*("+derivative(node.right)+"))/("+product2+")^2");
                case 'x':
                    return "1";
                case '^':
                    /*if(!Character.isDigit(node.left.ch)) {
                        if (node.left.ch == 'e') {
                            if (node.right.ch == 'x') {
                                return node.left.ch + "^" + node.right.ch;
                            } else if (node.right.ch == '*') {
                                return "(" + node.right.left.ch + ")" + "(" + node.left.ch + ")^(" + node.right.right.ch + "*" + node.right.left.ch + ")";
                                //}
                            } else {
                                return "(" + node.right.ch + ")" + "*" + node.left.ch + "^" + (Integer.parseInt(node.right.ch + "") - 1);
                            }
                        } else {
                            if (node.right.ch == 'x') {
                                return "" + "log(" + node.left.ch + ")" + "*" + node.left.ch + "^x";
                            }
                        }
                    }*/
                    if (node.left.ch == 'e') {
                        if (node.right.ch == 'x') {
                            return node.left.ch + "^" + node.right.ch;
                        } else if (node.right.ch == '*') {
                            return "(" + node.right.left.ch + ")" + "(" + node.left.ch + ")^(" + node.right.right.ch + "*" + node.right.left.ch + ")";
                            //}
                        }else if(Character.isDigit(node.right.ch)){
                            return "0";
                        } else {
                            return "(" + node.right.ch + ")" + "*" + node.left.ch + "^" + (Integer.parseInt(node.right.ch + "") - 1);
                        }
                    } else {
                        if (node.right.ch == 'x') {
                            return "" + "log(" + node.left.ch + ")" + "*" + node.left.ch + "^x";
                        }else{
                            StringBuilder stringBuilder = new StringBuilder(0);
                            printNode(node.left, stringBuilder);
                            StringBuilder stringBuilder1 = new StringBuilder();
                            printNode(node.right, stringBuilder1);
                            return stringBuilder1+"*("+stringBuilder+")^("+stringBuilder1+"-1)*("+derivative(node.left)+")";
                        }
                    }
                default:
                    return "0";
            }
        }
        return "";
    }

    /*

    /*public void derivative(TreeNode node) {
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
                    derivative+=mult2;

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

                   // System.out.println("R"+node.right.ch);
                   // System.out.println("L"+node.left.ch);
                    //derivative+= "(" + node.left.ch + "*" + node.right.right.ch + ")" + "*" + node.right.left.ch + "^" + (Integer.parseInt(node.right.right.ch+"")-1);
                    if(!Character.isDigit(node.left.ch)){
                        if(node.left.ch == 'e'){
                            if(node.right.ch == 'x'){
                                derivative+= "+"+node.left.ch+"^"+node.right.ch;
                            }else if(node.right.ch == '*'){
                                derivative+= "+("+node.right.left.ch+")"+"("+node.left.ch+")^("+node.right.right.ch+"*"+node.right.left.ch+")";
                            }
                        }else{
                            derivative+= "+(" + node.right.ch + ")" + "*" + node.left.ch + "^" + (Integer.parseInt(node.right.ch+"")-1);
                        }
                    }else{
                        if(node.right.ch == 'x'){
                            derivative+="+"+"log("+node.left.ch+")"+"*"+node.left.ch+"^x";
                        }
                    }
                    break;
                default:
                    derivative+="+0";
                    break;

            }

            /*loopTree(node.left, infix);
            infix.append(node.ch);
            loopTree(node.right, infix);
            //infix.append(")");
        }
    }*/

}

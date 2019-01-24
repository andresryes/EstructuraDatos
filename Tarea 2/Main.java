import java.util.*;
public class Main{

    public static int[] stack = new int[0];

    public static Methods m = new Methods();

    public static void main(String args[]){
        Scanner s = new Scanner(System.in);
        int a = s.nextInt();
        while(a!=1){
            stack = m.push(stack, a);   
            a = s.nextInt();         
        }

        stack = m.pop(stack);

        System.out.println("-----");
        for(int i = 0; i < stack.length ; i++){
            System.out.println(stack[i]);
        }

        m.clear();
    }

    public void menu(){

    }

}
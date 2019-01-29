import java.util.*;
public class Main{

    public static Stack stack = new Stack();

    public static void main(String args[]){
        Scanner s = new Scanner(System.in);
        int a = s.nextInt();
        
        //Termina cuando el número es negativo
        while(a>=0){
            stack.setStack(stack.push(stack.getStack(), a));
            a = s.nextInt();         
        }

        stack.setStack(stack.pop(stack.getStack());
        
        System.out.println("-----");
        for(int i = 0; i < stack.length ; i++){
            System.out.println(stack.getStack()[i]);
        }

        stack.clear(stack.getStack());
        s.nextInt();
    }
    
}
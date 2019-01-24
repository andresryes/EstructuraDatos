public class Methods{

    public static int[] push(int[] stack, int ch){
        int[] st = new int[stack.length + 1];
        for(int i = 0; i < stack.length; i++){
            st[i] = stack[i];
            stack[i] = 0;
        }
        st[stack.length] = ch;
        stack = null;
        return st;
    }

    public static int[] pop(int[] stack){
        int[] st = new int[stack.length-1];
        for(int i = 0; i < st.length; i++){
            st[i] = stack[i];
            stack[i] = 0;
        }
        stack = null;

        return st;
    }

    public static int[] clear(int[] stack){
        stack = null;
        return new int[0];
    }
}
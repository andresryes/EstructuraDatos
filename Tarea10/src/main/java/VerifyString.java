public class VerifyString {
    public boolean checkParentheses(String s) {
        int nesting = 0;
        for (int i = 0; i < s.length(); ++i)
        {
            char c = s.charAt(i);
            switch (c) {
                case '(':
                    nesting++;
                    break;
                case ')':
                    nesting--;
                    if (nesting < 0) {
                        return false;
                    }
                    break;
            }
        }
        return nesting == 0;
    }

    public String[] separateTerms(String input){

        input = input.replaceAll("-", "+(-)");

        String[] values = input.split("\\+");

        return values;
    }
}

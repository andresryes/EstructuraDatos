import java.util.Arrays;

public class Power {

    //Receive a string, return the derivative of that term

    public String power(String term){
        String[] values = term.split("\\^");
        return values[1] + "*(" + values[0]+")^"+(Integer.parseInt(values[1])-1);
    }
}

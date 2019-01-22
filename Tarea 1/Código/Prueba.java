public class Prueba{
    public static void main(String args[]){

        Sum s = new Sum();

        int[] numeros = new int[4];
        numeros[0] = 5;
        numeros[1] = 4;
        numeros[2] = 15;
        numeros[3] = 120;

        int[] numeros2 = new int[4];
        numeros2[0] = 15;
        numeros2[1] = 10;
        numeros2[2] = 120;
        numeros2[3] = 7260;

        for(int i = 0; i <= 3; i++){

            if(s.suma(numeros[i], 1) == numeros2[i]){
                System.out.println("Elemento correcto");
            }else{
                System.out.println("Se produjo un error");
            }
        }
    }
}
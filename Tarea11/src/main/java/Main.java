import java.util.InputMismatchException;
import java.util.Scanner;
public class Main{
    public static void main(String[] args){
      Scanner in = new Scanner(System.in);
      Scanner st = new Scanner(System.in);
      BTree bTree = new BTree();
          while (true) {
              System.out.print("BTree\n"
                      + "1) to insert to the B Tree.\n"
                      + "4) to print the B Tree.\n"
                      + "Option:\n");
              int choose, key;
              choose = in.nextInt();
              switch (choose) {
                  case 1:
                      System.out.print("Enter the word to insert in the B tree: ");
                      bTree.insert(st.nextLine());
                      break;
                  case 2:
                      break;
                  case 3:
                      break;
                  case 4:
                      System.out.println("-------\n"
                              + "BTree...\n");
                      bTree.print();
                      break;
                  default:
                      System.exit(0);
              }
              System.out.println("-----------------------");
          }
    }

}

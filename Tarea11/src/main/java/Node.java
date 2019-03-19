public class Node{
  public int numberOfNodes; //how many nodes it has
  public String key[]; //array for the actual values
  public Node children[]; //array to store its children
  public boolean isLeaf; //if it's a leaf

  //constructor of the class Node
  Node(){
    key = new String[3]; //at most 3 keys
    children = new Node[4]; //4 spaces for pointers to others nodes
    isLeaf = true;
  }
}

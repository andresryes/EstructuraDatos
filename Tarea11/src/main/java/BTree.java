public class BTree{
  public Node root; //root of the bTree

  //constructor of the BTree
  BTree(){
    root = new Node();
    root.numberOfNodes = 0; //no nodes at the beginning
    root.isLeaf = true;
    root.key[0] = ""; //starts with null value on the first key
  }

  //insert method for bTree
  //takes a string
  public void insert(String key){
      Node node = root;
      if(node.numberOfNodes == 3){ //node is full
          Node newNode = new Node(); //creates a new node to become the root
          root = newNode; //newNode now is the root of the tree
          newNode.numberOfNodes = 0;
          root.isLeaf = false; //is no longer a leaf
          newNode.children[0] = node;

          //after node (originally the root) becomes a child of the new root
          //call the function split, because it is full
          splitChild(newNode, 1, node);

          //call nonFull scenario to add the key value
          insertNonfull(newNode, key);
      }else{
          insertNonfull(node, key);
      }
  }

  //split method to fractioning the node
  public void splitChild(Node parentNode, int childIndex, Node newChild){
      //create a new node, will become the new child of nodeParent
      Node newNode = new Node();
      newNode.isLeaf = newChild.isLeaf;
      newNode.numberOfNodes = 1;
      newNode.key[0] = newChild.key[2];

      //if nodeChild is not a leaf, assign the largest key and child to newNode
      if(!newChild.isLeaf){
          newNode.children[1] = newChild.children[3];
          newNode.children[0] = newChild.children[2];
      }
      newChild.numberOfNodes = 1;

      //insert the newNode as a child of the current nodeParent
      for(int h = parentNode.numberOfNodes+1; h>=childIndex+1; h--){
          parentNode.children[h] = parentNode.children[h-1];
          parentNode.key[h-1] = parentNode.key[h-2];
      }

      //assing the reference to the new Node(child of parentNode)
      parentNode.children[childIndex] = newNode;
      parentNode.key[childIndex-1] = newChild.key[1];
      //parentNode.numberOfNodes increases
      parentNode.numberOfNodes++;
  }

  //instert method if the node is not full
  public void insertNonfull(Node node, String key){
      int i = node.numberOfNodes;
      //if the node is leaf, we insert the key into it
      if(node.isLeaf){
          while(i>=1 && (key.compareTo(node.key[i-1])<0)){
            node.key[i] = node.key[i-1];
            i--;
          }
          node.key[i] = key;
          node.numberOfNodes++;
      //if node is not a leaf, the value will be inserted into the correct leaf
      //check if the node is full, if so, split the node
      }else{
          while(i>=1 && (key.compareTo(node.key[i-1])<0)){
              i--;
          }
          i++;
          // if node is full, split it
          if(node.children[i-1].numberOfNodes == 3){
              //split the node in two
              splitChild(node, i, node.children[i-1]);
              //select wich node will contain the new value
              if(key.compareTo(node.key[i-1])>0){
                  i++;
              }
          }
          //recursive call
          insertNonfull(node.children[i-1], key);
      }
  }

  public boolean search(){
    return false;
  }

  public void print(){
    printBTree(root);
  }

  public void printBTree(Node node){
      for(int i=0; i<node.numberOfNodes;i++){
        if(!node.isLeaf){
        printBTree(node.children[i]);
      }
        System.out.println(node.key[i]);
      }
      if(!node.isLeaf){
        printBTree(node.children[node.numberOfNodes]);
      }
  }
}

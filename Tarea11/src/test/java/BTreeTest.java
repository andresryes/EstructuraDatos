import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class BTreeTest {
    @Test(groups = {"All", "BTree"}, description = "toTest the insertion of BTree")
    public void insertBTreeTest(){
        BTree bTree = new BTree();

        bTree.insert("prueba");

        Assert.assertTrue(bTree.search("prueba"));
    }


    @Test(groups = {"All", "BTree"}, description = "toTest the insertion of BTree")
    public void searchBTree(){
        BTree bTree = new BTree();


        bTree.insert("prueba");
        bTree.insert("prueba2");
        bTree.insert("prueba3");
        bTree.insert("prueba4");
        bTree.insert("prueba5");


        Assert.assertFalse(bTree.search("prueba6"));
    }

    @Test(groups = {"All", "BTree"}, description = "toTest the insertion of BTree")
    public void searchBTreeFound(){
        BTree bTree = new BTree();


        bTree.insert("prueba");
        bTree.insert("prueba2");
        bTree.insert("prueba3");
        bTree.insert("prueba4");
        bTree.insert("prueba5");


        Assert.assertTrue(bTree.search("prueba5"));
    }


}

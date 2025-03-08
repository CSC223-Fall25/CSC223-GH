package csc223.gh;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class BSTTest {
    
    @Test void insertTest(){
        BST tree = new BST();
        assertEquals(tree.root, null);
        tree.insert(1);
        assertEquals(tree.root.data, 1);
        tree.insert(3);
        assertEquals(tree.root.right.data, 3);
        tree.insert(0);
        assertEquals(tree.root.left.data, 0);
        tree.insert(2);
        assertEquals(tree.root.right.left.data, 2);   
    }  

    @Test void deleteTest(){
        BST tree = new BST();
        tree.insert(10);
        tree.insert(15);
        tree.insert(8);
        tree.insert(16);
        tree.insert(12);
        tree.insert(11);
        tree.insert(14);

        tree.delete(10);
        assertEquals(tree.root.data, 11);
        tree.delete(11);
        assertEquals(tree.root.data, 12);
        tree.delete(15);
        assertEquals(tree.root.right.data, 16);
        tree.delete(8);
        assertEquals(tree.root.left, null);

    }

    @Test void searchTest(){
        BST tree = new BST();

        assertEquals(tree.search(10),false);

        tree.insert(10);
        tree.insert(15);
        tree.insert(8);
        tree.insert(16);
        tree.insert(12);
        tree.insert(11);
        tree.insert(14);

        assertEquals(tree.search(10),true);
        assertEquals(tree.search(19),false);
        
        tree.delete(10);
        assertEquals(tree.search(10), false);
    }

    @Test void updateTest(){
        BST tree = new BST();
        tree.insert(10);
        tree.insert(15);
        tree.insert(8);
        tree.insert(16);
        tree.insert(12);
        tree.insert(11);
        tree.insert(14);

        tree.update(10, 6);
        assertEquals(tree.root.data, 11);
        assertEquals(tree.root.left.left.data, 6);
    }

    @Test void inOrderTest(){
        BST tree = new BST();
        assertEquals(tree.inOrder(), "");
        tree.insert(10);
        assertEquals(tree.inOrder(), "10");
        tree.insert(15);
        tree.insert(8);
        assertEquals(tree.inOrder(), "8, 10, 15");
        tree.insert(16);
        tree.insert(12);
        tree.insert(11);
        tree.insert(14);
        assertEquals(tree.inOrder(), "8, 10, 11, 12, 14, 15, 16");
    }

    @Test void sortedArrayToBSTTest(){
        int[] mylist1 = new int[]{-10, -3, 0, 5, 9};
        BST tree1 = BST.sortedArrayToBST(mylist1);
        assertEquals(tree1.root.data, 0);
        assertEquals(tree1.root.left.data, -10);
        assertEquals(tree1.root.right.data, 5);

        int[] mylist2 = new int[]{1,3};
        BST tree2 = BST.sortedArrayToBST(mylist2);
        assertEquals(tree2.root.data, 1);
        assertEquals(tree2.root.right.data, 3);

        int[] mylist3 = new int[]{-1,0,1,3};
        BST tree3 = BST.sortedArrayToBST(mylist3);
        assertEquals(tree3.root.data, 0);
        assertEquals(tree3.root.right.data, 1);
        assertEquals(tree3.root.left.data, -1);

        int[] mylist4 = null;
        BST tree4 = BST.sortedArrayToBST(mylist4);
        assertEquals(tree4, null);

    }

    @Test void lowestCommonAncenstorTest(){
        BST tree = new BST();
        assertEquals(tree.lowestCommonAncestor(0, 1), -1);
        tree.insert(6);
        tree.insert(2);
        tree.insert(8);
        tree.insert(0);
        tree.insert(4);
        tree.insert(7);
        tree.insert(9);
        tree.insert(3);
        tree.insert(5);
        assertEquals(tree.lowestCommonAncestor(2, 8), 6);
        assertEquals(tree.lowestCommonAncestor(2, 4), 2);
        assertEquals(tree.lowestCommonAncestor(8, 7), 8);
        assertEquals(tree.lowestCommonAncestor(0, 5), 2);
        assertEquals(tree.lowestCommonAncestor(9, 12), -1);



    }
}

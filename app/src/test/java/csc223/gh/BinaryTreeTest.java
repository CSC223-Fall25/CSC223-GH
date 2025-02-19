package csc223.gh;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class BinaryTreeTest {

    @Test
    public void insertTest(){
        BinaryTree k = new BinaryTree(10);
        k.insert('G');
        assertEquals(k.size(), 1);
        k.insert('R');
        assertEquals(k.size(), 2);
        k.insert('E');
        assertEquals(k.size(), 3);
        System.out.println(k.root.right.data);
    }

    @Test
    public void levelorderTest(){
        BinaryTree k = new BinaryTree(10);
        k.insert('G');
        k.insert('R');
        k.insert('E');
        k.insert('Y');
        k.insert('S');
        k.insert('O');
        k.insert('N');
        assertEquals(k.levelorder(),"GREYSON");
        
    }

    @Test
    public void inorderTest(){
        BinaryTree k = new BinaryTree(10);
        k.insert('G');
        k.insert('R');
        k.insert('E');
        k.insert('Y');
        k.insert('S');
        k.insert('O');
        k.insert('N');
        System.out.println(k.root.left.data);
        assertEquals(k.inorder(),"YRSGOEN");
    }

    @Test
    public void preorderTest(){
        BinaryTree k = new BinaryTree(10);
        k.insert('G');
        k.insert('R');
        k.insert('E');
        k.insert('Y');
        k.insert('S');
        k.insert('O');
        k.insert('N');
        System.out.println(k.root.left.data);
        assertEquals(k.preorder(),"GRYSEON");
    }

    @Test
    public void postorderTest(){
        BinaryTree k = new BinaryTree(10);
        k.insert('G');
        k.insert('R');
        k.insert('E');
        k.insert('Y');
        k.insert('S');
        k.insert('O');
        k.insert('N');
        System.out.println(k.root.left.data);
        assertEquals(k.postorder(),"YSRONEG");
    }

    @Test
    public void sizeTest(){
        BinaryTree k = new BinaryTree(10);
        k.insert('G');
        assertEquals(k.size, 1);
        k.insert('R');
        assertEquals(k.size, 2);
        k.insert('E');
        assertEquals(k.size, 3);
    }

    @Test
    public void heightTest(){
        BinaryTree k = new BinaryTree(10);
        k.insert('G');
        assertEquals(k.height(), 0);
        k.insert('R');
        assertEquals(k.height(), 1);
        k.insert('E');
        assertEquals(k.height(), 1);
        k.insert('Y');
        k.insert('S');
        k.insert('O');
        k.insert('N');
        assertEquals(k.height(), 2);

    }

    @Test
    public void searchTest(){
        BinaryTree k = new BinaryTree(10);
        k.insert('G');
        k.insert('R');
        k.insert('E');
        k.insert('Y');
        k.insert('S');
        k.insert('O');
        k.insert('N');
        assertEquals(k.search('G'),true);
        assertEquals(k.search('R'),true);
        assertEquals(k.search('E'),true);
        assertEquals(k.search('Y'),true);
        assertEquals(k.search('S'),true);
        assertEquals(k.search('O'),true);
        assertEquals(k.search('N'),true);
        assertEquals(k.search('I'),false);
        assertEquals(k.search('L'),false);
    }
}

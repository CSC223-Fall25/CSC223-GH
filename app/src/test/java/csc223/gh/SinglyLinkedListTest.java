package csc223.gh;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class SinglyLinkedListTest {

    @Test void insert_test(){
        SinglyLinkedList l = new SinglyLinkedList();
        l.insert('G');
        l.insert('R');
        assertEquals(l.head.data,'G');
        assertEquals(l.head.next.data, 'R');
    }

    @Test void remove_test(){
        SinglyLinkedList l = new SinglyLinkedList();
        l.insert('G');
        l.insert('R');
        l.remove('R');
        assertEquals(l.head.data, 'G');
        assertEquals(l.head.next, null);
        l.remove('G');
        assertEquals(l.head,null);
        l.remove('G');
    }

    @Test void indexOfTest(){
        SinglyLinkedList l = new SinglyLinkedList();
        l.insert('G');
        l.insert('R');
        l.insert('R');
        assertEquals(l.indexOf('G'), 0);
        assertEquals(l.indexOf('R'), 1);
        assertEquals(l.indexOf('I'), -1);
    }

    @Test void lastIndexOfTest(){
        SinglyLinkedList l = new SinglyLinkedList();
        l.insert('G');
        l.insert('R');
        l.insert('R');
        l.insert('R');
        l.insert('G');
        assertEquals(l.lastIndexOf('R'), 3);
        assertEquals(l.lastIndexOf('G'), 4);
        assertEquals(l.lastIndexOf('I'), -1);
    }

    @Test void containsTest(){
        SinglyLinkedList l = new SinglyLinkedList();
        l.insert('G');
        l.insert('R');
        assertEquals(l.contains('G'), true);
        assertEquals(l.contains('R'), true);
        assertEquals(l.contains('I'), false);
    }

    @Test void sizeTest(){
        SinglyLinkedList l = new SinglyLinkedList();
        assertEquals(l.size(), 0);
        l.insert('G');
        assertEquals(l.size(), 1);
        l.insert('R');
        assertEquals(l.size(), 2);
        l.remove('R');
        assertEquals(l.size(), 1);
    }

    @Test void getTest(){
        SinglyLinkedList l = new SinglyLinkedList();
        l.insert('G');
        l.insert('R');
        assertEquals(l.get(0), 'G');
        assertEquals(l.get(1), 'R');
        assertEquals(l.get(2), '☠');
    }

    @Test void clearTest(){
        SinglyLinkedList l = new SinglyLinkedList();
        l.insert('G');
        l.insert('R');
        l.clear();
        assertEquals(l.size(),0);
        assertEquals(l.head, null);
    }

    @Test void getFirstTest(){
        SinglyLinkedList l = new SinglyLinkedList();
        assertEquals(l.getFirst(), '☠');
        l.insert('G');
        l.insert('R');
        assertEquals(l.getFirst(), 'G');
    }

    @Test void getLastTest(){
        SinglyLinkedList l = new SinglyLinkedList();
        assertEquals(l.getLast(), '☠');
        l.insert('G');
        l.insert('R');
        assertEquals(l.getLast(), 'R');
    }

    @Test void isEmptyTest(){
        SinglyLinkedList l = new SinglyLinkedList();
        assertEquals(l.isEmpty(), true);
        l.insert('G');
        l.insert('R');
        assertEquals(l.isEmpty(), false);   
    }

    @Test void reverseTest(){
        SinglyLinkedList l = new SinglyLinkedList();
        l.insert('G');
        l.insert('R');
        l.insert('E');
        l.insert('Y');
        l.insert('S');
        l.insert('O');
        l.insert('N');
        l.reverse();
        assertEquals(l.getFirst(), 'N');
        assertEquals(l.head.data, 'N');
        assertEquals(l.head.next.data, 'O');
        assertEquals(l.getLast(),'G');
    }

}

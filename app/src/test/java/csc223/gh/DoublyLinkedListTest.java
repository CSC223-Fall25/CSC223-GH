package csc223.gh;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
public class DoublyLinkedListTest {

    @Test void insert_test(){
        DoublyLinkedList l = new DoublyLinkedList();
        l.insert('G');
        l.insert('R');
        assertEquals(l.head.data,'G');
        assertEquals(l.head.next.data, 'R');
    }

    @Test void remove_test(){
        DoublyLinkedList l = new DoublyLinkedList();
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
        DoublyLinkedList l = new DoublyLinkedList();
        l.insert('G');
        l.insert('R');
        l.insert('R');
        assertEquals(l.indexOf('G'), 0);
        assertEquals(l.indexOf('R'), 1);
        assertEquals(l.indexOf('I'), -1);
    }

    @Test void lastIndexOfTest(){
        DoublyLinkedList l = new DoublyLinkedList();
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
        DoublyLinkedList l = new DoublyLinkedList();
        l.insert('G');
        l.insert('R');
        assertEquals(l.contains('G'), true);
        assertEquals(l.contains('R'), true);
        assertEquals(l.contains('I'), false);
    }

    @Test void sizeTest(){
        DoublyLinkedList l = new DoublyLinkedList();
        assertEquals(l.size(), 0);
        l.insert('G');
        assertEquals(l.size(), 1);
        l.insert('R');
        assertEquals(l.size(), 2);
        l.remove('R');
        assertEquals(l.size(), 1);
    }

    @Test void getTest(){
        DoublyLinkedList l = new DoublyLinkedList();
        l.insert('G');
        l.insert('R');
        assertEquals(l.get(0), 'G');
        assertEquals(l.get(1), 'R');
        assertEquals(l.get(2), '☠');
    }

    @Test void clearTest(){
        DoublyLinkedList l = new DoublyLinkedList();
        l.insert('G');
        l.insert('R');
        l.clear();
        assertEquals(l.size(),0);
        assertEquals(l.head, null);
    }

    @Test void getFirstTest(){
        DoublyLinkedList l = new DoublyLinkedList();
        assertEquals(l.getFirst(), '☠');
        l.insert('G');
        l.insert('R');
        assertEquals(l.getFirst(), 'G');
    }

    @Test void getLastTest(){
        DoublyLinkedList l = new DoublyLinkedList();
        assertEquals(l.getLast(), '☠');
        l.insert('G');
        l.insert('R');
        assertEquals(l.getLast(), 'R');
    }

    @Test void isEmptyTest(){
        DoublyLinkedList l = new DoublyLinkedList();
        assertEquals(l.isEmpty(), true);
        l.insert('G');
        l.insert('R');
        assertEquals(l.isEmpty(), false);  
        l.remove('G');
        l.remove('R');
        assertEquals(l.isEmpty(), true);
    }

    @Test void reverseTest(){
        DoublyLinkedList l = new DoublyLinkedList();
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
        assertEquals(l.head.prev, null);
        assertEquals(l.head.next.data, 'O');
        assertEquals(l.head.next.prev, l.head);
        assertEquals(l.getLast(),'G');
    }

}

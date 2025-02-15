package csc223.gh;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
public class SortedDoublyLinkedListTest {
    
    @Test void insert_test(){
        SortedDoublyLinkedList l = new SortedDoublyLinkedList();
        l.insert('G');
        l.insert('R');
        l.insert('E');
        l.insert('Y');
        l.insert('S');
        l.insert('O');
        l.insert('N');
        l.print();
        assertEquals(l.contains('R'),true);
        assertEquals(l.head.next.next.data, 'N');
        assertEquals(l.head.data,'E');
        assertEquals(l.head.next.data, 'G');
    }

    @Test void remove_test(){
        SortedDoublyLinkedList l = new SortedDoublyLinkedList();
        l.insert('G');
        l.insert('R');
        l.insert('E');
        l.remove('E');
        assertEquals(l.head.data, 'G');
    }

    @Test void indexOfTest(){
        SortedDoublyLinkedList l = new SortedDoublyLinkedList();
        l.insert('G');
        assertEquals(l.indexOf('G'), 0);
        l.insert('R');
        l.insert('R');
        l.insert('E');
        assertEquals(l.indexOf('G'), 1);
        assertEquals(l.indexOf('E'), 0);
        assertEquals(l.indexOf('I'), -1);
    }

    @Test void lastIndexOfTest(){
        SortedDoublyLinkedList l = new SortedDoublyLinkedList();
        l.insert('G');
        l.insert('R');
        l.insert('R');
        l.insert('R');
        l.insert('G');
        assertEquals(l.head.next.data, 'G');
        assertEquals(l.head.next.next.data, 'R');
        assertEquals(l.head.next.next.next.data, 'R');
        assertEquals(l.lastIndexOf('R'), 4);
        assertEquals(l.lastIndexOf('G'), 1);
        assertEquals(l.lastIndexOf('I'), -1);
    }
    @Test void containsTest(){
        SortedDoublyLinkedList l = new SortedDoublyLinkedList();
        l.insert('G');
        l.insert('R');
        assertEquals(l.contains('G'), true);
        assertEquals(l.contains('R'), true);
        assertEquals(l.contains('I'), false);
    }

    @Test void sizeTest(){
        SortedDoublyLinkedList l = new SortedDoublyLinkedList();
        assertEquals(l.size(), 0);
        l.insert('G');
        assertEquals(l.size(), 1);
        l.insert('R');
        assertEquals(l.size(), 2);
        l.remove('R');
        assertEquals(l.size(), 1);
    }

    @Test void getTest(){
        SortedDoublyLinkedList l = new SortedDoublyLinkedList();
        l.insert('G');
        l.insert('R');
        assertEquals(l.get(0), 'G');
        assertEquals(l.get(1), 'R');
        assertEquals(l.get(2), '☠');
    }

    @Test void clearTest(){
       SortedDoublyLinkedList l = new SortedDoublyLinkedList();
        l.insert('G');
        l.insert('R');
        l.clear();
        assertEquals(l.size(),0);
        assertEquals(l.head, null);
    }

    @Test void getFirstTest(){
        SortedDoublyLinkedList l = new SortedDoublyLinkedList();
        assertEquals(l.getFirst(), '☠');
        l.insert('G');
        l.insert('R');
        assertEquals(l.getFirst(), 'G');
    }

    @Test void getLastTest(){
        SortedDoublyLinkedList l = new SortedDoublyLinkedList();
        assertEquals(l.getLast(), '☠');
        l.insert('G');
        l.insert('R');
        assertEquals(l.getLast(), 'R');
    }

    @Test void isEmptyTest(){
        SortedDoublyLinkedList l = new SortedDoublyLinkedList();
        assertEquals(l.isEmpty(), true);
        l.insert('G');
        l.insert('R');
        assertEquals(l.isEmpty(), false);  
        l.remove('G');
        l.remove('R');
        assertEquals(l.isEmpty(), true);
    }

    @Test void reverseTest(){
        SortedDoublyLinkedList l = new SortedDoublyLinkedList();
        l.insert('G');
        l.insert('R');
        l.insert('E');
        l.insert('Y');
        l.insert('S');
        l.insert('O');
        l.insert('N');
        // assertEquals(l.contains('G'), true);
        // assertEquals(l.contains('R'), true);
        // assertEquals(l.contains('E'), true);
        // assertEquals(l.contains('Y'), true);
        // assertEquals(l.contains('S'), true);
        // assertEquals(l.contains('O'), true);
        // assertEquals(l.contains('N'), true);
        l.print();
        l.reverse();
        assertEquals(l.getFirst(), 'Y');
        assertEquals(l.head.data, 'Y');
        assertEquals(l.head.prev, null);
        assertEquals(l.head.next.data, 'S');
        assertEquals(l.head.next.prev, l.head);
        assertEquals(l.getLast(),'E');
    }
}

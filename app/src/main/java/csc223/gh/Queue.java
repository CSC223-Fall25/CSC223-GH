package csc223.gh;

public interface Queue<T> {
    void enqueue(int item);
    T dequeue();
    T peek();
    boolean isEmpty();
    int size();
}

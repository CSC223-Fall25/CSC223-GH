package csc223.gh;

public class ArrayQueue<T> implements Queue<T>{
    T[] arr;
    int curr;
    int q_length;
    public ArrayQueue(int desired_length){
        this.arr = (T[]) new Object[desired_length];
        this.curr = 0;
        this.q_length = desired_length;
    }
    

    public void enqueue(T item){
        arr[curr] = item;
        curr+=1;
    }

    public T dequeue(){
        T out = arr[0];
        T[] newArr = (T[]) new Object[q_length];
        System.arraycopy(arr, 1, newArr, 0, q_length-1);
        arr = newArr;
        curr-=1;
        return out;
    }

    public T peek(){
        return arr[0];
    }

    public boolean isEmpty(){
        return curr==0;
    }

    public int size(){
        return curr;
    }

    // public static void main(String[] args){
    //     ArrayQueue x = new ArrayQueue();
    //     x.enqueue(1);
    //     x.enqueue(2);
    //     x.enqueue(3);
    //     System.out.println(x.peek());
    //     System.out.println(x.size());
    //     System.out.println(x.isEmpty());
    //     System.out.println(x.dequeue());
    //     System.out.println(x.peek());
    //     System.out.println(x.size());
    // }
}

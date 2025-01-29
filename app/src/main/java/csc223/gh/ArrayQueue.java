package csc223.gh;

public class ArrayQueue implements Queue{
    int[] arr = new int[10];
    int curr=0;

    public void enqueue(int item){
        arr[curr] = item;
        curr+=1;
    }

    public int dequeue(){
        int out = arr[0];
        int[] newArr = new int[arr.length];
        System.arraycopy(arr, 1, newArr, 0, 9);
        arr = newArr;
        curr-=1;
        return out;
    }

    public int peek(){
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

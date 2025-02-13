package csc223.gh;

public class Stack<T>{ 

    T[] data;
    int curr;
    int capacity;

    public Stack(){        
        this.capacity = 10;
        this.data = (T[]) new Object[this.capacity];
        this.curr = 0;
    }
    
    public void push(T x){
        if (this.curr < this.data.length){
            this.data[this.curr] = x;
            this.curr += 1;
        }
        else {
            this.capacity = this.capacity + 10;
            T[] newdata = (T[]) new Object[this.capacity];

            for (int i = 0; i < this.data.length; i++){
                newdata[i] = this.data[i];
            }
            this.data = newdata;
            this.data[curr] = x;
            this.curr += 1;

        }
    }

    public T pop(){
        if (this.curr == 0){
            return null;
        }
        else{
            this.curr -= 1;
            return this.data[this.curr];
        }
    }

    public T peek(){
        return this.data[this.curr -1];
    }

    public static void main(String[] args){
        Stack<String> s = new Stack<>();
        s.push("a");
        s.push("b");
        s.push("c");

        System.out.println(s.pop());

    }

}
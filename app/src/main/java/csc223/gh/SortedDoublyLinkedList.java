package csc223.gh;

public class SortedDoublyLinkedList extends DoublyLinkedList{
    int size;
    Node head;
    
    public SortedDoublyLinkedList(){
        this.size=0;
        this.head=null;
        super.size = this.size;
        super.head = this.head;
    }


    private void insert(Node curr, char item) {
        Node z = new Node(item);
    
        if (this.head == null) { 
            this.head = z;
            size+=1;
            return;
        }
    
        if (item <= curr.data) { 
            if (curr == this.head) {  
                z.next = curr;
                curr.prev = z;
                this.head = z;
            } else {  
                z.prev = curr.prev;
                z.next = curr;
                curr.prev.next = z;
                curr.prev = z;
            }
            size+=1;
            return;
        }
    
        
        if (curr.next == null) { 
            curr.next = z;
            z.prev = curr;
            size+=1;
            return;
        }
    
        insert(curr.next, item); 
    }
    

    @Override
    public void insert(char item){
        insert(this.head, item);
    }

    public void remove(char item){
        if(head==null){
            System.out.println("empty ll");
            return;
        }
        else if(head.data==item){
            if(head.next!=null){
                head = head.next;
                head.prev=null;
                size-=1;
                return;
            }
            else{
                head=null;
                size-=1;
                return;
            }
        }
        Node curr = head;
        while(curr.next!=null){
            if(curr.next.data==item){
                if(curr.next.next==null){
                    curr.next=null;
                    this.size-=1;
                    return;
                }
                else{
                    curr.next=curr.next.next;
                    curr.next.next.prev = curr;
                    this.size-=1;
                    return;
                }
            }
            curr=curr.next;
        }

    }

    @Override
    public int indexOf(char item){
        Node curr = head;
        int count = 0;
       
        while(curr != null){
            if(curr.data==item){
                return count;
            }
            count+=1;
            curr=curr.next;
        }
        return -1;
    }

    @Override
    public int lastIndexOf(char item){
        Node curr = head;
        int count = 0;
        int lastbest = -1;
        while(curr != null){
            if(curr.data==item){
                lastbest = count;
            }
            count+=1;
            curr=curr.next;
        }
        return lastbest;
    }

    public boolean isEmpty(){
       return this.size==0;
    }

    @Override
    public boolean contains(char item){
        Node curr = head;
        while(curr != null){
            if(curr.data == item){
                return true;
            }
            curr = curr.next;
        }
        return false;
    }

    @Override
    public void clear(){
        head = null;
        size=0;
    }

    @Override
    public char get(int index){
        Node curr = head;
        while(index>0){
            if(curr.next==null || head==null){
                return '☠';
            }
            curr=curr.next;
            index-=1;
        }
        return curr.data;
    }

    @Override
    public char getFirst(){
        if(head==null){
            return '☠';
        }
        return head.data;
    }
    
    @Override
    public char getLast(){
        if(head==null){
            return '☠';
        }
        Node curr = head;
        while(curr.next != null){
            curr = curr.next;
        }
        return curr.data;
    }

    @Override
    public int size(){
        return this.size;
    }

    public void print(){
        if (this.head==null){
            System.out.println("No head");
            return;
        }
        else if (this.head.next == null){
            System.out.println(this.head.data);
        }
        Node curr = head;
        while (curr!=null){
            System.out.println(curr.data);
            curr = curr.next;
        }
    }

    private Node reverse(Node n){
        if (n==null || n.next==null){
            head = n;
            head.prev = null;
            return n;
        }
        Node remains = reverse(n.next);
        n.next.next = n;
        n.prev = n.next;
        n.next = null;
        return remains;
    }

    public void reverse(){
        reverse(head);
    }
}

package csc223.gh;

public class DoublyLinkedList extends SinglyLinkedList{
    int size;
    Node head;

    public DoublyLinkedList(){
        this.size=0;
        this.head=null;
    }

    public void insert(char item){
        size+=1;
        if(this.head==null){
            this.head = new Node(item);
        }
        else{
            Node curr = head;
            while(curr.next != null){
                curr = curr.next;
            }
            curr.next = new Node(item);
            curr.next.prev = curr;
        }
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

    @Override
    public boolean isEmpty(){
        return size==0;
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

package csc223.gh;

public class SinglyLinkedList implements LinkedList{
    int size;
    Node head;

    public SinglyLinkedList(){
        this.size = 0;
        this.head = null;
    }

    public void insert(char item){
        if(this.head==null){
            this.head = new Node(item);
        }
        else{
            Node curr = head;
            while(curr.next != null){
                curr = curr.next;
            }
            curr.next = new Node(item);
        }
    }

    public void remove(char item){
        if(head==null){
            System.out.println("empty ll");
        }
        else if(head.data==item){
            if(head.next!=null){
                head = head.next;
            }
            else{
                head=null;
            }
        }

        Node curr = head;
        while(curr.next!=null){
            if(curr.next.data==item){
                if(curr.next.next==null){
                    curr.next=null;
                    return;
                }
                else{
                    curr.next=curr.next.next;
                    return;
                }
            }
            curr=curr.next;
        }
    }

    public char get(int index){
        Node curr = head;
        while(index>0){
            if(curr.next==null || head==null){
                return '☠';
            }
            curr=curr.next;
        }
        return curr.data;

    }

    public int indexOf(char item){
        Node curr = head;
        int count = 0;
        while(curr.next != null){
            if(curr.data==item){
                return count;
            }
            count+=1;
            curr=curr.next;
        }
        return -1;
    }
    public int lastIndexOf(char item){
        Node curr = head;
        int count = 0;
        int lastbest = -1;
        while(curr.next != null){
            if(curr.data==item){
                lastbest = count;
            }
            count+=1;
            curr=curr.next;
        }
        return lastbest;
    } 

    public boolean contains(char item){
        Node curr = head;
        while(curr.next != null){
            if(curr.data == item){
                return true;
            }
            curr = curr.next;
        }
        return false;
    }
    public void clear(){
        this.head = null;
    }

    public char getFirst(){
        if(head==null){
            return '☠';
        }
        return head.data;
    }

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

    public int size(){
        return size;
    }

    public boolean isEmpty(){
        return size==0;
    }

    private Node reverse(Node n){
        if (n==null || n.next==null){
            return n;
        }
        Node remains = reverse(n.next);
        n.next.next = n;
        n.next = null;
        return remains;
        

    }
    public void reverse(){
        reverse(head);
    }
}

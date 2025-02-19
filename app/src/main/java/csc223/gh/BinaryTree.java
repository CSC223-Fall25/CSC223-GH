package csc223.gh;

public class BinaryTree implements Tree{
    int size;
    TreeNode root;
    TreeNode curr;
    int capacity;


    public BinaryTree(int capacity){
        this.size=0;
        this.root = null;
        this.curr = this.root;
        this.capacity = capacity;

    }

    public void insert(char item){
        ArrayQueue<TreeNode> q = new ArrayQueue<>(capacity);
        TreeNode n = new TreeNode(item);
       
        this.size+=1;
        if(this.root==null){
            this.root = n;
            return;
        }
        q.enqueue(root);
        curr = root;

        while(q.isEmpty()==false){
            curr = q.dequeue();

            if(curr.left != null){
                q.enqueue(curr.left);
            }
            
            
            else if(curr.left == null){
                curr.left = n;
                return;
            }

            if(curr.right!=null){
                q.enqueue(curr.right);
            }
            else if (curr.right == null){
                curr.right = n;
                return;
            }
        } 
    }
       
    public String levelorder(){
        String output = "";
        ArrayQueue<TreeNode> q = new ArrayQueue<>(capacity);
        q.enqueue(root);
        curr = root;
        while(q.isEmpty()==false){
            curr = q.dequeue();
            output+=curr.data;

            if(curr.left != null){
                q.enqueue(curr.left);
            }
            
            if(curr.right!=null){
                q.enqueue(curr.right);
            }

        }
        return output;
    }
    private String inorder(TreeNode node){

        if (node == null){
            return "";
        }
        

        String left_str = inorder(node.left);
        System.out.println("Left string " + left_str);
        String right_str = inorder(node.right);
        System.out.println("Right string " + right_str);
    
        return left_str + node.data + right_str;

 
    }
    public String inorder(){
        return inorder(this.root);
    }

    private String postorder(TreeNode node){
    

        if (node == null){
            return "";
        }
        

        String left_str = postorder(node.left);
        System.out.println("Left string " + left_str);
        String right_str = postorder(node.right);
        System.out.println("Right string " + right_str);
    
        return left_str + right_str + node.data;

 
    }
    public String postorder(){
        return postorder(this.root);

    }

    private String preorder(TreeNode node){
    
        if (node == null){
            return "";
        }
        

        String left_str = preorder(node.left);
        System.out.println("Left string " + left_str);
        String right_str = preorder(node.right);
        System.out.println("Right string " + right_str);
    
        return node.data + left_str + right_str;

 
    }
    public String preorder(){
        return preorder(this.root);
    }
    public int size(){
        return this.size;
    }

    public int height(){
        double dubsize = (double) this.size;
        int output = (int) (Math.log(dubsize)/Math.log(2.0));
        return output;
    }

    private boolean search(char item, TreeNode node){
        
        if (node == null){
            return false;
        }
        else if (node.data == item){
            return true;
        }

        boolean in_left = search(item, node.left);
        boolean in_right = search(item, node.right);

        return (in_left || in_right);

    }
    public boolean search(char item){
        return search(item, this.root);
    }

    public boolean isEmpty(){
        return size==0;
    }


}

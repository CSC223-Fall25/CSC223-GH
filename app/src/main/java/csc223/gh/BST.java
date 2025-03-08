package csc223.gh;

public class BST {
    TreeNode<Integer> root;

    public BST(){
        this.root = null;
    }

    private void insert(int value, TreeNode<Integer> n){

        // empty root case
        if (this.root==null){
            this.root = new TreeNode<Integer>(value);
            return;
        }

        // no repeat values in tree
        if (n.data == value){
            return;
        }

        //placement
        if (n.data < value){
            if (n.right == null){
                n.right = new TreeNode<Integer>(value);
            }
            else{
                insert(value, n.right);
            }
        }

        else if(n.data>value){
            if (n.left == null){
                n.left = new TreeNode<Integer>(value);
            }
            else{
                insert(value, n.left);
            }
        }
    }


    public void insert(int value){
        insert(value, this.root);
    }

    public TreeNode<Integer> preorder_successor(TreeNode<Integer> n){

        if (n.left==null){
            return n;
        }
        else{
            return preorder_successor(n.left);
        }

    }

    private TreeNode<Integer> delete(int value, TreeNode<Integer> n){
        if (n==null){
            return null;
        }

        //navigation
        if (value < n.data){
            n.left = delete(value, n.left);
        }
        else if (value > n.data){
            n.right = delete(value, n.right);
        }

        //deletion case
        else{

            //one child
            if (n.left == null){
                return n.right;
            }
            if (n.right == null){
                return n.left;
            }

            //preorder for 2 children
            TreeNode<Integer> successor = preorder_successor(n.right);
            n.data = successor.data;
            n.right = delete(successor.data, n.right);
        }

        return n;    
    }

    public void delete(int value){
        delete(value, this.root);
    }

    private boolean search(int value, TreeNode<Integer> n){
        if (n == null){
            return false;
        }
        else if (n.data==value){
            return true;
        }
        else if (n.left==null && n.right == null){
            return false;
        }
        
        else if (value > n.data){
            return search(value, n.right);
        }
        else{
            return search(value, n.left);   
        }
    }

    public boolean search(int value){
        return search(value, this.root);
    }
    
    public void update(int oldValue, int newValue){

        //edge cases
        if (this.root == null || this.search(oldValue)==false){
            System.out.println("Empty tree or missing oldValue");
            return;
        }

        else{
            this.delete(oldValue);
            this.insert(newValue);
        }

    }

    private String inOrder(TreeNode<Integer> n){
        String left = "";
        String right = "";
        if (this.root == null){
            return "";
        }
        if (n.left != null){
            left = inOrder(n.left);
            left += ", ";
        }
        if (n.right != null){
            right = inOrder(n.right);
            right = ", "+ right;
        }
        return left + Integer.toString(n.data) + right;
    }

    public String inOrder(){
        return inOrder(this.root);
    }

    static BST sortedArrayToBST(int[] nums){

        if (nums == null){
            return null;
        }

        int median = -1;

        //finding median index in nums array for root
        if (nums.length % 2 == 1){
            median = nums.length / 2;    
        }
        else if (nums.length % 2 == 0){
            median = (nums.length/2)-1;
        }

        // creating new tree
        BST newtree = new BST();
        newtree.insert(nums[median]);
        for (int i=0; i < nums.length;i++ ){
            newtree.insert(nums[i]);
        }

        return newtree;
    }


    private int lowestCommonAncestor(int p, int q, TreeNode<Integer> n){

        //while a child is true, keep going down
        //return node.data when children are both false

        boolean rightContainsLCA = false; 
        boolean leftContainsLCA = false;
        boolean selfContainsLCA = false;

        //null case
        if (n==null){
            return -1;
        }        

        //checking if L/R branches contain LCA
        if (n.right != null){
            rightContainsLCA = (search(p, n.right) || search(q, n.right));
        }
        if (n.left != null){
            leftContainsLCA = (search(p, n.left) || search(q, n.left));
        }
        if (n.data==q || n.data == p){
            selfContainsLCA = true;
        }
    



        //basecase
        if ((rightContainsLCA && leftContainsLCA) || selfContainsLCA){
            return n.data;
        }
        
        else{
            if (leftContainsLCA){
                return lowestCommonAncestor(p, q, n.left);
            }
            else if (rightContainsLCA){
                return lowestCommonAncestor(p, q, n.right);
            }
            else{
                return -1;
            }
        }
    }

    public int lowestCommonAncestor(int p, int q){
        if (search(p)==false || search(q) == false){
            return -1;
        }
        else{
            return lowestCommonAncestor(p, q, this.root);
        }
        
    }
   
}

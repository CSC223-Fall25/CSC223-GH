// package csc223.gh;

// public class BinaryTree implements Tree{
//     int height;
//     int size;
//     TreeNode root;
//     TreeNode curr;

//     public BinaryTree(){
//         this.height=0;
//         this.size=0;
//         this.root = null;
//         this.curr = this.root;
//     }

//     public void insert(TreeNode node){
//         ArrayQueue<TreeNode> q = new ArrayQueue<>(20);
//         size+=1;
//         if(root==null){
//             root = node;
//             return;
//         }
//         q.enqueue(root);
//         curr = root;

//         while(q.isEmpty()==false){
//             curr = q.dequeue();

//             if(curr.left != null){
//                 q.enqueue(curr.left);
//             }
            
//             else if(curr.right!=null){
//                 q.enqueue(curr.right);
//             }
//             else if(curr.left == null){
//                 curr.left = node;
//                 return;
//             }
//             else{
//                 curr.right = node;
//                 return;
//             }
//         } 
//     }
       
//     public String levelorder(){
//         String output = "";
//         ArrayQueue<TreeNode> q = new ArrayQueue<>(10);
//         q.enqueue(root);
//         curr = root;
//         while(q.isEmpty()==false){
//             curr = q.dequeue();
//             output+=curr.data;

//             if(curr.left != null){
//                 q.enqueue(curr.left);
//             }
            
//             if(curr.right!=null){
//                 q.enqueue(curr.right);
//             }

//         }
//         return output;
//     }
//     private String inorder(TreeNode node, String string){
        
//     }
//     public String inorder(){
//         return inorder(this.root, "");
//     }

    
//     public int size(){
//         return this.size;
//     }

//     public int height(){
//         return this.height;
//     }

//     public boolean isEmpty(){
//         return size==0;
//     }


// }

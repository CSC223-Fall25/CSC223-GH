package csc223.gh;

public class TreeNode<T>{
    TreeNode<T> left;
    TreeNode<T> right;
    T data;
    public TreeNode(T data){
        this.left = null;
        this.right = null;
        this.data = data;
    }   
}
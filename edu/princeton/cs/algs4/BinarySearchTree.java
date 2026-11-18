package edu.princeton.cs.algs4;

import com.sun.source.tree.Tree;

class TreeNode{
    int data;
    TreeNode left;
    TreeNode right;


    public TreeNode(int data){
        this.data = data;
        right = null;
        left = null;
    }
}

public class BinarySearchTree {
    public static TreeNode insert(TreeNode root, int data) {
        if (root == null){
            return new TreeNode(data);
        }
        else {
            if (data <= root.data){
                root.left = insert(root.left, data);
            }
            else {
                root.right = insert(root.right, data) ;
            }
        }
        return root;
    }
}

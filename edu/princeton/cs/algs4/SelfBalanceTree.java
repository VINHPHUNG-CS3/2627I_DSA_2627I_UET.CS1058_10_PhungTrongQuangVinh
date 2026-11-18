package edu.princeton.cs.algs4;

import java.util.*;

public class SelfBalanceTree {

    static class Node {
        int val;
        int ht;
        Node left, right;

        Node(int val) {
            this.val = val;
            this.ht = 0;
            this.left = null;
            this.right = null;
        }
    }

    static int height(Node node) {
        if (node == null) {
            return -1;
        }
        return node.ht;
    }

    static void updateHeight(Node node) {
        node.ht = 1 + Math.max(height(node.left), height(node.right));
    }

    static int balanceFactor(Node node) {
        return height(node.left) - height(node.right);
    }

    static Node rotateRight(Node y) {
        Node x = y.left;
        Node T2 = x.right;

        x.right = y;
        y.left = T2;

        updateHeight(y);
        updateHeight(x);

        return x;
    }

    static Node rotateLeft(Node x) {
        Node y = x.right;
        Node T2 = y.left;

        y.left = x;
        x.right = T2;

        updateHeight(x);
        updateHeight(y);

        return y;
    }

    static Node insert(Node root, int val) {
        if (root == null) {
            return new Node(val);
        }

        if (val < root.val) {
            root.left = insert(root.left, val);
        } else if (val > root.val) {
            root.right = insert(root.right, val);
        } else {
            return root;
        }

        updateHeight(root);

        int bf = balanceFactor(root);

        if (bf > 1 && val < root.left.val) {
            return rotateRight(root);
        }

        if (bf < -1 && val > root.right.val) {
            return rotateLeft(root);
        }

        if (bf > 1 && val > root.left.val) {
            root.left = rotateLeft(root.left);
            return rotateRight(root);
        }

        if (bf < -1 && val < root.right.val) {
            root.right = rotateRight(root.right);
            return rotateLeft(root);
        }

        return root;
    }

    static void inorder(Node root) {
        if (root == null) {
            return;
        }

        inorder(root.left);
        System.out.print(root.val + "(BF=" + balanceFactor(root) + ") ");
        inorder(root.right);
    }

    static void preorder(Node root) {
        if (root == null) {
            return;
        }

        System.out.print(root.val + "(BF=" + balanceFactor(root) + ") ");
        preorder(root.left);
        preorder(root.right);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Node root = null;
        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            int val = sc.nextInt();
            root = insert(root, val);
        }

        int insert_value = sc.nextInt();
        root = insert(root, insert_value);

        inorder(root);
        System.out.println();

        preorder(root);
        System.out.println();

        sc.close();
    }
}

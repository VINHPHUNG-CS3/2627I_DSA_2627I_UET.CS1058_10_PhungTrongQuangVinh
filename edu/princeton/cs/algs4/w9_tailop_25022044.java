package edu.princeton.cs.algs4;
import java.util.Scanner;

public class w9_tailop_25022044 {
    static final int MAX = 100;

    // Mang bieu dien cay
    static int[] firstChild = new int[MAX];
    static int[] nextSibling = new int[MAX];

    static int n, root;

    // Khoi tao cay
    static void init() {
        for (int i = 0; i < MAX; i++) {
            firstChild[i] = -1;
            nextSibling[i] = -1;
        }
    }

    // Them node child vao danh sach con cua parent
    static void addChild(int parent, int child) {
        if (firstChild[parent] == -1) {
            firstChild[parent] = child;
        } else {
            int p = firstChild[parent];

            while (nextSibling[p] != -1) {
                p = nextSibling[p];
            }

            nextSibling[p] = child;
        }
    }

    // 1. Tim bo cua node x
    static int findParent(int x) {
        for (int i = 1; i <= n; i++) {
            int child = firstChild[i];

            while (child != -1) {
                if (child == x) {
                    return i;
                }

                child = nextSibling[child];
            }
        }

        return -1;
    }

    // 2. Tim cac con cua node x
    static void findChildren(int x) {
        System.out.print("Cac con cua node " + x + ": ");

        int child = firstChild[x];

        if (child == -1) {
            System.out.println("Khong co");
            return;
        }

        while (child != -1) {
            System.out.print(child + " ");
            child = nextSibling[child];
        }

        System.out.println();
    }

    // 3. Tim cac em lien ke cua node x
    static void findSiblings(int x) {
        System.out.print("Cac em lien ke cua node " + x + ": ");

        int parent = findParent(x);

        if (parent == -1) {
            System.out.println("Khong co");
            return;
        }

        int sibling = firstChild[parent];

        while (sibling != -1) {
            if (sibling != x) {
                System.out.print(sibling + " ");
            }

            sibling = nextSibling[sibling];
        }

        System.out.println();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        init();

        n = sc.nextInt();
        root = sc.nextInt();

        for (int i = 0; i < n - 1; i++) {
            int parent = sc.nextInt();
            int child = sc.nextInt();

            addChild(parent, child);
        }

        int x = sc.nextInt();

        int parent = findParent(x);

        if (parent == -1)
            System.out.println("Parent: None (Root)");
        else
            System.out.println("Parent: " + parent);

        findChildren(x);
        findSiblings(x);

        sc.close();
    }
}

package edu.princeton.cs.algs4;

import java.util.Comparator;
import java.util.Scanner;

public class MergeSort {
    private static boolean less(Comparable a, Comparable b){
        return a.compareTo(b) < 0;
    }
    private static void merge (Comparable[] a, Comparable[] aux, int lo, int mid, int hi){
        for (int k = 0; k <= hi; k++){
            aux[k] = a[k];
        }
        int i = lo;
        int j = mid + 1;
        for (int k = lo; k <= hi; k++){
            if (i > mid) a[k] = aux[j++];
            else if (j > hi) a[k] = aux[i++];
            else if (less(aux[i], aux[j])) a[k] = aux[i++];
            else a[k] = aux[j++];
        }
    }

    private static void sort(Comparable[] a, Comparable[] aux, int lo, int hi){
        if (hi <= lo) return;
        int mid = lo + (hi - lo) / 2;
        sort(a, aux, lo, mid);
        sort(a, aux, mid + 1, hi);
        merge(a, aux, lo, mid, hi);
    }

    public static void sort(Comparable[] a){
        Comparable[] aux = new Comparable[a.length];
        sort(a, aux, 0, a.length - 1);
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        Comparable [] a = new Comparable[N];
        for (int i = 0; i < N; i++){
            a[i] = sc.nextInt();
        }
        sort(a);

        for (Comparable i : a) {
            System.out.print(i + " ");
        }
    }
}

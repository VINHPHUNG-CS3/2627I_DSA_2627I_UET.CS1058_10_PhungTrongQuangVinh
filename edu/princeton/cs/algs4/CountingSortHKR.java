package edu.princeton.cs.algs4;

import java.util.Scanner;

public class CountingSortHKR {
    static int[] freq = new int[100];
    public static void frequency(int[] ar){
        for (int i = 0; i < 100; i++){
            freq[i] = 0;
        }
        for (int i = 0; i < ar.length; i++){
            freq[ar[i]] += 1;
        }
    }




    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int arr[] = new int[n];
        for (int i = 0; i < n; i++){
            arr[i] = sc.nextInt();
        }
        frequency(arr);
        System.out.println();
        for (int num : freq) {
            System.out.print(num + " ");
        }
    }
}

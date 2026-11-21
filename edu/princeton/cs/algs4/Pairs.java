package edu.princeton.cs.algs4;

import java.util.HashMap;
import java.util.Scanner;

public class Pairs {
    private static int pairs_count (int key, int[] arr){
        HashMap<Long, Integer> hm = new HashMap<>();
        int pairs = 0;
        for (int i : arr){
            long num = (long) i;

            pairs += hm.getOrDefault(num + key, 0);
            pairs += hm.getOrDefault(num - key, 0);

            hm.put(num, hm.getOrDefault(num, 0) + 1);
        }
        return pairs;
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n, k;
        n = sc.nextInt();
        k = sc.nextInt();
        int[]arr = new int[n];
        for (int i = 0; i < n; i++){
            arr[i] = sc.nextInt();
        }
        int res = pairs_count (k, arr);
        System.out.println(res);
        sc.close();
    }
}

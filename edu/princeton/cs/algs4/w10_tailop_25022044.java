package edu.princeton.cs.algs4;

import java.util.Scanner;

public class w10_tailop_25022044 {

    static class Result {
        int max;
        int min;

        Result(int max, int min) {
            this.max = max;
            this.min = min;
        }
    }

    static Result findMaxMin(int[] a, int left, int right) {

        // Truong hop co 1 phan tu
        if (left == right) {
            return new Result(a[left], a[left]);
        }

        // Truong hop co 2 phan tu
        if (right == left + 1) {
            if (a[left] > a[right]) {
                return new Result(a[left], a[right]);
            } else {
                return new Result(a[right], a[left]);
            }
        }

        // Chia day thanh hai nua
        int mid = (left + right) / 2;

        // De quy tim max, min cua hai nua
        Result L = findMaxMin(a, left, mid);
        Result R = findMaxMin(a, mid + 1, right);

        // Ket hop ket qua
        int max = Math.max(L.max, R.max);
        int min = Math.min(L.min, R.min);

        return new Result(max, min);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);


        int n = sc.nextInt();

        int[] a = new int[n];


        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }

        Result result = findMaxMin(a, 0, n - 1);

        System.out.println("Gia tri lon nhat: " + result.max);
        System.out.println("Gia tri nho nhat: " + result.min);

        sc.close();
    }
}

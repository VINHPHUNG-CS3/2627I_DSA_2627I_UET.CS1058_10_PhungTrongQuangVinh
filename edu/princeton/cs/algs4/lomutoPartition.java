package edu.princeton.cs.algs4;

import java.util.Scanner;

public class lomutoPartition
{
    private static void swap(int[] arr, int i, int j)
    {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    private static int partition(int[] arr, int low, int high) {
        int pivot = arr[high];
        int i = low;
        for (int j = low; j < high; j++) {
            if (arr[j] <= pivot) {
                swap(arr, i, j);
                i += 1;
            }
        }
        swap(arr, i, high);
        for (int k = 0; k < arr.length; k++)
        {
            System.out.print(arr[k] + " ");
        }
        System.out.println();
        return i;
    }

    private static void quicksort(int[] A, int low, int high)
    {
        if (low < high)
        {
            int p = partition(A, low, high);
            quicksort(A, low, p - 1);
            quicksort(A, p + 1, high);
        }
    }

    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++)
        {
            arr[i] = sc.nextInt();
        }
        quicksort(arr, 0, n - 1);
    }
}

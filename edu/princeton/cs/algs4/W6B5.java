package edu.princeton.cs.algs4;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class W6B5
{
    private static List<Integer> partition(List<Integer> arr)
    {
        int pivot = arr.get(0);
        List<Integer> left = new ArrayList<>();
        List<Integer> right = new ArrayList<>();
        List<Integer> equal = new ArrayList<>();
        for (int x : arr)
        {
            if (x == pivot) {equal.add(x);}
            else if (x > pivot) {right.add(x);}
            else {left.add(x);}
        }
        List<Integer> res = new ArrayList<>();
        for (int i : left) {res.add(i);}
        for (int i : equal) {res.add(i);}
        for (int i : right) {res.add(i);}
        return res;
    }

    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++)
        {
            list.add(sc.nextInt());
        }
        list = partition(list);
        for (int i : list)
        {
            System.out.print(i + " ");
        }
    }
}

package edu.princeton.cs.algs4;

import java.util.Arrays;
import java.util.Scanner;

public class w4_tailop_25022044 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        sc.nextLine();
        int[] std = new int[N];
        for (int i = 0; i < N; i++){
            std[i] = sc.nextInt();
        }
        Arrays.sort(std);
        for (int i = 0; i < std.length / 2; i++) {
            int temp = std[i];
            std[i] = std[std.length - 1 - i];
            std[std.length - 1 - i] = temp;
        }

        int h_index = 0;
        for (int i : std){
            if (i >= h_index + 1) {h_index += 1;}
            else{
                break;
            }
        }
        System.out.println(h_index);
    }
}
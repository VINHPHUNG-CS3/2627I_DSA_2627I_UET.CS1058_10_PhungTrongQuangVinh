package edu.princeton.cs.algs4;

import java.util.Scanner;

public class JavaStringPalindrome {
    private static boolean isPalindrome(String s){
        int left = 0;
        int right = s.length() -  1;
        boolean flag = true;
        while (left < right){
            if (s.charAt(left) != s.charAt(right)) {flag = false; break;}
            else {
                left++;
                right--;
            }
        }
        return flag;
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        if (isPalindrome(s)) {System.out.println("Yes");}
        else {System.out.println("No");}
    }
}

package edu.princeton.cs.algs4;

import java.util.Scanner;
import java.util.Stack;

public class BalanceBrackets {
    public static boolean isValid(String s){
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()){
            if (c == '(' || c == '[' || c == '{'){
                stack.push(c);
            }
            else if (c == ')' || c == ']' || c == '}'){
                if (stack.isEmpty()) {return false;}

                char top = stack.pop();
                if ((c == ')' && top != '(') || (c == ']' && top != '[') || (c == '}' && top != '{')) {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();

        String[] res = new String[n];

        for (int i = 0; i < n; i++) {
            String line = sc.nextLine();
            if (isValid(line)){
                res[i] = "YES";
            }
            else {res[i] = "NO";}
        }

        for (String op : res) {
            System.out.println(op);
        }
        sc.close();
    }
}

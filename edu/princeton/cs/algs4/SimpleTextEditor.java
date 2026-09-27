package edu.princeton.cs.algs4;

import java.util.Scanner;
import java.util.Stack;

public class SimpleTextEditor {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int Q = sc.nextInt();
        sc.nextLine();
        String text = "";
        Stack<String> history = new Stack<>();

        for (int i = 0; i < Q; i++){
            String line = sc.nextLine();
            String[] parts = line.split(" ");
            int opType = Integer.parseInt(parts[0]);

            if (opType == 1) {
                history.push(text);
                text += parts[1];
            }

            else if (opType == 2) {
                history.push(text);
                int k = Integer.parseInt(parts[1]);
                text = text.substring(0, text.length() - k);
            }

            else if (opType == 3) {
                int k = Integer.parseInt(parts[1]);
                System.out.println(text.charAt(k - 1));
            }

            else if (opType == 4) {
                if (!history.isEmpty()){
                    text = history.pop();
                }
            }
        }
        sc.close();
    }
}

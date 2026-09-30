package edu.princeton.cs.algs4;

import java.util.Stack;



public class w3_tailop_25022044 {

    // Hàm xác định độ ưu tiên của toán tử
    private static int precedence(char ch) {
        switch (ch) {
            case '+':
            case '-':
                return 1;
            case '*':
            case '/':
                return 2;
        }
        return -1;
    }

    // Hàm chuyển đổi từ Trung tố sang Hậu tố
    public static String convert(String exp) {
        StringBuilder result = new StringBuilder();
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < exp.length(); i++) {
            char c = exp.charAt(i);

            // Bỏ qua khoảng trắng
            if (c == ' ') {
                continue;
            }

            // 1. Nếu là toán hạng (chữ cái hoặc chữ số) -> Đưa ra kết quả
            if (Character.isLetterOrDigit(c)) {
                result.append(c).append(" ");
            }
            // 2. Nếu là '(' -> Push vào stack
            else if (c == '(') {
                stack.push(c);
            }
            // 3. Nếu là ')' -> Pop đến khi gặp '('
            else if (c == ')') {
                while (!stack.isEmpty() && stack.peek() != '(') {
                    result.append(stack.pop()).append(" ");
                }
                if (!stack.isEmpty() && stack.peek() == '(') {
                    stack.pop(); // Bỏ dấu '(' khỏi stack
                }
            }
            // 4. Nếu là toán tử (+, -, *, /)
            else {
                while (!stack.isEmpty() && precedence(c) <= precedence(stack.peek())) {
                    result.append(stack.pop()).append(" ");
                }
                stack.push(c);
            }
        }

        // 5. Pop các toán tử còn lại trong stack
        while (!stack.isEmpty()) {
            if (stack.peek() == '(') {
                return "Biểu thức không hợp lệ!";
            }
            result.append(stack.pop()).append(" ");
        }

        return result.toString().trim();
    }

    public static void main(String[] args) {
        String infix1 = "A + B * C";
        String infix2 = "(A + B) * (C - D)";
        String infix3 = "A + B * (C - D) / E";

        System.out.println("Trung tố: " + infix1 + " => Hậu tố: " + convert(infix1));
        System.out.println("Trung tố: " + infix2 + " => Hậu tố: " + convert(infix2));
        System.out.println("Trung tố: " + infix3 + " => Hậu tố: " + convert(infix3));
    }
}
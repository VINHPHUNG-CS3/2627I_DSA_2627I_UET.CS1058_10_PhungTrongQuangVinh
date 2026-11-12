package edu.princeton.cs.algs4;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

public class JesseAndCookies {
    private static int cookies(int k, List<Integer> A){
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (int x : A){
            pq.add((Integer) x);
        }
        int cnt = 0;
        while (!pq.isEmpty() && pq.peek() < k){
            if (pq.size() < 2) {return -1;}

            long a = pq.poll();
            long b = pq.poll();
            int new_sweetness = (int) (a + 2*b);

            pq.add((Integer) new_sweetness);
            cnt++;
        }
        return cnt;
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String[] inputs = sc.nextLine().split(" ");
        int n = Integer.parseInt(inputs[0]);
        int k = Integer.parseInt(inputs[1]);
        List<Integer> list = new ArrayList<>();
        for (int i = 0 ; i < n; i++){
            list.add((Integer) sc.nextInt());
        }
        int res = cookies(k, list);
        System.out.println(res);
        sc.close();
    }
}

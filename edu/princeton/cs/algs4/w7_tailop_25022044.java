package edu.princeton.cs.algs4;


import java.io.*;
import java.util.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Result {



    public static List<Double> runningMedian(List<Integer> a) {
        List<Double> result = new ArrayList<>();


        PriorityQueue<Integer> lower = new PriorityQueue<>(Collections.reverseOrder());

        PriorityQueue<Integer> higher = new PriorityQueue<>();

        for (int num : a) {

            lower.add(num);


            higher.add(lower.poll());


            if (higher.size() > lower.size()) {
                lower.add(higher.poll());
            }


            if (lower.size() > higher.size()) {
                result.add((double) lower.peek());
            } else {
                result.add((lower.peek() + higher.peek()) / 2.0);
            }
        }

        return result;
    }

}

public class w7_tailop_25022044 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        if (!scanner.hasNextInt()) return;
        int n = scanner.nextInt();

        List<Integer> a = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            a.add(scanner.nextInt());
        }

        List<Double> result = Result.runningMedian(a);

        for (double median : result) {
            System.out.printf(Locale.US, "%.1f\n", median);
        }

        scanner.close();
    }
}
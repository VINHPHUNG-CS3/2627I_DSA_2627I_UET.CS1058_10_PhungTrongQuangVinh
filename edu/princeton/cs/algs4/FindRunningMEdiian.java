package edu.princeton.cs.algs4;

import java.util.*;


public class FindRunningMEdiian {
    static List<Double> find(List<Integer> a){
        List<Double> medians = new ArrayList<>();

        Comparator<int []> comp = (x,y) -> {
            if (x[0] != y[0]){
                return Integer.compare(x[0], y[0]);
            }
            return Integer.compare(x[1], y[1]);
        };

        TreeSet<int []> leftSet = new TreeSet<>(comp);
        TreeSet<int []> rightSet = new TreeSet<>(comp);

        for (int i = 0; i < a.size(); i++){
            int[] current = new int[]{a.get(i), i};
            leftSet.add(current);
            rightSet.add(leftSet.pollLast());

            if (leftSet.size() < rightSet.size()){
                leftSet.add(rightSet.pollFirst());
            }

            if (leftSet.size() > rightSet.size()){
                medians.add((double) leftSet.last()[0]);
            } else {
                medians.add((double) 0.5*(leftSet.last()[0] + rightSet.first()[0]));
            }
        }
        return medians;
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<Integer> arr = new ArrayList<>();
        for (int i = 0; i < n; i++){
            arr.add(sc.nextInt());
        }
        List<Double> res = find(arr);
        for (double x : res){
            System.out.println(x);
        }
        sc.close();
    }
}

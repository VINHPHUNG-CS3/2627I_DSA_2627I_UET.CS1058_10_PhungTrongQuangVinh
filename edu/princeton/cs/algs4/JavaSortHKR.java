package edu.princeton.cs.algs4;

import java.util.*;

class Student{
    private int ID;
    private String FirstName;
    private double CGPA;

    public Student(int ID, String FirstName, double CGPA){
        this.ID = ID;
        this.FirstName = FirstName;
        this.CGPA = CGPA;
    }

    public int getID(){
        return this.ID;
    }

    public String getFirstName(){
        return this.FirstName;
    }

    public double getCGPA(){
        return this.CGPA;
    }

    @Override
    public String toString(){
        return this.ID + " " + this.FirstName + " " + this.CGPA;
    }
}

public class JavaSortHKR {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int N = Integer.parseInt(sc.nextLine());
        List<Student> list = new ArrayList<>();

        for (int i = 0; i < N; i++){
            String line = sc.nextLine();
            String parts[] = line.split(" ");
            int ID = Integer.parseInt(parts[0]);
            String Name = parts[1];
            double CGPA = Double.parseDouble(parts[2]);
            list.add(new Student(ID, Name, CGPA));
        }

        Collections.sort(list, new Comparator<Student>(){

            @Override
            public int compare(Student o1, Student o2) {
                if (Double.compare(o2.getCGPA(), o1.getCGPA()) != 0){
                    return Double.compare(o2.getCGPA(), o1.getCGPA());
                }
                if (!o1.getFirstName().equals(o2.getFirstName()))
                {return o1.getFirstName().compareTo(o2.getFirstName());}
                return Integer.compare(o1.getID(), o2.getID());
            }
        });

        for (Student student : list) {
            System.out.println(student.getFirstName());
        }
    }
}

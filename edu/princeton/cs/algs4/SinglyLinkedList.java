package edu.princeton.cs.algs4;

import java.util.Scanner;

public class SinglyLinkedList<Item> {
    private Node head;
    private Node tail;
    private int size;

    private class Node {
        Item data;
        Node next;

        public Node(Item data){
            this.data = data;
            this.next = null;
        }
    }

    public SinglyLinkedList(){
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    public void add(Item data){
        Node newNode = new Node(data);
        if (head == null){
            head = newNode;
            tail = newNode;
        }
        else {
            tail.next = newNode;
            tail = newNode;
        }
        size++;
    }

    public boolean isEmpty(){
        return size == 0;
    }

    public Item removeFirst(){
        if (isEmpty()) { return null;}

        Item removedItem = head.data;

        head = head.next;
        size--;

        if (head == null) {
            tail = null;
        }
        return removedItem;
    }

    public boolean remove(Item data){
        if (isEmpty()) return false;

        //Trường hợp đó là node head
        if (head.data.equals(data)) {
            head = head.next;
            size--;
            return true;
        }

        //Trường hơp phía sau node head
        Node current = head;
        while (current.next != null && !current.next.data.equals(data)) {
            current = current.next;
        }

        if (current.next != null){
            if (current.next == tail) {
                tail = current;
            }
            current.next = current.next.next;
            size--;
            return true;
        }

        return false;
    }

    public Item removeAt(int index){
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Invalid Index");
        }

        if (index == 0) {return removeFirst();}

        Node current = head;
        for (int i = 0; i < index - 1; i++){
            current = current.next;
        }
        Item removedData = current.next.data;
        current.next = current.next.next;
        size--;
        return removedData;
    }

    public void printLinkedList(){
        Node current = head;
        while (current != null){
            System.out.print(current.data + " -> ");
            current = current.next;
        }
        System.out.print(" null ");
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        SinglyLinkedList<Integer> linklist = new SinglyLinkedList<>();

        for (int i = 0 ; i < N; i++) {
            Integer data = sc.nextInt();
            linklist.add(data);
        }

        linklist.printLinkedList();
        sc.close();
    }
}
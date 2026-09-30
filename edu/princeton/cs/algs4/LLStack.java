package edu.princeton.cs.algs4;

//Stack with linked-list implement.
public class LLStack<Item> {
    //private inner class
    private class Node{
        Item item;
        Node next;
    }

    private Node first = null;

    public boolean isEmpty(){
        return first == null;
    }

    public void push(Item data){
        Node oldfirst = first;
        first = new Node();
        first.item = data;
        first.next = oldfirst;
    }

    public Item pop(){
        Item removeData = first.item;
        first = first.next;
        return removeData;
    }
}

package edu.princeton.cs.algs4;


public class FixedCapacityStackofGeneric<Item> {
    private Item[] item;
    private int N;

    public FixedCapacityStackofGeneric(int capacity){
        item = (Item[]) new Object[capacity];
    }

    public boolean isEmpty(){
        return N == 0;
    }

    public void push(Item data){
        item[N] = data;
        N++;
    }

    public Item pop(){
        N--;
        Item removedData = item[N];
        item[N] = null;
        return removedData;
    }
}

package com.cs.datastructure.stack;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Stack<T> {
    private class Node<T>{
        Node<T> prev;
        T data;
    }

    private Node<T> head;
    private int size = 0;


    public Stack(){

    }

    public void push(T data){
        Node<T> node = new Node<>();
        node.data = data;

        if(head == null){
            head = node;
        } else{
            node.prev = head;
            head = node;
        }
        size++;
    }
    public T pop(){
        if(head == null){
            return null;
        }

        T data = head.data;

        head = head.prev;
        size--;
        return data;
    }
    public T peek(){
        if(head == null){
            return null;
        }
        return head.data;
    }
    public int getSize() {
        return size;
    }


    public static void main(String[] args) {
        PriorityQueue<String> p = new PriorityQueue<>(2);
        p.offer("z");
        p.offer("a");
        p.offer("b");
        System.out.println(p.poll());

        System.out.println(p.poll());
    }
}
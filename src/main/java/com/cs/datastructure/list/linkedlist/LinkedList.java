package com.cs.datastructure.list.linkedlist;

public class LinkedList<T> {


    public static class Node<T> {
        public T data;
        public Node<T> next;
    }

    private Node<T> head;
    private int size = 0;

    public LinkedList() {
    }

    public LinkedList(Node<T> head) {
        this.head = head;
    }

    public Node<T> getHead() {
        return this.head;
    }

    public void addCycle(T data) {
        Node<T> node = new Node<>();
        node.data = data;
        if (head == null) {
            head = node;
        } else {
            Node<T> curr = head;

            while (curr.next != null) {
                curr = curr.next;
            }

            curr.next = node;
        }
        node.next = head.next;
        size++;
    }

    public T getFirst() {
        if (head == null) {
            return null;
        }
        return head.data;
    }

    public void add(T data) {
        Node<T> node = new Node<>();
        node.data = data;
        if (head == null) {
            head = node;
        } else {
            Node<T> curr = head;

            while (curr.next != null) {
                curr = curr.next;
            }

            curr.next = node;
        }
        size++;

    }

    public void addToFront(T data) {
        Node<T> node = new Node<>();
        node.data = data;
        if (head != null) {
            node.next = head;
        }
        head = node;
        size++;

    }

    public T remove(int index) {
        if (index >= size) {
            return null;
        }
        T data = null;

        if (index == 0) {
            data = head.data;
            head = head.next;
        } else {
            int i = 1;
            Node<T> curr = head.next;
            Node<T> prev = head;
            while (curr != null) {
                if (i == index) {
                    break;
                }
                i++;
                curr = curr.next;
                prev = prev.next;
            }
            data = curr.data;
            prev.next = curr.next;
        }
        size--;
        return data;
    }

    public T remove() {

        if (head == null) {
            return null;
        }

        T data = null;

        if (head.next == null) {
            data = head.data;
            head = null;

        }

        Node<T> curr = head.next;
        Node<T> prev = head;
        while (curr.next != null) {

            curr = curr.next;
            prev = prev.next;
        }
        data = curr.data;
        prev.next = curr.next;
        size--;
        return data;
    }

    public void clear() {
        head = null;
        size = 0;
    }

    public int getSize() {
        return size;
    }

    public void print() {
        if (head == null) {
            throw new NullPointerException();
        }
        Node<T> curr = head;

        while (curr != null) {
            System.out.print(curr.data + " -> ");
            curr = curr.next;
        }
        System.out.print("null");
    }
}
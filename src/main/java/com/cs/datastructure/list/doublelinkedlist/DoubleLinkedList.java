package com.cs.datastructure.list.doublelinkedlist;


public class DoubleLinkedList {
    int size;
    Node head;
    Node tail;

    public DoubleLinkedList(){
        head = new Node();
        tail = new Node();
        head.next = tail;
        tail.prev = head;
    }


    public void sort(){

    }

    public void addAfter(Node node, int i){
        Node nodeToadd = new Node();
        nodeToadd.value = i;

        nodeToadd.prev = node;
        nodeToadd.next = node.next;

        node.next.prev = nodeToadd;
        node.next = nodeToadd;
        size++;
    }

    public void addBefore(Node node, int i){
        Node nodeToAdd = new Node();
        nodeToAdd.value = i;

        nodeToAdd.next = node;
        nodeToAdd.prev = node.prev;
        node.prev.next = nodeToAdd;
        node.prev = nodeToAdd;
        size++;
    }

    public void add(int i){
        addBefore(tail, i);
    }

    public void addToHead(int i){
        addAfter(head, i);
    }

    public void add(int i, int position) {
        if(position <= size && position > 0){
            Node curr = head.next;

            int count = 1;
            while(curr != tail && position != count) {
                curr = curr.next;
                count++;
            }
            addBefore(curr, i);
        } else {
            throw new IndexOutOfBoundsException();
        }
    }

    public void remove(Node node){
        Node left = node.prev;
        Node right = node.next;

        left.next = right;
        right.prev = left;
        node.prev = null;
        node.next = null;
        size--;
    }

    public void removeAll(int i){
        Node curr = head.next;

        while(curr != tail) {
            if(i == curr.value){
                Node temp = curr;
                curr = curr.next;
                remove(temp);
            } else{
                curr = curr.next;
            }
        }
    }

    public Node findFirst(int i){
        Node curr = head.next;

        while(curr != tail) {
            if(i == curr.value){
                return curr;
            } 
        }
        return null;
    }

    public boolean contains(int i){
        Node node = findFirst(i);
        return node != null;
    }

    public void print(){
        Node curr = head.next;
        while(curr != tail) {
            System.out.print(curr.value + (curr.next != tail ? "<=>" : ""));
            curr = curr.next;
        }
        System.out.println();
    }
    public int size(){
        return this.size;
    }
    
    
    public static void main(String[] args) {
        DoubleLinkedList ddl = new DoubleLinkedList();
        ddl.add(2);
        ddl.add(3);
        ddl.add(4);
        ddl.add(5);
        ddl.add(6);
        System.out.println(ddl.size());
        ddl.addToHead(-1);
        ddl.addToHead(-3);
        System.out.println(ddl.size());
        ddl.removeAll(4);
        ddl.add(20, 3);
        ddl.add(30, 7);
        ddl.add(50, 1);
        System.out.println(ddl.size());
        ddl.print();
    }
    
    public static class Node{
        Node prev;
        Node next;
        int value;
    }
}
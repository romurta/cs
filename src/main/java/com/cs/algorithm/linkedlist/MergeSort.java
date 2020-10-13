package com.cs.algorithm.linkedlist;

import com.cs.datastructure.list.linkedlist.LinkedList;
import com.cs.datastructure.list.linkedlist.LinkedList.Node;

public class MergeSort {
    static final SortCompare ASC = (a, b) -> a <= b;
    static final SortCompare DESC = (a, b) -> a > b;

    static SortCompare DEFAULT = ASC;

    public static Node<Integer> getSortedList(Node<Integer> head, boolean desc) {
        if (desc) {
            DEFAULT = DESC;
        } else {
            DEFAULT = ASC;
        }
        return split(head);
    }

    public static Node<Integer> split(Node<Integer> head) {
        if (head == null || head.next == null) return head;
        Node<Integer> slow = head;
        Node<Integer> fast = head.next;  


        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        fast = slow.next;
        slow.next = null;

        return merge(split(head), split(fast));
    }


    private static Node<Integer> merge(Node<Integer> left, Node<Integer> right) {
        Node<Integer> head = new Node<>();
        Node<Integer> curr = head;

        while (left != null && right != null) {

            if (DEFAULT.compare(left.data, right.data)) {
                curr.next = left;
                left = left.next;
            } else {
                curr.next = right;
                right = right.next;
            }

            curr = curr.next;
        }

        if (left != null) {
            curr.next = left;
        }

        if (right != null) {
            curr.next = right;
        }

        return head.next;
    }

    public static void main(String[] args) {

        LinkedList<Integer> list = new LinkedList<>();
        list.add(5);
        list.add(4);
        list.add(1);
        list.add(3);
        list.add(10);
        list.add(0);
        list.add(2);
        list.add(0);

        list.print();

        System.out.println("");
        Node<Integer> newHead = getSortedList(list.getHead(), false);

        LinkedList<Integer> newList = new LinkedList<>(newHead);
        newList.print();

    }
}


interface SortCompare {
    boolean compare(Integer a, Integer b);
}

package com.cs.algorithm.linkedlist;

import com.cs.datastructure.list.linkedlist.LinkedList;

public class Cycle {
    public static void main(String[] args) {
        LinkedList<Integer> list = new LinkedList<>();

        list.add(4);
        list.add(3);
        list.add(5);
        list.addCycle(6);

        System.out.println(solution(list.getHead()));

        LinkedList<Integer> listN = new LinkedList<>();

        listN.add(4);
        listN.add(3);
        listN.add(5);

        System.out.println(solution(listN.getHead()));

    }

    private static boolean solution(LinkedList.Node<Integer> head) {

        LinkedList.Node<Integer> slow = head;
        LinkedList.Node<Integer> fast = head.next;

        while (fast.next != null && fast.next.next != null) {

            if (fast == slow) {
                return true;
            }

            slow = slow.next;
            fast = fast.next.next;
        }
        return false;
    }
}

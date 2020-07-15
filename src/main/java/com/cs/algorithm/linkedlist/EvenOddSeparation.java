package com.cs.algorithm.linkedlist;

import com.cs.datastructure.list.linkedlist.LinkedList;
import com.cs.datastructure.list.linkedlist.LinkedList.Node;

/**
 * Separate even and odd numbers returning even numbers first
 *
 * 0->1->2->3->4->5
 * 0->2->4->1->3->5
 */
public class EvenOddSeparation {
    public static void main(String[] args) {
        LinkedList<Integer> list = new LinkedList<>();
        list.add(0);
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);

        list.print();

        System.out.println();

        Node<Integer> head = list.getHead();

        LinkedList<Integer> newList = new LinkedList<>(solution(head));
        newList.print();
    }

    private static Node<Integer> solution(Node<Integer> head) {

        Node<Integer> evenHead = null;
        Node<Integer> evenTail = null;
        Node<Integer> oddHead = null;
        Node<Integer> oddTail = null;
        Node<Integer> curr = head;

        while(curr != null){
            if(isEven(curr.data)) {
                if(evenHead == null){
                    evenHead = curr;
                    evenTail = curr;
                } else{
                    evenTail.next = curr;
                    evenTail = curr;
                }
            } else {
                if(oddHead == null){
                    oddHead = curr;
                    oddTail = curr;
                } else{
                    oddTail.next = curr;
                    oddTail = curr;
                }
            }

            curr = curr.next;
        }



        if(oddTail != null){
            oddTail.next = null;
        }
        if(evenTail != null){
            evenTail.next = oddHead;

        }

        return evenHead != null? evenHead : oddHead;
    }

    private static boolean isEven(Integer data) {
        return (data % 2 == 0);
    }
}

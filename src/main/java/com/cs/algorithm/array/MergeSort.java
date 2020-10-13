package com.cs.algorithm.array;

public class MergeSort {
    // Linked list node
    static class Node
    {
        int data;
        Node next;

        Node(int data, Node next) {
            this.data = data;
            this.next = next;
        }
    };

    static class Linked_List
    {
        // Printing function
        public static void printList(Node head)
        {
            Node ptr = head;
            while (ptr != null)
            {
                System.out.print(ptr.data + " -> ");
                ptr = ptr.next;
            }

            System.out.println("null");
        }

        // merging two linked list
        public static Node SortedMerge(Node lst1, Node lst2)
        {
            // Base cases
            if (lst1 == null)
                return lst2;

            else if (lst2 == null)
                return lst1;

            Node result;

            if (lst1.data <= lst2.data)
            {
                result = lst1;
                result.next = SortedMerge(lst1.next, lst2);
            }
            else
            {
                result = lst2;
                result.next = SortedMerge(lst1, lst2.next);
            }

            return result;
        }

        //splitting list into two halves
        public static Node[] FrontBackSplit(Node ptr)
        {
            // base case
            if (ptr == null || ptr.next == null) {
                return new Node[]{ ptr, null } ;
            }

            Node backward = ptr;
            Node forward = ptr.next;

            // Forward moves twice and backward moves once
            while (forward != null)
            {
                forward = forward.next;
                if (forward != null)
                {
                    backward = backward.next;
                    forward = backward.next;
                }
            }

            // splitting the linked list
            Node[] arr = new Node[]{ ptr, backward.next };
            backward.next = null;

            return arr;
        }

        // Sorting linked list using merge sort.
        public static Node MergeSort(Node head)
        {
            // Base case
            if (head == null || head.next == null) {
                return head;
            }

            Node[] arr = FrontBackSplit(head);
            Node first_half = arr[0];
            Node second_half = arr[1];


            first_half = MergeSort(first_half);
            second_half = MergeSort(second_half);

            // merge the two sorted list into single list.
            return SortedMerge(first_half, second_half);
        }

        // Driver Program
        public static void main(String[] arguments)
        {
            int[] arr = { 54, 12, 2, 1, 15, 4, 10};

            Node head = null;
            for (int i=0; i < 7; i++) {
                head = new Node (arr[i], head);
            }

            printList(head);
            head = MergeSort(head);
            printList(head);
        }
    }
}

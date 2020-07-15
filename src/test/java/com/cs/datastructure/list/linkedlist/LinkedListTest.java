package com.cs.datastructure.list.linkedlist;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LinkedListTest {

    private LinkedList<Integer> linkedList;

    @BeforeEach
    public void setup(){
        linkedList = new LinkedList<>();
    }

    @Test
    public void shouldAddElementToTheList(){
        linkedList.add(1);
        linkedList.add(2);
        linkedList.add(3);

        assertEquals(3, linkedList.getSize());
    }

    @Test
    public void shouldRemoveTheLastElementCorrectly(){
        linkedList.add(1);
        linkedList.add(2);
        linkedList.add(3);

        Integer data = linkedList.remove();

        assertEquals(3,data);
        assertEquals(2, linkedList.getSize());
    }

    @Test
    public void shouldRemoveElementByIndexCorrectly(){
        linkedList.add(1);
        linkedList.add(2);
        linkedList.add(3);

        Integer data = linkedList.remove(1);

        assertEquals(2,data);
        assertEquals(2, linkedList.getSize());
    }

    @Test
    public void shouldRemoveHeadByIndexCorrectly(){
        linkedList.add(1);
        linkedList.add(2);
        linkedList.add(3);

        Integer data = linkedList.remove(0);

        assertEquals(1,data);
        assertEquals(2, linkedList.getSize());
        assertEquals(2,linkedList.getFirst());
    }

}
package com.cs.datastructure.heap;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MaxHeapTest {

    private MaxHeap heap;

    @BeforeEach
    void setUp() {
        heap = new MaxHeap(10);
    }

    @Test
    public void shouldExtratTheCorrectMax(){
        heap.add(0);
        heap.add(16);
        heap.add(50);
        heap.add(15);
        heap.add(2);

        assertEquals(5, heap.getSize());
        assertEquals(50, heap.extractMax());
        assertEquals(16, heap.extractMax());
        assertEquals(15, heap.extractMax());
    }
}
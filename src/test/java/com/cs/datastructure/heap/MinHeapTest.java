package com.cs.datastructure.heap;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MinHeapTest {

    private MinHeap heap;

    @BeforeEach
    void setUp() {
        heap = new MinHeap(10);
    }

    @Test
    public void shouldExtratTheCorrectMax(){
        heap.add(1);
        heap.add(16);
        heap.add(50);
        heap.add(15);
        heap.add(2);

        assertEquals(5, heap.getSize());
        assertEquals(1, heap.extractMin());
        assertEquals(2, heap.extractMin());
        assertEquals(15, heap.extractMin());
    }
}
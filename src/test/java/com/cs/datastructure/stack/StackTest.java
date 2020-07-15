package com.cs.datastructure.stack;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StackTest {


    private Stack<Integer> stack;

    @BeforeEach
    public void setup(){
        stack = new Stack<>();
    }

    @Test
    public void shouldPushDataCorrectly(){
        stack.push(1);
        stack.push(2);

        assertEquals(2,stack.peek());
        assertEquals(2,stack.getSize());

    }

    @Test
    public void shouldPopDataCorrectly(){
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);

        assertEquals(4,stack.peek());
        assertEquals(4,stack.getSize());
        assertEquals(4,stack.pop());
        assertEquals(3,stack.peek());
        assertEquals(3,stack.getSize());
    }
}
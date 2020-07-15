package com.cs.datastructure.tree.bst;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BinarySearchTreeTest {

    private BinarySearchTree<Integer> bst;

    @BeforeEach
    public void setup(){
        bst = new BinarySearchTree<>();
    }

    @Test
    public void shouldHaveTheCorrectSizeAfterAddNodeToTheTree(){
        bst.insert(3,3);
        bst.insert(2,2);
        bst.insert(5,5);
        bst.insert(1,1);
        bst.insert(8,8);
        bst.insert(7,7);

        assertEquals(6, bst.getSize());
    }

}
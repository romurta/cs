package com.cs.datastructure.tree.general.iterator;

import com.cs.datastructure.tree.general.TreeNode;

import java.util.Iterator;
import java.util.Stack;

public class GeneneralTreeIterator<T extends TreeNode> implements Iterator<T> {

    Stack<T> stack;

    public GeneneralTreeIterator(T node){
        stack = new Stack<>();
        stack.push(node);
    }

    @Override
    public boolean hasNext() {
        return !stack.isEmpty();
    }

    @Override
    public T next() {
        T node = stack.pop();
        for (int i = node.getChildren().size() - 1; i >= 0; i--) {
            stack.push((T) node.getChildren().get(i));
        }
        return node;
    }
}

package com.cs.datastructure.tree.general;

import com.cs.datastructure.tree.general.iterator.GeneneralTreeIterator;

import java.util.Iterator;

public class Tree<T extends TreeNode> implements Iterable<T> {
    private TreeNode<T> root;

    public Tree(T root) {
        this.root = root;
    }

    @Override
    public Iterator<T> iterator() {
        return new GeneneralTreeIterator<T>((T) root);
    }
}

package com.cs.datastructure.tree.general;

import lombok.Getter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

@Getter
public class TreeNode<T> {
    private T data;
    private List<TreeNode<T>> children;

    public TreeNode(T data) {
        this.data = data;
        children = new ArrayList<>();
    }

    public void addChild(T data){
        this.addChild(new TreeNode<>(data));
    }

    public void addChild(TreeNode<T> node){
        this.children.add(node);
    }

    public void addChildren(TreeNode<T>...nodes){
        this.children.addAll(Arrays.asList(nodes));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TreeNode<?> treeNode = (TreeNode<?>) o;
        return Objects.equals(data, treeNode.data);
    }

    @Override
    public int hashCode() {
        return Objects.hash(data);
    }
}

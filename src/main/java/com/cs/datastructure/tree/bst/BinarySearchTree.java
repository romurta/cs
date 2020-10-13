package com.cs.datastructure.tree.bst;


import java.util.Iterator;
import java.util.Stack;

public class BinarySearchTree<T> implements Iterator<T>, Iterable<T> {

    Stack<BstNode<T>> stack;

    @Override
    public boolean hasNext() {
        return !stack.isEmpty();
    }

    @Override
    public T next() {

        BstNode<T> node = stack.pop();

        if (node.right != null) {
            populateIteratorStack(node.right);
        }

        return node.value;
    }

    @Override
    public Iterator<T> iterator() {
        stack = new Stack<>();
        populateIteratorStack(root);
        return this;
    }

    private void populateIteratorStack(BstNode node) {
        while (node != null) {
            stack.push(node);
            node = node.left;
        }
    }

    public static class BstNode<T> {
        int key;
        T value;
        BstNode<T> left;
        BstNode<T> right;

        public BstNode(int key, T value) {
            this.key = key;
            this.value = value;
        }

        /**
         * find the min of a node children
         * The min will be located in the extreme left side of a sub tree
         *
         * @return
         */
        public BstNode<T> min() {
            if (left == null) {
                return this;
            } else {
                return left.min();
            }
        }
    }

    private BstNode<T> root;
    private int size = 0;

    public int getSize() {
        return this.size;
    }

    public void insert(int key, T data) {
        this.root = insert(key, data, root);
    }

    private BstNode<T> insert(int key, T data, BstNode<T> node) {
        if (node == null) {
            node = new BstNode<>(key, data);
            size++;
        } else if (key < node.key) {
            node.left = insert(key, data, node.left);
        } else if (key > node.key) {
            node.right = insert(key, data, node.right);
        } else {
            System.out.println("duplicate element");
        }
        return node;
    }

    public void delete(int key) {
        this.root = delete(key, this.root);
    }

    private BstNode<T> delete(int key, BstNode<T> node) {
        if (node == null) {
            return null;
        } else if (key < node.key) {
            node.left = delete(key, node.left);
        } else if (key > node.key) {
            node.right = delete(key, node.right);
        } else {
            // leaf
            if (node.left == null && node.right == null) {
                node = null;
            }
            // one child
            else if (node.left != null) {
                node = node.left;
            } else if (node.right != null) {
                node = node.right;
            }
            // node has subtree
            else {
                BstNode<T> rightMin = findMin(node.right);

                node.key = rightMin.key;
                node.value = rightMin.value;

                node = delete(node.key, node.right);
            }
        }
        return node;
    }

    public void printBoundary() {

        if (this.root == null) {
            return;
        }

        System.out.print(this.root.key + " ");

        printLeft(this.root.left);
        printLeaf(this.root);
        printRight(this.root.right);
    }

    private void printRight(BstNode<T> node) {
        if (node == null) {
            return;
        }

        if(node.left==null && node.right==null){
            return;
        }

        if (node.right != null) {
            printRight(node.right);
        } else if (node.left != null) {
            printRight(node.left);
        }
        System.out.print(node.key + " ");
    }

    private void printLeaf(BstNode<T> node) {
        if (node == null) {
            return;
        }

        if (node.left == null && node.right == null) {
            System.out.print(node.key + " ");
            return;
        }

        printLeaf(node.left);
        printLeaf(node.right);

    }

    private void printLeft(BstNode<T> node) {
        if (node == null) {
            return;
        }

        if(node.left==null && node.right==null){
            return;
        }

        System.out.print(node.key + " ");
        if (node.left != null) {
            printLeft(node.left);
        } else if (node.right != null) {
            printLeft(node.right);
        }
    }

    public void printInOrder() {
        printInOrder(this.root);
    }

    private void printInOrder(BstNode<T> node) {
        if (node == null) {
            return;
        }
        printPreOrder(node.left);
        System.out.print(node.key + " ");
        printPreOrder(node.right);
    }

    public void printPreOrder() {
        printPreOrder(this.root);
    }

    private void printPreOrder(BstNode<T> node) {
        if (node == null) {
            return;
        }
        System.out.print(node.key + " ");
        printPreOrder(node.left);
        printPreOrder(node.right);
    }

    public void printPostOrder() {
        printPostOrder(this.root);
    }

    private void printPostOrder(BstNode<T> node) {
        if (node == null) {
            return;
        }

        printPreOrder(node.left);
        printPreOrder(node.right);
        System.out.print(node.key + " ");
    }

    private BstNode<T> findMin(BstNode<T> right) {
        return right.min();
    }

    public static void main(String[] args) {
        BinarySearchTree<Integer> bst = new BinarySearchTree<>();
        bst.insert(3, 3);
        bst.insert(2, 2);
        bst.insert(5, 5);
        bst.insert(1, 1);
        bst.insert(8, 8);
        bst.insert(7, 7);

        bst.printBoundary();
        System.out.println();
//        bst.printInOrder();
//        System.out.println();
//        bst.printPreOrder();
//        System.out.println();
//        bst.printPostOrder();
    }

}
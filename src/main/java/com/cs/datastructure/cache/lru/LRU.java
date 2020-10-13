package com.cs.datastructure.cache.lru;

import java.util.HashMap;
import java.util.Map;

public class LRU<K, V> {

    private static class Node<K, V> {
        V data;
        K key;
        Node<K, V> left;
        Node<K, V> right;
    }

    private Map<K, Node<K, V>> hash;
    private Node<K, V> head;
    private Node<K, V> tail;
    private int capacity;

    public LRU(int capacity) {
        this.capacity = capacity;
        hash = new HashMap<>(this.capacity);

        head.right = tail;
        tail.left = head;
    }

    public void put(K key, V value) {
        Node<K, V> node = this.hash.get(key);
        if (node == null) {
            node = new Node<>();
            node.data = value;

            if (hash.size() == capacity) {
                this.hash.remove(tail.left.key);
                remove(tail.left);
            }
            this.hash.put(key, node);
            add(node);
        } else {
            moveToFront(node);
            node.data = value;
        }
    }

    public V get(K key) {
        Node<K, V> node = this.hash.get(key);
        if (node == null) {
            return null;
        }

        V data = node.data;

        moveToFront(node);

        return data;
    }

    private void add(Node<K, V> node) {
        node.left = head;
        node.right = head.right;

        head.right.left = node;
        head.right = node;
    }

    private void remove(Node<K, V> node) {
        Node<K, V> rightNode = node.right;
        Node<K, V> leftNode = node.left;

        leftNode.right = rightNode;
        rightNode.left = leftNode;
    }

    private void moveToFront(Node<K, V> node) {
        remove(node);
        add(node);
    }


}
package com.cs.datastructure.tree.trie;

import java.util.ArrayList;
import java.util.List;

public class Trie {
    TrieNode root;

    public Trie() {
        root = new TrieNode(' ');
    }

    public List<String> autocomplete(String prefix) {
        TrieNode lastNode = root;
        for (int i = 0; i < prefix.length(); i++) {
            lastNode = lastNode.getChild(prefix.charAt(i));
            if(lastNode == null){
                return new ArrayList<>();
            }
        }
        return lastNode.getWords();
    }

    public void insert(String word) {
        if (search(word)) {
            return;
        }
        TrieNode curr = root;
        TrieNode pre;

        for (char ch : word.toCharArray()) {
            pre = curr;
            TrieNode child = curr.getChild(ch);
            if(child != null){
                curr = child;
                child.parent = pre;
            } else{
                TrieNode newChild = new TrieNode(ch);
                curr.children.add(newChild);
                curr = newChild;
                newChild.parent = pre;
            }
        }
        curr.isEnd = true;
    }

    private boolean search(String word) {
        TrieNode curr = root;
        for (char ch : word.toCharArray()) {
            if(curr.getChild(ch) == null){
                return false;
            }else{
                curr = curr.getChild(ch);
            }
        }
        if(curr.isEnd){
            return true;
        }
        return false;
    }
}

package com.cs.datastructure.tree.trie;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
//
public class TrieNode {
    char data;
    LinkedList<TrieNode> children;
    TrieNode parent;
    boolean isEnd;

    public TrieNode(char c) {
        data = c;
        children = new LinkedList<>();
        isEnd = false;
    }

    public TrieNode getChild(char c) {
        if(children != null) {
            for (TrieNode eachChild: children){
                if(eachChild.data == c){
                    return eachChild;
                }
            }
        }
        return null;
    }

    protected List<String> getWords() {
        List<String> list = new ArrayList<>();
        if(isEnd){
            list.add(toString());
        }

        if(children != null){
            for (int i = 0; i < children.size(); i++) {
                if(children.get(i) != null) {
                    list.addAll(children.get(i).getWords());
                }

            }
        }
        return list;
    }

    @Override
    public String toString() {
        if(parent == null){
            return "";
        } else{
            return parent.toString() + new String(new char[]{data});
        }
    }

    public static void main(String[] args) {
        Trie t = new Trie();

        t.insert("amazon");
        t.insert("amazon prime");
        t.insert("amazing");
        t.insert("amazing spider man");

        List<String> a = t.autocomplete("amazon");
        for (int i = 0; i < a.size(); i++) {
            System.out.println(a.get(i));
        }
    }
}

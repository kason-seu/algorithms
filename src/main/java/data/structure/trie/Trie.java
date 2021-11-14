package data.structure.trie;

import java.util.Map;
import java.util.TreeMap;

public class Trie {
    private class Node {
        // 是否是某个单词的末尾
        public boolean isWordTail;

        // trie 树的子节点
        public Map<Character, Node> next;

        public Node() {
            this(false);
        }

        public Node(boolean isWordTail) {
            this.isWordTail = isWordTail;
            next = new TreeMap<>();
        }
    }

    // trie树的根节点
    private Node root;
    // 代表有多少个单词
    private int size;

    public int getSize() {
        return size;
    }

    public Trie() {
        root = new Node();
    }

    public void insert(String word) {
        insertDg(root, word, 0);
    }

    private void insertDg(Node node, String word, int index) {
        if (index == word.length()) {
            if (!node.isWordTail) {
                node.isWordTail = true;
                size++;
            }
            return;
        }
        if (node.next.get(word.charAt(index)) != null) {
            insertDg(node.next.get(word.charAt(index)), word, index + 1);
        } else {
            Node newNode = new Node(false);
            node.next.put(word.charAt(index), newNode);
            insertDg(newNode, word, index + 1);
        }
    }

    public boolean search(String word) {
        return searchDg(root, word, 0);
    }

    private boolean searchDg(Node node, String word, int index) {
        if (index >= word.length()) {
            return node.isWordTail;
        }
        if (node.next.get(word.charAt(index)) == null) {
            return false;
        } else {
            return searchDg(node.next.get(word.charAt(index)), word, index + 1);
        }
    }

    public boolean startsWith(String prefix) {


        return startsWithDg(root, prefix, 0);
    }

    private boolean startsWithDg(Node node, String prefix, int index) {

        if (index >= prefix.length()) {
            return true;
        }

        if (node.next.get(prefix.charAt(index)) != null) {
            return startsWithDg(node.next.get(prefix.charAt(index)), prefix, index + 1);
        } else {
            return false;
        }

    }
}

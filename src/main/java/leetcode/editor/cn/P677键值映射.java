package leetcode.editor.cn;


import java.util.Map;
import java.util.TreeMap;

public class P677键值映射 {

    public static void main(String[] args) {
        MapSum mapSum = new P677键值映射().new MapSum();

        mapSum.insert("a", 3);
        int ap = mapSum.sum("ap");// return 3 (apple = 3)

        System.out.println(ap);
        mapSum.insert("b", 2);
        ap = mapSum.sum("a");

        System.out.println(ap);
    }


    private class MapSum {
        private class Node<E> {
            public E value;
            // trie 树的子节点
            public Map<Character, Node<E>> next;

            public Node(E value) {
                next = new TreeMap<>();
                this.value = value;
            }
        }

        // trie树的根节点
        private Node<Integer> root;
        // 代表有多少个单词

        public MapSum() {
            root = new Node<Integer>(0);
        }

        public void insert(String key, int val) {

            insert(root, key, 0, val);
        }

        private void insert(Node<Integer> node, String word, int index, int val) {
            if (index >= word.length()) {
                node.value = val;
                return;
            }
            if (node.next.get(word.charAt(index)) != null) {
                insert(node.next.get(word.charAt(index)), word, index + 1, val);
            } else {
                Node newNode = new Node(0);
                node.next.put(word.charAt(index), newNode);
                insert(newNode, word, index + 1, val);
            }
        }

        public int sum(String prefix) {

            Node<Integer> cur = root;
            for (int i = 0; i < prefix.length(); i++) {
                if (cur.next.get(prefix.charAt(i)) != null) {
                    cur = cur.next.get(prefix.charAt(i));
                } else {
                    return 0;
                }
            }
            return  cur.value + sum(cur);
        }

        public int sum(Node<Integer> node) {
            int result = 0;
            for (Node<Integer> n : node.next.values()) {
                result =  result + n.value + sum(n);
            }
            return result;
        }
    }

}

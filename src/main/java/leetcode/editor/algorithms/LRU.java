package leetcode.editor.algorithms;

import java.util.HashMap;
import java.util.Map;

public class LRU {


    public static void main(String[] args) {
        MyQueue<String, Integer> myqueue = new MyQueue<>(3);

        myqueue.add("a", 1);
        myqueue.add("b", 2);
        myqueue.add("c", 3);
        System.out.println(myqueue.get("a").value);
        myqueue.update("b", 22);
        myqueue.add("d", 4);
        System.out.println(myqueue.get("d").value);

    }

    private static class Node<K,V> {
        public Node<K, V> pre;
        public Node<K, V> next;

        public V value;
        public K key;
        public Node(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }
    // 双端队列
    private static class NodeDoubleLinkedQueue<K,V> {

        public Node<K, V> head;
        public Node<K, V> tail;


        public NodeDoubleLinkedQueue() {
            this.head = null;
            this.tail = null;

        }

        public void addNode(Node<K, V> node) {
            if (head == null && tail == null) {
                    head = node;
                    tail = node;

            } else {

                this.tail.next = node;
                node.pre = this.tail;

                this.tail = node;


            }
        }

        public Node<K,V> moveToTail(Node<K,V> node) {


            if (head == node) {
                Node<K, V> next = node.next;
                head = next;
                tail.next = node;
                node.pre = tail;
                this.tail = node;
            } else if (tail != node){

                Node<K, V> pre = node.pre;
                Node<K, V> next = node.next;

                pre.next = next;
                next.pre = pre;

                this.tail.next = node;
                node.pre = this.tail;
                this.tail = node;

                return node;
            }
            return node;
        }

        public Node<K,V> removeHead() {
            Node<K, V> head = this.head;

            Node<K,V> next = head.next;
            this.head = next;
            return head;
        }
    }

    public static class MyQueue<K,V> {

        private Map<K,Node<K,V>> nodesMap;
        private NodeDoubleLinkedQueue<K, V> nodeDoubleLinkedQueue;
        private int cap;

        public MyQueue(int cap) {
            this.nodesMap = new HashMap<>();
            this.cap = cap;
            this.nodeDoubleLinkedQueue = new NodeDoubleLinkedQueue<>();
        }


        public void add(K key, V val) {
            if (nodesMap.containsKey(key)) {
                return;
            } else {
                if (nodesMap.size() < cap) {
                    Node<K, V> newNode = new Node<>(key, val);
                    this.nodeDoubleLinkedQueue.addNode(newNode);
                    nodesMap.put(key, newNode);
                } else {
                    Node<K, V> kvNode = this.nodeDoubleLinkedQueue.removeHead();
                    nodesMap.remove(kvNode.key);

                    Node<K, V> newNode = new Node<>(key, val);
                    this.nodeDoubleLinkedQueue.addNode(newNode);
                    nodesMap.put(key, newNode);
                }
            }
        }

        public Node<K,V> update(K key, V val) {
            if (nodesMap.containsKey(key)) {
                Node<K, V> kvNode = nodesMap.get(key);
                kvNode.value = val;
                this.nodeDoubleLinkedQueue.moveToTail(kvNode);
                return kvNode;
            } else {
                return null;
            }
        }

        public Node<K,V> get(K key) {
            if (nodesMap.containsKey(key)) {
                Node<K, V> kvNode = nodesMap.get(key);
                this.nodeDoubleLinkedQueue.moveToTail(kvNode);
                return kvNode;
            } else {
                return null;
            }
        }
    }

}

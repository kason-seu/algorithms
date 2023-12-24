package leetcode.editor.cn;

import java.util.HashMap;
import java.util.Map;

/** * @author  kason * @date    2023-12-24 12:49:13 */public class Q0146LruCache{    //
// 请你设计并实现一个满足 
// LRU (最近最少使用) 缓存 约束的数据结构。
// 
//
// 
// 实现 
// LRUCache 类：
// 
//
// 
// 
// 
// LRUCache(int capacity) 以 正整数 作为容量 capacity 初始化 LRU 缓存 
// int get(int key) 如果关键字 key 存在于缓存中，则返回关键字的值，否则返回 -1 。 
// void put(int key, int value) 如果关键字 key 已经存在，则变更其数据值 value ；如果不存在，则向缓存中插入该组 
//key-value 。如果插入操作导致关键字数量超过 capacity ，则应该 逐出 最久未使用的关键字。 
// 
// 
// 
//
// 函数 get 和 put 必须以 O(1) 的平均时间复杂度运行。 
//
// 
//
// 示例： 
//
// 
//输入
//["LRUCache", "put", "put", "get", "put", "get", "put", "get", "get", "get"]
//[[2], [1, 1], [2, 2], [1], [3, 3], [2], [4, 4], [1], [3], [4]]
//输出
//[null, null, null, 1, null, -1, null, -1, 3, 4]
//
//解释
//LRUCache lRUCache = new LRUCache(2);
//lRUCache.put(1, 1); // 缓存是 {1=1}
//lRUCache.put(2, 2); // 缓存是 {1=1, 2=2}
//lRUCache.get(1);    // 返回 1
//lRUCache.put(3, 3); // 该操作会使得关键字 2 作废，缓存是 {1=1, 3=3}
//lRUCache.get(2);    // 返回 -1 (未找到)
//lRUCache.put(4, 4); // 该操作会使得关键字 1 作废，缓存是 {4=4, 3=3}
//lRUCache.get(1);    // 返回 -1 (未找到)
//lRUCache.get(3);    // 返回 3
//lRUCache.get(4);    // 返回 4
// 
//
// 
//
// 提示： 
//
// 
// 1 <= capacity <= 3000 
// 0 <= key <= 10000 
// 0 <= value <= 10⁵ 
// 最多调用 2 * 10⁵ 次 get 和 put 
// 
//
// Related Topics 设计 哈希表 链表 双向链表 👍 3041 👎 0
    public static void main(String[] args) {
        LRUCache solution = new Q0146LruCache().new LRUCache(2);

        solution.put(1,1);
        solution.put(2,2);
        solution.get(1);
        solution.put(3,3);
        System.out.println(solution);
    }    //leetcode submit region begin(Prohibit modification and deletion)
    class LRUCache {

        private int size = 0;
        private int capacity;
        private Map<Integer, Node> items;
        private Node head;
        private Node tail;
        class Node {
            public Integer Value;

            public Node left;
            public Node right;

        }
    public LRUCache(int capacity) {

            this.head = new Node();
            this.tail = new Node();
            head.right = tail;
            tail.left = head;
            this.capacity = capacity;
            this.items = new HashMap<>();

    }
    
    public int get(int key) {
        Node posNode = items.get(key);
        if (posNode == null) {
            return -1;
        } else {
            // update
            updatePos(posNode);
            return posNode.Value;

        }
    }
    
    public void put(int key, int value) {
        if (items.containsKey(key)) {
            Node node = items.get(key);
            node.Value = value;
            // 放到尾部

            updatePos(node);
        } else {
            Node tailPre = this.tail.left;
            Node newNode = new Node();
            newNode.Value = value;

            tailPre.right = newNode;
            newNode.left = tailPre;
            newNode.right = tail;
            tail.left = newNode;
            items.put(key, newNode);

            if (items.size() > capacity) {
                head = head.right;
                Integer removeKey = head.Value;
                head.left = null;
                items.remove(removeKey);
            }
        }
    }

        private void updatePos(Node node) {
            Node nodePre= node.left;
            Node nodeAfter = node.right;

            Node tailPre = this.tail.left;

            nodePre.right = nodeAfter;
            nodeAfter.left = nodePre;

            tailPre.right = node;
            node.left = tailPre;
            node.right = tail;
            tail.left = node;
        }
    }

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
//leetcode submit region end(Prohibit modification and deletion)
}
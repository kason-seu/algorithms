package leetcode.editor.cn;

public class POffer36 {


    class Node {
        public int val;
        public Node left;
        public Node right;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val,Node _left,Node _right) {
            val = _val;
            left = _left;
            right = _right;
        }
    };
    public Node treeToDoublyList(Node root) {

        if (root == null) {
            return null;
        }
        dfs(root);
        head.left = pre;
        pre.right = head;

        return head;
    }
    private Node head; // 记录头结点
    private Node pre; // 记录前置节点
    private Node dfs(Node cur) {
        if (cur == null) {
            return null;
        }

        Node left = dfs(cur.left);

        if (pre == null) {
            head = cur;
        } else {
            pre.right = cur;
        }
        cur.left = pre;
        pre = cur;

        Node right = dfs(cur.right);
        return cur;
    }
}

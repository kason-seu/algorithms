package leetcode.editor.cn;
/** * @author  kason * @date    2023-12-30 23:31:12 */public class Q0117PopulatingNextRightPointersInEachNodeIi{    //给定一个二叉树： 
//
// 
//struct Node {
//  int val;
//  Node *left;
//  Node *right;
//  Node *next;
//} 
//
// 填充它的每个 next 指针，让这个指针指向其下一个右侧节点。如果找不到下一个右侧节点，则将 next 指针设置为 NULL 。 
//
// 初始状态下，所有 next 指针都被设置为 NULL 。 
//
// 
//
// 示例 1： 
// 
// 
//输入：root = [1,2,3,4,5,null,7]
//输出：[1,#,2,3,#,4,5,7,#]
//解释：给定二叉树如图 A 所示，你的函数应该填充它的每个 next 指针，以指向其下一个右侧节点，如图 B 所示。序列化输出按层序遍历顺序（由 next 指
//针连接），'#' 表示每层的末尾。 
//
// 示例 2： 
//
// 
//输入：root = []
//输出：[]
// 
//
// 
//
// 提示： 
//
// 
// 树中的节点数在范围 [0, 6000] 内 
// -100 <= Node.val <= 100 
// 
//
// 进阶： 
//
// 
// 你只能使用常量级额外空间。 
// 使用递归解题也符合要求，本题中递归程序的隐式栈空间不计入额外空间复杂度。 
// 
//
// 
// 
//
// Related Topics 树 深度优先搜索 广度优先搜索 链表 二叉树 👍 822 👎 0
    public static void main(String[] args) {        Solution solution = new Q0117PopulatingNextRightPointersInEachNodeIi().new Solution();    }    //leetcode submit region begin(Prohibit modification and deletion)
/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/
static class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
}
class Solution {
    public Node connect(Node root) {
        return connect(root, null);
    }

    public Node connect(Node node, Node beConnected) {

        if (node == null) {
            return null;
        }

        node.next = beConnected;

        // 看子节点的连接情况
        if (beConnected != null) {

            if (node.right == null) {
                while (beConnected != null && beConnected.left == null && beConnected.right == null) {
                   beConnected = beConnected.next;
                }
                if (beConnected == null) {
                    connect(node.left, null);
                } else {
                    connect(node.left, beConnected.left != null ? beConnected.left : beConnected.right);
                }
            } else {
                connect(node.left, node.right);
                while (beConnected != null && beConnected.left == null && beConnected.right == null) {
                    beConnected = beConnected.next;
                }
                if (beConnected == null) {
                    connect(node.right, null);
                } else {
                    connect(node.right, beConnected.left != null ? beConnected.left : beConnected.right);
                }
            }

        } else {
            connect(node.left, node.right);
            connect(node.right, null);
        }

        return node;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
}
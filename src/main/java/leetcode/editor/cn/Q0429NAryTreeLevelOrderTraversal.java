package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/** * @author  kason * @date    2024-02-17 12:23:00 */public class Q0429NAryTreeLevelOrderTraversal{    //给定一个 N 叉树，返回其节点值的层序遍历。（即从左到右，逐层遍历）。
//
// 树的序列化输入是用层序遍历，每组子节点都由 null 值分隔（参见示例）。 
//
// 
//
// 示例 1： 
//
// 
//
// 
//输入：root = [1,null,3,2,4,null,5,6]
//输出：[[1],[3,2,4],[5,6]]
// 
//
// 示例 2： 
//
// 
//
// 
//输入：root = [1,null,2,3,4,5,null,null,6,7,null,8,null,9,10,null,null,11,null,12,
//null,13,null,null,14]
//输出：[[1],[2,3,4,5],[6,7,8,9,10],[11,12,13],[14]]
// 
//
// 
//
// 提示： 
//
// 
// 树的高度不会超过 1000 
// 树的节点总数在 [0, 10^4] 之间 
// 
//
// Related Topics 树 广度优先搜索 👍 440 👎 0
    public static void main(String[] args) {        Solution solution = new Q0429NAryTreeLevelOrderTraversal().new Solution();    }    //leetcode submit region begin(Prohibit modification and deletion)
/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

class Solution {
    class Node {
        public int val;
        public List<Node> children;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    };
    public List<List<Integer>> levelOrder(Node root) {

        if (root == null) {
            return new ArrayList<>();
        }

        List<List<Integer>> result = new ArrayList<>();
        LinkedList<Node> queue = new LinkedList<>();
        queue.addLast(root);

        while (!queue.isEmpty()) {

            int size = queue.size();
            List<Integer> levelValues = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                Node head = queue.pollFirst();
                levelValues.add(head.val);
                List<Node> children = head.children ;
                if (children != null) {
                    for (Node n : children) {
                        if (n != null) {
                            queue.addLast(n);
                        }
                    }
                }
            }
            result.add(levelValues);

        }
        return result;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
}
package leetcode.editor.cn;

import common.TreeNode;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;

/** * @author  kason * @date    2024-01-28 20:20:32 */public class Q0513FindBottomLeftTreeValue{    //给定一个二叉树的 根节点 root，请找出该二叉树的 最底层 最左边 节点的值。
//
// 假设二叉树中至少有一个节点。 
//
// 
//
// 示例 1: 
//
// 
//
// 
//输入: root = [2,1,3]
//输出: 1
// 
//
// 示例 2: 
//
// 
//
// 
//输入: [1,2,3,4,null,5,6,null,null,7]
//输出: 7
// 
//
// 
//
// 提示: 
//
// 
// 二叉树的节点个数的范围是 [1,10⁴] 
// 
// -2³¹ <= Node.val <= 2³¹ - 1 
// 
//
// Related Topics 树 深度优先搜索 广度优先搜索 二叉树 👍 560 👎 0
    public static void main(String[] args) {        Solution solution = new Q0513FindBottomLeftTreeValue().new Solution();

        TreeNode root = new TreeNode(2);
        TreeNode root2 = new TreeNode(1);
        TreeNode root3 = new TreeNode(3);
        root.left = root2;
        root.right = root3;
        System.out.println(solution.findBottomLeftValue(root));


    }    //leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public int findBottomLeftValue(TreeNode root) {

        LinkedList<TreeNode> queue = new LinkedList<>();

        queue.add(root);
        int level = 0;
        int left = -1;
        while (!queue.isEmpty()) {
            int queueSize = queue.size();
            for (int i = 0; i < queueSize; i++) {
                TreeNode poll = queue.pop();
                if (poll != null) {
                    left = poll.val;

                    queue.addLast(poll.left);
                    queue.addLast(poll.right);
                }
            }
            level++;
        }
        return left;

    }
}
//leetcode submit region end(Prohibit modification and deletion)
}
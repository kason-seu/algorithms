package leetcode.editor.cn;

import common.TreeNode;

/** * @author  kason * @date    2024-01-20 19:06:27 */public class Q0124BinaryTreeMaximumPathSum{    //二叉树中的 路径 被定义为一条节点序列，序列中每对相邻节点之间都存在一条边。同一个节点在一条路径序列中 至多出现一次 。该路径 至少包含一个 节点，且不一定
//经过根节点。 
//
// 路径和 是路径中各节点值的总和。 
//
// 给你一个二叉树的根节点 root ，返回其 最大路径和 。 
//
// 
//
// 示例 1： 
// 
// 
//输入：root = [1,2,3]
//输出：6
//解释：最优路径是 2 -> 1 -> 3 ，路径和为 2 + 1 + 3 = 6 
//
// 示例 2： 
// 
// 
//输入：root = [-10,9,20,null,null,15,7]
//输出：42
//解释：最优路径是 15 -> 20 -> 7 ，路径和为 15 + 20 + 7 = 42
// 
//
// 
//
// 提示： 
//
// 
// 树中节点数目范围是 [1, 3 * 10⁴] 
// -1000 <= Node.val <= 1000 
// 
//
// Related Topics 树 深度优先搜索 动态规划 二叉树 👍 2148 👎 0
    public static void main(String[] args) {        Solution solution = new Q0124BinaryTreeMaximumPathSum().new Solution();    }    //leetcode submit region begin(Prohibit modification and deletion)
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
    int res = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        oneSizeMax(root);
        return res;
    }

    public int oneSizeMax2(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = Math.max(0, oneSizeMax(root.left));
        int right = Math.max(0, oneSizeMax(root.right));
        res = Math.max(res, left + right + root.val);
        return Math.max(left + root.val, right + root.val);
    }

    public int oneSizeMax(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = oneSizeMax(root.left);
        int right = oneSizeMax(root.right);
        int sum1 = left > 0 ? left + root.val : root.val;
        int sum2 = right > 0 ? right + root.val : root.val;
        int sum3 = left + right + root.val;
        res = Math.max(res, Math.max(Math.max(sum1, sum2), sum3));
        return Math.max(left + root.val, right + root.val);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
}
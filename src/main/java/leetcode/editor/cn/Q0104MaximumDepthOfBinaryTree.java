package leetcode.editor.cn;

import common.TreeNode;

/** * @author  kason * @date    2024-01-21 22:43:46 */public class Q0104MaximumDepthOfBinaryTree{    //给定一个二叉树 root ，返回其最大深度。
//
// 二叉树的 最大深度 是指从根节点到最远叶子节点的最长路径上的节点数。 
//
// 
//
// 示例 1： 
//
// 
//
// 
//
// 
//输入：root = [3,9,20,null,null,15,7]
//输出：3
// 
//
// 示例 2： 
//
// 
//输入：root = [1,null,2]
//输出：2
// 
//
// 
//
// 提示： 
//
// 
// 树中节点的数量在 [0, 10⁴] 区间内。 
// -100 <= Node.val <= 100 
// 
//
// Related Topics 树 深度优先搜索 广度优先搜索 二叉树 👍 1769 👎 0
    public static void main(String[] args) {        Solution solution = new Q0104MaximumDepthOfBinaryTree().new Solution();    }    //leetcode submit region begin(Prohibit modification and deletion)
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

    int depth = 0;
    int res = 0;

    // 分解法
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        return 1 + Math.max(maxDepth(root.right), maxDepth(root.left));
    }

    public int maxDepth2(TreeNode root) {
        traversal(root);
        return depth;
    }

    public void traversal(TreeNode root) {
        if (root == null) {
            res = Math.max(res, depth);
            return;
        }
        // 先序遍历位置
        depth++;
        traversal(root.left);
        traversal(root.right);
        // 后续遍历位置
        depth--;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
}
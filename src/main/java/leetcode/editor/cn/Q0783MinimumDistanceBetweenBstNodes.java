package leetcode.editor.cn;

import common.TreeNode;

/** * @author  kason * @date    2024-02-02 23:30:01 */public class Q0783MinimumDistanceBetweenBstNodes{    //给你一个二叉搜索树的根节点 root ，返回 树中任意两不同节点值之间的最小差值 。
//
// 差值是一个正数，其数值等于两值之差的绝对值。 
//
// 
//
// 
// 
// 示例 1： 
// 
// 
//输入：root = [4,2,6,1,3]
//输出：1
// 
// 
// 
//
// 示例 2： 
// 
// 
//输入：root = [1,0,48,null,null,12,49]
//输出：1
// 
//
// 
//
// 提示： 
//
// 
// 树中节点的数目范围是 [2, 100] 
// 0 <= Node.val <= 10⁵ 
// 
//
// 
//
// 注意：本题与 530：https://leetcode-cn.com/problems/minimum-absolute-difference-in-
//bst/ 相同 
//
// Related Topics 树 深度优先搜索 广度优先搜索 二叉搜索树 二叉树 👍 279 👎 0
    public static void main(String[] args) {        Solution solution = new Q0783MinimumDistanceBetweenBstNodes().new Solution();    }    //leetcode submit region begin(Prohibit modification and deletion)
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
    TreeNode pre = null;
    public int minDiffInBST(TreeNode root) {


        min(root);
        return min;

    }
    int min = Integer.MAX_VALUE;
    private TreeNode min(TreeNode root) {
        if (root == null) {
            return null;
        }
        min(root.left);
        if (pre == null) {
            pre = root;
        } else {
            min = Math.min(min, root.val - pre.val);
            pre = root;
        }
        min(root.right);
        return root;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
}
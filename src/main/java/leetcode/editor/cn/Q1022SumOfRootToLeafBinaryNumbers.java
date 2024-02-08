package leetcode.editor.cn;

import common.TreeNode;

/** * @author  kason * @date    2024-02-07 22:32:52 */public class Q1022SumOfRootToLeafBinaryNumbers{    //给出一棵二叉树，其上每个结点的值都是 0 或 1 。每一条从根到叶的路径都代表一个从最高有效位开始的二进制数。
//
// 
// 例如，如果路径为 0 -> 1 -> 1 -> 0 -> 1，那么它表示二进制数 01101，也就是 13 。 
// 
//
// 对树上的每一片叶子，我们都要找出从根到该叶子的路径所表示的数字。 
//
// 返回这些数字之和。题目数据保证答案是一个 32 位 整数。 
//
// 
//
// 示例 1： 
// 
// 
//输入：root = [1,0,1,0,1,0,1]
//输出：22
//解释：(100) + (101) + (110) + (111) = 4 + 5 + 6 + 7 = 22
// 
//
// 示例 2： 
//
// 
//输入：root = [0]
//输出：0
// 
//
// 
//
// 提示： 
//
// 
// 树中的节点数在 [1, 1000] 范围内 
// Node.val 仅为 0 或 1 
// 
//
// Related Topics 树 深度优先搜索 二叉树 👍 244 👎 0
    public static void main(String[] args) {        Solution solution = new Q1022SumOfRootToLeafBinaryNumbers().new Solution();    }    //leetcode submit region begin(Prohibit modification and deletion)
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
    public int sumRootToLeaf(TreeNode root) {

        preDfs(root, 0);
        return totalSum;

    }
    int totalSum = 0;
    public void preDfs(TreeNode root, int sum) {
        if (root == null) {
            return;
        }

        int localsum = sum * 2 + root.val;
        if (root.left == null && root.right == null) {
            totalSum += localsum;
        }
        preDfs(root.left, localsum);
        preDfs(root.right, localsum);

    }
}
//leetcode submit region end(Prohibit modification and deletion)
}
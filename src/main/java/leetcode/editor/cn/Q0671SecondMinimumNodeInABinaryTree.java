package leetcode.editor.cn;

import common.TreeNode;

/** * @author  kason * @date    2024-02-02 21:53:15 */public class Q0671SecondMinimumNodeInABinaryTree{    //给定一个非空特殊的二叉树，每个节点都是正数，并且每个节点的子节点数量只能为 2 或 0。如果一个节点有两个子节点的话，那么该节点的值等于两个子节点中较小的一
//个。 
//
// 更正式地说，即 root.val = min(root.left.val, root.right.val) 总成立。 
//
// 给出这样的一个二叉树，你需要输出所有节点中的 第二小的值 。 
//
// 如果第二小的值不存在的话，输出 -1 。 
//
// 
//
// 示例 1： 
// 
// 
//输入：root = [2,2,5,null,null,5,7]
//输出：5
//解释：最小的值是 2 ，第二小的值是 5 。
// 
//
// 示例 2： 
// 
// 
//输入：root = [2,2,2]
//输出：-1
//解释：最小的值是 2, 但是不存在第二小的值。
// 
//
// 
//
// 提示： 
//
// 
// 树中节点数目在范围 [1, 25] 内 
// 1 <= Node.val <= 2³¹ - 1 
// 对于树中每个节点 root.val == min(root.left.val, root.right.val) 
// 
//
// Related Topics 树 深度优先搜索 二叉树 👍 307 👎 0
    public static void main(String[] args) {        Solution solution = new Q0671SecondMinimumNodeInABinaryTree().new Solution();    }    //leetcode submit region begin(Prohibit modification and deletion)
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
    int min = Integer.MAX_VALUE;
    int minSecond = -1;
    public int findSecondMinimumValue(TreeNode root) {


        preDfs(root);
        return minSecond;

    }

    private void preDfs(TreeNode root) {
        if (root == null) {
            return;
        }

        if (min == Integer.MAX_VALUE) {
            min = root.val;
        } else {
            if (root.val > min) {
                if (minSecond == -1) {
                    minSecond = root.val;
                } else {
                    minSecond = Math.min(minSecond, root.val);
                }
            } else if (root.val < min){
                minSecond = min;
                min = root.val;
            }
        }

        preDfs(root.left);
        preDfs(root.right);

    }
}
//leetcode submit region end(Prohibit modification and deletion)
}
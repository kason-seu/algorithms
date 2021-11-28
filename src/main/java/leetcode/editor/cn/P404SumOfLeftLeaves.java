/**
  * 题目Id：404
  * 题目：左叶子之和
  * 内容: //计算给定二叉树的所有左叶子之和。 
//
// 示例： 
//
// 
//    3
//   / \
//  9  20
//    /  \
//   15   7
//
//在这个二叉树中，有两个左叶子，分别是 9 和 15，所以返回 24 
//
// 
// Related Topics 树 深度优先搜索 广度优先搜索 二叉树 👍 366 👎 0
	
  * 日期：2021-11-28 22:41:21
*/
//计算给定二叉树的所有左叶子之和。 
//
// 示例： 
//
// 
//    3
//   / \
//  9  20
//    /  \
//   15   7
//
//在这个二叉树中，有两个左叶子，分别是 9 和 15，所以返回 24 
//
// 
// Related Topics 树 深度优先搜索 广度优先搜索 二叉树 👍 366 👎 0

package leetcode.editor.cn;

import common.TreeNode;

public class P404SumOfLeftLeaves {
    public static void main(String[] args) {
        Solution solution = new P404SumOfLeftLeaves().new Solution();
        System.out.println("Hello world");
    }
    //leetcode submit region begin(Prohibit modification and deletion)
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
    public int sumOfLeftLeaves(TreeNode root) {

        return sumOfLeftLeavesDg(root, -1);

    }

    private int sumOfLeftLeavesDg(TreeNode cur, int direction) {

        if (cur == null) {
            return 0;
        }
        if (direction == 0 && cur.left == null && cur.right == null) {
            return cur.val;
        }
        return sumOfLeftLeavesDg(cur.left, 0) + sumOfLeftLeavesDg(cur.right, 1);
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
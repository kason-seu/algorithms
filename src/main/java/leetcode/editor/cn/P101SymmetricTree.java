/**
 * 题目Id：101
 * 题目：对称二叉树
 * 内容: //给定一个二叉树，检查它是否是镜像对称的。
 * //
 * //
 * //
 * // 例如，二叉树 [1,2,2,3,4,4,3] 是对称的。
 * //
 * //     1
 * //   / \
 * //  2   2
 * // / \ / \
 * //3  4 4  3
 * //
 * //
 * //
 * //
 * // 但是下面这个 [1,2,2,null,3,null,3] 则不是镜像对称的:
 * //
 * //     1
 * //   / \
 * //  2   2
 * //   \   \
 * //   3    3
 * //
 * //
 * //
 * //
 * // 进阶：
 * //
 * // 你可以运用递归和迭代两种方法解决这个问题吗？
 * // Related Topics 树 深度优先搜索 广度优先搜索 二叉树 👍 1624 👎 0
 * <p>
 * 日期：2021-11-28 21:17:26
 */
//给定一个二叉树，检查它是否是镜像对称的。 
//
// 
//
// 例如，二叉树 [1,2,2,3,4,4,3] 是对称的。 
//
//     1
//   / \
//  2   2
// / \ / \
//3  4 4  3
// 
//
// 
//
// 但是下面这个 [1,2,2,null,3,null,3] 则不是镜像对称的: 
//
//     1
//   / \
//  2   2
//   \   \
//   3    3
// 
//
// 
//
// 进阶： 
//
// 你可以运用递归和迭代两种方法解决这个问题吗？ 
// Related Topics 树 深度优先搜索 广度优先搜索 二叉树 👍 1624 👎 0

package leetcode.editor.cn;

import common.TreeNode;

public class P101SymmetricTree {
    public static void main(String[] args) {
        Solution solution = new P101SymmetricTree().new Solution();
        System.out.println("Hello world");
    }
    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     * int val;
     * TreeNode left;
     * TreeNode right;
     * TreeNode() {}
     * TreeNode(int val) { this.val = val; }
     * TreeNode(int val, TreeNode left, TreeNode right) {
     * this.val = val;
     * this.left = left;
     * this.right = right;
     * }
     * }
     */
    class Solution {
        public boolean isSymmetric(TreeNode root) {


            return isSymmetricDg(root, root);

        }

        private boolean isSymmetricDg(TreeNode cur1, TreeNode cur2) {

            if (cur1 == null && cur2 == null) {
                return true;
            } else if (cur1 == null) {
                return false;
            } else if (cur2 == null) {
                return false;
            }
            if (cur1 == cur2) {
                return isSymmetricDg(cur1.left, cur2.right);
            } else if (cur1.val == cur2.val) {
                return isSymmetricDg(cur1.left, cur2.right) && isSymmetricDg(cur1.right, cur2.left);
            } else {
                return false;
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
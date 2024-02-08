package leetcode.editor.cn;

import common.TreeNode;

/** * @author  kason * @date    2024-02-02 23:16:29 */public class Q0700SearchInABinarySearchTree{    //给定二叉搜索树（BST）的根节点
// root 和一个整数值
// val。 
//
// 你需要在 BST 中找到节点值等于 val 的节点。 返回以该节点为根的子树。 如果节点不存在，则返回
// null 。 
//
// 
//
// 示例 1: 
//
// 
// 
//
// 
//输入：root = [4,2,7,1,3], val = 2
//输出：[2,1,3]
// 
//
// 示例 2: 
// 
// 
//输入：root = [4,2,7,1,3], val = 5
//输出：[]
// 
//
// 
//
// 提示： 
//
// 
// 树中节点数在 [1, 5000] 范围内 
// 1 <= Node.val <= 10⁷ 
// root 是二叉搜索树 
// 1 <= val <= 10⁷ 
// 
//
// Related Topics 树 二叉搜索树 二叉树 👍 460 👎 0
    public static void main(String[] args) {        Solution solution = new Q0700SearchInABinarySearchTree().new Solution();    }    //leetcode submit region begin(Prohibit modification and deletion)
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
    TreeNode node = null;
    boolean find = false;
    public TreeNode searchBST(TreeNode root, int val) {

        dfs(root, val);
        return node;

    }

    public boolean dfs(TreeNode root, int val) {


        if (root == null) {
            return false;
        }

        if (find) {
            return true;
        }
        dfs(root.left, val);

        if (root.val == val) {
            node = root;
            return true;
        }
        dfs(root.right, val);
        return false;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
}
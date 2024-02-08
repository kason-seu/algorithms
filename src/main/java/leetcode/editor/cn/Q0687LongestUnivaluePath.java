package leetcode.editor.cn;

import com.sun.jmx.snmp.SnmpNull;
import common.TreeNode;

/** * @author  kason * @date    2024-02-02 22:08:16 */public class Q0687LongestUnivaluePath{    //给定一个二叉树的
// root ，返回 最长的路径的长度 ，这个路径中的 每个节点具有相同值 。 这条路径可以经过也可以不经过根节点。 
//
// 两个节点之间的路径长度 由它们之间的边数表示。 
//
// 
//
// 示例 1: 
//
// 
//
// 
//输入：root = [5,4,5,1,1,5]
//输出：2
// 
//
// 示例 2: 
//
// 
//
// 
//输入：root = [1,4,5,4,4,5]
//输出：2
// 
//
// 
//
// 提示: 
//
// 
// 树的节点数的范围是
// [0, 10⁴] 
// -1000 <= Node.val <= 1000 
// 树的深度将不超过 1000 
// 
//
// Related Topics 树 深度优先搜索 二叉树 👍 789 👎 0
    public static void main(String[] args) {        Solution solution = new Q0687LongestUnivaluePath().new Solution();    }    //leetcode submit region begin(Prohibit modification and deletion)
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
    int max = 0;
    public int longestUnivaluePath(TreeNode root) {

        dfs(root);
        return max;

    }

    public int dfs(TreeNode root) {


        if (root == null) {
            return 0;
        }


        int left = 0;
        int right = 0;
        int leftNew = dfs(root.left);
        int rightNew = dfs(root.right);
        if (root.left != null && root.val == root.left.val) {

            left = leftNew + 1 + dfs(root.left);
        }
        if (root.right != null && root.val == root.right.val) {

            right = rightNew + 1 + dfs(root.right);
        }
        max = Math.max(max, left + right);
        return Math.max(left,  right);

    }
}
//leetcode submit region end(Prohibit modification and deletion)
}
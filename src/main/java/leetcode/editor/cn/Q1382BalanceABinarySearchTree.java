package leetcode.editor.cn;

import common.TreeNode;

import java.util.ArrayList;
import java.util.List;

/** * @author  kason * @date    2024-02-09 01:26:59 */public class Q1382BalanceABinarySearchTree{    //给你一棵二叉搜索树，请你返回一棵 平衡后 的二叉搜索树，新生成的树应该与原来的树有着相同的节点值。如果有多种构造方法，请你返回任意一种。
//
// 如果一棵二叉搜索树中，每个节点的两棵子树高度差不超过 1 ，我们就称这棵二叉搜索树是 平衡的 。 
//
// 
//
// 示例 1： 
//
// 
//
// 
//输入：root = [1,null,2,null,3,null,4,null,null]
//输出：[2,1,3,null,null,null,4]
//解释：这不是唯一的正确答案，[3,1,4,null,2,null,null] 也是一个可行的构造方案。
// 
//
// 示例 2： 
//
// 
//
// 
//输入: root = [2,1,3]
//输出: [2,1,3]
// 
//
// 
//
// 提示： 
//
// 
// 树节点的数目在 [1, 10⁴] 范围内。 
// 1 <= Node.val <= 10⁵ 
// 
//
// Related Topics 贪心 树 深度优先搜索 二叉搜索树 分治 二叉树 👍 198 👎 0
    public static void main(String[] args) {        Solution solution = new Q1382BalanceABinarySearchTree().new Solution();    }    //leetcode submit region begin(Prohibit modification and deletion)
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
    public TreeNode balanceBST(TreeNode root) {

        List<Integer> values = new ArrayList<>();

        dfs(root, values);

       return buildRoot(values, 0, values.size() - 1);

    }

    private void dfs(TreeNode root, List<Integer> values) {

        if (root == null) {
            return;
        }
        dfs(root.left, values);
        values.add(root.val);
        dfs(root.right, values);
    }

    private TreeNode buildRoot(List<Integer> values, int i, int j) {
        if (i < 0 || j > values.size() - 1) {
            return null;
        }
        int mid = (i + j) / 2;

        TreeNode mindRoot = new TreeNode(values.get(mid));
        mindRoot.left = buildRoot(values, i, mid - 1);
        mindRoot.right = buildRoot(values, mid + 1, j);
        return mindRoot;
    }
}


//leetcode submit region end(Prohibit modification and deletion)
}
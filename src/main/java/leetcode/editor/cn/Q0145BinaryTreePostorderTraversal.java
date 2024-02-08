package leetcode.editor.cn;

import common.TreeNode;

import java.util.ArrayList;
import java.util.List;

/** * @author  kason * @date    2024-01-26 22:06:06 */public class Q0145BinaryTreePostorderTraversal{    //给你一棵二叉树的根节点 root ，返回其节点值的 后序遍历 。
//
// 
//
// 示例 1： 
// 
// 
//输入：root = [1,null,2,3]
//输出：[3,2,1]
// 
//
// 示例 2： 
//
// 
//输入：root = []
//输出：[]
// 
//
// 示例 3： 
//
// 
//输入：root = [1]
//输出：[1]
// 
//
// 
//
// 提示： 
//
// 
// 树中节点的数目在范围 [0, 100] 内 
// -100 <= Node.val <= 100 
// 
//
// 
//
// 进阶：递归算法很简单，你可以通过迭代算法完成吗？ 
//
// Related Topics 栈 树 深度优先搜索 二叉树 👍 1140 👎 0
    public static void main(String[] args) {        Solution solution = new Q0145BinaryTreePostorderTraversal().new Solution();    }    //leetcode submit region begin(Prohibit modification and deletion)
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
    List<Integer> ans = new ArrayList<>();
    public List<Integer> postorderTraversal(TreeNode root) {

        postDfs(root);

        return ans;

    }

    private void postDfs(TreeNode root) {
        if (root == null) {
            return;
        }
        postDfs(root.left);
        postDfs(root.right);
        ans.add(root.val);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
}
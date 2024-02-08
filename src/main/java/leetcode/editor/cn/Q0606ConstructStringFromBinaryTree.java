package leetcode.editor.cn;

import common.TreeNode;

/** * @author  kason * @date    2024-02-02 13:22:13 */public class Q0606ConstructStringFromBinaryTree{    //给你二叉树的根节点 root ，请你采用前序遍历的方式，将二叉树转化为一个由括号和整数组成的字符串，返回构造出的字符串。
//
// 空节点使用一对空括号对 "()" 表示，转化后需要省略所有不影响字符串与原始二叉树之间的一对一映射关系的空括号对。 
//
// 
// 
// 
// 
// 
//
// 示例 1： 
// 
// 
//输入：root = [1,2,3,4]
//输出："1(2(4))(3)"
//解释：初步转化后得到 "1(2(4)())(3()())" ，但省略所有不必要的空括号对后，字符串应该是"1(2(4))(3)" 。
// 
//
// 示例 2： 
// 
// 
//输入：root = [1,2,3,null,4]
//输出："1(2()(4))(3)"
//解释：和第一个示例类似，但是无法省略第一个空括号对，否则会破坏输入与输出一一映射的关系。 
//
// 
//
// 提示： 
//
// 
// 树中节点的数目范围是 [1, 10⁴] 
// -1000 <= Node.val <= 1000 
// 
//
// Related Topics 树 深度优先搜索 字符串 二叉树 👍 393 👎 0
    public static void main(String[] args) {        Solution solution = new Q0606ConstructStringFromBinaryTree().new Solution();    }    //leetcode submit region begin(Prohibit modification and deletion)
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
    public String tree2str(TreeNode root) {

        return preOrderDfs(root);



    }

    private String preOrderDfs(TreeNode root) {

        if (root == null) {
            return "";
        }

        String currentS = "" + root.val;

        if (root.left != null && root.right != null) {
            currentS += "(";
            currentS += preOrderDfs(root.left);
            currentS += ")";
            currentS += "(";
            currentS += preOrderDfs(root.right);
            currentS += ")";
        }
        if (root.left != null && root.right == null) {
            currentS += "(";
            currentS += preOrderDfs(root.left);
            currentS += ")";
        }
        if (root.left == null && root.right != null) {
            currentS += "(";
            currentS += ")";
            currentS += "(";
            currentS += preOrderDfs(root.right);
            currentS += ")";
        }
        if (root.left == null && root.right == null) {

        }
        return currentS;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
}
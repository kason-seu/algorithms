/**
  * 题目Id：257
  * 题目：二叉树的所有路径
  * 内容: //给你一个二叉树的根节点 root ，按 任意顺序 ，返回所有从根节点到叶子节点的路径。 
//
// 叶子节点 是指没有子节点的节点。 
// 
//
// 示例 1： 
//
// 
//输入：root = [1,2,3,null,5]
//输出：["1->2->5","1->3"]
// 
//
// 示例 2： 
//
// 
//输入：root = [1]
//输出：["1"]
// 
//
// 
//
// 提示： 
//
// 
// 树中节点的数目在范围 [1, 100] 内 
// -100 <= Node.val <= 100 
// 
// Related Topics 树 深度优先搜索 字符串 二叉树 👍 612 👎 0
	
  * 日期：2021-12-01 23:57:20
*/
//给你一个二叉树的根节点 root ，按 任意顺序 ，返回所有从根节点到叶子节点的路径。 
//
// 叶子节点 是指没有子节点的节点。 
// 
//
// 示例 1： 
//
// 
//输入：root = [1,2,3,null,5]
//输出：["1->2->5","1->3"]
// 
//
// 示例 2： 
//
// 
//输入：root = [1]
//输出：["1"]
// 
//
// 
//
// 提示： 
//
// 
// 树中节点的数目在范围 [1, 100] 内 
// -100 <= Node.val <= 100 
// 
// Related Topics 树 深度优先搜索 字符串 二叉树 👍 612 👎 0

package leetcode.editor.cn;

import common.TreeNode;
import org.checkerframework.checker.units.qual.A;

import java.util.ArrayList;
import java.util.List;

public class P257BinaryTreePaths {
    public static void main(String[] args) {
        Solution solution = new P257BinaryTreePaths().new Solution();
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
    public List<String> binaryTreePaths(TreeNode root) {

        return binaryTreePathsDg(root);
    }

    private List<String> binaryTreePathsDg(TreeNode root) {

        List<String> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        if (root.left == null && root.right == null) {
            res.add(root.val + "");
        }

        List<String> leftLists = binaryTreePathsDg(root.left);
        for (String s : leftLists) {
            res.add(root.val + "->" + s);
        }
        List<String> rightLists = binaryTreePathsDg(root.right);

        for (String s : rightLists) {
            res.add(root.val + "->" + s);
        }

        return res;


    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
/**
  * 题目Id：1008
  * 题目：前序遍历构造二叉搜索树
  * 内容: //给定一个整数数组，它表示BST(即 二叉搜索树 )的 先序遍历 ，构造树并返回其根。 
//
// 保证 对于给定的测试用例，总是有可能找到具有给定需求的二叉搜索树。 
//
// 二叉搜索树 是一棵二叉树，其中每个节点， Node.left 的任何后代的值 严格小于 Node.val , Node.right 的任何后代的值 严格大
//于 Node.val。 
//
// 二叉树的 前序遍历 首先显示节点的值，然后遍历Node.left，最后遍历Node.right。 
//
// 
//
// 示例 1： 
//
// 
//
// 
//输入：preorder = [8,5,1,7,10,12]
//输出：[8,5,10,1,7,null,12]
// 
//
// 示例 2: 
//
// 
//输入: preorder = [1,3]
//输出: [1,null,3]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= preorder.length <= 100 
// 1 <= preorder[i] <= 10^8 
// preorder 中的值 互不相同 
// 
//
// 
// Related Topics 栈 树 二叉搜索树 数组 二叉树 单调栈 👍 206 👎 0
	
  * 日期：2022-04-03 19:46:37
*/
//给定一个整数数组，它表示BST(即 二叉搜索树 )的 先序遍历 ，构造树并返回其根。 
//
// 保证 对于给定的测试用例，总是有可能找到具有给定需求的二叉搜索树。 
//
// 二叉搜索树 是一棵二叉树，其中每个节点， Node.left 的任何后代的值 严格小于 Node.val , Node.right 的任何后代的值 严格大
//于 Node.val。 
//
// 二叉树的 前序遍历 首先显示节点的值，然后遍历Node.left，最后遍历Node.right。 
//
// 
//
// 示例 1： 
//
// 
//
// 
//输入：preorder = [8,5,1,7,10,12]
//输出：[8,5,10,1,7,null,12]
// 
//
// 示例 2: 
//
// 
//输入: preorder = [1,3]
//输出: [1,null,3]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= preorder.length <= 100 
// 1 <= preorder[i] <= 10^8 
// preorder 中的值 互不相同 
// 
//
// 
// Related Topics 栈 树 二叉搜索树 数组 二叉树 单调栈 👍 206 👎 0

package leetcode.editor.cn;

import common.TreeNode;

public class P1008ConstructBinarySearchTreeFromPreorderTraversal {
    public static void main(String[] args) {
        Solution solution = new P1008ConstructBinarySearchTreeFromPreorderTraversal().new Solution();
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
    public TreeNode bstFromPreorder(int[] preorder) {

        if (preorder == null) {
            return null;
        }

        return dg(preorder, 0, 1, preorder.length);
    }

    public TreeNode dg(int[] preorder, int cur, int start, int end) {


        if (cur == end - 1) {
            return new TreeNode(preorder[cur]);
        }

        int leftEnd = -1;
        int rightStart = -1;

        for (int i = start; i < end; i++) {
            if (preorder[i] < preorder[cur]) {
                leftEnd = i;
            } else {
                rightStart = i;
                break;
            }
        }

        TreeNode node = new TreeNode(preorder[cur]);
        node.left = leftEnd == -1 ? null : dg(preorder, start, start + 1, leftEnd + 1);
        node.right =rightStart == -1 ? null : dg(preorder, rightStart, rightStart + 1, end);
        return node;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
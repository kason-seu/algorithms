package leetcode.editor.cn;

import common.TreeNode;

/** * @author  kason * @date    2024-02-17 12:50:19 */public class Q0106ConstructBinaryTreeFromInorderAndPostorderTraversal{    //给定两个整数数组 inorder 和 postorder ，其中 inorder 是二叉树的中序遍历， postorder 是同一棵树的后序遍历，请你构造并
//返回这颗 二叉树 。 
//
// 
//
// 示例 1: 
// 
// 
//输入：inorder = [9,3,15,20,7], postorder = [9,15,7,20,3]
//输出：[3,9,20,null,null,15,7]
// 
//
// 示例 2: 
//
// 
//输入：inorder = [-1], postorder = [-1]
//输出：[-1]
// 
//
// 
//
// 提示: 
//
// 
// 1 <= inorder.length <= 3000 
// postorder.length == inorder.length 
// -3000 <= inorder[i], postorder[i] <= 3000 
// inorder 和 postorder 都由 不同 的值组成 
// postorder 中每一个值都在 inorder 中 
// inorder 保证是树的中序遍历 
// postorder 保证是树的后序遍历 
// 
//
// Related Topics 树 数组 哈希表 分治 二叉树 👍 1172 👎 0
    public static void main(String[] args) {        Solution solution = new Q0106ConstructBinaryTreeFromInorderAndPostorderTraversal().new Solution();    }    //leetcode submit region begin(Prohibit modification and deletion)
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
    public TreeNode buildTree(int[] inorder, int[] postorder) {


        return build(inorder, postorder, 0, inorder.length - 1, 0, postorder.length - 1);

    }

    public TreeNode build(int[] inorder, int[] postorder, int leftPos, int leftEnd, int rightPos, int rightEnd) {


        if (leftEnd - leftPos == 0) {
            return new TreeNode(inorder[leftPos]);
        }

        if (leftPos > leftEnd) {
            return null;
        }
        int rootLeftPos = leftPos + 1;
        int root = inorder[rootLeftPos];

        // find 后续遍历的位置
        int rootInPostPos = -1;
        for (int i = rightPos; i <= rightEnd; i++) {
            if (postorder[i] == root) {
                // find 右边的位置
                rootInPostPos = i;
                break;
            }
        }


            if(postorder[rightPos] == inorder[leftPos] && postorder[rightPos + 1] == inorder[leftPos + 1]) {
                TreeNode rootNode = new TreeNode(root);
                rootNode.left = new TreeNode(inorder[leftPos]);
                return rootNode;
            } else if(postorder[rightPos] == inorder[leftPos + 1] && postorder[rightPos + 1] == inorder[leftPos]) {
                TreeNode rootNode = new TreeNode(root);
                rootNode.right = new TreeNode(inorder[leftPos]);
                return rootNode;
            } else {

                TreeNode rootNode = new TreeNode(root);
                rootNode.left = new TreeNode(inorder[leftPos]);
                rootNode.right = build(inorder, postorder, leftPos + 2, leftEnd, rightPos + 1, rootInPostPos - 1);
                return rootNode;
            }

        /*if (rootInPostPos < rootLeftPos) {
            TreeNode rootNode = new TreeNode(root);
            rootNode.right = new TreeNode(inorder[leftPos]);
            TreeNode nextNode = build(inorder, postorder, leftPos + 2, leftEnd, rightPos+ 2, rightEnd);
            if (nextNode != null) {
                nextNode.left = rootNode;
            }
            return nextNode != null ? nextNode : rootNode;
        } else if (rootInPostPos == rootLeftPos) {
            TreeNode rootNode = new TreeNode(root);
            rootNode.left = new TreeNode(inorder[leftPos]);
            TreeNode nextNode = build(inorder, postorder, leftPos + 2, leftEnd, rightPos+ 2, rightEnd);
            if (nextNode != null) {
                nextNode.left = rootNode;
            }
            return nextNode != null ? nextNode : rootNode;
        } else {
            TreeNode rootNode = new TreeNode(root);
            rootNode.left = new TreeNode(inorder[leftPos]);
            rootNode.right = build(inorder, postorder, leftPos + 2, leftEnd, rightPos + 1, rightEnd - 1);
            return rootNode;
        }*/

    }
}
//leetcode submit region end(Prohibit modification and deletion)
}
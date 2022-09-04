/**
 * 题目Id：99
 * 题目：恢复二叉搜索树
 * 内容: //给你二叉搜索树的根节点 root ，该树中的 恰好 两个节点的值被错误地交换。请在不改变其结构的情况下，恢复这棵树 。
 //
 //
 //
 // 示例 1：
 //
 //
 //输入：root = [1,3,null,null,2]
 //输出：[3,1,null,null,2]
 //解释：3 不能是 1 的左孩子，因为 3 > 1 。交换 1 和 3 使二叉搜索树有效。
 //
 //
 // 示例 2：
 //
 //
 //输入：root = [3,1,4,null,null,2]
 //输出：[2,1,4,null,null,3]
 //解释：2 不能在 3 的右子树中，因为 2 < 3 。交换 2 和 3 使二叉搜索树有效。
 //
 //
 //
 // 提示：
 //
 //
 // 树上节点的数目在范围 [2, 1000] 内
 // -2³¹ <= Node.val <= 2³¹ - 1
 //
 //
 //
 //
 // 进阶：使用 O(n) 空间复杂度的解法很容易实现。你能想出一个只使用 O(1) 空间的解决方案吗？
 // Related Topics 树 深度优先搜索 二叉搜索树 二叉树 👍 771 👎 0

 * 日期：2022-08-28 21:54:42
 */
//给你二叉搜索树的根节点 root ，该树中的 恰好 两个节点的值被错误地交换。请在不改变其结构的情况下，恢复这棵树 。
//
//
//
// 示例 1：
//
//
//输入：root = [1,3,null,null,2]
//输出：[3,1,null,null,2]
//解释：3 不能是 1 的左孩子，因为 3 > 1 。交换 1 和 3 使二叉搜索树有效。
//
//
// 示例 2：
//
//
//输入：root = [3,1,4,null,null,2]
//输出：[2,1,4,null,null,3]
//解释：2 不能在 3 的右子树中，因为 2 < 3 。交换 2 和 3 使二叉搜索树有效。
//
//
//
// 提示：
//
//
// 树上节点的数目在范围 [2, 1000] 内
// -2³¹ <= Node.val <= 2³¹ - 1
//
//
//
//
// 进阶：使用 O(n) 空间复杂度的解法很容易实现。你能想出一个只使用 O(1) 空间的解决方案吗？
// Related Topics 树 深度优先搜索 二叉搜索树 二叉树 👍 771 👎 0

package leetcode.editor.cn;

import common.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class P99RecoverBinarySearchTree {
    public static void main(String[] args) {
        Solution solution = new P99RecoverBinarySearchTree().new Solution();
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
        public void recoverTree(TreeNode root) {

            List<TreeNode> nodesList = new ArrayList<>();

            traversalNodeTree(root, nodesList);

            int rootIndex = -1;
            for (int i = 0; i < nodesList.size(); i++) {
                if (nodesList.get(i).val == root.val) {
                    rootIndex = i;
                    break;
                }
            }

            int leftNotValidIndex = -1;
            int rightNotValidIndex = -1;

            for (int i = 0; i <= rootIndex; i++) {
                if (nodesList.get(i).val > nodesList.get(rootIndex).val) {
                    leftNotValidIndex = i;
                    break;
                }
            }

            for (int j = rootIndex; j < nodesList.size(); j++) {
                if (nodesList.get(j).val < nodesList.get(rootIndex).val) {
                    rightNotValidIndex = j;
                    break;
                }
            }

            if (leftNotValidIndex != -1 && rightNotValidIndex != -1) {
                swap(leftNotValidIndex, rightNotValidIndex,nodesList);
            } else { // 在右边

                int swapLeft = rootIndex;
                int swapRight = -1;

                for (int i = rootIndex; i < nodesList.size() - 1; i++) {
                    if (nodesList.get(i).val > nodesList.get(i + 1).val) {
                        swapLeft = i;
                        break;
                    }
                }

                for (int j = nodesList.size() - 1; j >= rootIndex + 1; j--) {
                    if (nodesList.get(j).val < nodesList.get(j - 1).val) {
                        swapRight = j;
                        break;
                    }
                }

                if (swapRight > swapLeft) {
                    swap(swapLeft, swapRight, nodesList);
                    return;
                }
                swapLeft = -1;
                swapRight = rootIndex;
                for (int i = 0; i < rootIndex; i++) {
                    if (nodesList.get(i).val > nodesList.get(i + 1).val) {
                        swapLeft = i;
                        break;
                    }
                }
                for (int j = rootIndex; j >= 1; j--) {
                    if (nodesList.get(j).val < nodesList.get(j - 1).val) {
                        swapRight = j;
                        break;
                    }
                }
                swap(swapLeft, swapRight, nodesList);
            }


        }

        private void swap(int leftNotValidIndex, int rightNotValidIndex, List<TreeNode> nodesList) {
            int temp = nodesList.get(leftNotValidIndex).val;
            nodesList.get(leftNotValidIndex).val = nodesList.get(rightNotValidIndex).val;
            nodesList.get(rightNotValidIndex).val = temp;
        }


        private void traversalNodeTree(TreeNode root, List<TreeNode> nodesList) {
            if (root == null) {
                return;
            }
            if (root.left != null) {
                traversalNodeTree(root.left, nodesList);
            }
            nodesList.add(root);

            if (root.right != null) {
                traversalNodeTree(root.right, nodesList);
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
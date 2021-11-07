/**
 * 题目Id：95
 * 题目：不同的二叉搜索树 II
 * 内容: //给你一个整数 n ，请你生成并返回所有由 n 个节点组成且节点值从 1 到 n 互不相同的不同 二叉搜索树 。可以按 任意顺序 返回答案。
 * //
 * //
 * //
 * //
 * //
 * // 示例 1：
 * //
 * //
 * //输入：n = 3
 * //输出：[[1,null,2,null,3],[1,null,3,2],[2,1,3],[3,1,null,null,2],[3,2,null,1]]
 * //
 * //
 * // 示例 2：
 * //
 * //
 * //输入：n = 1
 * //输出：[[1]]
 * //
 * //
 * //
 * //
 * // 提示：
 * //
 * //
 * // 1 <= n <= 8
 * //
 * //
 * //
 * // Related Topics 树 二叉搜索树 动态规划 回溯 二叉树 👍 1029 👎 0
 * <p>
 * 日期：2021-11-06 19:14:33
 */
//给你一个整数 n ，请你生成并返回所有由 n 个节点组成且节点值从 1 到 n 互不相同的不同 二叉搜索树 。可以按 任意顺序 返回答案。 
//
// 
//
// 
// 
// 示例 1： 
//
// 
//输入：n = 3
//输出：[[1,null,2,null,3],[1,null,3,2],[2,1,3],[3,1,null,null,2],[3,2,null,1]]
// 
//
// 示例 2： 
//
// 
//输入：n = 1
//输出：[[1]]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 8 
// 
// 
// 
// Related Topics 树 二叉搜索树 动态规划 回溯 二叉树 👍 1029 👎 0

package leetcode.editor.cn;

import common.TreeNode;
import common.TreeNodeUtils;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static common.TreeNodeUtils.printPreNodeTree;

public class P95UniqueBinarySearchTreesIi {
    public static void main(String[] args) {
        Solution solution = new P95UniqueBinarySearchTreesIi().new Solution();
        List<TreeNode> treeNodes = solution.generateTrees(3);

        for (TreeNode t : treeNodes) {
            printPreNodeTree(t);
            System.out.println("=======");
        }

        //System.out.println("Hello world size " + treeNodes);
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
        public List<TreeNode> generateTrees(int n) {

            List<TreeNode> result = new ArrayList<>();

            dg(n, null, 0, new boolean[n], result, new HashSet<>());

            // 去重

            return result;
        }

        private TreeNode dg(int n, TreeNode node, int index, boolean[] arr, List<TreeNode> result, Set<String> keys) {

            if (index == n) {
                // copy the eitire tree
                TreeNode newHead = copyTree(node);
                String preNodeTreeStr = getPreNodeTree(newHead);
                if (!keys.contains(preNodeTreeStr)) {
                    result.add(newHead);
                    keys.add(preNodeTreeStr);
                }
                return node;
            }
            for (int i = 0; i < n; i++) {
                if (!arr[i]) {
                    arr[i] = true;
                    if (node == null) {
                        TreeNode nd = new TreeNode(i + 1);
                        dg(n, nd, 1, arr, result, keys);
                        nd = null;
                    } else {
                        // 插入节点
                        insert(node, i + 1);
                        dg(n, node, index + 1, arr, result, keys);
                        // 去除插入的节点
                        removeNode(node, i + 1);
                    }
                    arr[i] = false;
                }

            }

            return null;
        }
        public String getPreNodeTree(TreeNode node) {
            if (node == null) {
                return "";
            }
            String s= ""+node.val;
            s += getPreNodeTree(node.left);
            s += getPreNodeTree(node.right);
            return s;
        }
        private TreeNode copyTree(TreeNode node) {
            TreeNode newTreeHead = new TreeNode(node.val);
            copyTree(node, newTreeHead);
            return newTreeHead;
        }

        private void copyTree(TreeNode preNode, TreeNode newNode) {

            if (preNode == null) {
                return;
            }

            if (preNode.left != null) {
                newNode.left = new TreeNode(preNode.left.val);
            }
            if (preNode.right != null) {
                newNode.right = new TreeNode(preNode.right.val);
            }
            copyTree(preNode.left, newNode.left);
            copyTree(preNode.right, newNode.right);
        }

        private void removeNode(TreeNode node, int i) {

            if (node != null && node.left != null && node.left.val == i) {
                node.left = null;
                return;
            }
            if (node != null && node.right != null && node.right.val == i) {
                node.right = null;
                return;
            }

            if (node != null) {
                removeNode(node.left, i);
                removeNode(node.right, i);
            }

        }

        private TreeNode insert(TreeNode node, int val) {

            if (node == null) {
                return new TreeNode(val);
            }

            if (val < node.val) {
                node.left = insert(node.left, val);
            }
            if (val > node.val) {
                node.right = insert(node.right, val);
            }

            return node;
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)


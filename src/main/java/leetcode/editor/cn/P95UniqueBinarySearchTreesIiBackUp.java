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

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static common.TreeNodeUtils.printPreNodeTree;

public class P95UniqueBinarySearchTreesIiBackUp {
    public static void main(String[] args) {
        Solution solution = new P95UniqueBinarySearchTreesIiBackUp().new Solution();
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
     * int val;
     * TreeNode left;
     * TreeNode right;
     * TreeNode() {}
     * TreeNode(int val) { this.val = val; }
     * TreeNode(int val, TreeNode left, TreeNode right) {
     * this.val = val;
     * this.left = left;
     * this.right = right;
     * }
     * }
     */
    class Solution {
        public List<TreeNode> generateTrees(int n) {

            List<TreeNode> result = new ArrayList<>();

            dg(n, null, 0, new boolean[n], result, new HashSet<>());

            // 去重

            return result;
        }

        /**
         *
         * @param n  : 代表总共进行多少次递归
         * @param node ： 符合条件的头结点
         * @param index： 当前到了第几次了
         * @param arr： 用于定义已经遍历过得结点
         * @param result： 存储符合条件的结果
         * @param keys： 用于二叉搜索树去重
         * @return
         */
        private TreeNode dg(int n, TreeNode node, int index, boolean[] arr, List<TreeNode> result, Set<String> keys) {

            if (index == n) {
                // copy the entire tree
                copyTree(node, keys, result);
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
                        TreeNode treeNode = insert2(node, i + 1);
                        dg(n, node, index + 1, arr, result, keys);
                        // 去除插入的节点
                        if ((i + 1) > treeNode.val) {
                            treeNode.right = null;
                        }
                        if ((i + 1) < treeNode.val) {
                            treeNode.left = null;
                        }
                    }
                    arr[i] = false;
                }

            }

            return node;
        }

        private TreeNode copyTree(TreeNode node, Set<String> keys, List<TreeNode> result) {
            TreeNode newTreeHead = new TreeNode(node.val);
            String s = copyTree(node, newTreeHead);
            //System.out.println("***" + s);
            if (!keys.contains(s)) {
                keys.add(s);
                result.add(newTreeHead);
            }

            return newTreeHead;
        }

        private String copyTree(TreeNode preNode, TreeNode newNode) {

            if (preNode == null) {
                return "";
            }
            String s = "" + preNode.val;
            if (preNode.left != null) {
                newNode.left = new TreeNode(preNode.left.val);
            }
            if (preNode.right != null) {
                newNode.right = new TreeNode(preNode.right.val);
            }
            s += copyTree(preNode.left, newNode.left);
            s += copyTree(preNode.right, newNode.right);
            return s;
        }

        // 返回插入节点的上一个节点
        private TreeNode insert2(TreeNode node, int val) {

            if (val < node.val && node.left == null) {
                //node.left = insert(node.left, val);
                node.left = new TreeNode(val);
                return node;
            } else if (val < node.val) {
                return insert2(node.left, val);
            }
            if (val > node.val && node.right == null) {
                //node.right = insert(node.right, val);
                node.right = new TreeNode(val);
                return node;
            } else if (val > node.val) {
                return insert2(node.right, val);
            }
            return null;
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)


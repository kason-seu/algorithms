/**
 * 题目Id：96
 * 题目：不同的二叉搜索树
 * 内容: //给你一个整数 n ，求恰由 n 个节点组成且节点值从 1 到 n 互不相同的 二叉搜索树 有多少种？返回满足题意的二叉搜索树的种数。
 * //
 * //
 * //
 * // 示例 1：
 * //
 * //
 * //输入：n = 3
 * //输出：5
 * //
 * //
 * // 示例 2：
 * //
 * //
 * //输入：n = 1
 * //输出：1
 * //
 * //
 * //
 * //
 * // 提示：
 * //
 * //
 * // 1 <= n <= 19
 * //
 * // Related Topics 树 二叉搜索树 数学 动态规划 二叉树 👍 1384 👎 0
 * <p>
 * 日期：2021-11-06 19:12:21
 */
//给你一个整数 n ，求恰由 n 个节点组成且节点值从 1 到 n 互不相同的 二叉搜索树 有多少种？返回满足题意的二叉搜索树的种数。 
//
// 
//
// 示例 1： 
//
// 
//输入：n = 3
//输出：5
// 
//
// 示例 2： 
//
// 
//输入：n = 1
//输出：1
// 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 19 
// 
// Related Topics 树 二叉搜索树 数学 动态规划 二叉树 👍 1384 👎 0

package leetcode.editor.cn;

import common.TreeNode;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class P96UniqueBinarySearchTrees {
    public static void main(String[] args) {
        Solution solution = new P96UniqueBinarySearchTrees().new Solution();

        int i = solution.numTrees(4);

        System.out.println(i);
        System.out.println("Hello world");
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int numTrees(int n) {

            Set<String> keys = new HashSet<>();
            dg(n, null, 0, new boolean[n], keys);

            // 去重

            return keys.size();
        }

        private TreeNode dg(int n, TreeNode node, int index, boolean[] arr, Set<String> keys) {

            if (index == n) {
                // copy the eitire tree
                copyTree(node, keys);
                /*String preNodeTreeStr = getPreNodeTree(newHead);
                if (!keys.contains(preNodeTreeStr)) {

                    keys.add(preNodeTreeStr);
                }*/
                return node;
            }
            for (int i = 0; i < n; i++) {
                if (!arr[i]) {
                    arr[i] = true;
                    if (node == null) {
                        TreeNode nd = new TreeNode(i + 1);
                        dg(n, nd, 1, arr, keys);
                        nd = null;
                    } else {
                        // 插入节点
                        insert(node, i + 1);
                        dg(n, node, index + 1, arr, keys);
                        // 去除插入的节点
                        removeNode(node, i + 1);
                    }
                    arr[i] = false;
                }

            }

            return node;
        }

        private TreeNode copyTree(TreeNode node,Set<String> keys) {
            TreeNode newTreeHead = new TreeNode(node.val);
            String s = copyTree(node, newTreeHead);
            System.out.println("***" + s);
            keys.add(s);

            return newTreeHead;
        }

        private String copyTree(TreeNode preNode, TreeNode newNode) {

            if (preNode == null) {
                return "";
            }
            String s = ""+preNode.val;
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


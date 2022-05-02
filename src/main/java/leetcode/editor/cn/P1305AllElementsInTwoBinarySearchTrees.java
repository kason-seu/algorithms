/**
  * 题目Id：1305
  * 题目：两棵二叉搜索树中的所有元素
  * 内容: //给你 root1 和 root2 这两棵二叉搜索树。请你返回一个列表，其中包含 两棵树 中的所有整数并按 升序 排序。. 
//
// 
//
// 示例 1： 
//
// 
//
// 
//输入：root1 = [2,1,4], root2 = [1,0,3]
//输出：[0,1,1,2,3,4]
// 
//
// 示例 2： 
//
// 
//
// 
//输入：root1 = [1,null,8], root2 = [8,1]
//输出：[1,1,8,8]
// 
//
// 
//
// 提示： 
//
// 
// 每棵树的节点数在 [0, 5000] 范围内 
// -10⁵ <= Node.val <= 10⁵ 
// 
// Related Topics 树 深度优先搜索 二叉搜索树 二叉树 排序 👍 120 👎 0
	
  * 日期：2022-05-01 16:23:24
*/
//给你 root1 和 root2 这两棵二叉搜索树。请你返回一个列表，其中包含 两棵树 中的所有整数并按 升序 排序。. 
//
// 
//
// 示例 1： 
//
// 
//
// 
//输入：root1 = [2,1,4], root2 = [1,0,3]
//输出：[0,1,1,2,3,4]
// 
//
// 示例 2： 
//
// 
//
// 
//输入：root1 = [1,null,8], root2 = [8,1]
//输出：[1,1,8,8]
// 
//
// 
//
// 提示： 
//
// 
// 每棵树的节点数在 [0, 5000] 范围内 
// -10⁵ <= Node.val <= 10⁵ 
// 
// Related Topics 树 深度优先搜索 二叉搜索树 二叉树 排序 👍 120 👎 0

package leetcode.editor.cn;

import common.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class P1305AllElementsInTwoBinarySearchTrees {
    public static void main(String[] args) {
        Solution solution = new P1305AllElementsInTwoBinarySearchTrees().new Solution();
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
    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {

        List<Integer> list1 = new ArrayList<>();
        middle(root1, list1);
        System.out.println(list1.size());
        List<Integer> list2 = new ArrayList<>();
        middle(root2, list2);
        System.out.println(list2.size());

        return merger(list1, list2);
    }

    private List<Integer> merger(List<Integer> list1, List<Integer> list2) {

        List<Integer> ans = new ArrayList<>();
        int p1 = 0, p2 = 0;

        while (p1 < list1.size() && p2 < list2.size()) {

            if (list1.get(p1) <= list2.get(p2)) {
                ans.add(list1.get(p1));
                p1++;
            } else if (list1.get(p1) > list2.get(p2)) {
                ans.add(list2.get(p2));
                p2++;
            }
        }

        if (p1 < list1.size()) {
            ans.addAll(list1.subList(p1, list1.size()));
        }

        if (p2 < list2.size()) {
            ans.addAll(list2.subList(p2, list2.size()));
        }

        return ans;

    }

    private TreeNode middle(TreeNode treeNode, List<Integer> ans) {

        if (treeNode == null) {
            return null;
        }

        TreeNode left = middle(treeNode.left, ans);
//        if (left != null) {
//            ans.add(left.val);
//        }

        ans.add(treeNode.val);

        TreeNode right = middle(treeNode.right, ans);
//        if (right != null) {
//            ans.add(right.val);
//        }


        return treeNode;

    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
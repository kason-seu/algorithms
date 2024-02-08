package leetcode.editor.cn;

import common.TreeNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/** * @author  kason * @date    2024-02-03 13:03:28 */public class Q0863AllNodesDistanceKInBinaryTree{    //给定一个二叉树（具有根结点 root）， 一个目标结点 target ，和一个整数值 k 。
//
// 返回到目标结点 target 距离为 k 的所有结点的值的列表。 答案可以以 任何顺序 返回。 
//
// 
//
// 
// 
//
// 示例 1： 
//
// 
//
// 
//输入：root = [3,5,1,6,2,0,8,null,null,7,4], target = 5, k = 2
//输出：[7,4,1]
//解释：所求结点为与目标结点（值为 5）距离为 2 的结点，值分别为 7，4，以及 1
// 
//
// 示例 2: 
//
// 
//输入: root = [1], target = 1, k = 3
//输出: []
// 
//
// 
//
// 提示: 
//
// 
// 节点数在 [1, 500] 范围内 
// 0 <= Node.val <= 500 
// Node.val 中所有值 不同 
// 目标结点 target 是树上的结点。 
// 0 <= k <= 1000 
// 
//
// 
//
// Related Topics 树 深度优先搜索 广度优先搜索 二叉树 👍 666 👎 0
    public static void main(String[] args) {        Solution solution = new Q0863AllNodesDistanceKInBinaryTree().new Solution();    }    //leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {

    Map<TreeNode, TreeNode> upNodes = new HashMap<>();
    Map<TreeNode, Boolean> visited = new HashMap<>();
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        dfs(root);
        List<Integer> ans = new ArrayList<>();
        //scan(target, 0, k, ans);
        scan(target, target, 0, k, ans);
        return ans;
    }

    private TreeNode dfs(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode l = dfs(root.left);
        TreeNode r = dfs(root.right);
        if (l != null) {
            upNodes.put(l, root);
        }
        if (r != null) {
            upNodes.put(r, root);
        }

        return root;
    }

    private void scan(TreeNode root, int num, int k, List<Integer> ans) {
        if (root == null) {
            return;
        }
        if (num == k) {
            ans.add(root.val);
            return;
        }



        num ++;
        visited.put(root, true);
        if (visited.get(root.left) == null) {
            scan(root.left, num, k, ans);
        }
        if (visited.get(root.right) == null) {
            scan(root.right, num, k, ans);
        }
        if (visited.get(upNodes.get(root)) == null) {
            scan(upNodes.get(root), num, k, ans);
        }
    }

    private void scan(TreeNode root, TreeNode from, int num, int k, List<Integer> ans) {
        if (root == null) {
            return;
        }
        if (num == k) {
            ans.add(root.val);
            return;
        }

        num ++;
        if (root.left != from) {
            scan(root.left, root, num, k, ans);
        }
        if (root.right != from) {
            scan(root.right, root, num, k, ans);
        }
        if (upNodes.get(root) != from) {
            scan(upNodes.get(root), root, num, k, ans);
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
}
package leetcode.editor.cn;

import common.TreeNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/** * @author  kason * @date    2024-01-27 20:46:07 */public class Q0508MostFrequentSubtreeSum{    //给你一个二叉树的根结点 root ，请返回出现次数最多的子树元素和。如果有多个元素出现的次数相同，返回所有出现次数最多的子树元素和（不限顺序）。
//
// 一个结点的 「子树元素和」 定义为以该结点为根的二叉树上所有结点的元素之和（包括结点本身）。 
//
// 
//
// 示例 1： 
//
// 
//
// 
//输入: root = [5,2,-3]
//输出: [2,-3,4]
// 
//
// 示例 2： 
//
// 
//
// 
//输入: root = [5,2,-5]
//输出: [2]
// 
//
// 
//
// 提示: 
//
// 
// 节点数在 [1, 10⁴] 范围内 
// -10⁵ <= Node.val <= 10⁵ 
// 
//
// Related Topics 树 深度优先搜索 哈希表 二叉树 👍 240 👎 0
    public static void main(String[] args) {        Solution solution = new Q0508MostFrequentSubtreeSum().new Solution();    }    //leetcode submit region begin(Prohibit modification and deletion)
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
    // key, root, value 是以该跟的和
    Map<TreeNode, Integer> ans = new HashMap<>();
    public int[] findFrequentTreeSum(TreeNode root) {

        sum(root);

        //System.out.println(ans);
        Map<Integer, Integer> cnts = new HashMap<>();
        // key: 跟节点， v : sum和
        for (Map.Entry<TreeNode, Integer> entry : ans.entrySet()) {
            Integer sum = entry.getValue();
            cnts.merge(sum, 1, Integer::sum);
        }

        //System.out.println(cnts);
        int maxTimes = 0;
        List<Integer> maxKeys = new ArrayList<>();
        // key sum和， value 次数
        for (Map.Entry<Integer, Integer> entry : cnts.entrySet()) {
            Integer times = entry.getValue();
            if (times > maxTimes) {
                maxTimes = times;
                maxKeys.clear();
                maxKeys.add(entry.getKey());
            } else if (times == maxTimes) {
                maxKeys.add(entry.getKey());
            }
        }


        return maxKeys.stream().mapToInt(i -> i).toArray();
    }

    private int sum(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (ans.get(root) != null) {
            return ans.get(root);
        }
        int rootSum = root.val;
        rootSum += sum(root.left);
        rootSum += sum(root.right);
        ans.put(root, rootSum);
        return rootSum;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
}
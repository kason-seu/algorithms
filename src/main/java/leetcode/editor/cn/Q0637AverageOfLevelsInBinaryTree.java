package leetcode.editor.cn;

import common.TreeNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/** * @author  kason * @date    2024-02-02 13:50:58 */public class Q0637AverageOfLevelsInBinaryTree{    //给定一个非空二叉树的根节点
// root , 以数组的形式返回每一层节点的平均值。与实际答案相差 10⁻⁵ 以内的答案可以被接受。 
//
// 
//
// 示例 1： 
//
// 
//
// 
//输入：root = [3,9,20,null,null,15,7]
//输出：[3.00000,14.50000,11.00000]
//解释：第 0 层的平均值为 3,第 1 层的平均值为 14.5,第 2 层的平均值为 11 。
//因此返回 [3, 14.5, 11] 。
// 
//
// 示例 2: 
//
// 
//
// 
//输入：root = [3,9,20,15,7]
//输出：[3.00000,14.50000,11.00000]
// 
//
// 
//
// 提示： 
//
// 
// 
//
// 
// 树中节点数量在 [1, 10⁴] 范围内 
// -2³¹ <= Node.val <= 2³¹ - 1 
// 
//
// Related Topics 树 深度优先搜索 广度优先搜索 二叉树 👍 475 👎 0
    public static void main(String[] args) {        Solution solution = new Q0637AverageOfLevelsInBinaryTree().new Solution();    }    //leetcode submit region begin(Prohibit modification and deletion)
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

    Map<Integer, List<Integer>> levelsMap = new HashMap<>();
    public List<Double> averageOfLevels(TreeNode root) {


        preDfs(root, 0);
        List<Double> result = new ArrayList<>();

        for (int i = 1; i <= levelsMap.size(); i++) {
            List<Integer> levelValue = levelsMap.get(i);
            long sum = 0;
            int cnt = 0;
            for (int j = 0; j < levelValue.size(); j++) {
                sum += levelValue.get(j);
                cnt++;
            }
            result.add(1.0 * sum/cnt);
        }

        return result;

    }

    private void preDfs(TreeNode root, int height) {
        if (root == null) {
            return;
        }

        height++;
        if (levelsMap.get(height) == null) {
            List<Integer> ans = new ArrayList<>();
            ans.add(root.val);
            levelsMap.put(height, ans);
        } else {
            levelsMap.get(height).add(root.val);
        }

        preDfs(root.left, height);
        preDfs(root.right, height);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
}
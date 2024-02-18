package leetcode.editor.cn;

import common.TreeNode;

import java.util.ArrayList;
import java.util.List;

/** * @author  kason * @date    2024-02-17 18:55:49 */public class Q0515FindLargestValueInEachTreeRow{    //给定一棵二叉树的根节点 root ，请找出该二叉树中每一层的最大值。
//
// 
//
// 示例1： 
//
// 
//
// 
//输入: root = [1,3,2,5,3,null,9]
//输出: [1,3,9]
// 
//
// 示例2： 
//
// 
//输入: root = [1,2,3]
//输出: [1,3]
// 
//
// 
//
// 提示： 
//
// 
// 二叉树的节点个数的范围是 [0,10⁴] 
// 
// -2³¹ <= Node.val <= 2³¹ - 1 
// 
//
// 
//
// Related Topics 树 深度优先搜索 广度优先搜索 二叉树 👍 353 👎 0
    public static void main(String[] args) {        Solution solution = new Q0515FindLargestValueInEachTreeRow().new Solution();    }    //leetcode submit region begin(Prohibit modification and deletion)
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
    public List<Integer> largestValues(TreeNode root) {

        predfs(root, 0);

        return result;

    }
    List<Integer> result = new ArrayList<>();
    private void predfs(TreeNode root, int level) {
        if (root == null) {
            return;
        }
        if (result.size() == level) {
        //if (result.get(level) == null) {
            //result.set(level, root.val);
            result.add(root.val);
        } else {
            Integer levelMax = result.get(level);
            if (levelMax < root.val) {
                result.set(level, root.val);
            }
        }

        predfs(root.left, level + 1);
        predfs(root.right, level + 1);

    }

}
//leetcode submit region end(Prohibit modification and deletion)
}
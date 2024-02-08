package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/** * @author  kason * @date    2023-12-24 20:52:30 */public class Q0103BinaryTreeZigzagLevelOrderTraversal{    //给你二叉树的根节点 root ，返回其节点值的 锯齿形层序遍历 。（即先从左往右，再从右往左进行下一层遍历，以此类推，层与层之间交替进行）。
//
// 
//
// 示例 1： 
// 
// 
//输入：root = [3,9,20,null,null,15,7]
//输出：[[3],[20,9],[15,7]]
// 
//
// 示例 2： 
//
// 
//输入：root = [1]
//输出：[[1]]
// 
//
// 示例 3： 
//
// 
//输入：root = []
//输出：[]
// 
//
// 
//
// 提示： 
//
// 
// 树中节点数目在范围 [0, 2000] 内 
// -100 <= Node.val <= 100 
// 
//
// Related Topics 树 广度优先搜索 二叉树 👍 837 👎 0
    public static void main(String[] args) {        Solution solution = new Q0103BinaryTreeZigzagLevelOrderTraversal().new Solution();    }    //leetcode submit region begin(Prohibit modification and deletion)
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
class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
  }
class Solution {


    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {

        Stack<TreeNode> q1 = new Stack<>();
        Stack<TreeNode> q2 = new Stack<>();
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> layerRes = new ArrayList<>();
        if (root == null) {
            return res;
        }
        q1.add(root);
        int layer = 1;

        while (!(q1.empty() && q2.empty())) {
            while (!q1.empty()) {
                TreeNode pop = q1.pop();
                layerRes.add(pop.val);
                if (layer % 2 == 1) {
                    TreeNode left = pop.left;
                    if (left != null) {
                        q2.push(left);
                    }
                    TreeNode right = pop.right;
                    if (right != null) {
                        q2.push(right);
                    }
                } else {
                    TreeNode right = pop.right;
                    if (right != null) {
                        q2.push(right);
                    }
                    TreeNode left = pop.left;
                    if (left != null) {
                        q2.push(left);
                    }
                }
            }

            res.add(layerRes);
            layer++;
            layerRes = new ArrayList<>();
            /*if (q2.isEmpty()) {
                break;
            }*/
            q1 = q2;
            q2 = new Stack<>();
        }


        return res;

    }
}
//leetcode submit region end(Prohibit modification and deletion)
}
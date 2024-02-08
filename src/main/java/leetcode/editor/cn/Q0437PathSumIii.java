package leetcode.editor.cn;

import common.TreeNode;

import java.util.HashMap;
import java.util.Map;

/** * @author  kason * @date    2024-01-27 10:16:44 */public class Q0437PathSumIii{    //给定一个二叉树的根节点 root ，和一个整数 targetSum ，求该二叉树里节点值之和等于 targetSum 的 路径 的数目。
//
// 路径 不需要从根节点开始，也不需要在叶子节点结束，但是路径方向必须是向下的（只能从父节点到子节点）。 
//
// 
//
// 示例 1： 
//
// 
//
// 
//输入：root = [10,5,-3,3,2,null,11,3,-2,null,1], targetSum = 8
//输出：3
//解释：和等于 8 的路径有 3 条，如图所示。
// 
//
// 示例 2： 
//
// 
//输入：root = [5,4,8,11,null,13,4,7,2,null,null,5,1], targetSum = 22
//输出：3
// 
//
// 
//
// 提示: 
//
// 
// 二叉树的节点个数的范围是 [0,1000] 
// 
// -10⁹ <= Node.val <= 10⁹ 
// -1000 <= targetSum <= 1000 
// 
//
// Related Topics 树 深度优先搜索 二叉树 👍 1788 👎 0
    public static void main(String[] args) {
        Solution solution = new Q0437PathSumIii().new Solution();

        /*TreeNode root = new TreeNode(10);
        TreeNode root2 = new TreeNode(5);
        TreeNode root3 = new TreeNode(-3);
        root.left = root2;
        root.right = root3;
        TreeNode root4 = new TreeNode(3);
        TreeNode root5 = new TreeNode(2);
        root2.left = root4;
        root2.right = root5;
        TreeNode root6 = new TreeNode(11);
        root3.right = root6;
        TreeNode root7 = new TreeNode(3);
        TreeNode root8 = new TreeNode(-2);
        root4.left = root7;
        root4.right = root8;
        TreeNode root9 = new TreeNode(1);
        root5.right = root9;*/

        /*TreeNode root = new TreeNode(1);
        TreeNode root2 = new TreeNode(2);
        TreeNode root3 = new TreeNode(3);
        TreeNode root4 = new TreeNode(4);
        TreeNode root5 = new TreeNode(5);
        root.right = root2;
        root2.right = root3;
        root3.right = root4;
        root4.right= root5;*/

        TreeNode root = new TreeNode(1000000000);
        TreeNode root2 = new TreeNode(1000000000);
        TreeNode root3 = new TreeNode(294967296);
        TreeNode root4 = new TreeNode(1000000000);
        TreeNode root5 = new TreeNode(1000000000);
        TreeNode root6 = new TreeNode(1000000000);
        root.left = root2;
        root2.right = root3;
        root3.right = root4;
        root4.right= root5;
        root5.right = root6;
        System.out.println(solution.pathSum(root, 0));





    }    //leetcode submit region begin(Prohibit modification and deletion)
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


    int ans = 0;

    Map<TreeNode, Boolean> visited = new HashMap<>();

    public int pathSum(TreeNode root, int targetSum) {
        pathDfs2(root, targetSum, targetSum);
        return ans;
    }
    private void pathDfs2(TreeNode root, long sum, int targetSum) {

        if (root == null) {
            return ;
        }

        // 用这个节点
        long n = sum - root.val;
        if (n == 0) {
            ans += 1;
            System.out.println(root + " " + sum + " " + root.val );
            //return;
        }
        pathDfs2(root.left, n, targetSum);
        pathDfs2(root.right, n, targetSum);

        // 不用这个节点
        if (root.left != null && visited.get(root.left) == null) {
            pathDfs2(root.left, targetSum, targetSum);
            visited.put(root.left, true);
        }
        if (root.right != null && visited.get(root.right) == null) {
            pathDfs2(root.right, targetSum, targetSum);
            visited.put(root.right, true);
        }


    }

}
//leetcode submit region end(Prohibit modification and deletion)
}
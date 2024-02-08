package leetcode.editor.cn;

import common.TreeNode;

import java.util.*;

/** * @author  kason * @date    2024-02-02 14:15:34 */public class Q0652FindDuplicateSubtrees{    //给你一棵二叉树的根节点 root ，返回所有 重复的子树 。
//
// 对于同一类的重复子树，你只需要返回其中任意 一棵 的根结点即可。 
//
// 如果两棵树具有 相同的结构 和 相同的结点值 ，则认为二者是 重复 的。 
//
// 
//
// 示例 1： 
//
// 
//
// 
//输入：root = [1,2,3,4,null,2,4,null,null,4]
//输出：[[2,4],[4]] 
//
// 示例 2： 
//
// 
//
// 
//输入：root = [2,1,1]
//输出：[[1]] 
//
// 示例 3： 
//
// 
//
// 
//输入：root = [2,2,2,3,null,3,null]
//输出：[[2,3],[3]] 
//
// 
//
// 提示： 
//
// 
// 树中的结点数在 [1, 5000] 范围内。 
// -200 <= Node.val <= 200 
// 
//
// Related Topics 树 深度优先搜索 哈希表 二叉树 👍 734 👎 0
    public static void main(String[] args) {        Solution solution = new Q0652FindDuplicateSubtrees().new Solution();    }    //leetcode submit region begin(Prohibit modification and deletion)
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
    Map<String, TreeNode> ansMap = new HashMap<>();

    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {

        findDuplicateSubtrees(root.left, root.right);
        return new ArrayList<>(ansMap.values());

    }


    public boolean isSame(TreeNode r1, TreeNode r2) {

        if (r1 == null && r2 == null) {
            return true;
        }
        if (r1 == null || r2 == null) {
            return false;
        }

        if (r1.val == r2.val) {
            return isSame(r1.left, r2.left) && isSame(r1.right, r2.right);
        } else {
            return false;
        }

    }

    public String valueKey(TreeNode r1) {

        if (r1 == null ) {
            return "";
        }

        return r1.val + "-" + valueKey(r1.left) + "_"+ valueKey(r1.right);
    }

    public void findDuplicateSubtrees(TreeNode r1, TreeNode r2) {


        if (r1 == null && r2 == null) {
            return;
        }

        if (isSame(r1, r2)) {
            String valueKey = valueKey(r1);
            //ans.add(r1);
            ansMap.put(valueKey, r1);
        }
        if (r1 == null) {
            findDuplicateSubtrees(r2.left, r2.right);
        }

        if (r2 == null) {
            findDuplicateSubtrees(r1.left, r1.right);
        }
        if (r2 != null) {
            findDuplicateSubtrees(r1, r2.left);
            findDuplicateSubtrees(r1, r2.right);
        }
        if (r1 != null) {
            findDuplicateSubtrees(r1.left, r2);
            findDuplicateSubtrees(r1.right, r2);
        }
    }


}

//leetcode submit region end(Prohibit modification and deletion)
}
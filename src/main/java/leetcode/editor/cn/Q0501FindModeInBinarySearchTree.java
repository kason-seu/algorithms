package leetcode.editor.cn;

import common.TreeNode;

import java.util.*;

/** * @author  kason * @date    2024-01-27 14:02:12 */public class Q0501FindModeInBinarySearchTree{    //给你一个含重复值的二叉搜索树（BST）的根节点 root ，找出并返回 BST 中的所有 众数（即，出现频率最高的元素）。
//
// 如果树中有不止一个众数，可以按 任意顺序 返回。 
//
// 假定 BST 满足如下定义： 
//
// 
// 结点左子树中所含节点的值 小于等于 当前节点的值 
// 结点右子树中所含节点的值 大于等于 当前节点的值 
// 左子树和右子树都是二叉搜索树 
// 
//
// 
//
// 示例 1： 
// 
// 
//输入：root = [1,null,2,2]
//输出：[2]
// 
//
// 示例 2： 
//
// 
//输入：root = [0]
//输出：[0]
// 
//
// 
//
// 提示： 
//
// 
// 树中节点的数目在范围 [1, 10⁴] 内 
// -10⁵ <= Node.val <= 10⁵ 
// 
//
// 
//
// 进阶：你可以不使用额外的空间吗？（假设由递归产生的隐式调用栈的开销不被计算在内） 
//
// Related Topics 树 深度优先搜索 二叉搜索树 二叉树 👍 732 👎 0
    public static void main(String[] args) {        Solution solution = new Q0501FindModeInBinarySearchTree().new Solution();


        /*TreeNode root = new TreeNode(1);
        TreeNode root2 = new TreeNode(2);
        TreeNode root3 = new TreeNode(2);
//        TreeNode root4 = new TreeNode(1000000000);
//        TreeNode root5 = new TreeNode(1000000000);
//        TreeNode root6 = new TreeNode(1000000000);
        root.right = root2;
        root2.left = root3;
//        root3.right = root4;
//        root4.right= root5;
//        root5.right = root6;*/
        TreeNode root = new TreeNode(0);


        /*TreeNode root = new TreeNode(1);
        TreeNode root2 = new TreeNode(2);
        TreeNode root3 = new TreeNode(2);
        TreeNode root4 = new TreeNode(3);
//        TreeNode root4 = new TreeNode(1000000000);
//        TreeNode root5 = new TreeNode(1000000000);
//        TreeNode root6 = new TreeNode(1000000000);
        root.right = root2;
        root2.left = root3;
        root2.right = root4;
//        root4.right= root5;
//        root5.right = root6;*/
        System.out.println(Arrays.toString(solution.findMode(root)));

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

    int count;
    int preMaxCnt = 0;
    Integer preValue = null;
    Set<Integer> ans = new HashSet<>();
    public int[] findMode(TreeNode root) {

        inOrderDfs(root);
        int[] result = new int[ans.size()];
        int i = 0;
        for (Integer r : ans) {
            result[i++] = r;
        }
        return result;
    }


    private void inOrderDfs(TreeNode root){

        if (root == null) {
            return;
        }

        inOrderDfs(root.left);
        if (preValue == null) {
            // 第一个节点
            count  = 1;
        } else if (preValue != root.val) {
            // 说明节点变更了，那么针对root的count计数就是1
            count  = 1;
        } else {
            count++;
        }
        preValue = root.val;
        // 遍历每一个节点的时候都处理，看要不要更新全局变量
        if (count == preMaxCnt) {
            ans.add(preValue);
        }
        if (count > preMaxCnt) {
            ans.clear();
            ans.add(preValue);
            preMaxCnt = count;
        }

        inOrderDfs(root.right);


    }
}
//leetcode submit region end(Prohibit modification and deletion)
}
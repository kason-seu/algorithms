/**
  * 题目Id：654
  * 题目：最大二叉树
  * 内容: //给定一个不重复的整数数组 nums 。 最大二叉树 可以用下面的算法从 nums 递归地构建: 
//
// 
// 创建一个根节点，其值为 nums 中的最大值。 
// 递归地在最大值 左边 的 子数组前缀上 构建左子树。 
// 递归地在最大值 右边 的 子数组后缀上 构建右子树。 
// 
//
// 返回 nums 构建的 最大二叉树 。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [3,2,1,6,0,5]
//输出：[6,3,5,null,2,0,null,null,1]
//解释：递归调用如下所示：
//- [3,2,1,6,0,5] 中的最大值是 6 ，左边部分是 [3,2,1] ，右边部分是 [0,5] 。
//    - [3,2,1] 中的最大值是 3 ，左边部分是 [] ，右边部分是 [2,1] 。
//        - 空数组，无子节点。
//        - [2,1] 中的最大值是 2 ，左边部分是 [] ，右边部分是 [1] 。
//            - 空数组，无子节点。
//            - 只有一个元素，所以子节点是一个值为 1 的节点。
//    - [0,5] 中的最大值是 5 ，左边部分是 [0] ，右边部分是 [] 。
//        - 只有一个元素，所以子节点是一个值为 0 的节点。
//        - 空数组，无子节点。
// 
//
// 示例 2： 
//
// 
//输入：nums = [3,2,1]
//输出：[3,null,2,null,1]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 1000 
// 0 <= nums[i] <= 1000 
// nums 中的所有整数 互不相同 
// 
// Related Topics 栈 树 数组 分治 二叉树 单调栈 👍 394 👎 0
	
  * 日期：2022-03-30 22:19:12
*/
//给定一个不重复的整数数组 nums 。 最大二叉树 可以用下面的算法从 nums 递归地构建: 
//
// 
// 创建一个根节点，其值为 nums 中的最大值。 
// 递归地在最大值 左边 的 子数组前缀上 构建左子树。 
// 递归地在最大值 右边 的 子数组后缀上 构建右子树。 
// 
//
// 返回 nums 构建的 最大二叉树 。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [3,2,1,6,0,5]
//输出：[6,3,5,null,2,0,null,null,1]
//解释：递归调用如下所示：
//- [3,2,1,6,0,5] 中的最大值是 6 ，左边部分是 [3,2,1] ，右边部分是 [0,5] 。
//    - [3,2,1] 中的最大值是 3 ，左边部分是 [] ，右边部分是 [2,1] 。
//        - 空数组，无子节点。
//        - [2,1] 中的最大值是 2 ，左边部分是 [] ，右边部分是 [1] 。
//            - 空数组，无子节点。
//            - 只有一个元素，所以子节点是一个值为 1 的节点。
//    - [0,5] 中的最大值是 5 ，左边部分是 [0] ，右边部分是 [] 。
//        - 只有一个元素，所以子节点是一个值为 0 的节点。
//        - 空数组，无子节点。
// 
//
// 示例 2： 
//
// 
//输入：nums = [3,2,1]
//输出：[3,null,2,null,1]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 1000 
// 0 <= nums[i] <= 1000 
// nums 中的所有整数 互不相同 
// 
// Related Topics 栈 树 数组 分治 二叉树 单调栈 👍 394 👎 0

package leetcode.editor.cn;

import common.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

public class P654MaximumBinaryTree {
    public static void main(String[] args) {
        Solution solution = new P654MaximumBinaryTree().new Solution();
        
        int[] arr =new int[]{3};
        TreeNode treeNode = solution.constructMaximumBinaryTree(arr);




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
    public TreeNode constructMaximumBinaryTree(int[] nums) {

        if (nums == null || nums.length == 0) {
            return null;
        }
        if (nums.length == 1) {
            return new TreeNode(nums[0]);
        }
        Map<Integer, TreeNode> nodeMap = new HashMap<>();
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < nums.length; i++) {


            int top;
            int max = Integer.MIN_VALUE;
            while (!stack.isEmpty() && (top = stack.peek()) < nums[i]) {
                top = stack.pop();
                max = Math.max(max, top);
                // 上一个
                if (!stack.isEmpty()) {
                    int up = stack.peek();
                    // 邻居也需要小于Nums[i]
                    if (up < nums[i]) {
                        //stack.pop();
                        max = Math.max(max, up);
                        if (!nodeMap.containsKey(up)) {
                            TreeNode treeNode = new TreeNode(up);

                            if (!nodeMap.containsKey(top)) {
                                TreeNode cur = new TreeNode(top);
                                treeNode.right = cur;
                                nodeMap.put(top, cur);
                            } else {
                                treeNode.right = nodeMap.get(top);
                            }
                            nodeMap.put(up, treeNode);
                        } else {
                            if (!nodeMap.containsKey(top)) {
                                TreeNode cur = new TreeNode(top);
                                nodeMap.get(up).right = cur;
                                nodeMap.put(top, cur);
                            } else {
                                nodeMap.get(up).right = nodeMap.get(top);
                            }
                        }
                    } else {
                        max = Math.max(max, up);
                        if (!nodeMap.containsKey(nums[i])) {
                            TreeNode treeNode = new TreeNode(nums[i]);

                            if (!nodeMap.containsKey(top)) {
                                TreeNode cur = new TreeNode(top);
                                treeNode.left = cur;
                                nodeMap.put(top, cur);
                            } else {
                                treeNode.left = nodeMap.get(top);
                            }
                            nodeMap.put(nums[i], treeNode);
                        } else {
                            if (!nodeMap.containsKey(top)) {
                                TreeNode cur = new TreeNode(top);
                                nodeMap.get(nums[i]).left = cur;
                                nodeMap.put(top, cur);
                            } else {
                                nodeMap.get(nums[i]).left = nodeMap.get(top);
                            }
                        }
                    }


                } else {

                    if (top < nums[i]) {
                        if (!nodeMap.containsKey(nums[i])) {
                            TreeNode treeNode = new TreeNode(nums[i]);

                            if (!nodeMap.containsKey(top)) {
                                TreeNode cur = new TreeNode(top);
                                treeNode.left = cur;
                                nodeMap.put(top, cur);
                            } else {
                                treeNode.left = nodeMap.get(top);
                            }
                            nodeMap.put(nums[i], treeNode);
                        } else {
                            if (!nodeMap.containsKey(top)) {
                                TreeNode cur = new TreeNode(top);
                                nodeMap.get(nums[i]).left = cur;
                                nodeMap.put(top, cur);
                            } else {
                                nodeMap.get(nums[i]).left = nodeMap.get(top);
                            }
                        }
                    }

                    break;
                }
            }
            if (max > nums[i]) {
                //stack.push(max);
                stack.push(nums[i]);
            } else {
                stack.push(nums[i]);
            }

        }

        int result = stack.peekLast();
        while (!stack.isEmpty()) {
            Integer big = stack.removeLast();

            if (!stack.isEmpty()) {
                Integer small = stack.peekLast();
                if (!nodeMap.containsKey(big)) {
                    TreeNode treeNode = new TreeNode(big);

                    if (!nodeMap.containsKey(small)) {
                        TreeNode cur = new TreeNode(small);
                        treeNode.right = cur;
                        nodeMap.put(small, cur);
                    } else {
                        treeNode.right = nodeMap.get(small);
                    }
                    nodeMap.put(big, treeNode);
                } else {
                    if (!nodeMap.containsKey(small)) {
                        TreeNode cur = new TreeNode(small);
                        nodeMap.get(big).right = cur;
                        nodeMap.put(small, cur);
                    } else {
                        nodeMap.get(big).right = nodeMap.get(small);
                    }
                }

            }

        }


        return nodeMap.get(result);


    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
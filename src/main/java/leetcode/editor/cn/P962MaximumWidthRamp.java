/**
  * 题目Id：962
  * 题目：最大宽度坡
  * 内容: //给定一个整数数组 A，坡是元组 (i, j)，其中 i < j 且 A[i] <= A[j]。这样的坡的宽度为 j - i。 
//
// 找出 A 中的坡的最大宽度，如果不存在，返回 0 。 
//
// 
//
// 示例 1： 
//
// 输入：[6,0,8,2,1,5]
//输出：4
//解释：
//最大宽度的坡为 (i, j) = (1, 5): A[1] = 0 且 A[5] = 5.
// 
//
// 示例 2： 
//
// 输入：[9,8,1,0,1,9,4,0,4,1]
//输出：7
//解释：
//最大宽度的坡为 (i, j) = (2, 9): A[2] = 1 且 A[9] = 1.
// 
//
// 
//
// 提示： 
//
// 
// 2 <= A.length <= 50000 
// 0 <= A[i] <= 50000 
// 
//
// 
// Related Topics 栈 数组 单调栈 👍 160 👎 0
	
  * 日期：2022-04-05 20:10:40
*/
//给定一个整数数组 A，坡是元组 (i, j)，其中 i < j 且 A[i] <= A[j]。这样的坡的宽度为 j - i。 
//
// 找出 A 中的坡的最大宽度，如果不存在，返回 0 。 
//
// 
//
// 示例 1： 
//
// 输入：[6,0,8,2,1,5]
//输出：4
//解释：
//最大宽度的坡为 (i, j) = (1, 5): A[1] = 0 且 A[5] = 5.
// 
//
// 示例 2： 
//
// 输入：[9,8,1,0,1,9,4,0,4,1]
//输出：7
//解释：
//最大宽度的坡为 (i, j) = (2, 9): A[2] = 1 且 A[9] = 1.
// 
//
// 
//
// 提示： 
//
// 
// 2 <= A.length <= 50000 
// 0 <= A[i] <= 50000 
// 
//
// 
// Related Topics 栈 数组 单调栈 👍 160 👎 0

package leetcode.editor.cn;

import java.util.ArrayDeque;
import java.util.Deque;

public class P962MaximumWidthRamp {
    public static void main(String[] args) {
        Solution solution = new P962MaximumWidthRamp().new Solution();
        int[] arr =new int[]{2,2,1};

        int i = solution.maxWidthRamp(arr);


        System.out.println("Hello world " + i);
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int maxWidthRamp(int[] nums) {

        Deque<Integer> deque = new ArrayDeque<>();
        for (int i = 0; i < nums.length; i++) {
            if (deque.isEmpty() || nums[deque.peek()] > nums[i] ) {
                deque.push(i);
            }
        }
        int max = 0;
        for (int j = nums.length - 1; j >= 0; j--) {

            while (!deque.isEmpty() && nums[deque.peek()] <= nums[j]) {
                max = Math.max(max, j - deque.pop());
            }
        }
        return max;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
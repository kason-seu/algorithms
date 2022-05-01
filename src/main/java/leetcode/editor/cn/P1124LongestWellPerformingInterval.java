/**
  * 题目Id：1124
  * 题目：表现良好的最长时间段
  * 内容: //给你一份工作时间表 hours，上面记录着某一位员工每天的工作小时数。 
//
// 我们认为当员工一天中的工作小时数大于 8 小时的时候，那么这一天就是「劳累的一天」。 
//
// 所谓「表现良好的时间段」，意味在这段时间内，「劳累的天数」是严格 大于「不劳累的天数」。 
//
// 请你返回「表现良好时间段」的最大长度。 
//
// 
//
// 示例 1： 
//
// 
//输入：hours = [9,9,6,0,6,6,9]
//输出：3
//解释：最长的表现良好时间段是 [9,9,6]。 
//
// 示例 2： 
//
// 
//输入：hours = [6,6,6]
//输出：0
// 
//
// 
//
// 提示： 
//
// 
// 1 <= hours.length <= 10⁴ 
// 0 <= hours[i] <= 16 
// 
// Related Topics 栈 数组 哈希表 前缀和 单调栈 👍 175 👎 0
	
  * 日期：2022-04-10 10:10:04
*/
//给你一份工作时间表 hours，上面记录着某一位员工每天的工作小时数。 
//
// 我们认为当员工一天中的工作小时数大于 8 小时的时候，那么这一天就是「劳累的一天」。 
//
// 所谓「表现良好的时间段」，意味在这段时间内，「劳累的天数」是严格 大于「不劳累的天数」。 
//
// 请你返回「表现良好时间段」的最大长度。 
//
// 
//
// 示例 1： 
//
// 
//输入：hours = [9,9,6,0,6,6,9]
//输出：3
//解释：最长的表现良好时间段是 [9,9,6]。 
//
// 示例 2： 
//
// 
//输入：hours = [6,6,6]
//输出：0
// 
//
// 
//
// 提示： 
//
// 
// 1 <= hours.length <= 10⁴ 
// 0 <= hours[i] <= 16 
// 
// Related Topics 栈 数组 哈希表 前缀和 单调栈 👍 175 👎 0

package leetcode.editor.cn;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;

public class P1124LongestWellPerformingInterval {
    public static void main(String[] args) {
        Solution solution = new P1124LongestWellPerformingInterval().new Solution();
        int[]hours = new int[]{14,16,1,11,3,5,3};
        System.out.println("Hello world " + solution.longestWPI(hours));

        hours = new int[]{6,6,9};
        System.out.println("Hello world " + solution.longestWPI(hours));
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int longestWPI(int[] hours) {
        int len = hours.length;
        int[] hours2 = new int[len];
        for (int i = 0; i < len; i++) {
            if (hours[i] > 8) {
                hours2[i] = 1;
            } else {
                hours2[i] = -1;
            }
        }
        int[] prefixSum = new int[len + 1];
        for (int i = 1; i < len + 1; i++) {
            prefixSum[i] = prefixSum[i - 1] + hours2[i - 1];
        }
        Deque<Integer> stack = new LinkedList<>();
        for (int i = 0; i < len + 1; i++) {
            if (stack.isEmpty() || prefixSum[stack.peek()] > prefixSum[i]) {
                stack.push(i);
            }
        }
        int ans = 0;
        for (int j = len; j >= ans; j--) {
            while (!stack.isEmpty()) {
                int i = stack.peek();
                if (prefixSum[j] > prefixSum[i]) {
                    ans = Math.max(ans, j - i);
                    stack.pop();
                } else {
                    break;
                }
            }

        }
        return ans;

    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
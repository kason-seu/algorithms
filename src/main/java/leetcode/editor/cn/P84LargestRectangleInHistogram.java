/**
  * 题目Id：84
  * 题目：柱状图中最大的矩形
  * 内容: //给定 n 个非负整数，用来表示柱状图中各个柱子的高度。每个柱子彼此相邻，且宽度为 1 。 
//
// 求在该柱状图中，能够勾勒出来的矩形的最大面积。 
//
// 
//
// 示例 1: 
//
// 
//
// 
//输入：heights = [2,1,5,6,2,3]
//输出：10
//解释：最大的矩形为图中红色区域，面积为 10
// 
//
// 示例 2： 
//
// 
//
// 
//输入： heights = [2,4]
//输出： 4 
//
// 
//
// 提示： 
//
// 
// 1 <= heights.length <=10⁵ 
// 0 <= heights[i] <= 10⁴ 
// 
// Related Topics 栈 数组 单调栈 👍 1839 👎 0
	
  * 日期：2022-03-27 11:44:47
*/
//给定 n 个非负整数，用来表示柱状图中各个柱子的高度。每个柱子彼此相邻，且宽度为 1 。 
//
// 求在该柱状图中，能够勾勒出来的矩形的最大面积。 
//
// 
//
// 示例 1: 
//
// 
//
// 
//输入：heights = [2,1,5,6,2,3]
//输出：10
//解释：最大的矩形为图中红色区域，面积为 10
// 
//
// 示例 2： 
//
// 
//
// 
//输入： heights = [2,4]
//输出： 4 
//
// 
//
// 提示： 
//
// 
// 1 <= heights.length <=10⁵ 
// 0 <= heights[i] <= 10⁴ 
// 
// Related Topics 栈 数组 单调栈 👍 1839 👎 0

package leetcode.editor.cn;

import java.util.Stack;

public class P84LargestRectangleInHistogram {
    public static void main(String[] args) {
        Solution solution = new P84LargestRectangleInHistogram().new Solution();
        int[] heights = new int[]{2,1,5,6,2,3};
        int i = solution.largestRectangleArea(heights);

        System.out.println("Hello world" + i);
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
        public int largestRectangleArea(int[] heights) {
            Stack<Integer> stack  = new Stack<>();
            int max = 0;
            for (int i = 0; i < heights.length;i++) {
                /*if (stack.isEmpty()) {
                    stack.push(i);
                }*/
                // 结算栈顶
                while (!stack.isEmpty() && heights[i] < heights[stack.peek()]) {
                    max = calArea(heights, stack, max, i);
                }
                stack.push(i);
            }

            // 栈不为空，则数据已经刚好越界，并且全部加到栈里面了。
            while (!stack.isEmpty()) {

                max = calArea(heights, stack, max, heights.length);
                /*int right = heights.length;
                Integer cur = stack.pop();
                int left = stack.isEmpty() ? -1 : stack.peek();
                int area = (right - left - 1) * heights[cur];
                max = Math.max(max, area);*/
            }
            return max;
        }

        private int calArea(int[] heights, Stack<Integer> stack, int max, int i) {
            // 右边界
            int right = i;
            // 当前的结算点
            Integer cur = stack.pop();
            // 左边界
            int left = stack.isEmpty() ? -1 : stack.peek();
            // 面积
            int area = (right - left - 1) * heights[cur];
            max = Math.max(max, area);
            return max;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
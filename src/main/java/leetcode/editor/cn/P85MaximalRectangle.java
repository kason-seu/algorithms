/**
 * 题目Id：85
 * 题目：最大矩形
 * 内容: //给定一个仅包含 0 和 1 、大小为 rows x cols 的二维二进制矩阵，找出只包含 1 的最大矩形，并返回其面积。
 * //
 * //
 * //
 * // 示例 1：
 * //
 * //
 * //输入：matrix = [["1","0","1","0","0"],["1","0","1","1","1"],["1","1","1","1","1"]
 * //,["1","0","0","1","0"]]
 * //输出：6
 * //解释：最大矩形如上图所示。
 * //
 * //
 * // 示例 2：
 * //
 * //
 * //输入：matrix = []
 * //输出：0
 * //
 * //
 * // 示例 3：
 * //
 * //
 * //输入：matrix = [["0"]]
 * //输出：0
 * //
 * //
 * // 示例 4：
 * //
 * //
 * //输入：matrix = [["1"]]
 * //输出：1
 * //
 * //
 * // 示例 5：
 * //
 * //
 * //输入：matrix = [["0","0"]]
 * //输出：0
 * //
 * //
 * //
 * //
 * // 提示：
 * //
 * //
 * // rows == matrix.length
 * // cols == matrix[0].length
 * // 1 <= row, cols <= 200
 * // matrix[i][j] 为 '0' 或 '1'
 * //
 * // Related Topics 栈 数组 动态规划 矩阵 单调栈 👍 1220 👎 0
 * <p>
 * 日期：2022-03-27 12:28:17
 */
//给定一个仅包含 0 和 1 、大小为 rows x cols 的二维二进制矩阵，找出只包含 1 的最大矩形，并返回其面积。 
//
// 
//
// 示例 1： 
//
// 
//输入：matrix = [["1","0","1","0","0"],["1","0","1","1","1"],["1","1","1","1","1"]
//,["1","0","0","1","0"]]
//输出：6
//解释：最大矩形如上图所示。
// 
//
// 示例 2： 
//
// 
//输入：matrix = []
//输出：0
// 
//
// 示例 3： 
//
// 
//输入：matrix = [["0"]]
//输出：0
// 
//
// 示例 4： 
//
// 
//输入：matrix = [["1"]]
//输出：1
// 
//
// 示例 5： 
//
// 
//输入：matrix = [["0","0"]]
//输出：0
// 
//
// 
//
// 提示： 
//
// 
// rows == matrix.length 
// cols == matrix[0].length 
// 1 <= row, cols <= 200 
// matrix[i][j] 为 '0' 或 '1' 
// 
// Related Topics 栈 数组 动态规划 矩阵 单调栈 👍 1220 👎 0

package leetcode.editor.cn;

import java.util.Stack;

public class P85MaximalRectangle {
    public static void main(String[] args) {
        Solution solution = new P85MaximalRectangle().new Solution();
        System.out.println("Hello world");
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int maximalRectangle(char[][] matrix) {
            int max = 0;
            int[] cacheUp = new int[matrix[0].length];

            int[] height = new int[matrix[0].length];
            for (int row = 0; row < matrix.length; row++) {

                for (int col = 0; col < matrix[0].length; col++) {

                    if (matrix[row][col] == '0') {
                        height[col] = 0;
                        cacheUp[col] = 0;
                    } else {
                        height[col] = (matrix[row][col] - '0') + cacheUp[col];
                        cacheUp[col] = height[col];
                    }
                }
                max = Math.max(max, largestRectangleArea(height));
            }
            return max;
        }

        public int largestRectangleArea(int[] heights) {
            Stack<Integer> stack = new Stack<>();
            int max = 0;
            for (int i = 0; i < heights.length; i++) {
                // 结算栈顶
                while (!stack.isEmpty() && heights[i] < heights[stack.peek()]) {
                    max = calArea(heights, stack, max, i);
                }
                stack.push(i);
            }

            // 栈不为空，则数据已经刚好越界，并且全部加到栈里面了。
            while (!stack.isEmpty()) {
                max = calArea(heights, stack, max, heights.length);
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
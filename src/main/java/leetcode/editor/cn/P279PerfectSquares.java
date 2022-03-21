/**
  * 题目Id：279
  * 题目：完全平方数
  * 内容: //给你一个整数 n ，返回 和为 n 的完全平方数的最少数量 。 
//
// 完全平方数 是一个整数，其值等于另一个整数的平方；换句话说，其值等于一个整数自乘的积。例如，1、4、9 和 16 都是完全平方数，而 3 和 11 不是。
// 
//
// 
//
// 示例 1： 
//
// 
//输入：n = 12
//输出：3 
//解释：12 = 4 + 4 + 4 
//
// 示例 2： 
//
// 
//输入：n = 13
//输出：2
//解释：13 = 4 + 9 
// 
//
// 提示： 
//
// 
// 1 <= n <= 10⁴ 
// 
// Related Topics 广度优先搜索 数学 动态规划 👍 1270 👎 0
	
  * 日期：2022-03-10 23:29:31
*/
//给你一个整数 n ，返回 和为 n 的完全平方数的最少数量 。 
//
// 完全平方数 是一个整数，其值等于另一个整数的平方；换句话说，其值等于一个整数自乘的积。例如，1、4、9 和 16 都是完全平方数，而 3 和 11 不是。
// 
//
// 
//
// 示例 1： 
//
// 
//输入：n = 12
//输出：3 
//解释：12 = 4 + 4 + 4 
//
// 示例 2： 
//
// 
//输入：n = 13
//输出：2
//解释：13 = 4 + 9 
// 
//
// 提示： 
//
// 
// 1 <= n <= 10⁴ 
// 
// Related Topics 广度优先搜索 数学 动态规划 👍 1270 👎 0

package leetcode.editor.cn;

import java.util.Arrays;

public class P279PerfectSquares {
    public static void main(String[] args) {
        Solution solution = new P279PerfectSquares().new Solution();

        int i = solution.numSquares(13);


        System.out.println("Hello world " + i);
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int numSquares(int n) {

        int sqrtn = (int)Math.sqrt(n);
        int[] arr = new int[n];
        Arrays.fill(arr, - 1);

        return recur(sqrtn, n,arr);
    }

    private int recur(int sqrtn, int n, int[] arr) {

        int re = Integer.MAX_VALUE;
        for (int i = 1 ; i <= sqrtn; i++) {
            if (n - i * i > 0) {
                // 最小值有了
                if (arr[n - i * i] != -1) {
                    re = Math.min(re, arr[n - i * i]);
                } else {
                    // 递归计算最小值
                    re = Math.min(re, 1 + recur(sqrtn, n - i * i, arr));
                    arr[n - i * i] = re;
                }
            } else if (n - i * i == 0) {
                re = Math.min(re, 1);
            }
        }
        return re;

    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
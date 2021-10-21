/**
  * 题目Id：509
  * 题目：斐波那契数
  * 内容: //斐波那契数，通常用 F(n) 表示，形成的序列称为 斐波那契数列 。该数列由 0 和 1 开始，后面的每一项数字都是前面两项数字的和。也就是： 
//
// 
//F(0) = 0，F(1) = 1
//F(n) = F(n - 1) + F(n - 2)，其中 n > 1
// 
//
// 给你 n ，请计算 F(n) 。 
//
// 
//
// 示例 1： 
//
// 
//输入：2
//输出：1
//解释：F(2) = F(1) + F(0) = 1 + 0 = 1
// 
//
// 示例 2： 
//
// 
//输入：3
//输出：2
//解释：F(3) = F(2) + F(1) = 1 + 1 = 2
// 
//
// 示例 3： 
//
// 
//输入：4
//输出：3
//解释：F(4) = F(3) + F(2) = 2 + 1 = 3
// 
//
// 
//
// 提示： 
//
// 
// 0 <= n <= 30 
// 
// Related Topics 递归 记忆化搜索 数学 动态规划 
// 👍 336 👎 0
	
  * 日期：2021-10-21 22:55:46
*/
//斐波那契数，通常用 F(n) 表示，形成的序列称为 斐波那契数列 。该数列由 0 和 1 开始，后面的每一项数字都是前面两项数字的和。也就是： 
//
// 
//F(0) = 0，F(1) = 1
//F(n) = F(n - 1) + F(n - 2)，其中 n > 1
// 
//
// 给你 n ，请计算 F(n) 。 
//
// 
//
// 示例 1： 
//
// 
//输入：2
//输出：1
//解释：F(2) = F(1) + F(0) = 1 + 0 = 1
// 
//
// 示例 2： 
//
// 
//输入：3
//输出：2
//解释：F(3) = F(2) + F(1) = 1 + 1 = 2
// 
//
// 示例 3： 
//
// 
//输入：4
//输出：3
//解释：F(4) = F(3) + F(2) = 2 + 1 = 3
// 
//
// 
//
// 提示： 
//
// 
// 0 <= n <= 30 
// 
// Related Topics 递归 记忆化搜索 数学 动态规划 
// 👍 336 👎 0

package leetcode.editor.cn;

import java.util.Arrays;

public class P509斐波那契数FibonacciNumber {
    public static void main(String[] args) {
        Solution solution = new P509斐波那契数FibonacciNumber().new Solution();

        int fib = solution.fib(5);
        System.out.println("Hello world" + fib);
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int fib(int n) {

        int[] arr =new int[n+1];
        Arrays.fill(arr, -1);
        return dg(n, arr);

    }

    private int dg(int n, int[] arr) {
        if (n == 0) {
            arr[0] = 0;
            return 0;
        }
        if (n == 1) {
            arr[1] = 1;
            return 1;
        }
        if (arr[n-1] == -1 && arr[n-2] == -1) {
            arr[n] = dg(n-1, arr) + dg(n-2, arr);
            return arr[n];
        } else if (arr[n-1] == -1) {
            arr[n] = dg(n-1, arr) + arr[n-2];
            return arr[n];
        } else if (arr[n-2] == -1) {
            arr[n] = dg(n-2, arr) + arr[n-1];
            return arr[n];
        } else {
            return arr[n-1] + arr[n-2];
        }

    }
}
//leetcode submit region end(Prohibit modification and deletion)

} 
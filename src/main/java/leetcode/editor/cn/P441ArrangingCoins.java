/**
  * 题目Id：441
  * 题目：排列硬币
  * 内容: //你总共有 n 枚硬币，并计划将它们按阶梯状排列。对于一个由 k 行组成的阶梯，其第 i 行必须正好有 i 枚硬币。阶梯的最后一行 可能 是不完整的。 
//
// 给你一个数字 n ，计算并返回可形成 完整阶梯行 的总行数。 
//
// 
//
// 示例 1： 
//
// 
//输入：n = 5
//输出：2
//解释：因为第三行不完整，所以返回 2 。
// 
//
// 示例 2： 
//
// 
//输入：n = 8
//输出：3
//解释：因为第四行不完整，所以返回 3 。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 2³¹ - 1 
// 
// Related Topics 数学 二分查找 👍 209 👎 0
	
  * 日期：2022-04-23 22:16:46
*/
//你总共有 n 枚硬币，并计划将它们按阶梯状排列。对于一个由 k 行组成的阶梯，其第 i 行必须正好有 i 枚硬币。阶梯的最后一行 可能 是不完整的。 
//
// 给你一个数字 n ，计算并返回可形成 完整阶梯行 的总行数。 
//
// 
//
// 示例 1： 
//
// 
//输入：n = 5
//输出：2
//解释：因为第三行不完整，所以返回 2 。
// 
//
// 示例 2： 
//
// 
//输入：n = 8
//输出：3
//解释：因为第四行不完整，所以返回 3 。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 2³¹ - 1 
// 
// Related Topics 数学 二分查找 👍 209 👎 0

package leetcode.editor.cn;
public class P441ArrangingCoins {
    public static void main(String[] args) {
        Solution solution = new P441ArrangingCoins().new Solution();
        System.out.println("Hello world " + solution.arrangeCoins(1804289383));
        System.out.println("Hello world " + solution.arrangeCoins(5));
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int arrangeCoins(int n) {
        /*for (int i = (int)Math.sqrt(2 * n) - 1; i <= (int)Math.sqrt(2 *n) + 1; i++) {
            if (i * (i + 1) == n*2) {
                return i;
            } else if (i * (i + 1) > n * 2) {
                return i - 1;
            }
        }

        return -1;*/

        int l = 1;
        int r = n/2;
        int mid;
        while (l < r) {
            mid = l + (r - l) / 2;
            if ((long)mid * (mid + 1) == (long)n * 2) {
                return mid;
            } else if ((long)mid * (mid + 1)> (long)n * 2) {
                r = mid;
            } else if ((long)mid * (mid + 1) < (long)n * 2){
                l = mid + 1;
            }
        }

        return l-1;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
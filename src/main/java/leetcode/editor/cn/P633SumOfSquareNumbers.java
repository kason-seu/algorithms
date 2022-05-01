/**
  * 题目Id：633
  * 题目：平方数之和
  * 内容: //给定一个非负整数 c ，你要判断是否存在两个整数 a 和 b，使得 a² + b² = c 。 
//
// 
//
// 示例 1： 
//
// 
//输入：c = 5
//输出：true
//解释：1 * 1 + 2 * 2 = 5
// 
//
// 示例 2： 
//
// 
//输入：c = 3
//输出：false
// 
//
// 
//
// 提示： 
//
// 
// 0 <= c <= 2³¹ - 1 
// 
// Related Topics 数学 双指针 二分查找 👍 351 👎 0
	
  * 日期：2022-04-30 23:45:43
*/
//给定一个非负整数 c ，你要判断是否存在两个整数 a 和 b，使得 a² + b² = c 。 
//
// 
//
// 示例 1： 
//
// 
//输入：c = 5
//输出：true
//解释：1 * 1 + 2 * 2 = 5
// 
//
// 示例 2： 
//
// 
//输入：c = 3
//输出：false
// 
//
// 
//
// 提示： 
//
// 
// 0 <= c <= 2³¹ - 1 
// 
// Related Topics 数学 双指针 二分查找 👍 351 👎 0

package leetcode.editor.cn;
public class P633SumOfSquareNumbers {
    public static void main(String[] args) {
        Solution solution = new P633SumOfSquareNumbers().new Solution();


        //System.out.println("Hello world " + solution.);
        System.out.println("Hello world " + solution.judgeSquareSum(1000000));
        System.out.println("Hello world " + solution.judgeSquareSum(2147483600));
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean judgeSquareSum(int c) {


        int ss = (int)Math.sqrt(c);

        int l = 0; int r = ss + 1;

        while (l <= r) {

            long v = (long) l * l + (long)r * r;
            if (v == c) {
                return true;
            } else if (v > c) {
                r = r - 1;
            } else {
                l = l + 1;
            }

        }

        return false;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
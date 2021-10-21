/**
  * 题目Id：326
  * 题目：3的幂
  * 内容: //给定一个整数，写一个函数来判断它是否是 3 的幂次方。如果是，返回 true ；否则，返回 false 。 
//
// 整数 n 是 3 的幂次方需满足：存在整数 x 使得 n == 3x 
//
// 
//
// 示例 1： 
//
// 
//输入：n = 27
//输出：true
// 
//
// 示例 2： 
//
// 
//输入：n = 0
//输出：false
// 
//
// 示例 3： 
//
// 
//输入：n = 9
//输出：true
// 
//
// 示例 4： 
//
// 
//输入：n = 45
//输出：false
// 
//
// 
//
// 提示： 
//
// 
// -231 <= n <= 231 - 1 
// 
//
// 
//
// 进阶： 
//
// 
// 你能不使用循环或者递归来完成本题吗？ 
// 
// Related Topics 递归 数学 
// 👍 228 👎 0
	
  * 日期：2021-10-21 22:50:57
*/
//给定一个整数，写一个函数来判断它是否是 3 的幂次方。如果是，返回 true ；否则，返回 false 。 
//
// 整数 n 是 3 的幂次方需满足：存在整数 x 使得 n == 3x 
//
// 
//
// 示例 1： 
//
// 
//输入：n = 27
//输出：true
// 
//
// 示例 2： 
//
// 
//输入：n = 0
//输出：false
// 
//
// 示例 3： 
//
// 
//输入：n = 9
//输出：true
// 
//
// 示例 4： 
//
// 
//输入：n = 45
//输出：false
// 
//
// 
//
// 提示： 
//
// 
// -231 <= n <= 231 - 1 
// 
//
// 
//
// 进阶： 
//
// 
// 你能不使用循环或者递归来完成本题吗？ 
// 
// Related Topics 递归 数学 
// 👍 228 👎 0

package leetcode.editor.cn;
public class P3263的幂PowerOfThree {
    public static void main(String[] args) {
        Solution solution = new P3263的幂PowerOfThree().new Solution();

        boolean powerOfThree = solution.isPowerOfThree(9);

        System.out.println("Hello world" + powerOfThree);

        powerOfThree = solution.isPowerOfThree(45);

        System.out.println("Hello world" + powerOfThree);
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean isPowerOfThree(int n) {
        if (n == 0) {
            return false;
        }
        return dg(n);
    }
        private boolean dg(int n) {

            if (n == 1) {
                return true;
            }
            if (n % 3 != 0) {
                return false;
            } else {
                return dg(n / 3);
            }

        }
}
//leetcode submit region end(Prohibit modification and deletion)

} 
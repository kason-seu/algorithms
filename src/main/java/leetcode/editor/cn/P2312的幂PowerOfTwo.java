/**
  * 题目Id：231
  * 题目：2 的幂
  * 内容: //给你一个整数 n，请你判断该整数是否是 2 的幂次方。如果是，返回 true ；否则，返回 false 。 
//
// 如果存在一个整数 x 使得 n == 2x ，则认为 n 是 2 的幂次方。 
//
// 
//
// 示例 1： 
//
// 
//输入：n = 1
//输出：true
//解释：20 = 1
// 
//
// 示例 2： 
//
// 
//输入：n = 16
//输出：true
//解释：24 = 16
// 
//
// 示例 3： 
//
// 
//输入：n = 3
//输出：false
// 
//
// 示例 4： 
//
// 
//输入：n = 4
//输出：true
// 
//
// 示例 5： 
//
// 
//输入：n = 5
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
// 进阶：你能够不使用循环/递归解决此问题吗？ 
// Related Topics 位运算 递归 数学 
// 👍 417 👎 0
	
  * 日期：2021-10-21 22:05:18
*/
//给你一个整数 n，请你判断该整数是否是 2 的幂次方。如果是，返回 true ；否则，返回 false 。 
//
// 如果存在一个整数 x 使得 n == 2x ，则认为 n 是 2 的幂次方。 
//
// 
//
// 示例 1： 
//
// 
//输入：n = 1
//输出：true
//解释：20 = 1
// 
//
// 示例 2： 
//
// 
//输入：n = 16
//输出：true
//解释：24 = 16
// 
//
// 示例 3： 
//
// 
//输入：n = 3
//输出：false
// 
//
// 示例 4： 
//
// 
//输入：n = 4
//输出：true
// 
//
// 示例 5： 
//
// 
//输入：n = 5
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
// 进阶：你能够不使用循环/递归解决此问题吗？ 
// Related Topics 位运算 递归 数学 
// 👍 417 👎 0

package leetcode.editor.cn;
public class P2312的幂PowerOfTwo {
    public static void main(String[] args) {
        Solution solution = new P2312的幂PowerOfTwo().new Solution();
        boolean powerOfTwo = solution.isPowerOfTwo(4);
        System.out.println("Hello world" + powerOfTwo);


        powerOfTwo = solution.isPowerOfTwo(5);
        System.out.println("Hello world" + powerOfTwo);

        powerOfTwo = solution.isPowerOfTwo(8);
        System.out.println("Hello world" + powerOfTwo);
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean isPowerOfTwo(int n) {

        if (n == 0) {
            return false;
        }
        return dg(n);

    }

    private boolean dg(int n) {

        if (n == 1) {
            return true;
        }
        if (n % 2 != 0) {
            return false;
        } else {
            return dg(n >> 1);
        }

    }
}
//leetcode submit region end(Prohibit modification and deletion)

} 
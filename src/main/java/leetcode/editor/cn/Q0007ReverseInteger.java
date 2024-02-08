package leetcode.editor.cn;
/** * @author  kason * @date    2024-01-14 12:04:02 */public class Q0007ReverseInteger{    //给你一个 32 位的有符号整数 x ，返回将 x 中的数字部分反转后的结果。 
//
// 如果反转后整数超过 32 位的有符号整数的范围 [−2³¹, 231 − 1] ，就返回 0。 
//假设环境不允许存储 64 位整数（有符号或无符号）。
//
// 
//
// 示例 1： 
//
// 
//输入：x = 123
//输出：321
// 
//
// 示例 2： 
//
// 
//输入：x = -123
//输出：-321
// 
//
// 示例 3： 
//
// 
//输入：x = 120
//输出：21
// 
//
// 示例 4： 
//
// 
//输入：x = 0
//输出：0
// 
//
// 
//
// 提示： 
//
// 
// -2³¹ <= x <= 2³¹ - 1 
// 
//
// Related Topics 数学 👍 3952 👎 0
    public static void main(String[] args) {        Solution solution = new Q0007ReverseInteger().new Solution();

        System.out.println(Integer.MIN_VALUE);

    }    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int reverse(int x) {
        boolean neg = x < 0;
        x = neg ? x : -x;
        int m = Integer.MIN_VALUE / 10;
        int r = Integer.MIN_VALUE % 10;
        int res = 0;
        while (x != 0) {
            if (x < m || (x == m && x % 10 < r) ) {
                return 0;
            }
            res = res * 10 + x % 10;
            x = x / 10;
        }
        return neg ? res : -res;

    }
}
//leetcode submit region end(Prohibit modification and deletion)
}
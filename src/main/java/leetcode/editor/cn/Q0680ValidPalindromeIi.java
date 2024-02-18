package leetcode.editor.cn;
/** * @author  kason * @date    2024-02-17 21:57:59 */public class Q0680ValidPalindromeIi{    //给你一个字符串 s，最多 可以从中删除一个字符。 
//
// 请你判断 s 是否能成为回文字符串：如果能，返回 true ；否则，返回 false 。 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "aba"
//输出：true
// 
//
// 示例 2： 
//
// 
//输入：s = "abca"
//输出：true
//解释：你可以删除字符 'c' 。
// 
//
// 示例 3： 
//
// 
//输入：s = "abc"
//输出：false 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 10⁵ 
// s 由小写英文字母组成 
// 
//
// Related Topics 贪心 双指针 字符串 👍 631 👎 0
    public static void main(String[] args) {        Solution solution = new Q0680ValidPalindromeIi().new Solution();


        boolean ececabbacec = solution.validPalindrome("ececabbacec");
        System.out.println(ececabbacec);
    }    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean validPalindrome(String s) {
        int low = 0, high = s.length() - 1;
        while (low < high) {
            char c1 = s.charAt(low), c2 = s.charAt(high);
            if (c1 == c2) {
                ++low;
                --high;
            } else {
                return validPalindrome(s, low, high - 1) || validPalindrome(s, low + 1, high);
            }
        }
        return true;
    }

    public boolean validPalindrome(String s, int low, int high) {
        for (int i = low, j = high; i < j; ++i, --j) {
            char c1 = s.charAt(i), c2 = s.charAt(j);
            if (c1 != c2) {
                return false;
            }
        }
        return true;
    }


    public boolean validPalindromeDG(String s) {

        return dg(s, 0, s.length() - 1);
    }
    int change = 0;
    private boolean dg(String s, int start, int end) {

        if (start >= end) {
            return true;
        }

        if (s.charAt(start) == s.charAt(end)) {
            return dg(s, start + 1, end - 1 );
        } else {
            // 两种选择
            if (change == 0) {
                change++;
                boolean q1 = dg(s, start + 1, end);
                boolean q2 = dg(s, start, end - 1);

                return q1 || q2;
            } else {
                return false;
            }
        }

    }
}
//leetcode submit region end(Prohibit modification and deletion)
}
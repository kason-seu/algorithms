package leetcode.editor.cn;
/** * @author  kason * @date    2024-02-17 21:27:01 */public class Q0541ReverseStringIi{    //给定一个字符串 s 和一个整数 k，从字符串开头算起，每计数至 2k 个字符，就反转这 2k 字符中的前 k 个字符。 
//
// 
// 如果剩余字符少于 k 个，则将剩余字符全部反转。 
// 如果剩余字符小于 2k 但大于或等于 k 个，则反转前 k 个字符，其余字符保持原样。 
// 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "abcdefg", k = 2
//输出："bacdfeg"
// 
//
// 示例 2： 
//
// 
//输入：s = "abcd", k = 2
//输出："bacd"
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 10⁴ 
// s 仅由小写英文组成 
// 1 <= k <= 10⁴ 
// 
//
// Related Topics 双指针 字符串 👍 574 👎 0
    public static void main(String[] args) {        Solution solution = new Q0541ReverseStringIi().new Solution();    }    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String reverseStr(String s, int k) {

        int pos = 0;
        char[] values = s.toCharArray();
        while (pos < s.length()) {
            if ((s.length() - pos) >= 2 * k) {
                int j = 0;
                while (j <  k/2) {
                    char t = values[pos+j];
                    values[pos+j] = values[pos + k - j - 1];
                    values[pos + k - j - 1] = t;
                    j++;
                }
                pos = pos + 2 * k;
            } else if ((s.length() - pos ) < 2 * k && (s.length() - pos ) >= k) {
                int j = 0;
                while (j <  k/2) {
                    char t = values[pos+j];
                    values[pos+j] = values[pos + k - j - 1];
                    values[pos + k - j - 1] = t;
                    j++;
                }
                pos = pos + k;
                break;
            } else {
                int j = 0;
                while (j <  (s.length() - pos ) / 2   ) {
                    char t = values[pos+j];
                    values[pos+j] = values[s.length() - j - 1];
                    values[s.length() - j - 1] = t;
                    j++;
                }
                break;
            }
        }

        return new String(values);

    }
}
//leetcode submit region end(Prohibit modification and deletion)
}
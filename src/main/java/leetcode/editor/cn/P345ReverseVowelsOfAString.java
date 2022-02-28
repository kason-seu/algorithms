/**
  * 题目Id：345
  * 题目：反转字符串中的元音字母
  * 内容: //给你一个字符串 s ，仅反转字符串中的所有元音字母，并返回结果字符串。 
//
// 元音字母包括 'a'、'e'、'i'、'o'、'u'，且可能以大小写两种形式出现。 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "hello"
//输出："holle"
// 
//
// 示例 2： 
//
// 
//输入：s = "leetcode"
//输出："leotcede" 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 3 * 10⁵ 
// s 由 可打印的 ASCII 字符组成 
// 
// Related Topics 双指针 字符串 👍 239 👎 0
	
  * 日期：2022-02-26 00:13:58
*/
//给你一个字符串 s ，仅反转字符串中的所有元音字母，并返回结果字符串。 
//
// 元音字母包括 'a'、'e'、'i'、'o'、'u'，且可能以大小写两种形式出现。 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "hello"
//输出："holle"
// 
//
// 示例 2： 
//
// 
//输入：s = "leetcode"
//输出："leotcede" 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 3 * 10⁵ 
// s 由 可打印的 ASCII 字符组成 
// 
// Related Topics 双指针 字符串 👍 239 👎 0

package leetcode.editor.cn;
public class P345ReverseVowelsOfAString {
    public static void main(String[] args) {
        Solution solution = new P345ReverseVowelsOfAString().new Solution();

        String hello = solution.reverseVowels("hello");
        System.out.println(hello);
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String reverseVowels(String s) {

        int left = 0;
        int right = s.length() - 1;
        char[] chars = s.toCharArray();




        while (left < right) {
            while (left < right && !(chars[left] == 'a' || chars[left] == 'e' || chars[left] == 'i'
            || chars[left] == 'o' || chars[left] == 'u' || chars[left] == 'A' || chars[left] == 'E'
            || chars[left] == 'I' || chars[left] == 'O' || chars[left] == 'U')) {
                left++;
            }
            while (left < right && !(chars[right] == 'a' || chars[right] == 'e' || chars[right] == 'i'
                    || chars[right] == 'o' || chars[right] == 'u' || chars[right] == 'A' || chars[right] == 'E'
                    || chars[right] == 'I' || chars[right] == 'O' || chars[right] == 'U')) {
                right--;
            }

            swap(left,right, chars);
            left++;
            right--;

        }

        return new String(chars);

    }

        private void swap(int left, int right, char[] chars) {

        char temp = chars[left];
        chars[left] = chars[right];
        chars[right] = temp;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
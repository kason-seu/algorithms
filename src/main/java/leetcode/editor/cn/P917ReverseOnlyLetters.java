/**
  * 题目Id：917
  * 题目：仅仅反转字母
  * 内容: //给你一个字符串 s ，根据下述规则反转字符串： 
//
// 
// 所有非英文字母保留在原有位置。 
// 所有英文字母（小写或大写）位置反转。 
// 
//
// 返回反转后的 s 。 
//
// 
//
// 
// 
//
// 示例 1： 
//
// 
//输入：s = "ab-cd"
//输出："dc-ba"
// 
//
// 
// 
//
// 示例 2： 
//
// 
//输入：s = "a-bC-dEf-ghIj"
//输出："j-Ih-gfE-dCba"
// 
//
// 
// 
//
// 示例 3： 
//
// 
//输入：s = "Test1ng-Leet=code-Q!"
//输出："Qedo1ct-eeLg=ntse-T!"
// 
//
// 
//
// 提示 
//
// 
// 1 <= s.length <= 100 
// s 仅由 ASCII 值在范围 [33, 122] 的字符组成 
// s 不含 '\"' 或 '\\' 
// 
// Related Topics 双指针 字符串 👍 157 👎 0
	
  * 日期：2022-02-23 23:41:23
*/
//给你一个字符串 s ，根据下述规则反转字符串： 
//
// 
// 所有非英文字母保留在原有位置。 
// 所有英文字母（小写或大写）位置反转。 
// 
//
// 返回反转后的 s 。 
//
// 
//
// 
// 
//
// 示例 1： 
//
// 
//输入：s = "ab-cd"
//输出："dc-ba"
// 
//
// 
// 
//
// 示例 2： 
//
// 
//输入：s = "a-bC-dEf-ghIj"
//输出："j-Ih-gfE-dCba"
// 
//
// 
// 
//
// 示例 3： 
//
// 
//输入：s = "Test1ng-Leet=code-Q!"
//输出："Qedo1ct-eeLg=ntse-T!"
// 
//
// 
//
// 提示 
//
// 
// 1 <= s.length <= 100 
// s 仅由 ASCII 值在范围 [33, 122] 的字符组成 
// s 不含 '\"' 或 '\\' 
// 
// Related Topics 双指针 字符串 👍 157 👎 0

package leetcode.editor.cn;
public class P917ReverseOnlyLetters {
    public static void main(String[] args) {
        Solution solution = new P917ReverseOnlyLetters().new Solution();

        String s = solution.reverseOnlyLetters("7_28]");

        System.out.println(s);
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String reverseOnlyLetters(String s) {
        int length = s.length();
        char[] chars = s.toCharArray();

        int left = 0;
        int right = length - 1;
        while (left < right) {

            while (left < right && !Character.isLetter(chars[left])) {
                left++;
            }
            while (left < right && !Character.isLetter(chars[right])) {
                right--;
            }

                swap(left, right, chars);
                left++;
                right--;

        }

        return new String(chars);
    }

        private void swap(int left, int right, char[] chs) {

            char temp = chs[left];
            chs[left] = chs[right];
            chs[right] = temp;

        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
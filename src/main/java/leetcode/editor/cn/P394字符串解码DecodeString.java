/**
 * 题目Id：394
 * 题目：字符串解码
 * 内容: //给定一个经过编码的字符串，返回它解码后的字符串。
 * //
 * // 编码规则为: k[encoded_string]，表示其中方括号内部的 encoded_string 正好重复 k 次。注意 k 保证为正整数。
 * //
 * // 你可以认为输入字符串总是有效的；输入字符串中没有额外的空格，且输入的方括号总是符合格式要求的。
 * //
 * // 此外，你可以认为原始数据不包含数字，所有的数字只表示重复的次数 k ，例如不会出现像 3a 或 2[4] 的输入。
 * //
 * //
 * //
 * // 示例 1：
 * //
 * // 输入：s = "3[a]2[bc]"
 * //输出："aaabcbc"
 * //
 * //
 * // 示例 2：
 * //
 * // 输入：s = "3[a2[c]]"
 * //输出："accaccacc"
 * //
 * //
 * // 示例 3：
 * //
 * // 输入：s = "2[abc]3[cd]ef"
 * //输出："abcabccdcdcdef"
 * //
 * //
 * // 示例 4：
 * //
 * // 输入：s = "abc3[cd]xyz"
 * //输出："abccdcdcdxyz"
 * //
 * // Related Topics 栈 递归 字符串
 * // 👍 910 👎 0
 * <p>
 * 日期：2021-10-24 22:18:25
 */
//给定一个经过编码的字符串，返回它解码后的字符串。 
//
// 编码规则为: k[encoded_string]，表示其中方括号内部的 encoded_string 正好重复 k 次。注意 k 保证为正整数。 
//
// 你可以认为输入字符串总是有效的；输入字符串中没有额外的空格，且输入的方括号总是符合格式要求的。 
//
// 此外，你可以认为原始数据不包含数字，所有的数字只表示重复的次数 k ，例如不会出现像 3a 或 2[4] 的输入。 
//
// 
//
// 示例 1： 
//
// 输入：s = "3[a]2[bc]"
//输出："aaabcbc"
// 
//
// 示例 2： 
//
// 输入：s = "3[a2[c]]"
//输出："accaccacc"
// 
//
// 示例 3： 
//
// 输入：s = "2[abc]3[cd]ef"
//输出："abcabccdcdcdef"
// 
//
// 示例 4： 
//
// 输入：s = "abc3[cd]xyz"
//输出："abccdcdcdxyz"
// 
// Related Topics 栈 递归 字符串 
// 👍 910 👎 0

package leetcode.editor.cn;

public class P394字符串解码DecodeString {
    public static void main(String[] args) {
        Solution solution = new P394字符串解码DecodeString().new Solution();
        String s = "3[a2[c]]";

        String result = solution.decodeString(s);
        System.out.println("Hello world" + " " + result);


        s = "3[a]2[bc]";

        result = solution.decodeString(s);
        System.out.println("Hello world" + " " + result);


        s = "2[abc]3[cd]ef";

        result = solution.decodeString(s);
        System.out.println("Hello world" + " " + result);

        s = "abc3[cd]xyz";

        result = solution.decodeString(s);
        System.out.println("Hello world" + " " + result);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    // TODO  改题目的效率不高
    class Solution {
        public String decodeString(String s) {


            return dg(s, 0, "", -1);
        }

        private boolean flag = false;
        private int endIndex = -1;

        private String dg(String s, int iterIndex, String subStr, int digitStartIndex) {


            if (iterIndex == s.length()) {
                flag = true;
                return subStr + "";
            }

            if (s.charAt(iterIndex) == ']') {

                if (iterIndex <= s.length() - 1) {
                    flag = false;
                    endIndex = iterIndex + 1;
                } else {
                    flag = true;
                }
                return subStr;

            }

            if (s.charAt(iterIndex) >= '0' && s.charAt(iterIndex) <= '9') {

                return subStr + dg(s, iterIndex + 1, "", digitStartIndex != -1 ? digitStartIndex : iterIndex);

            }
            if (s.charAt(iterIndex) == '[') {
                int sum = 0;
                for (int i = digitStartIndex; i < iterIndex; i++) {
                    // 计算数字
                    sum = (s.charAt(i) - '0') + sum * 10;
                }

                // 循环递归获取所有的子集合
                String sRe = subStr;
                String littleS = dg(s, iterIndex + 1, "", -1);


                for (int i = 0; i < sum; i++) {

                    sRe = sRe + littleS;

                }
                if (false) {
                    return sRe;
                } else {
                    return sRe + dg(s, endIndex, "", -1);
                }
            }
            if (s.charAt(iterIndex) != '[' && s.charAt(iterIndex) != ']' && !(s.charAt(iterIndex) >= '0' && s.charAt(iterIndex) <= '9')) {
                return dg(s, iterIndex + 1, subStr + s.charAt(iterIndex), -1);
            }

            return "";

        }
    }
//leetcode submit region end(Prohibit modification and deletion)

} 
/**
 * 题目Id：859
 * 题目：亲密字符串
 * 内容: //给你两个字符串 s 和 goal ，只要我们可以通过交换 s 中的两个字母得到与 goal 相等的结果，就返回 true ；否则返回 false 。
 * //
 * // 交换字母的定义是：取两个下标 i 和 j （下标从 0 开始）且满足 i != j ，接着交换 s[i] 和 s[j] 处的字符。
 * //
 * //
 * // 例如，在 "abcd" 中交换下标 0 和下标 2 的元素可以生成 "cbad" 。
 * //
 * //
 * //
 * //
 * // 示例 1：
 * //
 * //
 * //输入：s = "ab", goal = "ba"
 * //输出：true
 * //解释：你可以交换 s[0] = 'a' 和 s[1] = 'b' 生成 "ba"，此时 s 和 goal 相等。
 * //
 * // 示例 2：
 * //
 * //
 * //输入：s = "ab", goal = "ab"
 * //输出：false
 * //解释：你只能交换 s[0] = 'a' 和 s[1] = 'b' 生成 "ba"，此时 s 和 goal 不相等。
 * //
 * // 示例 3：
 * //
 * //
 * //输入：s = "aa", goal = "aa"
 * //输出：true
 * //解释：你可以交换 s[0] = 'a' 和 s[1] = 'a' 生成 "aa"，此时 s 和 goal 相等。
 * //
 * //
 * // 示例 4：
 * //
 * //
 * //输入：s = "aaaaaaabc", goal = "aaaaaaacb"
 * //输出：true
 * //
 * //
 * //
 * //
 * // 提示：
 * //
 * //
 * // 1 <= s.length, goal.length <= 2 * 10⁴
 * // s 和 goal 由小写英文字母组成
 * //
 * // Related Topics 哈希表 字符串 👍 232 👎 0
 * <p>
 * 日期：2021-11-23 22:45:54
 */
//给你两个字符串 s 和 goal ，只要我们可以通过交换 s 中的两个字母得到与 goal 相等的结果，就返回 true ；否则返回 false 。 
//
// 交换字母的定义是：取两个下标 i 和 j （下标从 0 开始）且满足 i != j ，接着交换 s[i] 和 s[j] 处的字符。 
//
// 
// 例如，在 "abcd" 中交换下标 0 和下标 2 的元素可以生成 "cbad" 。 
// 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "ab", goal = "ba"
//输出：true
//解释：你可以交换 s[0] = 'a' 和 s[1] = 'b' 生成 "ba"，此时 s 和 goal 相等。 
//
// 示例 2： 
//
// 
//输入：s = "ab", goal = "ab"
//输出：false
//解释：你只能交换 s[0] = 'a' 和 s[1] = 'b' 生成 "ba"，此时 s 和 goal 不相等。 
//
// 示例 3： 
//
// 
//输入：s = "aa", goal = "aa"
//输出：true
//解释：你可以交换 s[0] = 'a' 和 s[1] = 'a' 生成 "aa"，此时 s 和 goal 相等。
// 
//
// 示例 4： 
//
// 
//输入：s = "aaaaaaabc", goal = "aaaaaaacb"
//输出：true
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length, goal.length <= 2 * 10⁴ 
// s 和 goal 由小写英文字母组成 
// 
// Related Topics 哈希表 字符串 👍 232 👎 0

package leetcode.editor.cn;

public class P859BuddyStrings {
    public static void main(String[] args) {
        Solution solution = new P859BuddyStrings().new Solution();

        boolean b = solution.buddyStrings("aa", "aa");
        System.out.println("Hello world" + b);


        b = solution.buddyStrings("ab", "ba");
        System.out.println("Hello world" + b);


        b = solution.buddyStrings("ab", "ab");
        System.out.println("Hello world" + b);

        b = solution.buddyStrings("aaaaaaabc", "aaaaaaacb");
        System.out.println("Hello world" + b);


        b = solution.buddyStrings("aaaaaaabc", "aaaaaaacbd");
        System.out.println("Hello world" + b);


        b = solution.buddyStrings("abab", "abab");
        System.out.println("Hello world" + b);

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean buddyStrings(String s, String goal) {

            if (s.length() <= 1 || goal.length() <= 1) {
                return false;
            }
            if (s.length() != goal.length()) {
                return false;
            }
            char left = '\0';
            char leftNotEqual = '\0';
            char right = '\0';
            char rightNotEqual = '\0';
            int record = 0;
            int[] result = new int[26];
            for (int i = 0; i < s.length(); i++) {

                if (s.charAt(i) != goal.charAt(i)) {
                    record++;
                    if (record == 1) {
                        left = s.charAt(i);
                        leftNotEqual = goal.charAt(i);
                    } else if (record == 2) {
                        right = s.charAt(i);
                        rightNotEqual = goal.charAt(i);
                    } else {
                        return false;
                    }
                } else {
                    result[s.charAt(i) - 'a']++;
                }

            }
            if (record == 2 && left == rightNotEqual && leftNotEqual == right) {
             return true;
            }
            if (record == 0 ) {
                for (int i : result) {
                    if ( i >= 2) {
                        return true;
                    }
                }
            }
            return false;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
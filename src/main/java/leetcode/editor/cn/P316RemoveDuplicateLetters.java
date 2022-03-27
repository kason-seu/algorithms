/**
  * 题目Id：316
  * 题目：去除重复字母
  * 内容: //给你一个字符串 s ，请你去除字符串中重复的字母，使得每个字母只出现一次。需保证 返回结果的字典序最小（要求不能打乱其他字符的相对位置）。 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "bcabc"
//输出："abc"
// 
//
// 示例 2： 
//
// 
//输入：s = "cbacdcbc"
//输出："acdb" 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 10⁴ 
// s 由小写英文字母组成 
// 
//
// 
//
// 注意：该题与 1081 https://leetcode-cn.com/problems/smallest-subsequence-of-
//distinct-characters 相同 
// Related Topics 栈 贪心 字符串 单调栈 👍 693 👎 0
	
  * 日期：2022-03-27 12:51:26
*/
//给你一个字符串 s ，请你去除字符串中重复的字母，使得每个字母只出现一次。需保证 返回结果的字典序最小（要求不能打乱其他字符的相对位置）。 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "bcabc"
//输出："abc"
// 
//
// 示例 2： 
//
// 
//输入：s = "cbacdcbc"
//输出："acdb" 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 10⁴ 
// s 由小写英文字母组成 
// 
//
// 
//
// 注意：该题与 1081 https://leetcode-cn.com/problems/smallest-subsequence-of-
//distinct-characters 相同 
// Related Topics 栈 贪心 字符串 单调栈 👍 693 👎 0

package leetcode.editor.cn;



import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class P316RemoveDuplicateLetters {
    public static void main(String[] args) {
        Solution solution = new P316RemoveDuplicateLetters().new Solution();
        //String s = "bbcaac";
        String s = "bcabc";
        //s = "abacb";
        System.out.println("Hello world :  " + solution.removeDuplicateLetters(s));

        s = "cbacdcbc";
        System.out.println("Hello world :  " + solution.removeDuplicateLetters(s));

        s = "abacb";
        System.out.println("Hello world :  " + solution.removeDuplicateLetters(s));
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String removeDuplicateLetters(String s) {

        Map<Character, Integer> letterCntMap = new HashMap<>();
        Map<Character, Boolean> status = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {

            if (letterCntMap.containsKey(s.charAt(i))) {
                letterCntMap.put(s.charAt(i), letterCntMap.get(s.charAt(i))+1);
            } else {
                letterCntMap.put(s.charAt(i), 1);
            }
        }
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            // 针对一个新的值，之前还没进过栈，那么该值要看看是否比之前的值要小，小则弹出处理
            if (status.get(s.charAt(i)) == null || !status.get(s.charAt(i))) {
                while (!stack.isEmpty()) {
                    Character top = stack.peek();
                    // 当前的值更小，之前的栈里的元素要看看是否要弹出
                    if (s.charAt(i) < top) {
                        if (letterCntMap.get(top) > 1) {
                            // 扔掉一个，后面还有
                            letterCntMap.put(top, letterCntMap.get(top) - 1);
                            status.put(top, false);
                            stack.pop();
                        } else {
                            break;
                        }
                    } else if (s.charAt(i) == stack.peek()) {
                        letterCntMap.put(top, letterCntMap.get(top) - 1);
                        break;
                    } else {
                        break;
                    }
                }
                stack.push(s.charAt(i));
                status.put(s.charAt(i), true);
            } else {
                letterCntMap.put(s.charAt(i), letterCntMap.get(s.charAt(i)) - 1);
            }

        }

        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        return sb.reverse().toString();

    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
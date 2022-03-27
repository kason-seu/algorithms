/**
  * 题目Id：402
  * 题目：移掉 K 位数字
  * 内容: //给你一个以字符串表示的非负整数 num 和一个整数 k ，移除这个数中的 k 位数字，使得剩下的数字最小。请你以字符串形式返回这个最小的数字。 
// 
//
// 示例 1 ： 
//
// 
//输入：num = "1432219", k = 3
//输出："1219"
//解释：移除掉三个数字 4, 3, 和 2 形成一个新的最小的数字 1219 。
// 
//
// 示例 2 ： 
//
// 
//输入：num = "10200", k = 1
//输出："200"
//解释：移掉首位的 1 剩下的数字为 200. 注意输出不能有任何前导零。
// 
//
// 示例 3 ： 
//
// 
//输入：num = "10", k = 2
//输出："0"
//解释：从原数字移除所有的数字，剩余为空就是 0 。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= k <= num.length <= 10⁵ 
// num 仅由若干位数字（0 - 9）组成 
// 除了 0 本身之外，num 不含任何前导零 
// 
// Related Topics 栈 贪心 字符串 单调栈 👍 758 👎 0
	
  * 日期：2022-03-27 17:20:09
*/
//给你一个以字符串表示的非负整数 num 和一个整数 k ，移除这个数中的 k 位数字，使得剩下的数字最小。请你以字符串形式返回这个最小的数字。 
// 
//
// 示例 1 ： 
//
// 
//输入：num = "1432219", k = 3
//输出："1219"
//解释：移除掉三个数字 4, 3, 和 2 形成一个新的最小的数字 1219 。
// 
//
// 示例 2 ： 
//
// 
//输入：num = "10200", k = 1
//输出："200"
//解释：移掉首位的 1 剩下的数字为 200. 注意输出不能有任何前导零。
// 
//
// 示例 3 ： 
//
// 
//输入：num = "10", k = 2
//输出："0"
//解释：从原数字移除所有的数字，剩余为空就是 0 。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= k <= num.length <= 10⁵ 
// num 仅由若干位数字（0 - 9）组成 
// 除了 0 本身之外，num 不含任何前导零 
// 
// Related Topics 栈 贪心 字符串 单调栈 👍 758 👎 0

package leetcode.editor.cn;

import java.util.Stack;

public class P402RemoveKDigits {
    public static void main(String[] args) {
        Solution solution = new P402RemoveKDigits().new Solution();

        String s = solution.removeKdigits("1432219", 3);

        System.out.println("ans " + s);
        s = solution.removeKdigits("10200", 1);

        System.out.println("ans " + s);

        s = solution.removeKdigits("1223459", 3);

        System.out.println("ans " + s);


        s = solution.removeKdigits("100", 1);

        System.out.println("ans " + s);
        System.out.println("Hello world");
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String removeKdigits(String num, int k) {

        if (k >= num.length()) {
            return "0";
        }
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < num.length(); i++) {
            if (stack.isEmpty() || k == 0) {
                stack.push(num.charAt(i));
            } else {
                if (num.charAt(i) < stack.peek() ) {
                    while (!stack.empty() && num.charAt(i) < stack.peek() && k > 0) {
                        stack.pop();
                        k--;
                    }
                }
                stack.push(num.charAt(i));
            }
        }
        while (k > 0 ) {
            stack.pop();
            k--;
        }

        StringBuilder sb = new StringBuilder();
        while (!stack.empty()) {
            sb.append(stack.pop());
        }

        String ans = sb.reverse().toString();

        if (ans.isEmpty()) {
            return "0";
        }
        boolean startZero = ans.charAt(0) == '0';
        if (!startZero) {
            return ans;
        }
        for (int i = 1; i < ans.length(); i++) {
            if (ans.charAt(i) != '0') {
                return ans.substring(i);
            }
        }
        return "0";


    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
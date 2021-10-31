/**
  * 题目Id：241
  * 题目：为运算表达式设计优先级
  * 内容: //给定一个含有数字和运算符的字符串，为表达式添加括号，改变其运算优先级以求出不同的结果。你需要给出所有可能的组合的结果。有效的运算符号包含 +, - 以及 *
// 。 
//
// 示例 1: 
//
// 输入: "2-1-1"
//输出: [0, 2]
//解释: 
//((2-1)-1) = 0 
//(2-(1-1)) = 2 
//
// 示例 2: 
//
// 输入: "2*3-4*5"
//输出: [-34, -14, -10, -10, 10]
//解释: 
//(2*(3-(4*5))) = -34 
//((2*3)-(4*5)) = -14 
//((2*(3-4))*5) = -10 
//(2*((3-4)*5)) = -10 
//(((2*3)-4)*5) = 10 
// Related Topics 递归 记忆化搜索 数学 字符串 动态规划 
// 👍 451 👎 0
	
  * 日期：2021-10-25 23:32:19
*/
//给定一个含有数字和运算符的字符串，为表达式添加括号，改变其运算优先级以求出不同的结果。你需要给出所有可能的组合的结果。有效的运算符号包含 +, - 以及 *
// 。 
//
// 示例 1: 
//
// 输入: "2-1-1"
//输出: [0, 2]
//解释: 
//((2-1)-1) = 0 
//(2-(1-1)) = 2 
//
// 示例 2: 
//
// 输入: "2*3-4*5"
//输出: [-34, -14, -10, -10, 10]
//解释: 
//(2*(3-(4*5))) = -34 
//((2*3)-(4*5)) = -14 
//((2*(3-4))*5) = -10 
//(2*((3-4)*5)) = -10 
//(((2*3)-4)*5) = 10 
// Related Topics 递归 记忆化搜索 数学 字符串 动态规划 
// 👍 451 👎 0

package leetcode.editor.cn;

import java.util.List;

public class P241为运算表达式设计优先级DifferentWaysToAddParentheses {
    public static void main(String[] args) {
        Solution solution = new P241为运算表达式设计优先级DifferentWaysToAddParentheses().new Solution();
        System.out.println("Hello world");
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<Integer> diffWaysToCompute(String expression) {

        return null;

    }

    private int dg(String expression, int quotaNum, int usedQuota, List<Integer> result) {


        if (usedQuota > quotaNum) {
            return 0;
        }
        StringBuilder sb = new StringBuilder();
        Character c = null;
        int i = 0;
        while(i < expression.length()) {
            if (expression.charAt(i) >= '0' && expression.charAt(i) <= '9') {
                sb.append(expression.charAt(i));
                i++;
            } else {
                c = expression.charAt(i);
                break;
            }
        }
        int num = Integer.parseInt(sb.toString());
        if (c == '+') {
            int s1 = num + dg(expression.substring(i + 1), quotaNum, usedQuota+1, result);

        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

} 
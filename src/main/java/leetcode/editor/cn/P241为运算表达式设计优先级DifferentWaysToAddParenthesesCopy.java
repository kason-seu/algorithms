/**
 * 题目Id：241
 * 题目：为运算表达式设计优先级
 * 内容: //给定一个含有数字和运算符的字符串，为表达式添加括号，改变其运算优先级以求出不同的结果。你需要给出所有可能的组合的结果。有效的运算符号包含 +, - 以及 *
 * // 。
 * //
 * // 示例 1:
 * //
 * // 输入: "2-1-1"
 * //输出: [0, 2]
 * //解释:
 * //((2-1)-1) = 0
 * //(2-(1-1)) = 2
 * //
 * // 示例 2:
 * //
 * // 输入: "2*3-4*5"
 * //输出: [-34, -14, -10, -10, 10]
 * //解释:
 * //(2*(3-(4*5))) = -34
 * //((2*3)-(4*5)) = -14
 * //((2*(3-4))*5) = -10
 * //(2*((3-4)*5)) = -10
 * //(((2*3)-4)*5) = 10
 * // Related Topics 递归 记忆化搜索 数学 字符串 动态规划
 * // 👍 451 👎 0
 * <p>
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

import java.util.ArrayList;
import java.util.List;

public class P241为运算表达式设计优先级DifferentWaysToAddParenthesesCopy {
    public static void main(String[] args) {
        Solution solution = new P241为运算表达式设计优先级DifferentWaysToAddParenthesesCopy().new Solution();
        String express = "2*3-4*5";
        List<Integer> integers = solution.diffWaysToCompute(express);

        for(int s : integers) {
            System.out.println(s);
        }
        System.out.println("Hello world" + integers);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<Integer> diffWaysToCompute(String expression) {
            int i = 0;
            int quotaNum= 0;
            while (i < expression.length()) {
                if (expression.charAt(i) >= '0' && expression.charAt(i) <= '9') {
                } else {
                    quotaNum++;
                }
                i++;
            }
            return dg(expression, quotaNum, 0);

        }

        private List<Integer> dg(String expression, int quotaNum, int usedQuota) {


            if (usedQuota >= quotaNum) {
                int re = Integer.parseInt(expression);
                List<Integer> result = new ArrayList<>();
                result.add(re);
                return result;
            }
            StringBuilder sb = new StringBuilder();
            Character c = null;
            int i = 0;
            boolean flag = false;
            if (expression.startsWith("-")) {
                flag = true;
                i = i + 1;
            }
            while (i < expression.length()) {
                if (expression.charAt(i) >= '0' && expression.charAt(i) <= '9') {
                    sb.append(expression.charAt(i));
                    i++;
                } else {
                    c = expression.charAt(i);
                    break;
                }
            }
            int num = flag? - 1 * Integer.parseInt(sb.toString()) : Integer.parseInt(sb.toString());
            //if (c == '+') {
            List<Integer> result = new ArrayList<>();
            List<Integer> dg = dg(expression.substring(i + 1), quotaNum, usedQuota + 1);


            switch (c) {
                case '+':
                    for (int ri : dg) {
                        result.add(ri + num);
                    }
                    break;
                case '-':
                    for (int ri : dg) {
                        result.add(num - ri);
                    }
                    break;
                case '*':
                    for (int ri : dg) {
                        result.add(num * ri);
                    }
                    break;
            }


            if (usedQuota < quotaNum) {
                // find next
                sb = new StringBuilder();
                i = i + 1;
                while (i < expression.length()) {
                    if (expression.charAt(i) >= '0' && expression.charAt(i) <= '9') {
                        sb.append(expression.charAt(i));
                        i++;
                    } else {
                        break;
                    }
                }
                int nextNum = Integer.parseInt(sb.toString());
                int newNum = 0;
                switch (c) {
                    case '+':
                        newNum = num + nextNum;
                        break;
                    case '-':
                        newNum = num - nextNum;
                        break;
                    case '*':
                        newNum = num * nextNum;
                        break;
                }

                List<Integer> dg1 = dg(newNum + expression.substring(i), quotaNum, usedQuota + 1);
                result.addAll(dg1);
            }

            return result;
            //}
        }


    }
//leetcode submit region end(Prohibit modification and deletion)

} 
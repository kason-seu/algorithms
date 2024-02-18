package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

/** * @author  kason * @date    2024-02-16 21:08:00 */public class Q0241DifferentWaysToAddParentheses{    //给你一个由数字和运算符组成的字符串 expression ，按不同优先级组合数字和运算符，计算并返回所有可能组合的结果。你可以 按任意顺序 返回答案。
//
// 生成的测试用例满足其对应输出值符合 32 位整数范围，不同结果的数量不超过 10⁴ 。 
//
// 
//
// 示例 1： 
//
// 
//输入：expression = "2-1-1"
//输出：[0,2]
//解释：
//((2-1)-1) = 0 
//(2-(1-1)) = 2
// 
//
// 示例 2： 
//
// 
//输入：expression = "2*3-4*5"
//输出：[-34,-14,-10,-10,10]
//解释：
//(2*(3-(4*5))) = -34 
//((2*3)-(4*5)) = -14 
//((2*(3-4))*5) = -10 
//(2*((3-4)*5)) = -10 
//(((2*3)-4)*5) = 10
// 
//
// 
//
// 提示： 
//
// 
// 1 <= expression.length <= 20 
// expression 由数字和算符 '+'、'-' 和 '*' 组成。 
// 输入表达式中的所有整数值在范围 [0, 99] 
// 
//
// Related Topics 递归 记忆化搜索 数学 字符串 动态规划 👍 872 👎 0
    public static void main(String[] args) {        Solution solution =

            new Q0241DifferentWaysToAddParentheses().new Solution();

            List<Integer> re = solution.diffWaysToCompute("2 * 3 - 4 * 5");
        System.out.println(re);

    }    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<Integer> diffWaysToCompute(String expression) {
        List<Integer> expressionsValues = new ArrayList<>();
        build(expressionsValues, expression);
        return expressionsValues;
    }

    private void calculate(List<Integer> expressionsValues, int start, List<Integer> ans, int value) {


        Integer leftValue = expressionsValues.get(start);
        if (start + 2 < expressionsValues.size()) {
            Integer rightValue = expressionsValues.get(start + 2);
            Integer op = expressionsValues.get(start + 1);
            switch (op) {
                case -1 :

            }
        }

    }
    private void build(List<Integer> expressionsValues, String expression) {
        int i = 0;
        while (i < expression.length()) {

            if (!Character.isDigit(expression.charAt(i))) {
                switch (expression.charAt(i)) {
                    case '+' :
                        expressionsValues.add(-1);
                        break;
                    case '-':
                        expressionsValues.add(-2);
                        break;
                    case '*':
                        expressionsValues.add(-3);
                        break;
                }
                i++;
            } else {
                int v =  0;
                while (i < expression.length() && Character.isDigit(expression.charAt(i))) {
                    v = v * 10 + (expression.charAt(i) - '0');
                    i++;
                }
                expressionsValues.add(v);
            }
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
}
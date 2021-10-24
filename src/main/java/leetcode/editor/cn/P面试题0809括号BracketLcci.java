/**
  * 题目Id：面试题 08.09
  * 题目：括号
  * 内容: //括号。设计一种算法，打印n对括号的所有合法的（例如，开闭一一对应）组合。 
//
// 说明：解集不能包含重复的子集。 
//
// 例如，给出 n = 3，生成结果为： 
//
// 
//[
//  "((()))",
//  "(()())",
//  "(())()",
//  "()(())",
//  "()()()"
//]
// 
// Related Topics 字符串 动态规划 回溯 
// 👍 93 👎 0
	
  * 日期：2021-10-23 19:05:58
*/
//括号。设计一种算法，打印n对括号的所有合法的（例如，开闭一一对应）组合。 
//
// 说明：解集不能包含重复的子集。 
//
// 例如，给出 n = 3，生成结果为： 
//
// 
//[
//  "((()))",
//  "(()())",
//  "(())()",
//  "()(())",
//  "()()()"
//]
// 
// Related Topics 字符串 动态规划 回溯 
// 👍 93 👎 0

package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

public class P面试题0809括号BracketLcci {
    public static void main(String[] args) {
        Solution solution = new P面试题0809括号BracketLcci().new Solution();
        List<String> strings = solution.generateParenthesis(3);

        strings.forEach(System.out::println);

        System.out.println("Hello world");

        strings = solution.generateParenthesis(1);

        strings.forEach(System.out::println);
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<String> generateParenthesis(int n) {

        if (n <= 0) {
            return new ArrayList<>();
        }
        List<String> re = new ArrayList<>();
        dg(n,0,0, "", re);

        return re;

    }

    private void dg(int n, int leftSize, int rightSize, String s, List<String> result) {

        if (leftSize == n  && rightSize == n ) {
            result.add(s);
            return ;
        }


        if (leftSize == 0) {  // 一开始必须(开始
            dg(n,1, rightSize, "(", result);

        } else {

            if (leftSize < n && rightSize < n) {
                dg(n, leftSize + 1, rightSize, s + "(", result);
            }

            if (rightSize < n && rightSize < leftSize) {
                dg(n, leftSize, rightSize + 1, s + ")", result);
            }
        }

    }
}
//leetcode submit region end(Prohibit modification and deletion)

} 
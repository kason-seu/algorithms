//Given a string S of lowercase letters, a duplicate removal consists of choosin
//g two adjacent and equal letters, and removing them. 
//
// We repeatedly make duplicate removals on S until we no longer can. 
//
// Return the final string after all such duplicate removals have been made. It 
//is guaranteed the answer is unique. 
//
// 
//
// Example 1: 
//
// 
//Input: "abbaca"
//Output: "ca"
//Explanation: 
//For example, in "abbaca" we could remove "bb" since the letters are adjacent a
//nd equal, and this is the only possible move.  The result of this move is that t
//he string is "aaca", of which only "aa" is possible, so the final string is "ca"
//.
// 
//
// 
//
// Note: 
//
// 
// 1 <= S.length <= 20000 
// S consists only of English lowercase letters. 
// Related Topics Stack 
// 👍 1000 👎 76

package leetcode.editor.en;
//Java：Remove All Adjacent Duplicates In String

import java.util.Stack;

public class P1047RemoveAllAdjacentDuplicatesInString {
    public static void main(String[] args) {
        Solution solution = new P1047RemoveAllAdjacentDuplicatesInString().new Solution();
        String s = "abbaca";
        System.out.println(solution.removeDuplicates(s));
        // "azxxzy
        s = "azxxzy";
        System.out.println(solution.removeDuplicates(s));
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {


        public String removeDuplicates(String S) {
            Stack<Character> stack = new Stack<>();
            for (int i = 0; i < S.length(); i++) {
                if (stack.empty()) {
                    stack.push(S.charAt(i));
                } else {
                    Character peek = stack.peek();
                    if (peek == S.charAt(i)) {
                        stack.pop();
                    } else {
                        stack.push(S.charAt(i));
                    }

                }
            }
            if (stack.empty()) {
                return "";
            } else {
                StringBuilder sb = new StringBuilder();
                for (int i = 0; i < stack.size(); i++) {
                    sb.append(stack.get(i));
                }
                return sb.toString();
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
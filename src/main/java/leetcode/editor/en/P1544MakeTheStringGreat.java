//Given a string s of lower and upper case English letters. 
//
// A good string is a string which doesn't have two adjacent characters s[i] and
// s[i + 1] where: 
//
// 
// 0 <= i <= s.length - 2 
// s[i] is a lower-case letter and s[i + 1] is the same letter but in upper-case
// or vice-versa. 
// 
//
// To make the string good, you can choose two adjacent characters that make the
// string bad and remove them. You can keep doing this until the string becomes go
//od. 
//
// Return the string after making it good. The answer is guaranteed to be unique
// under the given constraints. 
//
// Notice that an empty string is also good. 
//
// 
// Example 1: 
//
// 
//Input: s = "leEeetcode"
//Output: "leetcode"
//Explanation: In the first step, either you choose i = 1 or i = 2, both will re
//sult "leEeetcode" to be reduced to "leetcode".
// 
//
// Example 2: 
//
// 
//Input: s = "abBAcC"
//Output: ""
//Explanation: We have many possible scenarios, and all lead to the same answer.
// For example:
//"abBAcC" --> "aAcC" --> "cC" --> ""
//"abBAcC" --> "abBA" --> "aA" --> ""
// 
//
// Example 3: 
//
// 
//Input: s = "s"
//Output: "s"
// 
//
// 
// Constraints: 
//
// 
// 1 <= s.length <= 100 
// s contains only lower and upper case English letters. 
// Related Topics String Stack 
// 👍 197 👎 25

package leetcode.editor.en;
//Java：Make The String Great

import java.util.Stack;

public class P1544MakeTheStringGreat {
    public static void main(String[] args) {
        Solution solution = new P1544MakeTheStringGreat().new Solution();
        System.out.println(solution.makeGood("abBAcC"));
        System.out.println(solution.makeGood("leEeetcode"));
        System.out.println(solution.makeGood("Pp"));
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String makeGood(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if (stack.empty()) {
                stack.push(s.charAt(i));
            } else {
                Character peek = stack.peek();
                if (s.charAt(i) == peek  - 32 || s.charAt(i) == peek  + 32) {
                    stack.pop();
                } else {
                    stack.push(s.charAt(i));
                }
            }
        }
        StringBuilder sb = new StringBuilder("");
        while (!stack.empty()) {
            sb.append(stack.pop());
        }
        return sb.reverse().toString();
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
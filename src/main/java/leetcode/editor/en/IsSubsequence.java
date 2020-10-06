//Given a string s and a string t, check if s is subsequence of t. 
//
// A subsequence of a string is a new string which is formed from the original s
//tring by deleting some (can be none) of the characters without disturbing the re
//lative positions of the remaining characters. (ie, "ace" is a subsequence of "ab
//cde" while "aec" is not). 
//
// Follow up: 
//If there are lots of incoming S, say S1, S2, ... , Sk where k >= 1B, and you w
//ant to check one by one to see if T has its subsequence. In this scenario, how w
//ould you change your code? 
//
// Credits: 
//Special thanks to @pbrother for adding this problem and creating all test case
//s. 
//
// 
// Example 1: 
// Input: s = "abc", t = "ahbgdc"
//Output: true
// Example 2: 
// Input: s = "axc", t = "ahbgdc"
//Output: false
// 
// 
// Constraints: 
//
// 
// 0 <= s.length <= 100 
// 0 <= t.length <= 10^4 
// Both strings consists only of lowercase characters. 
// 
// Related Topics Binary Search Dynamic Programming Greedy 
// 👍 1805 👎 213

package leetcode.editor.en;
//Java：Is Subsequence

import java.util.Arrays;

public class IsSubsequence {
    public static void main(String[] args) {
        Solution solution = new IsSubsequence().new Solution();

        System.out.println(solution.isSubsequence("abc", "ahbgdc"));
        System.out.println(solution.isSubsequence("acb", "ahbgdc"));
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean isSubsequence(String s, String t) {

        int sPos = s.length() - 1;
        int tPos = t.length() - 1;
        while (sPos >= 0 && tPos >= 0) {
            if (s.charAt(sPos) == t.charAt(tPos)) {
                sPos--;
                tPos--;
            } else {
                tPos--;
            }
        }
        if (sPos == -1) {
            return true;
        } else {
            return false;
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
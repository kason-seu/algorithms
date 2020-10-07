//Given two strings S and T, return if they are equal when both are typed into e
//mpty text editors. # means a backspace character. 
//
// Note that after backspacing an empty text, the text will continue empty. 
//
// 
// Example 1: 
//
// 
//Input: S = "ab#c", T = "ad#c"
//Output: true
//Explanation: Both S and T become "ac".
// 
//
// 
// Example 2: 
//
// 
//Input: S = "ab##", T = "c#d#"
//Output: true
//Explanation: Both S and T become "".
// 
//
// 
// Example 3: 
//
// 
//Input: S = "a##c", T = "#a#c"
//Output: true
//Explanation: Both S and T become "c".
// 
//
// 
// Example 4: 
//
// 
//Input: S = "a#c", T = "b"
//Output: false
//Explanation: S becomes "c" while T becomes "b".
// 
//
// Note: 
//
// 
// 1 <= S.length <= 200 
// 1 <= T.length <= 200 
// S and T only contain lowercase letters and '#' characters. 
// 
//
// Follow up: 
//
// 
// Can you solve it in O(N) time and O(1) space? 
// 
// 
// 
// 
// 
// Related Topics Two Pointers Stack 
// 👍 1935 👎 97

package leetcode.editor.en;
//Java：Backspace String Compare

import java.util.Stack;

public class P844BackspaceStringCompare {
    public static void main(String[] args) {
        Solution solution = new P844BackspaceStringCompare().new Solution();
        String s = "a#c";
        String t = "b";
        System.out.println(solution.backspaceCompare(s, t));
        System.out.println("____");
        s = "a##c";
        t = "#a#c";
        System.out.println(solution.backspaceCompare(s, t));
        System.out.println("____");
        // "xywrrmp" "xywrrm#p
        s = "xywrrmp";
        t = "xywrrm#p";
        System.out.println(solution.backspaceCompare(s, t));
        System.out.println("____");
        // "bxj##tw" "bxj###tw"
        s = "bxj##tw";
        t = "bxj###tw";
        System.out.println(solution.backspaceCompare(s, t));
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
        /**
         * 双指针
         * @param S
         * @param T
         * @return
         */
    public boolean backspaceCompare(String S, String T) {
        //
        int s1Len = S.length() - 1;
        int tLen = T.length() - 1;
        int skipS = 0;
        int skipT = 0;
        while (s1Len >= 0 || tLen >= 0) {
            while (s1Len >= 0) {
                if (S.charAt(s1Len) == '#') {
                    skipS++;
                    s1Len--;
                } else if (skipS > 0) {
                    skipS--;
                    s1Len--;
                } else {
                    break;
                }
            }
            while (tLen >= 0) {
                if (T.charAt(tLen) == '#') {
                    skipT++;
                    tLen--;
                } else if (skipT > 0) {
                    skipT--;
                    tLen--;
                } else {
                    break;
                }
            }
            if (s1Len >= 0 && tLen >= 0 && S.charAt(s1Len) != T.charAt(tLen)) {
                return false;
            }
            if ((s1Len >=0 && tLen < 0) || (s1Len <0 && tLen >= 0) ) {
                return false;
            }
            s1Len--;
            tLen--;
        }
        return true;
    }

        /**
         * 栈方法
         * @param S
         * @param T
         * @return
         */
        public boolean backspaceCompare2(String S, String T) {
            Stack<Character> s1 = new Stack<>();
            Stack<Character> t1 = new Stack<>();
            for (int i = 0; i < S.length(); i++) {
                if (S.charAt(i) == '#') {
                    if (!s1.empty()) {
                        s1.pop();
                    }
                } else {
                    s1.push(S.charAt(i));
                }
            }

            for (int i = 0; i < T.length(); i++) {
                if (T.charAt(i) == '#') {
                    if (!t1.empty()) {
                        t1.pop();
                    }
                } else {
                    t1.push(T.charAt(i));
                }
            }

            if (s1.size() != t1.size()) {
                return false;
            } else {
                while (!s1.empty()) {
                    Character pop = s1.pop();

                    Character pop1 = t1.pop();

                    if (pop != pop1) {
                        return false;
                    }


                }
            }
            return true;
        }
}
//leetcode submit region end(Prohibit modification and deletion)

}
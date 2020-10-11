//Given two strings s and t, determine if they are isomorphic. 
//
// Two strings are isomorphic if the characters in s can be replaced to get t. 
//
// All occurrences of a character must be replaced with another character while 
//preserving the order of characters. No two characters may map to the same charac
//ter but a character may map to itself. 
//
// Example 1: 
//
// 
//Input: s = "egg", t = "add"
//Output: true
// 
//
// Example 2: 
//
// 
//Input: s = "foo", t = "bar"
//Output: false 
//
// Example 3: 
//
// 
//Input: s = "paper", t = "title"
//Output: true 
//
// Note: 
//You may assume both s and t have the same length. 
// Related Topics Hash Table 
// 👍 1588 👎 392

package leetcode.editor.en;
//Java：Isomorphic Strings

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class P205IsomorphicStrings {
    public static void main(String[] args) {
        Solution solution = new P205IsomorphicStrings().new Solution();
        String s= "aa";
        String t = "ab";
        System.out.println(solution.isIsomorphic(s,t));
        s= "egg";
        t = "add";
        System.out.println(solution.isIsomorphic(s,t));
        s= "13";
        t = "42";
        System.out.println(solution.isIsomorphic(s,t));
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean isIsomorphic(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        int[] map = new int[128];
        Arrays.fill(map, -1);
        int[] count = new int[128];

        for (int i = 0; i < s.length(); i++) {
            if (map[s.charAt(i)] == -1) {
                map[s.charAt(i)] = t.charAt(i);
                count[t.charAt(i)] ++;
                if (count[t.charAt(i)] > 1) {
                    return false;
                }
            } else {
                if (map[s.charAt(i)] != (t.charAt(i))) {
                    return false;
                }
            }
        }
       return true;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
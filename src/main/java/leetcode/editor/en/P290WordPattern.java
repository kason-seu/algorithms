//Given a pattern and a string s, find if s follows the same pattern. 
//
// Here follow means a full match, such that there is a bijection between a lett
//er in pattern and a non-empty word in s. 
//
// 
// Example 1: 
//
// 
//Input: pattern = "abba", s = "dog cat cat dog"
//Output: true
// 
//
// Example 2: 
//
// 
//Input: pattern = "abba", s = "dog cat cat fish"
//Output: false
// 
//
// Example 3: 
//
// 
//Input: pattern = "aaaa", s = "dog cat cat dog"
//Output: false
// 
//
// Example 4: 
//
// 
//Input: pattern = "abba", s = "dog dog dog dog"
//Output: false
// 
//
// 
// Constraints: 
//
// 
// 1 <= pattern.length <= 300 
// pattern contains only lower-case English letters. 
// 1 <= s.length <= 3000 
// s contains only lower-case English letters and spaces ' '. 
// s does not contain any leading or trailing spaces. 
// All the words in s are separated by a single space. 
// 
// Related Topics Hash Table 
// 👍 1486 👎 190

package leetcode.editor.en;
//Java：Word Pattern

import java.util.HashMap;
import java.util.Map;

public class P290WordPattern {
    public static void main(String[] args) {
        Solution solution = new P290WordPattern().new Solution();
        String pattern = "abba";
        String s = "dog cat cat dog";
        System.out.println(solution.wordPattern(pattern, s));

        pattern = "abba";
        s = "dog dog dog dog";
        System.out.println(solution.wordPattern(pattern, s));
        pattern = "abc";
        s = "b c a";
        System.out.println(solution.wordPattern(pattern, s));
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean wordPattern(String pattern, String s) {
        String[] s1 = s.split(" ");

        if (pattern.length() != s1.length) {
            return false;
        }
        Map re = new HashMap<>();
        for (int i = 0; i < pattern.length(); i++) {
            if (!re.containsKey(pattern.charAt(i))) {
                re.put(pattern.charAt(i), i);
            }
            if (!re.containsKey(s1[i])) {
                re.put(s1[i], i);
            }

            if (!re.get(pattern.charAt(i)).equals(re.get(s1[i]))) {
                return false;
            }
        }
        return true;
    }
        public boolean wordPattern3(String pattern, String s) {

            String[] s1 = s.split(" ");

            if (pattern.length() != s1.length) {
                return false;
            }

            Map<Character, String> map1 = new HashMap<>();
            Map<String, Character> map2 = new HashMap<>();
            for (int i = 0; i < pattern.length(); i++) {
                if (map1.containsKey(pattern.charAt(i))) {
                    if (!map1.get(pattern.charAt(i)).equals(s1[i])) {
                        return false;
                    }
                }  else {
                    if (map2.containsKey(s1[i])) {
                        return false;
                    }
                    map1.put(pattern.charAt(i), s1[i]);
                }
                if (map2.containsKey(s1[i])) {
                    if (!map2.get(s1[i]).equals(pattern.charAt(i))) {
                        return false;
                    }
                } else {
                    map2.put(s1[i], pattern.charAt(i));
                }
            }

            return true;
        }

        public boolean wordPattern2(String pattern, String s) {

            String[] s1 = s.split(" ");

            if (pattern.length() != s1.length) {
                return false;
            }

            Map<Character, String> map = new HashMap<>();
            for (int i = 0; i < pattern.length(); i++) {
                if (map.containsKey(pattern.charAt(i))) {
                    if (!map.get(pattern.charAt(i)).equals(s1[i])) {
                        return false;
                    }
                } else {
                    if (map.containsValue(s1[i])) {
                        return false;
                    }
                    map.put(pattern.charAt(i), s1[i]);
                }
            }

            return true;
        }
}
//leetcode submit region end(Prohibit modification and deletion)

}
package leetcode.editor.cn;

import java.util.HashSet;
import java.util.Set;

public class POffer48 {

    public int lengthOfLongestSubstring(String s) {
        int l = 0;
        int r = 0;
        int max = 0;
        Set<Character> csets = new HashSet<>();
        //csets.add(s.charAt(0));
        while (l < s.length() && r < s.length()) {
            if (!csets.contains(s.charAt(r))) {
                csets.add(s.charAt(r));
                r++;
            } else {
                // 结算计算当前的距离
               max = Math.max(max,  (r - l));
               for (int j = l; j < r;j++) {
                   if (s.charAt(j) == s.charAt(r)) {

                       l = j + 1;
                       break;
                   } else {
                       csets.remove(s.charAt(j));
                   }
               }
               r++;
            }
        }

        return max;
    }

}

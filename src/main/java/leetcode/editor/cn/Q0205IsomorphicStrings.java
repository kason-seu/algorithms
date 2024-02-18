package leetcode.editor.cn;

import java.util.HashMap;
import java.util.Map;

/** * @author  kason * @date    2024-02-17 19:48:05 */public class Q0205IsomorphicStrings{    //给定两个字符串 s 和 t ，判断它们是否是同构的。
//
// 如果 s 中的字符可以按某种映射关系替换得到 t ，那么这两个字符串是同构的。 
//
// 每个出现的字符都应当映射到另一个字符，同时不改变字符的顺序。不同字符不能映射到同一个字符上，相同字符只能映射到同一个字符上，字符可以映射到自己本身。 
//
// 
//
// 示例 1: 
//
// 
//输入：s = "egg", t = "add"
//输出：true
// 
//
// 示例 2： 
//
// 
//输入：s = "foo", t = "bar"
//输出：false 
//
// 示例 3： 
//
// 
//输入：s = "paper", t = "title"
//输出：true 
//
// 
//
// 提示： 
//
// 
// 
//
// 
// 1 <= s.length <= 5 * 10⁴ 
// t.length == s.length 
// s 和 t 由任意有效的 ASCII 字符组成 
// 
//
// Related Topics 哈希表 字符串 👍 696 👎 0
    public static void main(String[] args) {        Solution solution = new Q0205IsomorphicStrings().new Solution();    }    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean isIsomorphic(String s, String t) {
        Map<Character, Character> s2t = new HashMap<Character, Character>();
        //Map<Character, Character> t2s = new HashMap<Character, Character>();

        int len = s.length();
        for (int i = 0; i < len; ++i) {
            char x = s.charAt(i), y = t.charAt(i);
            if ((s2t.containsKey(x) && s2t.get(x) != y) ) {
                return false;
            }
            s2t.put(x, y);

        }
        return true;
    }

}
//leetcode submit region end(Prohibit modification and deletion)
}
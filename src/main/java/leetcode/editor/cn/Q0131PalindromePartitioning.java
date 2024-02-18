package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

/** * @author  kason * @date    2024-02-17 01:39:45 */public class Q0131PalindromePartitioning{    //给你一个字符串 s，请你将 s 分割成一些子串，使每个子串都是 回文串 。返回 s 所有可能的分割方案。
//
// 回文串 是正着读和反着读都一样的字符串。 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "aab"
//输出：[["a","a","b"],["aa","b"]]
// 
//
// 示例 2： 
//
// 
//输入：s = "a"
//输出：[["a"]]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 16 
// s 仅由小写英文字母组成 
// 
//
// Related Topics 字符串 动态规划 回溯 👍 1728 👎 0
    public static void main(String[] args) {        Solution solution = new Q0131PalindromePartitioning().new Solution();    }    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<List<String>> partition(String s) {

        dfs(new ArrayList<>(), s, 0);
        return result;
    }
    List<List<String>> result = new ArrayList<>();
    private void dfs(List<String> oneAns, String s, int pos) {

        if (pos > s.length()) {
            return;
        }
        if (pos == s.length()) {
            result.add(new ArrayList<>(oneAns));
            return;
        }
        for (int i = pos; i < s.length(); i++) {
            if (ishuiwen(s, pos, i)) {
                oneAns.add(s.substring(pos,i + 1));
                dfs(oneAns, s, i + 1);
                oneAns.remove(oneAns.size() - 1);
            }
        }

    }

    private boolean ishuiwen(String s, int start, int end) {

        while (start <= end) {
            if (s.charAt(start) == s.charAt(end)) {
                start++;
                end--;
            } else {
                return false;
            }
        }

        return true;

    }
}
//leetcode submit region end(Prohibit modification and deletion)
}
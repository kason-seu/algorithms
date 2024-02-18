package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

/** * @author  kason * @date    2024-02-17 01:06:30 */public class Q0093RestoreIpAddresses{    //有效 IP 地址 正好由四个整数（每个整数位于 0 到 255 之间组成，且不能含有前导 0），整数之间用 '.' 分隔。
//
// 
// 例如："0.1.2.201" 和 "192.168.1.1" 是 有效 IP 地址，但是 "0.011.255.245"、"192.168.1.312" 
//和 "192.168@1.1" 是 无效 IP 地址。 
// 
//
// 给定一个只包含数字的字符串 s ，用以表示一个 IP 地址，返回所有可能的有效 IP 地址，这些地址可以通过在 s 中插入 '.' 来形成。你 不能 重新
//排序或删除 s 中的任何数字。你可以按 任何 顺序返回答案。 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "25525511135"
//输出：["255.255.11.135","255.255.111.35"]
// 
//
// 示例 2： 
//
// 
//输入：s = "0000"
//输出：["0.0.0.0"]
// 
//
// 示例 3： 
//
// 
//输入：s = "101023"
//输出：["1.0.10.23","1.0.102.3","10.1.0.23","10.10.2.3","101.0.2.3"]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 20 
// s 仅由数字组成 
// 
//
// Related Topics 字符串 回溯 👍 1384 👎 0
    public static void main(String[] args) {        Solution solution = new Q0093RestoreIpAddresses().new Solution();
        List<String> strings = solution.restoreIpAddresses("101023");
        for (String s : strings) {
            System.out.println(s);
        }
    }    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<String> restoreIpAddresses(String s) {
        newdfs(new ArrayList<>(), s, 0);
        return ans;
    }

    List<String> ans = new ArrayList<>();



    private void newdfs(List<String> result, String origin, int start ){

        if (start > origin.length()) {
            return;
        }

        if (start < origin.length() && result.size()>= 4) {
            return;
        }
        if (start == origin.length() && result.size() == 4) {
            ans.add(String.join(".", result));
        }

        for (int i = start; i < origin.length(); i++) {
            if (i == start && origin.charAt(i) == '0') {
                result.add("0");
                newdfs(result, origin, i + 1);
                result.remove(result.size() - 1);
                break;
            } else {
                int value = value = Integer.parseInt(origin.substring(start, i + 1));
                if (value <= 255) {
                    result.add(origin.substring(start, i + 1));
                    newdfs(result, origin, i + 1);
                    result.remove(result.size() - 1);
                } else {
                    break;
                }
            }
        }

    }

    private void backDfs(List<Integer> result, String origin, int start ){

        if (start > origin.length() || result.size() > 4) {
            return;
        }
        if (start == origin.length() && result.size() == 4) {
            // 有效
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < result.size(); i++) {
                sb.append(result.get(i));
                if (i != result.size() - 1) {
                    sb.append(".");
                }
            }
            ans.add(sb.toString());
        }
        if (start < origin.length() && result.size()>= 4) {
            return;
        }

        int value = 0;
        for (int i = start; i < origin.length(); i++) {
            if (i == start && origin.charAt(i) == '0') {
                result.add(0);
                backDfs(result, origin, i + 1);
                result.remove(result.size() - 1);
                break;
            } else {
                value = value * 10 + (origin.charAt(i) - '0');
                if (value <= 255) {
                    result.add(value);
                    backDfs(result, origin, i + 1);
                    result.remove(result.size() - 1);
                } else {
                    break;
                }
            }

        }

    }



}
//leetcode submit region end(Prohibit modification and deletion)
}
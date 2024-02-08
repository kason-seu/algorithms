package leetcode.editor.cn;
/** * @author  kason * @date    2024-01-02 22:25:52 */public class Q0466CountTheRepetitions{    //定义 str = [s, n] 表示 str 由 n 个字符串 s 连接构成。 
//
// 
// 例如，str == ["abc", 3] =="abcabcabc" 。 
// 
//
// 如果可以从 s2 中删除某些字符使其变为 s1，则称字符串 s1 可以从字符串 s2 获得。 
//
// 
// 例如，根据定义，s1 = "abc" 可以从 s2 = "abdbec" 获得，仅需要删除加粗且用斜体标识的字符。 
// 
//
// 现在给你两个字符串 s1 和 s2 和两个整数 n1 和 n2 。由此构造得到两个字符串，其中 str1 = [s1, n1]、str2 = [s2, 
//n2] 。 
//
// 请你找出一个最大整数 m ，以满足 str = [str2, m] 可以从 str1 获得。 
//
// 
//
// 示例 1： 
//
// 
//输入：s1 = "acb", n1 = 4, s2 = "ab", n2 = 2
//输出：2
// 
//
// 示例 2： 
//
// 
//输入：s1 = "acb", n1 = 1, s2 = "acb", n2 = 1
//输出：1
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s1.length, s2.length <= 100 
// s1 和 s2 由小写英文字母组成 
// 1 <= n1, n2 <= 10⁶ 
// 
//
// Related Topics 字符串 动态规划 👍 260 👎 0
    public static void main(String[] args) {        Solution solution = new Q0466CountTheRepetitions().new Solution();


        System.out.println(solution.getMaxRepetitions("acbd",4 ,"ab", 2));

    }    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int getMaxRepetitions(String s1, int n1, String s2, int n2) {

        StringBuilder str1 = new StringBuilder();
        for (int i = 0; i < n1; i++) {
            str1.append(s1);
        }
        String ts1 = str1.toString();
        StringBuilder str2 = new StringBuilder();
        for (int i = 0; i < n2; i++) {
            str2.append(s2);
        }
        String ts2= str2.toString();
        return transfer(ts1, ts2);
    }

    private int transfer(String ts1, String ts2, int p1, int p2) {
        if (ts1.length() == p1) {
            if (p2 == ts2.length()) {
                return 1;
            } else {
                return 0;
            }
        }
        // 找到嘞一个符合条件的位置
        if (p2 == ts2.length()) {
            return 1 + transfer(ts1, ts2, p1 , 0);
        }

        if (ts1.charAt(p1) == ts2.charAt(p2)) {
            return transfer(ts1, ts2, p1 + 1, p2+1);
        } else {
            return transfer(ts1, ts2, p1 + 1, p2);
        }



    }


    private int transfer(String ts1, String ts2) {
        int p1 = 0, p2 = 0;
        int count = 0;

        while (p1 < ts1.length()) {
            if (p2 == ts2.length()) {
                count++;
                p2 = 0; // 重新开始检查 ts2
            }

            if (ts1.charAt(p1) == ts2.charAt(p2)) {
                p2++;
            }

            p1++;
        }

        // 检查是否可以形成 ts2 的最后一部分
        if (p2 == ts2.length()) {
            count++;
        }

        return count;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
}
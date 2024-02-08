package leetcode.editor.cn;
/** * @author  kason * @date    2023-12-27 22:52:26 */public class Q0096UniqueBinarySearchTrees{    //给你一个整数 n ，求恰由 n 个节点组成且节点值从 1 到 n 互不相同的 二叉搜索树 有多少种？返回满足题意的二叉搜索树的种数。 
//
// 
//
// 示例 1： 
// 
// 
//输入：n = 3
//输出：5
// 
//
// 示例 2： 
//
// 
//输入：n = 1
//输出：1
// 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 19 
// 
//
// Related Topics 树 二叉搜索树 数学 动态规划 二叉树 👍 2424 👎 0
    public static void main(String[] args) {        Solution solution = new Q0096UniqueBinarySearchTrees().new Solution();    }    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int numTrees(int n) {

return 0;

    }

    private int dfs( int cur, int n, boolean[] flag) {
        int sum = 0;
        boolean totalFlag = true;
        for (int i = 1; i <= n; i++ ) {
            if (!flag[i]) {
                totalFlag = false;
                flag[i] = true;
                sum += dfs(0, n, flag);
                flag[i] = false;
            }
        }
        if (totalFlag) {
            return 1;
        }
        return 0;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
}
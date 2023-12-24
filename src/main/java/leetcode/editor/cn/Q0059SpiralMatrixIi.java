package leetcode.editor.cn;
/** * @author  kason * @date    2023-12-24 19:42:16 */public class Q0059SpiralMatrixIi{    //给你一个正整数 n ，生成一个包含 1 到 n² 所有元素，且元素按顺时针顺序螺旋排列的 n x n 正方形矩阵 matrix 。 
//
// 
//
// 示例 1： 
// 
// 
//输入：n = 3
//输出：[[1,2,3],[8,9,4],[7,6,5]]
// 
//
// 示例 2： 
//
// 
//输入：n = 1
//输出：[[1]]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 20 
// 
//
// Related Topics 数组 矩阵 模拟 👍 1232 👎 0
    public static void main(String[] args)
    {        Solution solution = new Q0059SpiralMatrixIi().new Solution();

        int[][] ints = solution.generateMatrix(3);
        System.out.println(ints);

    }    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[][] generateMatrix(int n) {

        int[][] res = new int[n][n];


        int t = 0;
        int b = n- 1;
        int l = 0;
        int r = n-1;

        int num = 1;

        while (true) {

            for (int i = l; i <= r; i++) {
                res[t][i] = num++;
            }
            if (++t > b) {
                break;
            }

            for (int i = t; i <= b; i++) {
                res[i][r] = num++;
            }

            if (--r < l) {
                break;
            }

            for (int i = r ; i >= l; i--) {
                res[b][i] = num++;
            }
            if (--b < t) {
                break;
            }

            for (int i = b; i >= t; i--) {
                res[i][l] = num++;
            }

            if (++l > r) {
                break;
            }

        }

        return res;

    }
}
//leetcode submit region end(Prohibit modification and deletion)
}
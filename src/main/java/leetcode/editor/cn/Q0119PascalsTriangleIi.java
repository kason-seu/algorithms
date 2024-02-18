package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

/** * @author  kason * @date    2024-02-17 00:47:12 */public class Q0119PascalsTriangleIi{    //给定一个非负索引 rowIndex，返回「杨辉三角」的第 rowIndex 行。
//
// 在「杨辉三角」中，每个数是它左上方和右上方的数的和。 
//
// 
//
// 
//
// 示例 1: 
//
// 
//输入: rowIndex = 3
//输出: [1,3,3,1]
// 
//
// 示例 2: 
//
// 
//输入: rowIndex = 0
//输出: [1]
// 
//
// 示例 3: 
//
// 
//输入: rowIndex = 1
//输出: [1,1]
// 
//
// 
//
// 提示: 
//
// 
// 0 <= rowIndex <= 33 
// 
//
// 
//
// 进阶： 
//
// 你可以优化你的算法到 O(rowIndex) 空间复杂度吗？ 
//
// Related Topics 数组 动态规划 👍 529 👎 0
    public static void main(String[] args) {        Solution solution = new Q0119PascalsTriangleIi().new Solution();    }    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<Integer> getRow(int rowIndex) {
       List<Integer> pre = new ArrayList<>();

        for (int i = 1; i <= rowIndex; i++) {
            List<Integer> oneAns = new ArrayList<>();
            if (!pre.isEmpty()) {
                for (int j = 0; j < i; j++) {
                    if (j == 0 || j == i - 1) {
                        oneAns.add(1);
                    } else {
                        oneAns.add(pre.get(j - 1) + pre.get(j));
                    }
                }
            } else {
                oneAns.add(1);
            }
            pre = oneAns;
        }

        return pre;

    }
}
//leetcode submit region end(Prohibit modification and deletion)
}
/**
  * 题目Id：42
  * 题目：接雨水
  * 内容: //给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。 
//
// 
//
// 示例 1： 
//
// 
//
// 
//输入：height = [0,1,0,2,1,0,1,3,2,1,2,1]
//输出：6
//解释：上面是由数组 [0,1,0,2,1,0,1,3,2,1,2,1] 表示的高度图，在这种情况下，可以接 6 个单位的雨水（蓝色部分表示雨水）。 
// 
//
// 示例 2： 
//
// 
//输入：height = [4,2,0,3,2,5]
//输出：9
// 
//
// 
//
// 提示： 
//
// 
// n == height.length 
// 1 <= n <= 2 * 10⁴ 
// 0 <= height[i] <= 10⁵ 
// 
// Related Topics 栈 数组 双指针 动态规划 单调栈 👍 3306 👎 0
	
  * 日期：2022-04-04 10:45:30
*/
//给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。 
//
// 
//
// 示例 1： 
//
// 
//
// 
//输入：height = [0,1,0,2,1,0,1,3,2,1,2,1]
//输出：6
//解释：上面是由数组 [0,1,0,2,1,0,1,3,2,1,2,1] 表示的高度图，在这种情况下，可以接 6 个单位的雨水（蓝色部分表示雨水）。 
// 
//
// 示例 2： 
//
// 
//输入：height = [4,2,0,3,2,5]
//输出：9
// 
//
// 
//
// 提示： 
//
// 
// n == height.length 
// 1 <= n <= 2 * 10⁴ 
// 0 <= height[i] <= 10⁵ 
// 
// Related Topics 栈 数组 双指针 动态规划 单调栈 👍 3306 👎 0

package leetcode.editor.cn;

import java.util.ArrayDeque;
import java.util.Deque;

public class P42TrappingRainWater {
    public static void main(String[] args) {
        Solution solution = new P42TrappingRainWater().new Solution();
        int[] h = new int[] {0,1,0,2,1,0,1,3,2,1,2,1};

        int trap = solution.trap(h);

        System.out.println("Hello world " + trap);

        h = new int[] {4,2,0,3,2,5};

        trap = solution.trap(h);

        System.out.println("Hello world " + trap);
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
        class Pair {
            public int value;
            public int cnt;

            public Pair(int value, int cnt) {
                this.value = value;
                this.cnt = cnt;
            }
        }
    public int trap(int[] height) {
        Deque<Pair> water = new ArrayDeque<>();
        int sumArea = 0;
        for (int i = 0; i < height.length; i++) {

            if (water.isEmpty()) {
                water.push(new Pair(height[i], 1));
                continue;
            }

            boolean flag = true;
            while (flag) {
                Pair peek = water.peek();
                if (peek.value < height[i]) {
                    Pair popMid = water.pop();
                    int cnt = peek.cnt;
                    while (!water.isEmpty() && water.peek().value <= popMid.value) {
                        Pair pop = water.pop();
                        cnt += pop.cnt;
                    }
                    Pair find = water.isEmpty() ? null : water.peek();
                    if (find != null) {
                        int h = Math.min(find.value - peek.value, height[i] - peek.value);
                        int w = cnt;
                        sumArea += h * w;
                        if (find.value > height[i]) {
                            water.push(new Pair(height[i], cnt + 1));
                            flag = false;
                        } else if (find.value <= height[i]) {
                            Pair pop = water.pop();
                            water.push(new Pair(pop.value, pop.cnt + cnt));
                            // 针对当前的i还需要计算的。因为还存在大小大
                            flag = true;
                        }
                    } else {
                        water.push(new Pair(height[i], 1));
                        flag = false;
                    }
                } else {
                    water.push(new Pair(height[i], 1));
                    flag = false;
                }
            }

        }
        return sumArea;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
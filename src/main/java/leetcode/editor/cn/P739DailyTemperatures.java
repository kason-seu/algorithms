/**
  * 题目Id：739
  * 题目：每日温度
  * 内容: //给定一个整数数组 temperatures ，表示每天的温度，返回一个数组 answer ，其中 answer[i] 是指在第 i 天之后，才会有更高的温度
//。如果气温在这之后都不会升高，请在该位置用 0 来代替。 
//
// 
//
// 示例 1: 
//
// 
//输入: temperatures = [73,74,75,71,69,72,76,73]
//输出: [1,1,4,2,1,1,0,0]
// 
//
// 示例 2: 
//
// 
//输入: temperatures = [30,40,50,60]
//输出: [1,1,1,0]
// 
//
// 示例 3: 
//
// 
//输入: temperatures = [30,60,90]
//输出: [1,1,0] 
//
// 
//
// 提示： 
//
// 
// 1 <= temperatures.length <= 10⁵ 
// 30 <= temperatures[i] <= 100 
// 
// Related Topics 栈 数组 单调栈 👍 1075 👎 0
	
  * 日期：2022-03-26 12:03:08
*/
//给定一个整数数组 temperatures ，表示每天的温度，返回一个数组 answer ，其中 answer[i] 是指在第 i 天之后，才会有更高的温度
//。如果气温在这之后都不会升高，请在该位置用 0 来代替。 
//
// 
//
// 示例 1: 
//
// 
//输入: temperatures = [73,74,75,71,69,72,76,73]
//输出: [1,1,4,2,1,1,0,0]
// 
//
// 示例 2: 
//
// 
//输入: temperatures = [30,40,50,60]
//输出: [1,1,1,0]
// 
//
// 示例 3: 
//
// 
//输入: temperatures = [30,60,90]
//输出: [1,1,0] 
//
// 
//
// 提示： 
//
// 
// 1 <= temperatures.length <= 10⁵ 
// 30 <= temperatures[i] <= 100 
// 
// Related Topics 栈 数组 单调栈 👍 1075 👎 0

package leetcode.editor.cn;

import java.util.Arrays;
import java.util.Stack;
import java.util.stream.Collectors;

public class P739DailyTemperatures {
    public static void main(String[] args) {
        Solution solution = new P739DailyTemperatures().new Solution();
        int[] tmeps = new int[]{73,74,75,71,69,72,76,73};

        int[] ints = solution.dailyTemperatures(tmeps);


        String result = Arrays.stream(ints).mapToObj(Integer::toString).collect(Collectors.joining(","));

        System.out.println("Hello world" + result);
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] dailyTemperatures(int[] temperatures) {

        Stack<Integer> stack = new Stack<>();
        int[] ans = new int[temperatures.length];
        for (int i = 0; i < temperatures.length; i++) {
            if (stack.isEmpty()) {
                stack.push(i);
                continue;
            }
            while (!stack.isEmpty()) {
                Integer top = stack.peek();
                if (temperatures[i] > temperatures[top]) {
                    ans[top] = i - top;
                    stack.pop();
                } else {
                    break;
                }
            }
            stack.push(i);
        }

        while (!stack.isEmpty()) {
            ans[stack.pop()] = 0;
        }

        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
/**
  * 题目Id：45
  * 题目：跳跃游戏 II
  * 内容: //给你一个非负整数数组 nums ，你最初位于数组的第一个位置。 
//
// 数组中的每个元素代表你在该位置可以跳跃的最大长度。 
//
// 你的目标是使用最少的跳跃次数到达数组的最后一个位置。 
//
// 假设你总是可以到达数组的最后一个位置。 
//
// 
//
// 示例 1: 
//
// 
//输入: nums = [2,3,1,1,4]
//输出: 2
//解释: 跳到最后一个位置的最小跳跃数是 2。
//     从下标为 0 跳到下标为 1 的位置，跳 1 步，然后跳 3 步到达数组的最后一个位置。
// 
//
// 示例 2: 
//
// 
//输入: nums = [2,3,0,1,4]
//输出: 2
// 
//
// 
//
// 提示: 
//
// 
// 1 <= nums.length <= 10⁴ 
// 0 <= nums[i] <= 1000 
// 
// Related Topics 贪心 数组 动态规划 👍 1423 👎 0
	
  * 日期：2022-02-25 23:06:04
*/
//给你一个非负整数数组 nums ，你最初位于数组的第一个位置。 
//
// 数组中的每个元素代表你在该位置可以跳跃的最大长度。 
//
// 你的目标是使用最少的跳跃次数到达数组的最后一个位置。 
//
// 假设你总是可以到达数组的最后一个位置。 
//
// 
//
// 示例 1: 
//
// 
//输入: nums = [2,3,1,1,4]
//输出: 2
//解释: 跳到最后一个位置的最小跳跃数是 2。
//     从下标为 0 跳到下标为 1 的位置，跳 1 步，然后跳 3 步到达数组的最后一个位置。
// 
//
// 示例 2: 
//
// 
//输入: nums = [2,3,0,1,4]
//输出: 2
// 
//
// 
//
// 提示: 
//
// 
// 1 <= nums.length <= 10⁴ 
// 0 <= nums[i] <= 1000 
// 
// Related Topics 贪心 数组 动态规划 👍 1423 👎 0

package leetcode.editor.cn;

import java.util.Arrays;

public class P45JumpGameIi {
    public static void main(String[] args) {
        Solution solution = new P45JumpGameIi().new Solution();
        int jump = solution.jump(new int[]{8,0,8,5,0,1,1,0,9,4,1,5,1,3,8,0,3,2,2,7,1,7,3,4,5,3,6,1,1,6,7,9,7,5,5,9,8,6,9,7,2,2,5,5,5,3,8,0,5,0,9,9,0,3});
        //int jump = solution.jump(new int[]{2,3,1,1,4});

        System.out.println("Hello world" + jump);
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int jump(int[] nums) {

        int[] indexMinStepArr = new int[nums.length];
        Arrays.fill(indexMinStepArr, -1);
        return dg(0, nums, nums.length, indexMinStepArr);
    }

    private int dg(int index, int[] nums, int length, int[] indexMinStepArr) {

        int maxStep = Integer.MAX_VALUE;
        /*if (nums[index] == 0 && index + nums[index] == length - 1) {
            return 0;
        }*/
        if (nums[index] == 0 && index + nums[index] != length - 1) {
            return Integer.MAX_VALUE - length;
        }
        for (int newIndex = index + 1; newIndex < length && newIndex <= index + nums[index] ; newIndex++) {

            if (indexMinStepArr[newIndex] != -1) {
                maxStep = Math.min(maxStep, indexMinStepArr[newIndex]);
            } else {


                indexMinStepArr[newIndex] = dg(newIndex, nums, length, indexMinStepArr);;
                maxStep = Math.min(maxStep, indexMinStepArr[newIndex]);

            }


        }
        return maxStep != Integer.MAX_VALUE  ?  1 + maxStep : 0;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
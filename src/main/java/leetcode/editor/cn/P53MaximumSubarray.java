/**
  * 题目Id：53
  * 题目：最大子数组和
  * 内容: //给你一个整数数组 nums ，请你找出一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。 
//
// 子数组 是数组中的一个连续部分。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [-2,1,-3,4,-1,2,1,-5,4]
//输出：6
//解释：连续子数组 [4,-1,2,1] 的和最大，为 6 。
// 
//
// 示例 2： 
//
// 
//输入：nums = [1]
//输出：1
// 
//
// 示例 3： 
//
// 
//输入：nums = [5,4,-1,7,8]
//输出：23
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 10⁵ 
// -10⁴ <= nums[i] <= 10⁴ 
// 
//
// 
//
// 进阶：如果你已经实现复杂度为 O(n) 的解法，尝试使用更为精妙的 分治法 求解。 
// Related Topics 数组 分治 动态规划 👍 4820 👎 0
	
  * 日期：2022-05-02 11:45:55
*/
//给你一个整数数组 nums ，请你找出一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。 
//
// 子数组 是数组中的一个连续部分。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [-2,1,-3,4,-1,2,1,-5,4]
//输出：6
//解释：连续子数组 [4,-1,2,1] 的和最大，为 6 。
// 
//
// 示例 2： 
//
// 
//输入：nums = [1]
//输出：1
// 
//
// 示例 3： 
//
// 
//输入：nums = [5,4,-1,7,8]
//输出：23
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 10⁵ 
// -10⁴ <= nums[i] <= 10⁴ 
// 
//
// 
//
// 进阶：如果你已经实现复杂度为 O(n) 的解法，尝试使用更为精妙的 分治法 求解。 
// Related Topics 数组 分治 动态规划 👍 4820 👎 0

package leetcode.editor.cn;

import java.util.Arrays;

public class P53MaximumSubarray {
    public static void main(String[] args) {
        Solution solution = new P53MaximumSubarray().new Solution();
        System.out.println("Hello world");
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int maxSubArray2(int[] nums) {

        int[] sums = new int[nums.length];
        Arrays.fill(sums, Integer.MIN_VALUE);
        recurSumSub(nums, nums.length - 1, sums);
        //return recurSumSub(nums, )
        return Arrays.stream(sums).max().getAsInt();
    }
    // 代表以i 作为子数组结尾的最大和
    private int recurSumSub(int[] nums, int i, int[] sums) {
        if (i == 0) {
            sums[0] = nums[0];
            return nums[0];
        }
        if (sums[i - 1] != Integer.MIN_VALUE) {
            sums[i] = Math.max(sums[i - 1]+ nums[i], nums[i]);
        } else {
            sums[i] = Math.max(recurSumSub(nums, i - 1, sums) + nums[i], nums[i]);
        }
        return sums[i];
    }
        public int maxSubArray1(int[] nums) {

            int[] sums = new int[nums.length];



            return dynamicSumSub1(nums, nums.length - 1, sums);
        }
        private int dynamicSumSub1(int[] nums, int n, int[] sums) {
            sums[0] = nums[0];
            int max = nums[0];
            for (int i = 1; i <= n; i++) {
                sums[i] = Math.max(sums[i-1] + nums[i], nums[i]);
                max = Math.max(max, sums[i]);
            }
            return max;
        }

        public int maxSubArray(int[] nums) {
            return dynamicSumSub(nums, nums.length - 1);
        }
        private int dynamicSumSub(int[] nums, int n) {
            int pre = nums[0];
            int max = nums[0];
            for (int i = 1; i <= n; i++) {
                pre = Math.max(pre + nums[i], nums[i]);
                max = Math.max(max, pre);
            }
            return max;
        }
}
//leetcode submit region end(Prohibit modification and deletion)

}
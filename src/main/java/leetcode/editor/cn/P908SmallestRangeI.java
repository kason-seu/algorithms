/**
  * 题目Id：908
  * 题目：最小差值 I
  * 内容: //给你一个整数数组 nums，和一个整数 k 。 
//
// 在一个操作中，您可以选择 0 <= i < nums.length 的任何索引 i 。将 nums[i] 改为 nums[i] + x ，其中 x 是一个
//范围为 [-k, k] 的整数。对于每个索引 i ，最多 只能 应用 一次 此操作。 
//
// nums 的 分数 是 nums 中最大和最小元素的差值。 
//
// 在对 nums 中的每个索引最多应用一次上述操作后，返回 nums 的最低 分数 。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1], k = 0
//输出：0
//解释：分数是 max(nums) - min(nums) = 1 - 1 = 0。
// 
//
// 示例 2： 
//
// 
//输入：nums = [0,10], k = 2
//输出：6
//解释：将 nums 改为 [2,8]。分数是 max(nums) - min(nums) = 8 - 2 = 6。
// 
//
// 示例 3： 
//
// 
//输入：nums = [1,3,6], k = 3
//输出：0
//解释：将 nums 改为 [4,4,4]。分数是 max(nums) - min(nums) = 4 - 4 = 0。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 10⁴ 
// 0 <= nums[i] <= 10⁴ 
// 0 <= k <= 10⁴ 
// 
// Related Topics 数组 数学 👍 154 👎 0
	
  * 日期：2022-04-30 21:18:07
*/
//给你一个整数数组 nums，和一个整数 k 。 
//
// 在一个操作中，您可以选择 0 <= i < nums.length 的任何索引 i 。将 nums[i] 改为 nums[i] + x ，其中 x 是一个
//范围为 [-k, k] 的整数。对于每个索引 i ，最多 只能 应用 一次 此操作。 
//
// nums 的 分数 是 nums 中最大和最小元素的差值。 
//
// 在对 nums 中的每个索引最多应用一次上述操作后，返回 nums 的最低 分数 。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1], k = 0
//输出：0
//解释：分数是 max(nums) - min(nums) = 1 - 1 = 0。
// 
//
// 示例 2： 
//
// 
//输入：nums = [0,10], k = 2
//输出：6
//解释：将 nums 改为 [2,8]。分数是 max(nums) - min(nums) = 8 - 2 = 6。
// 
//
// 示例 3： 
//
// 
//输入：nums = [1,3,6], k = 3
//输出：0
//解释：将 nums 改为 [4,4,4]。分数是 max(nums) - min(nums) = 4 - 4 = 0。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 10⁴ 
// 0 <= nums[i] <= 10⁴ 
// 0 <= k <= 10⁴ 
// 
// Related Topics 数组 数学 👍 154 👎 0

package leetcode.editor.cn;

import java.util.Arrays;

public class P908SmallestRangeI {
    public static void main(String[] args) {
        Solution solution = new P908SmallestRangeI().new Solution();
        System.out.println("Hello world");
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int smallestRangeI(int[] nums, int k) {


        Arrays.sort(nums);

        int diff = nums[nums.length - 1] - nums[0];

        if (diff <= 2 * k) {
            return 0;
        } else  {
            return diff - 2 * k;
        }

    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
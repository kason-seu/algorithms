package leetcode.editor.cn;

import java.util.*;

/** * @author  kason * @date    2024-02-18 10:03:15 */public class Q2824CountPairsWhoseSumIsLessThanTarget{    //给你一个下标从 0 开始长度为 n 的整数数组 nums 和一个整数 target ，请你返回满足 0 <= i < j < n 且 nums[i] +
//nums[j] < target 的下标对 (i, j) 的数目。
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [-1,1,2,3,1], target = 2
//输出：3
//解释：总共有 3 个下标对满足题目描述：
//- (0, 1) ，0 < 1 且 nums[0] + nums[1] = 0 < target
//- (0, 2) ，0 < 2 且 nums[0] + nums[2] = 1 < target 
//- (0, 4) ，0 < 4 且 nums[0] + nums[4] = 0 < target
//注意 (0, 3) 不计入答案因为 nums[0] + nums[3] 不是严格小于 target 。
// 
//
// 示例 2： 
//
// 
//输入：nums = [-6,2,5,-2,-7,-1,3], target = -2
//输出：10
//解释：总共有 10 个下标对满足题目描述：
//- (0, 1) ，0 < 1 且 nums[0] + nums[1] = -4 < target
//- (0, 3) ，0 < 3 且 nums[0] + nums[3] = -8 < target
//- (0, 4) ，0 < 4 且 nums[0] + nums[4] = -13 < target
//- (0, 5) ，0 < 5 且 nums[0] + nums[5] = -7 < target
//- (0, 6) ，0 < 6 且 nums[0] + nums[6] = -3 < target
//- (1, 4) ，1 < 4 且 nums[1] + nums[4] = -5 < target
//- (3, 4) ，3 < 4 且 nums[3] + nums[4] = -9 < target
//- (3, 5) ，3 < 5 且 nums[3] + nums[5] = -3 < target
//- (4, 5) ，4 < 5 且 nums[4] + nums[5] = -8 < target
//- (4, 6) ，4 < 6 且 nums[4] + nums[6] = -4 < target
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length == n <= 50 
// -50 <= nums[i], target <= 50 
// 
//
// Related Topics 数组 双指针 二分查找 排序 👍 53 👎 0
    public static void main(String[] args) {        Solution solution = new Q2824CountPairsWhoseSumIsLessThanTarget().new Solution();    }    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int countPairs(List<Integer> nums, int target) {

        Collections.sort(nums);
        int i = 0, j= nums.size() - 1;
        int ans = 0;
        while (i < j) {
            while ( j > i && ((nums.get(j)+ nums.get(i)) >= target) ) {
                j--;
            }
            ans += j - i;
            i++;
        }
        return ans;

    }
}
//leetcode submit region end(Prohibit modification and deletion)
}
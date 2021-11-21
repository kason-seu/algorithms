/**
  * 题目Id：594
  * 题目：最长和谐子序列
  * 内容: //和谐数组是指一个数组里元素的最大值和最小值之间的差别 正好是 1 。 
//
// 现在，给你一个整数数组 nums ，请你在所有可能的子序列中找到最长的和谐子序列的长度。 
//
// 数组的子序列是一个由数组派生出来的序列，它可以通过删除一些元素或不删除元素、且不改变其余元素的顺序而得到。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,3,2,2,5,2,3,7]
//输出：5
//解释：最长的和谐子序列是 [3,2,2,2,3]
// 
//
// 示例 2： 
//
// 
//输入：nums = [1,2,3,4]
//输出：2
// 
//
// 示例 3： 
//
// 
//输入：nums = [1,1,1,1]
//输出：0
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 2 * 10⁴ 
// -10⁹ <= nums[i] <= 10⁹ 
// 
// Related Topics 数组 哈希表 排序 👍 271 👎 0
	
  * 日期：2021-11-20 19:01:12
*/
//和谐数组是指一个数组里元素的最大值和最小值之间的差别 正好是 1 。 
//
// 现在，给你一个整数数组 nums ，请你在所有可能的子序列中找到最长的和谐子序列的长度。 
//
// 数组的子序列是一个由数组派生出来的序列，它可以通过删除一些元素或不删除元素、且不改变其余元素的顺序而得到。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,3,2,2,5,2,3,7]
//输出：5
//解释：最长的和谐子序列是 [3,2,2,2,3]
// 
//
// 示例 2： 
//
// 
//输入：nums = [1,2,3,4]
//输出：2
// 
//
// 示例 3： 
//
// 
//输入：nums = [1,1,1,1]
//输出：0
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 2 * 10⁴ 
// -10⁹ <= nums[i] <= 10⁹ 
// 
// Related Topics 数组 哈希表 排序 👍 271 👎 0

package leetcode.editor.cn;

import java.util.Arrays;

public class P594LongestHarmoniousSubsequence {
    public static void main(String[] args) {
        Solution solution = new P594LongestHarmoniousSubsequence().new Solution();
        int lhs = solution.findLHS(new int[]{1, 3, 2, 2, 5, 2, 3, 7});
        System.out.println("Hello world" + lhs);
        lhs = solution.findLHS(new int[]{1,2,3,4});
        System.out.println("Hello world" + lhs);
        lhs = solution.findLHS(new int[]{1,1,1,1});
        System.out.println("Hello world" + lhs);
        lhs = solution.findLHS(new int[]{1,2,2,1});
        System.out.println("Hello world" + lhs);
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int findLHS(int[] nums) {
        Arrays.sort(nums);
        int max = 0;
        for (int i = 0 ; i < nums.length - 1; i++) {
            int result = 0;
            boolean flag = false;
            for (int j = i; j < nums.length; j++) {
                if (nums[j] - nums[i] == 1 ) {
                    flag = true;
                    result++;
                } else if (nums[j] - nums[i] == 0) {
                    result++;
                } else {
                    break;
                }
            }
            if (flag) {
                max = Math.max(max, result);
            }
        }

        return max;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
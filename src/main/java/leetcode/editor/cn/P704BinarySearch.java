/**
  * 题目Id：704
  * 题目：二分查找
  * 内容: //给定一个 n 个元素有序的（升序）整型数组 nums 和一个目标值 target ，写一个函数搜索 nums 中的 target，如果目标值存在返回下标，否
//则返回 -1。 
//
// 
//示例 1: 
//
// 输入: nums = [-1,0,3,5,9,12], target = 9
//输出: 4
//解释: 9 出现在 nums 中并且下标为 4
// 
//
// 示例 2: 
//
// 输入: nums = [-1,0,3,5,9,12], target = 2
//输出: -1
//解释: 2 不存在 nums 中因此返回 -1
// 
//
// 
//
// 提示： 
//
// 
// 你可以假设 nums 中的所有元素是不重复的。 
// n 将在 [1, 10000]之间。 
// nums 的每个元素都将在 [-9999, 9999]之间。 
// 
// Related Topics 数组 二分查找 👍 767 👎 0
	
  * 日期：2022-04-17 10:36:11
*/
//给定一个 n 个元素有序的（升序）整型数组 nums 和一个目标值 target ，写一个函数搜索 nums 中的 target，如果目标值存在返回下标，否
//则返回 -1。 
//
// 
//示例 1: 
//
// 输入: nums = [-1,0,3,5,9,12], target = 9
//输出: 4
//解释: 9 出现在 nums 中并且下标为 4
// 
//
// 示例 2: 
//
// 输入: nums = [-1,0,3,5,9,12], target = 2
//输出: -1
//解释: 2 不存在 nums 中因此返回 -1
// 
//
// 
//
// 提示： 
//
// 
// 你可以假设 nums 中的所有元素是不重复的。 
// n 将在 [1, 10000]之间。 
// nums 的每个元素都将在 [-9999, 9999]之间。 
// 
// Related Topics 数组 二分查找 👍 767 👎 0

package leetcode.editor.cn;
public class P704BinarySearch {
    public static void main(String[] args) {
        Solution solution = new P704BinarySearch().new Solution();
        int[] nums = new int[]{-1,0,3,5,9,12};

        System.out.println("Hello world " + solution.search(nums, 9));


        nums = new int[]{-1,0,3,5,9,12};

        System.out.println("Hello world " + solution.search(nums, 2));
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int search(int[] nums, int target) {

        int mid;
        int left = 0; int right = nums.length -1;

        while (left <= right) {

            mid = left + (right - left) /2;

            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid -1;
            }

        }

        return -1;

    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
/**
  * 题目Id：33
  * 题目：搜索旋转排序数组
  * 内容: //整数数组 nums 按升序排列，数组中的值 互不相同 。 
//
// 在传递给函数之前，nums 在预先未知的某个下标 k（0 <= k < nums.length）上进行了 旋转，使数组变为 [nums[k], nums[
//k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]]（下标 从 0 开始 计数）。例如， [0,1,2
//,4,5,6,7] 在下标 3 处经旋转后可能变为 [4,5,6,7,0,1,2] 。 
//
// 给你 旋转后 的数组 nums 和一个整数 target ，如果 nums 中存在这个目标值 target ，则返回它的下标，否则返回 -1 。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [4,5,6,7,0,1,2], target = 0
//输出：4
// 
//
// 示例 2： 
//
// 
//输入：nums = [4,5,6,7,0,1,2], target = 3
//输出：-1 
//
// 示例 3： 
//
// 
//输入：nums = [1], target = 0
//输出：-1
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 5000 
// -10^4 <= nums[i] <= 10^4 
// nums 中的每个值都 独一无二 
// 题目数据保证 nums 在预先未知的某个下标上进行了旋转 
// -10^4 <= target <= 10^4 
// 
//
// 
//
// 进阶：你可以设计一个时间复杂度为 O(log n) 的解决方案吗？ 
// Related Topics 数组 二分查找 👍 2054 👎 0
	
  * 日期：2022-05-01 00:22:15
*/
//整数数组 nums 按升序排列，数组中的值 互不相同 。 
//
// 在传递给函数之前，nums 在预先未知的某个下标 k（0 <= k < nums.length）上进行了 旋转，使数组变为 [nums[k], nums[
//k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]]（下标 从 0 开始 计数）。例如， [0,1,2
//,4,5,6,7] 在下标 3 处经旋转后可能变为 [4,5,6,7,0,1,2] 。 
//
// 给你 旋转后 的数组 nums 和一个整数 target ，如果 nums 中存在这个目标值 target ，则返回它的下标，否则返回 -1 。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [4,5,6,7,0,1,2], target = 0
//输出：4
// 
//
// 示例 2： 
//
// 
//输入：nums = [4,5,6,7,0,1,2], target = 3
//输出：-1 
//
// 示例 3： 
//
// 
//输入：nums = [1], target = 0
//输出：-1
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 5000 
// -10^4 <= nums[i] <= 10^4 
// nums 中的每个值都 独一无二 
// 题目数据保证 nums 在预先未知的某个下标上进行了旋转 
// -10^4 <= target <= 10^4 
// 
//
// 
//
// 进阶：你可以设计一个时间复杂度为 O(log n) 的解决方案吗？ 
// Related Topics 数组 二分查找 👍 2054 👎 0

package leetcode.editor.cn;
public class P33SearchInRotatedSortedArray {
    public static void main(String[] args) {
        Solution solution = new P33SearchInRotatedSortedArray().new Solution();
        System.out.println("Hello world " + solution.search(new int[]{4,5,6,7,0,1,2}, 0));
        System.out.println("Hello world " + solution.search(new int[]{4,5,6,7,0,1,2}, 3));
        System.out.println("Hello world " + solution.search(new int[]{4,5,6,7,0,1,2}, 7));
        System.out.println("Hello world " + solution.search(new int[]{4,5,6,7,0,1,2}, 1));
        System.out.println("Hello world " + solution.search(new int[]{4,5,6,7,0,1,2}, 5));
        System.out.println("Hello world " + solution.search(new int[]{1}, 5));
        System.out.println("Hello world " + solution.search(new int[]{3,1}, 1));
        System.out.println("Hello world " + solution.search(new int[]{5,1,3}, 5));
        // [4,5,6,7,8,1,2,3]
        //8
        System.out.println("Hello world " + solution.search(new int[]{4,5,6,7,8,1,2,3}, 8));
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int search(int[] nums, int target) {


        if (nums.length == 1) {
            return nums[0] == target ? 0 : -1;
        }

        int l = 0, r = nums.length - 1;

        while (l <= r) {

            int mid = l + (r - l) / 2;


            if (target == nums[mid]) {
                return mid;
            } else if (target > nums[mid]) {

                if (nums[mid] < nums[l] && target > nums[r]) {
                    r = mid - 1;
                } else {
                    l = mid + 1;
                }

            } else {
                if (nums[mid] >= nums[l] && target < nums[l]) {
                    l = mid + 1;
                } else {
                    r = mid - 1;
                }
            }

            /*// 说明还是符合左侧的那个逻辑
            if (nums[mid] > nums[l]) {

                if (target == nums[mid]) {
                    return mid;
                } else if (target > nums[mid]) {
                    l = mid + 1;
                } else {
                    if (target < nums[l]) {
                        l = mid + 1;
                    } else {
                        r = mid - 1;
                    }
                }
            } else {
                // 在右侧了
                if (target == nums[mid]) {
                    return mid;
                } else if (target > nums[mid]) {
                    l = mid + 1;
                } else {

                    r = mid - 1;
                }
            }*/

        }

        return -1;

    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
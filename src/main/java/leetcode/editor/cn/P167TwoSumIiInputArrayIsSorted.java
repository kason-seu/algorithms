/**
  * 题目Id：167
  * 题目：两数之和 II - 输入有序数组
  * 内容: //给你一个下标从 1 开始的整数数组 numbers ，该数组已按 非递减顺序排列 ，请你从数组中找出满足相加之和等于目标数 target 的两个数。如果设这
//两个数分别是 numbers[index1] 和 numbers[index2] ，则 1 <= index1 < index2 <= numbers.
//length 。 
//
// 以长度为 2 的整数数组 [index1, index2] 的形式返回这两个整数的下标 index1 和 index2。 
//
// 你可以假设每个输入 只对应唯一的答案 ，而且你 不可以 重复使用相同的元素。 
//
// 你所设计的解决方案必须只使用常量级的额外空间。 
// 
//
// 示例 1： 
//
// 
//输入：numbers = [2,7,11,15], target = 9
//输出：[1,2]
//解释：2 与 7 之和等于目标数 9 。因此 index1 = 1, index2 = 2 。返回 [1, 2] 。 
//
// 示例 2： 
//
// 
//输入：numbers = [2,3,4], target = 6
//输出：[1,3]
//解释：2 与 4 之和等于目标数 6 。因此 index1 = 1, index2 = 3 。返回 [1, 3] 。 
//
// 示例 3： 
//
// 
//输入：numbers = [-1,0], target = -1
//输出：[1,2]
//解释：-1 与 0 之和等于目标数 -1 。因此 index1 = 1, index2 = 2 。返回 [1, 2] 。
// 
//
// 
//
// 提示： 
//
// 
// 2 <= numbers.length <= 3 * 10⁴ 
// -1000 <= numbers[i] <= 1000 
// numbers 按 非递减顺序 排列 
// -1000 <= target <= 1000 
// 仅存在一个有效答案 
// 
// Related Topics 数组 双指针 二分查找 👍 770 👎 0
	
  * 日期：2022-04-24 23:17:31
*/
//给你一个下标从 1 开始的整数数组 numbers ，该数组已按 非递减顺序排列 ，请你从数组中找出满足相加之和等于目标数 target 的两个数。如果设这
//两个数分别是 numbers[index1] 和 numbers[index2] ，则 1 <= index1 < index2 <= numbers.
//length 。 
//
// 以长度为 2 的整数数组 [index1, index2] 的形式返回这两个整数的下标 index1 和 index2。 
//
// 你可以假设每个输入 只对应唯一的答案 ，而且你 不可以 重复使用相同的元素。 
//
// 你所设计的解决方案必须只使用常量级的额外空间。 
// 
//
// 示例 1： 
//
// 
//输入：numbers = [2,7,11,15], target = 9
//输出：[1,2]
//解释：2 与 7 之和等于目标数 9 。因此 index1 = 1, index2 = 2 。返回 [1, 2] 。 
//
// 示例 2： 
//
// 
//输入：numbers = [2,3,4], target = 6
//输出：[1,3]
//解释：2 与 4 之和等于目标数 6 。因此 index1 = 1, index2 = 3 。返回 [1, 3] 。 
//
// 示例 3： 
//
// 
//输入：numbers = [-1,0], target = -1
//输出：[1,2]
//解释：-1 与 0 之和等于目标数 -1 。因此 index1 = 1, index2 = 2 。返回 [1, 2] 。
// 
//
// 
//
// 提示： 
//
// 
// 2 <= numbers.length <= 3 * 10⁴ 
// -1000 <= numbers[i] <= 1000 
// numbers 按 非递减顺序 排列 
// -1000 <= target <= 1000 
// 仅存在一个有效答案 
// 
// Related Topics 数组 双指针 二分查找 👍 770 👎 0

package leetcode.editor.cn;

import java.util.Arrays;
import java.util.stream.Collectors;

public class P167TwoSumIiInputArrayIsSorted {
    public static void main(String[] args) {
        Solution solution = new P167TwoSumIiInputArrayIsSorted().new Solution();
        int[] ints = solution.twoSum(new int[]{1,2,3,4,4,9,56,90}, 8);

        System.out.println("Hello world " + ints[0] + " " + ints[1]);

        ints = solution.twoSum(new int[]{0,0,3,4}, 0);

        System.out.println("Hello world " + ints[0] + " " + ints[1]);

        ints = solution.twoSum(new int[]{2,7,11,15}, 9);

        System.out.println("Hello world " + ints[0] + " " + ints[1]);


        ints = solution.twoSum(new int[]{2,3,4}, 6);

        System.out.println("Hello world " + ints[0] + " " + ints[1]);

        ints = solution.twoSum(new int[]{-1,0}, -1);

        System.out.println("Hello world " + ints[0] + " " + ints[1]);
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {


        public int[] twoSum(int[] numbers, int target) {

           int l = 0;
           int r = numbers.length - 1;
           while (l < r) {

               if (numbers[l] + numbers[r] > target) {
                   r--;
               } else if (numbers[l] + numbers[r] < target) {
                   l++;
               } else {
                   return new int[]{l+1,r+1};
               }

           }

           return new int[]{-1,-1};

        }

    public int[] twoSum2(int[] numbers, int target) {

        for (int i = 0 ; i < numbers.length; i++) {

            int k = binarySearch(numbers, target - numbers[i], i);
            if (k != -1 && k > i) {
                return new int[]{i+1, k+1};
            }
        }

        return new int[]{-1,-1};

    }

    private int binarySearch(int[] nums, int target, int origin) {

        int l = origin+1;
        int r = nums.length-1;

        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (nums[mid] == target) {
                if (mid != origin) {
                    return mid;
                } else {
                    if (mid + 1 < nums.length && nums[mid+1] == target) {
                        return mid + 1;
                    } else {
                        return -1;
                    }
                }
            } else if (nums[mid] < target) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }

        return -1;

    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
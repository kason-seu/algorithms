/**
 * 题目Id：503
 * 题目：下一个更大元素 II
 * 内容: //给定一个循环数组 nums （ nums[nums.length - 1] 的下一个元素是 nums[0] ），返回 nums 中每个元素的 下一个更大元素
 * // 。
 * //
 * // 数字 x 的 下一个更大的元素 是按数组遍历顺序，这个数字之后的第一个比它更大的数，这意味着你应该循环地搜索它的下一个更大的数。如果不存在，则输出 -1
 * //。
 * //
 * //
 * //
 * // 示例 1:
 * //
 * //
 * //输入: nums = [1,2,1]
 * //输出: [2,-1,2]
 * //解释: 第一个 1 的下一个更大的数是 2；
 * //数字 2 找不到下一个更大的数；
 * //第二个 1 的下一个最大的数需要循环搜索，结果也是 2。
 * //
 * //
 * // 示例 2:
 * //
 * //
 * //输入: nums = [1,2,3,4,3]
 * //输出: [2,3,4,-1,4]
 * //
 * //
 * //
 * //
 * // 提示:
 * //
 * //
 * // 1 <= nums.length <= 10⁴
 * // -10⁹ <= nums[i] <= 10⁹
 * //
 * // Related Topics 栈 数组 单调栈 👍 565 👎 0
 * <p>
 * 日期：2022-02-28 21:46:01
 */
//给定一个循环数组 nums （ nums[nums.length - 1] 的下一个元素是 nums[0] ），返回 nums 中每个元素的 下一个更大元素
// 。 
//
// 数字 x 的 下一个更大的元素 是按数组遍历顺序，这个数字之后的第一个比它更大的数，这意味着你应该循环地搜索它的下一个更大的数。如果不存在，则输出 -1 
//。 
//
// 
//
// 示例 1: 
//
// 
//输入: nums = [1,2,1]
//输出: [2,-1,2]
//解释: 第一个 1 的下一个更大的数是 2；
//数字 2 找不到下一个更大的数； 
//第二个 1 的下一个最大的数需要循环搜索，结果也是 2。
// 
//
// 示例 2: 
//
// 
//输入: nums = [1,2,3,4,3]
//输出: [2,3,4,-1,4]
// 
//
// 
//
// 提示: 
//
// 
// 1 <= nums.length <= 10⁴ 
// -10⁹ <= nums[i] <= 10⁹ 
// 
// Related Topics 栈 数组 单调栈 👍 565 👎 0

package leetcode.editor.cn;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.stream.Collectors;

public class P503NextGreaterElementIi {
    public static void main(String[] args) {
        Solution solution = new P503NextGreaterElementIi().new Solution();
        int[] nums = new int[]{1, 2, 3, 4, 3};
        int[] ints = solution.nextGreaterElements(nums);


        String ans = Arrays.stream(ints).mapToObj(Integer::toString).collect(Collectors.joining(","));

        System.out.println("Hello world : " + ans);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] nextGreaterElements(int[] nums) {

            Deque<Integer> deque = new ArrayDeque<>();
            int[] ans = new int[nums.length];
            for (int i = 0; i < nums.length; i++) {
                while (!deque.isEmpty() && nums[i] > nums[deque.peek()]) {
                    ans[deque.pop()] = nums[i];
                }
                deque.push(i);
            }

            for (int i = 0; i < nums.length; i++) {
                while (!deque.isEmpty() && nums[i] > nums[deque.peek()]) {
                    ans[deque.pop()] = nums[i];
                }
            }

            while (!deque.isEmpty()) {
                ans[deque.pop()] = -1;
            }

            return ans;

        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
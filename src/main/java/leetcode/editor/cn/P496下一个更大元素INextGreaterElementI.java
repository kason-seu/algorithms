/**
  * 题目Id：496
  * 题目：下一个更大元素 I
  * 内容: //给你两个 没有重复元素 的数组 nums1 和 nums2 ，其中nums1 是 nums2 的子集。 
//
// 请你找出 nums1 中每个元素在 nums2 中的下一个比其大的值。 
//
// nums1 中数字 x 的下一个更大元素是指 x 在 nums2 中对应位置的右边的第一个比 x 大的元素。如果不存在，对应位置输出 -1 。 
//
// 
//
// 示例 1: 
//
// 
//输入: nums1 = [4,1,2], nums2 = [1,3,4,2].
//输出: [-1,3,-1]
//解释:
//    对于 num1 中的数字 4 ，你无法在第二个数组中找到下一个更大的数字，因此输出 -1 。
//    对于 num1 中的数字 1 ，第二个数组中数字1右边的下一个较大数字是 3 。
//    对于 num1 中的数字 2 ，第二个数组中没有下一个更大的数字，因此输出 -1 。 
//
// 示例 2: 
//
// 
//输入: nums1 = [2,4], nums2 = [1,2,3,4].
//输出: [3,-1]
//解释:
//    对于 num1 中的数字 2 ，第二个数组中的下一个较大数字是 3 。
//    对于 num1 中的数字 4 ，第二个数组中没有下一个更大的数字，因此输出 -1 。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums1.length <= nums2.length <= 1000 
// 0 <= nums1[i], nums2[i] <= 104 
// nums1和nums2中所有整数 互不相同 
// nums1 中的所有整数同样出现在 nums2 中 
// 
//
// 
//
// 进阶：你可以设计一个时间复杂度为 O(nums1.length + nums2.length) 的解决方案吗？ 
// Related Topics 栈 数组 哈希表 单调栈 
// 👍 583 👎 0
	
  * 日期：2021-10-26 22:52:45
*/
//给你两个 没有重复元素 的数组 nums1 和 nums2 ，其中nums1 是 nums2 的子集。 
//
// 请你找出 nums1 中每个元素在 nums2 中的下一个比其大的值。 
//
// nums1 中数字 x 的下一个更大元素是指 x 在 nums2 中对应位置的右边的第一个比 x 大的元素。如果不存在，对应位置输出 -1 。 
//
// 
//
// 示例 1: 
//
// 
//输入: nums1 = [4,1,2], nums2 = [1,3,4,2].
//输出: [-1,3,-1]
//解释:
//    对于 num1 中的数字 4 ，你无法在第二个数组中找到下一个更大的数字，因此输出 -1 。
//    对于 num1 中的数字 1 ，第二个数组中数字1右边的下一个较大数字是 3 。
//    对于 num1 中的数字 2 ，第二个数组中没有下一个更大的数字，因此输出 -1 。 
//
// 示例 2: 
//
// 
//输入: nums1 = [2,4], nums2 = [1,2,3,4].
//输出: [3,-1]
//解释:
//    对于 num1 中的数字 2 ，第二个数组中的下一个较大数字是 3 。
//    对于 num1 中的数字 4 ，第二个数组中没有下一个更大的数字，因此输出 -1 。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums1.length <= nums2.length <= 1000 
// 0 <= nums1[i], nums2[i] <= 104 
// nums1和nums2中所有整数 互不相同 
// nums1 中的所有整数同样出现在 nums2 中 
// 
//
// 
//
// 进阶：你可以设计一个时间复杂度为 O(nums1.length + nums2.length) 的解决方案吗？ 
// Related Topics 栈 数组 哈希表 单调栈 
// 👍 583 👎 0

package leetcode.editor.cn;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class P496下一个更大元素INextGreaterElementI {
    public static void main(String[] args) {
        Solution solution = new P496下一个更大元素INextGreaterElementI().new Solution();
        // [1,3,5,2,4]
        //[6,5,4,3,2,1,7]
        int[] nums1 = new int[]{1,3,5,2,4};
        int[] nums2 = new int[]{6,5,4,3,2,1,7};
        int[] ints = solution.nextGreaterElement(nums1, nums2);


        System.out.println("Hello world" +  Arrays.toString(ints));


        nums1 = new int[]{4,1,2};
        nums2 = new int[]{1,3,4,2};
        ints = solution.nextGreaterElement(nums1, nums2);


        System.out.println("Hello world" +  Arrays.toString(ints));
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {


        Stack<Integer> stack = new Stack<>();
        Map<Integer, Integer> result = new HashMap<>();

        for (int index = nums2.length - 1; index >= 0; index--) {

            if (stack.isEmpty()) {
                result.put(nums2[index] , -1);
                stack.push(nums2[index]);
            } else {
                Integer peek = stack.peek();

                if (nums2[index] < peek) {
                    result.put(nums2[index], peek);
                    stack.push(nums2[index]);
                } else {

                    while (!stack.isEmpty()) {
                        peek = stack.peek();

                        if (nums2[index] < peek) {
                            result.put(nums2[index], peek);
                            stack.push(nums2[index]);
                            break;
                        } else {
                            stack.pop();
                        }

                    }
                    if (stack.isEmpty()) {
                        result.put(nums2[index], -1);
                        stack.push(nums2[index]);
                    }

                }

            }


        }

        int[] sink = new int[nums1.length];
        for (int i = 0; i < nums1.length; i++) {
            sink[i] = result.get(nums1[i]);
        }

        return sink;

    }
}
//leetcode submit region end(Prohibit modification and deletion)

} 
/**
  * 题目Id：1855
  * 题目：下标对中的最大距离
  * 内容: //给你两个 非递增 的整数数组 nums1 和 nums2 ，数组下标均 从 0 开始 计数。 
//
// 下标对 (i, j) 中 0 <= i < nums1.length 且 0 <= j < nums2.length 。如果该下标对同时满足 i <= 
//j 且 nums1[i] <= nums2[j] ，则称之为 有效 下标对，该下标对的 距离 为 j - i 。 
//
// 返回所有 有效 下标对 (i, j) 中的 最大距离 。如果不存在有效下标对，返回 0 。 
//
// 一个数组 arr ，如果每个 1 <= i < arr.length 均有 arr[i-1] >= arr[i] 成立，那么该数组是一个 非递增 数组。 
//
//
// 
//
// 示例 1： 
//
// 
//输入：nums1 = [55,30,5,4,2], nums2 = [100,20,10,10,5]
//输出：2
//解释：有效下标对是 (0,0), (2,2), (2,3), (2,4), (3,3), (3,4) 和 (4,4) 。
//最大距离是 2 ，对应下标对 (2,4) 。
// 
//
// 示例 2： 
//
// 
//输入：nums1 = [2,2,2], nums2 = [10,10,1]
//输出：1
//解释：有效下标对是 (0,0), (0,1) 和 (1,1) 。
//最大距离是 1 ，对应下标对 (0,1) 。 
//
// 示例 3： 
//
// 
//输入：nums1 = [30,29,19,5], nums2 = [25,25,25,25,25]
//输出：2
//解释：有效下标对是 (2,2), (2,3), (2,4), (3,3) 和 (3,4) 。
//最大距离是 2 ，对应下标对 (2,4) 。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums1.length <= 10⁵ 
// 1 <= nums2.length <= 10⁵ 
// 1 <= nums1[i], nums2[j] <= 10⁵ 
// nums1 和 nums2 都是 非递增 数组 
// 
// Related Topics 贪心 数组 双指针 二分查找 👍 32 👎 0
	
  * 日期：2022-05-01 09:42:16
*/
//给你两个 非递增 的整数数组 nums1 和 nums2 ，数组下标均 从 0 开始 计数。 
//
// 下标对 (i, j) 中 0 <= i < nums1.length 且 0 <= j < nums2.length 。如果该下标对同时满足 i <= 
//j 且 nums1[i] <= nums2[j] ，则称之为 有效 下标对，该下标对的 距离 为 j - i 。 
//
// 返回所有 有效 下标对 (i, j) 中的 最大距离 。如果不存在有效下标对，返回 0 。 
//
// 一个数组 arr ，如果每个 1 <= i < arr.length 均有 arr[i-1] >= arr[i] 成立，那么该数组是一个 非递增 数组。 
//
//
// 
//
// 示例 1： 
//
// 
//输入：nums1 = [55,30,5,4,2], nums2 = [100,20,10,10,5]
//输出：2
//解释：有效下标对是 (0,0), (2,2), (2,3), (2,4), (3,3), (3,4) 和 (4,4) 。
//最大距离是 2 ，对应下标对 (2,4) 。
// 
//
// 示例 2： 
//
// 
//输入：nums1 = [2,2,2], nums2 = [10,10,1]
//输出：1
//解释：有效下标对是 (0,0), (0,1) 和 (1,1) 。
//最大距离是 1 ，对应下标对 (0,1) 。 
//
// 示例 3： 
//
// 
//输入：nums1 = [30,29,19,5], nums2 = [25,25,25,25,25]
//输出：2
//解释：有效下标对是 (2,2), (2,3), (2,4), (3,3) 和 (3,4) 。
//最大距离是 2 ，对应下标对 (2,4) 。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums1.length <= 10⁵ 
// 1 <= nums2.length <= 10⁵ 
// 1 <= nums1[i], nums2[j] <= 10⁵ 
// nums1 和 nums2 都是 非递增 数组 
// 
// Related Topics 贪心 数组 双指针 二分查找 👍 32 👎 0

package leetcode.editor.cn;
public class P1855MaximumDistanceBetweenAPairOfValues {
    public static void main(String[] args) {
        Solution solution = new P1855MaximumDistanceBetweenAPairOfValues().new Solution();

        System.out.println("Hello world " + solution.maxDistance(new int[]{55,30,5,4,2}, new int[]{100,20,10,10,5}));
        System.out.println("Hello world " + solution.maxDistance(new int[]{2,2,2}, new int[]{10,10,8,1}));
        System.out.println("Hello world " + solution.maxDistance(new int[]{2,2,2}, new int[]{10,10,1}));
        System.out.println("Hello world " + solution.maxDistance(new int[]{30,29,19,5}, new int[]{25,25,25,25,25}));
        System.out.println("Hello world " + solution.maxDistance(new int[]{4,3,2,1}, new int[]{100,20,10,10,5}));
        System.out.println("Hello world " + solution.maxDistance(new int[]{100,20,10,10,5}, new int[]{4,3,2,1}));
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int maxDistance(int[] nums1, int[] nums2) {

        int max = 0;
        int s = 0, f = 0;
        while (s < nums1.length && f < nums2.length) {

            if (nums1[s] <= nums2[f]) {
                max = Math.max(max, f - s);
                f++;
            } else {
                if (s < f) {
                    s++;
                } else {
                    s++;
                    f++;
                }
            }

        }

        return max;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
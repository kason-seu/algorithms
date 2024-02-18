package leetcode.editor.cn;
/** * @author  kason * @date    2024-02-18 00:41:33 */public class Q2540MinimumCommonValue{    //给你两个整数数组 nums1 和 nums2 ，它们已经按非降序排序，请你返回两个数组的 最小公共整数 。如果两个数组 nums1 和 nums2 没有公共
//整数，请你返回 -1 。 
//
// 如果一个整数在两个数组中都 至少出现一次 ，那么这个整数是数组 nums1 和 nums2 公共 的。 
//
// 
//
// 示例 1： 
//
// 输入：nums1 = [1,2,3], nums2 = [2,4]
//输出：2
//解释：两个数组的最小公共元素是 2 ，所以我们返回 2 。
// 
//
// 示例 2： 
//
// 输入：nums1 = [1,2,3,6], nums2 = [2,3,4,5]
//输出：2
//解释：两个数组中的公共元素是 2 和 3 ，2 是较小值，所以返回 2 。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums1.length, nums2.length <= 10⁵ 
// 1 <= nums1[i], nums2[j] <= 10⁹ 
// nums1 和 nums2 都是 非降序 的。 
// 
//
// Related Topics 数组 哈希表 双指针 二分查找 👍 19 👎 0
    public static void main(String[] args) {        Solution solution = new Q2540MinimumCommonValue().new Solution();    }    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int getCommon(int[] nums1, int[] nums2) {

        int i = 0, j = 0;

        while (i < nums1.length && j < nums2.length) {
            if (nums1[i] == nums2[j]) {
                return nums1[i];
            } else if (nums1[i] < nums2[j]) {
                i++;
            } else {
                j++;
            }
        }

        return -1;

    }
}
//leetcode submit region end(Prohibit modification and deletion)
}
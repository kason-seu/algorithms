/**
  * 题目Id：713
  * 题目：乘积小于 K 的子数组
  * 内容: //给你一个整数数组 nums 和一个整数 k ，请你返回子数组内所有元素的乘积严格小于 k 的连续子数组的数目。
// 
//
// 示例 1： 
//
// 
//输入：nums = [10,5,2,6], k = 100
//输出：8
//解释：8 个乘积小于 100 的子数组分别为：[10]、[5]、[2],、[6]、[10,5]、[5,2]、[2,6]、[5,2,6]。
//需要注意的是 [10,5,2] 并不是乘积小于 100 的子数组。
// 
//
// 示例 2： 
//
// 
//输入：nums = [1,2,3], k = 0
//输出：0 
//
// 
//
// 提示: 
//
// 
// 1 <= nums.length <= 3 * 10⁴ 
// 1 <= nums[i] <= 1000 
// 0 <= k <= 10⁶ 
// 
// Related Topics 数组 滑动窗口 👍 525 👎 0
	
  * 日期：2022-05-05 23:35:01
*/
//给你一个整数数组 nums 和一个整数 k ，请你返回子数组内所有元素的乘积严格小于 k 的连续子数组的数目。
// 
//
// 示例 1： 
//
// 
//输入：nums = [10,5,2,6], k = 100
//输出：8
//解释：8 个乘积小于 100 的子数组分别为：[10]、[5]、[2],、[6]、[10,5]、[5,2]、[2,6]、[5,2,6]。
//需要注意的是 [10,5,2] 并不是乘积小于 100 的子数组。
// 
//
// 示例 2： 
//
// 
//输入：nums = [1,2,3], k = 0
//输出：0 
//
// 
//
// 提示: 
//
// 
// 1 <= nums.length <= 3 * 10⁴ 
// 1 <= nums[i] <= 1000 
// 0 <= k <= 10⁶ 
// 
// Related Topics 数组 滑动窗口 👍 525 👎 0

package leetcode.editor.cn;
public class P713SubarrayProductLessThanK {
    public static void main(String[] args) {
        Solution solution = new P713SubarrayProductLessThanK().new Solution();
        //System.out.println("Hello world " + solution.numSubarrayProductLessThanK(new int[]{10,5,2,6}, 100));
        //System.out.println("Hello world " + solution.numSubarrayProductLessThanK(new int[]{1,2,3}, 0));
        System.out.println("Hello world " + solution.numSubarrayProductLessThanK(new int[]{10,5,1,2,6}, 6));
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {



        int i = 0, j = 0;
        int value = 1;
        int ans = 0;
        while (j < nums.length) {

            int n = j;
            for (n = j; n < nums.length; n++) {
                if (value * nums[j] < k) {
                    continue;
                }
            }
            ans += (j - i + 1);

            j = n;
            i++;
        }
        if (i != nums.length - 1) {
            int width = j - i;
            ans += caulate(width);
        }


        return ans;

    }

        private int caulate(int width) {

        int sum = 0;
            for (int i = 1; i<= width; i++) {

                sum += i;

            }
            return sum;
        }

        private  int jiecheng(int n, int k) {
            int re1 = 1;
            for (int i = n-k+1; i <= n; i++) {
                re1 *= i;
            }
            int re2 = 1;
            for (int i = 1; i <= k; i++) {
                re2*= i;
            }

            return re1 / re2;
        }
}


//leetcode submit region end(Prohibit modification and deletion)

}
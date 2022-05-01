/**
  * 题目Id：1588
  * 题目：所有奇数长度子数组的和
  * 内容: //给你一个正整数数组 arr ，请你计算所有可能的奇数长度子数组的和。 
//
// 子数组 定义为原数组中的一个连续子序列。 
//
// 请你返回 arr 中 所有奇数长度子数组的和 。 
//
// 
//
// 示例 1： 
//
// 输入：arr = [1,4,2,5,3]
//输出：58
//解释：所有奇数长度子数组和它们的和为：
//[1] = 1
//[4] = 4
//[2] = 2
//[5] = 5
//[3] = 3
//[1,4,2] = 7
//[4,2,5] = 11
//[2,5,3] = 10
//[1,4,2,5,3] = 15
//我们将所有值求和得到 1 + 4 + 2 + 5 + 3 + 7 + 11 + 10 + 15 = 58 
//
// 示例 2： 
//
// 输入：arr = [1,2]
//输出：3
//解释：总共只有 2 个长度为奇数的子数组，[1] 和 [2]。它们的和为 3 。 
//
// 示例 3： 
//
// 输入：arr = [10,11,12]
//输出：66
// 
//
// 
//
// 提示： 
//
// 
// 1 <= arr.length <= 100 
// 1 <= arr[i] <= 1000 
// 
// Related Topics 数组 数学 前缀和 👍 172 👎 0
	
  * 日期：2022-04-13 22:55:11
*/
//给你一个正整数数组 arr ，请你计算所有可能的奇数长度子数组的和。 
//
// 子数组 定义为原数组中的一个连续子序列。 
//
// 请你返回 arr 中 所有奇数长度子数组的和 。 
//
// 
//
// 示例 1： 
//
// 输入：arr = [1,4,2,5,3]
//输出：58
//解释：所有奇数长度子数组和它们的和为：
//[1] = 1
//[4] = 4
//[2] = 2
//[5] = 5
//[3] = 3
//[1,4,2] = 7
//[4,2,5] = 11
//[2,5,3] = 10
//[1,4,2,5,3] = 15
//我们将所有值求和得到 1 + 4 + 2 + 5 + 3 + 7 + 11 + 10 + 15 = 58 
//
// 示例 2： 
//
// 输入：arr = [1,2]
//输出：3
//解释：总共只有 2 个长度为奇数的子数组，[1] 和 [2]。它们的和为 3 。 
//
// 示例 3： 
//
// 输入：arr = [10,11,12]
//输出：66
// 
//
// 
//
// 提示： 
//
// 
// 1 <= arr.length <= 100 
// 1 <= arr[i] <= 1000 
// 
// Related Topics 数组 数学 前缀和 👍 172 👎 0

package leetcode.editor.cn;
public class P1588SumOfAllOddLengthSubarrays {
    public static void main(String[] args) {
        Solution solution = new P1588SumOfAllOddLengthSubarrays().new Solution();
        int [] arr =new int[]{1,4,2,5,3};

        int i = solution.sumOddLengthSubarrays(arr);

        System.out.println("Hello world " + i);


        arr =new int[]{1,2};

        i = solution.sumOddLengthSubarrays(arr);

        System.out.println("Hello world " + i);
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int sumOddLengthSubarrays(int[] arr) {

        int[] sum = new int[arr.length+1];
        for (int i = 0; i < arr.length; i++) {

            sum[i+1] = sum[i] + arr[i];
        }

        int len = arr.length;
        int i = 1;
        int ans = 0;
        while (i <= len) {

            for (int j = 0; j + i<= arr.length; ) {
                ans += sum[j+i] - sum[j];
                j = j + 1;
            }
            i += 2;
        }

        return ans;


    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
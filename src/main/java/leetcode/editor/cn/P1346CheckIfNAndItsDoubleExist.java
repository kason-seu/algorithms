/**
  * 题目Id：1346
  * 题目：检查整数及其两倍数是否存在
  * 内容: //给你一个整数数组 arr，请你检查是否存在两个整数 N 和 M，满足 N 是 M 的两倍（即，N = 2 * M）。 
//
// 更正式地，检查是否存在两个下标 i 和 j 满足： 
//
// 
// i != j 
// 0 <= i, j < arr.length 
// arr[i] == 2 * arr[j] 
// 
//
// 
//
// 示例 1： 
//
// 输入：arr = [10,2,5,3]
//输出：true
//解释：N = 10 是 M = 5 的两倍，即 10 = 2 * 5 。
// 
//
// 示例 2： 
//
// 输入：arr = [7,1,14,11]
//输出：true
//解释：N = 14 是 M = 7 的两倍，即 14 = 2 * 7 。
// 
//
// 示例 3： 
//
// 输入：arr = [3,1,7,11]
//输出：false
//解释：在该情况下不存在 N 和 M 满足 N = 2 * M 。
// 
//
// 
//
// 提示： 
//
// 
// 2 <= arr.length <= 500 
// -10^3 <= arr[i] <= 10^3 
// 
// Related Topics 数组 哈希表 双指针 二分查找 排序 👍 52 👎 0
	
  * 日期：2022-04-30 21:42:28
*/
//给你一个整数数组 arr，请你检查是否存在两个整数 N 和 M，满足 N 是 M 的两倍（即，N = 2 * M）。 
//
// 更正式地，检查是否存在两个下标 i 和 j 满足： 
//
// 
// i != j 
// 0 <= i, j < arr.length 
// arr[i] == 2 * arr[j] 
// 
//
// 
//
// 示例 1： 
//
// 输入：arr = [10,2,5,3]
//输出：true
//解释：N = 10 是 M = 5 的两倍，即 10 = 2 * 5 。
// 
//
// 示例 2： 
//
// 输入：arr = [7,1,14,11]
//输出：true
//解释：N = 14 是 M = 7 的两倍，即 14 = 2 * 7 。
// 
//
// 示例 3： 
//
// 输入：arr = [3,1,7,11]
//输出：false
//解释：在该情况下不存在 N 和 M 满足 N = 2 * M 。
// 
//
// 
//
// 提示： 
//
// 
// 2 <= arr.length <= 500 
// -10^3 <= arr[i] <= 10^3 
// 
// Related Topics 数组 哈希表 双指针 二分查找 排序 👍 52 👎 0

package leetcode.editor.cn;

import java.util.Arrays;

public class P1346CheckIfNAndItsDoubleExist {
    public static void main(String[] args) {
        Solution solution = new P1346CheckIfNAndItsDoubleExist().new Solution();

        //boolean b = solution.checkIfExist(new int[]{-10, 12, -20, -8, 15});
        //boolean b = solution.checkIfExist(new int[]{-2,0,10,-19,4,6,-8});
        //boolean b = solution.checkIfExist(new int[]{0,0});
        boolean b = solution.checkIfExist(new int[]{-20,8,-6,-14,0,-19,14,4});
        //[-20,8,-6,-14,0,-19,14,4]
// [-2,0,10,-19,4,6,-8]
        System.out.println("Hello world " + b);
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean checkIfExist(int[] arr) {

        Arrays.sort(arr);

        for (int i = 0; i < arr.length; i++) {
            int l = 0;
            int r = arr.length - 1;

            while (l <= r ) {
                int mid = l + (r - l) / 2;
                if (2 * arr[i] == arr[mid] ) {
                    if (i != mid){
                        return true;
                    } else {
                       //l = mid + 1;
                        if ((mid + 1 < arr.length && arr[mid + 1] == 0) || (mid - 1 >= 0 && arr[mid-1] == 0)) {
                            return true;
                        } else {
                            break;
                        }
                    }

                } else if (2 * arr[i] > arr[mid]) {
                    l = mid + 1;

                } else {
                    r = mid - 1;
                }
            }

        }

        return false;

    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
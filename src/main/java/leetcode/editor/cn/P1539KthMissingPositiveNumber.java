/**
  * 题目Id：1539
  * 题目：第 k 个缺失的正整数
  * 内容: //给你一个 严格升序排列 的正整数数组 arr 和一个整数 k 。 
//
// 请你找到这个数组里第 k 个缺失的正整数。 
//
// 
//
// 示例 1： 
//
// 输入：arr = [2,3,4,7,11], k = 5
//输出：9
//解释：缺失的正整数包括 [1,5,6,8,9,10,12,13,...] 。第 5 个缺失的正整数为 9 。
// 
//
// 示例 2： 
//
// 输入：arr = [1,2,3,4], k = 2
//输出：6
//解释：缺失的正整数包括 [5,6,7,...] 。第 2 个缺失的正整数为 6 。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= arr.length <= 1000 
// 1 <= arr[i] <= 1000 
// 1 <= k <= 1000 
// 对于所有 1 <= i < j <= arr.length 的 i 和 j 满足 arr[i] < arr[j] 
// 
// Related Topics 数组 二分查找 👍 100 👎 0
	
  * 日期：2022-05-01 10:27:36
*/
//给你一个 严格升序排列 的正整数数组 arr 和一个整数 k 。 
//
// 请你找到这个数组里第 k 个缺失的正整数。 
//
// 
//
// 示例 1： 
//
// 输入：arr = [2,3,4,7,11], k = 5
//输出：9
//解释：缺失的正整数包括 [1,5,6,8,9,10,12,13,...] 。第 5 个缺失的正整数为 9 。
// 
//
// 示例 2： 
//
// 输入：arr = [1,2,3,4], k = 2
//输出：6
//解释：缺失的正整数包括 [5,6,7,...] 。第 2 个缺失的正整数为 6 。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= arr.length <= 1000 
// 1 <= arr[i] <= 1000 
// 1 <= k <= 1000 
// 对于所有 1 <= i < j <= arr.length 的 i 和 j 满足 arr[i] < arr[j] 
// 
// Related Topics 数组 二分查找 👍 100 👎 0

package leetcode.editor.cn;
public class P1539KthMissingPositiveNumber {
    public static void main(String[] args) {
        Solution solution = new P1539KthMissingPositiveNumber().new Solution();
        System.out.println("Hello world " + solution.findKthPositive(new int[]{2,3,4,7,11}, 5));
        System.out.println("Hello world " + solution.findKthPositive(new int[]{1,2,3,4}, 2));
        // [1,2,3,4,8,10,15,19,30]
        System.out.println("Hello world " + solution.findKthPositive(new int[]{1,2,3,4,8,10,15,19,30}, 10));

        System.out.println("Hello world " + solution.findKthPositive(new int[]{2}, 1));
        System.out.println("Hello world " + solution.findKthPositive(new int[]{3,4}, 2));
        System.out.println("Hello world " + solution.findKthPositive(new int[]{4,4}, 2));
        System.out.println("Hello world " + solution.findKthPositive(new int[]{5,6,7,8,9}, 9));
        // [1,4,7,9,14,15,16,18,20,23,24,25,26,28,29,30,33,35,38,39,42,44,46,48,49,52,53,55,57,58,60,63,68,69,70]
        //11

        System.out.println("Hello world " + solution.findKthPositive(new int[]{1,4,7,9,14,15,16,18,20,23,24,25,26,28,29,30,33,35,38,39,42,44,46,48,49,52,53,55,57,58,60,63,68,69,70}, 11));

        //[6,7,10,20,28,29,33,37,39,40,49,53,55,72,75,76,85,87,88,94,106,107,119,120,129,142,147,152,157,159,161,173,178,183,187,188,193,199,202,212,215,224,227,230,237,239,246,251,256,260,266,268,273,277,279,281,291,297,298,310,312,314,315,321,324,326,329,341,342,348,355,367,370,374,387,389,394,413,420,424,429,446,447,458,460,464,467,473,477,478,498,500,501,503,514,515,523,525,528,529,531,535,539,555,566,569,572,583,588,591,596,602,604,605,606,610,611,616,619,622,623,631,632,640,642,645,647,661,680,684,685,687,694,696,698,714,717,720,726,734,738,742,745,753,770,775,780,781,783,787,788,798,806,821,835,852,865,873,888,897,926,932,935,939,945,956,966,967,969,973,979,980,986,992,995,997]
        //96
        System.out.println("Hello world " + solution.findKthPositive(new int[]{6,7,10,20,28,29,33,37,39,40,49,53,55,72,75,76,85,87,88,94,106,107,119,120,129,142,147,152,157,159,161,173,178,183,187,188,193,199,202,212,215,224,227,230,237,239,246,251,256,260,266,268,273,277,279,281,291,297,298,310,312,314,315,321,324,326,329,341,342,348,355,367,370,374,387,389,394,413,420,424,429,446,447,458,460,464,467,473,477,478,498,500,501,503,514,515,523,525,528,529,531,535,539,555,566,569,572,583,588,591,596,602,604,605,606,610,611,616,619,622,623,631,632,640,642,645,647,661,680,684,685,687,694,696,698,714,717,720,726,734,738,742,745,753,770,775,780,781,783,787,788,798,806,821,835,852,865,873,888,897,926,932,935,939,945,956,966,967,969,973,979,980,986,992,995,997}, 96));
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int findKthPositive(int[] arr, int k) {

        int[] diff = new int[arr.length];

        for (int i = 0; i < arr.length; i++) {
            if (i == 0) {
                diff[i] = arr[i] - 1;
            } else {
                diff[i] = diff[i - 1] + arr[i] - arr[i-1] - 1;
            }
        }

        int l = 0, r = diff.length - 1;

        // 在最左侧
        if (diff[0] >= k) {
            return 1 + (k - 1);
        }
        if (diff[diff.length-1] < k) {
            return arr[diff.length-1] + k - diff[diff.length-1];
        }
        int index = getIndex(l, r, diff, k);



        return arr[index] + (k - diff[index]);

    }

    private int getIndex(int l, int r,int[] diff, int k) {
        while (l < r) {

            int mid = l + (r - l) / 2;

            if (diff[mid] < k) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }

        }

        return diff[l] >= k ? l - 1 : l;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
/**
  * 题目Id：373
  * 题目：查找和最小的 K 对数字
  * 内容: //给定两个以 升序排列 的整数数组 nums1 和 nums2 , 以及一个整数 k 。 
//
// 定义一对值 (u,v)，其中第一个元素来自 nums1，第二个元素来自 nums2 。 
//
// 请找到和最小的 k 个数对 (u1,v1), (u2,v2) ... (uk,vk) 。 
//
// 
//
// 示例 1: 
//
// 
//输入: nums1 = [1,7,11], nums2 = [2,4,6], k = 3
//输出: [1,2],[1,4],[1,6]
//解释: 返回序列中的前 3 对数：
//     [1,2],[1,4],[1,6],[7,2],[7,4],[11,2],[7,6],[11,4],[11,6]
// 
//
// 示例 2: 
//
// 
//输入: nums1 = [1,1,2], nums2 = [1,2,3], k = 2
//输出: [1,1],[1,1]
//解释: 返回序列中的前 2 对数：
//     [1,1],[1,1],[1,2],[2,1],[1,2],[2,2],[1,3],[1,3],[2,3]
// 
//
// 示例 3: 
//
// 
//输入: nums1 = [1,2], nums2 = [3], k = 3 
//输出: [1,3],[2,3]
//解释: 也可能序列中所有的数对都被返回:[1,3],[2,3]
// 
//
// 
//
// 提示: 
//
// 
// 1 <= nums1.length, nums2.length <= 10⁵ 
// -10⁹ <= nums1[i], nums2[i] <= 10⁹ 
// nums1 和 nums2 均为升序排列 
// 1 <= k <= 1000 
// 
// Related Topics 数组 堆（优先队列） 👍 380 👎 0
	
  * 日期：2022-03-06 12:19:01
*/
//给定两个以 升序排列 的整数数组 nums1 和 nums2 , 以及一个整数 k 。 
//
// 定义一对值 (u,v)，其中第一个元素来自 nums1，第二个元素来自 nums2 。 
//
// 请找到和最小的 k 个数对 (u1,v1), (u2,v2) ... (uk,vk) 。 
//
// 
//
// 示例 1: 
//
// 
//输入: nums1 = [1,7,11], nums2 = [2,4,6], k = 3
//输出: [1,2],[1,4],[1,6]
//解释: 返回序列中的前 3 对数：
//     [1,2],[1,4],[1,6],[7,2],[7,4],[11,2],[7,6],[11,4],[11,6]
// 
//
// 示例 2: 
//
// 
//输入: nums1 = [1,1,2], nums2 = [1,2,3], k = 2
//输出: [1,1],[1,1]
//解释: 返回序列中的前 2 对数：
//     [1,1],[1,1],[1,2],[2,1],[1,2],[2,2],[1,3],[1,3],[2,3]
// 
//
// 示例 3: 
//
// 
//输入: nums1 = [1,2], nums2 = [3], k = 3 
//输出: [1,3],[2,3]
//解释: 也可能序列中所有的数对都被返回:[1,3],[2,3]
// 
//
// 
//
// 提示: 
//
// 
// 1 <= nums1.length, nums2.length <= 10⁵ 
// -10⁹ <= nums1[i], nums2[i] <= 10⁹ 
// nums1 和 nums2 均为升序排列 
// 1 <= k <= 1000 
// 
// Related Topics 数组 堆（优先队列） 👍 380 👎 0

package leetcode.editor.cn;

import java.util.*;

public class P373FindKPairsWithSmallestSums {
    public static void main(String[] args) {
        Solution solution = new P373FindKPairsWithSmallestSums().new Solution();

        int l = (int)Math.pow(10, 5) * (int)Math.pow(10, 5);
        System.out.println("Hello world" + l);
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {

        public List<List<Integer>> kSmallestPairs2(int[] nums1, int[] nums2, int k) {

            int len1 = nums1.length;
            int len2 = nums2.length;

            boolean[][] recordVisited = new boolean[len1][len2];

            List<List<Integer>> ans = new ArrayList<>();

            k = Math.min(k, Math.min(len1 * len2, Integer.MAX_VALUE));

            // 使用堆存储最小的值;
            PriorityQueue<List<Integer>> priorityQueue = new PriorityQueue<>(new Comparator<List<Integer>>() {
                @Override
                public int compare(List<Integer> o1, List<Integer> o2) {
                    return  (nums1[o1.get(0)] + nums2[o1.get(1)]) - (nums1[o2.get(0)] + nums2[o2.get(1)]);
                }
            });
            // 一开始最左上角的格子是最小的值
            priorityQueue.add(Arrays.asList(0, 0));
            recordVisited[0][0] = true;

            int num = 0;

            while (!priorityQueue.isEmpty() && num < k) {

                List<Integer> poll = priorityQueue.poll();
                int num1Index = poll.get(0);
                int num2Index = poll.get(1);
                ans.add(Arrays.asList(nums1[num1Index], nums2[num2Index]));
                num++;
                // 向右
                if (num2Index + 1 < len2 && !recordVisited[num1Index][num2Index + 1]) {
                    priorityQueue.add(Arrays.asList(num1Index, num2Index + 1));
                    recordVisited[num1Index][num2Index + 1] = true;
                }
                // 向下
                if (num1Index + 1 < len1 && !recordVisited[num1Index + 1][num2Index]) {
                    priorityQueue.add(Arrays.asList(num1Index + 1, num2Index));
                    recordVisited[num1Index+1][num2Index] = true;
                }

            }

            return ans;
        }


        public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {

            int len1 = nums1.length;
            int len2 = nums2.length;
            List<List<Integer>> ans = new ArrayList<>();
            k = Math.min(k, Math.min(len1 * len2, Integer.MAX_VALUE));
            // 使用堆存储最小的值;
            PriorityQueue<List<Integer>> priorityQueue = new PriorityQueue<>(new Comparator<List<Integer>>() {
                @Override
                public int compare(List<Integer> o1, List<Integer> o2) {
                    return  (nums1[o1.get(0)] + nums2[o1.get(1)]) - (nums1[o2.get(0)] + nums2[o2.get(1)]);
                }
            });

            for (int i = 0 ; i <= Math.min(k, len2 - 1); i++) {
                priorityQueue.add(Arrays.asList(0, i));
            }
            int num = 0;
            while (!priorityQueue.isEmpty() && num < k) {

                List<Integer> poll = priorityQueue.poll();
                int num1Index = poll.get(0);
                int num2Index = poll.get(1);
                ans.add(Arrays.asList(nums1[num1Index], nums2[num2Index]));
                num++;
                // 向下
                if (num1Index + 1 < len1) {
                    priorityQueue.add(Arrays.asList(num1Index + 1, num2Index));
                }
            }

            return ans;
        }
}
//leetcode submit region end(Prohibit modification and deletion)

}
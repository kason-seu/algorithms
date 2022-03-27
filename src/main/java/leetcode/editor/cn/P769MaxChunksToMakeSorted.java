/**
  * 题目Id：769
  * 题目：最多能完成排序的块
  * 内容: //给定一个长度为 n 的整数数组 arr ，它表示在 [0, n - 1] 范围内的整数的排列。 
//
// 我们将 arr 分割成若干 块 (即分区)，并对每个块单独排序。将它们连接起来后，使得连接的结果和按升序排序后的原数组相同。 
//
// 返回数组能分成的最多块数量。 
//
// 
//
// 示例 1: 
//
// 
//输入: arr = [4,3,2,1,0]
//输出: 1
//解释:
//将数组分成2块或者更多块，都无法得到所需的结果。
//例如，分成 [4, 3], [2, 1, 0] 的结果是 [3, 4, 0, 1, 2]，这不是有序的数组。
// 
//
// 示例 2: 
//
// 
//输入: arr = [1,0,2,3,4]
//输出: 4
//解释:
//我们可以把它分成两块，例如 [1, 0], [2, 3, 4]。
//然而，分成 [1, 0], [2], [3], [4] 可以得到最多的块数。
// 
//
// 
//
// 提示: 
//
// 
// n == arr.length 
// 1 <= n <= 10 
// 0 <= arr[i] < n 
// arr 中每个元素都 不同 
// 
// Related Topics 栈 贪心 数组 排序 单调栈 👍 180 👎 0
	
  * 日期：2022-03-27 18:43:22
*/
//给定一个长度为 n 的整数数组 arr ，它表示在 [0, n - 1] 范围内的整数的排列。 
//
// 我们将 arr 分割成若干 块 (即分区)，并对每个块单独排序。将它们连接起来后，使得连接的结果和按升序排序后的原数组相同。 
//
// 返回数组能分成的最多块数量。 
//
// 
//
// 示例 1: 
//
// 
//输入: arr = [4,3,2,1,0]
//输出: 1
//解释:
//将数组分成2块或者更多块，都无法得到所需的结果。
//例如，分成 [4, 3], [2, 1, 0] 的结果是 [3, 4, 0, 1, 2]，这不是有序的数组。
// 
//
// 示例 2: 
//
// 
//输入: arr = [1,0,2,3,4]
//输出: 4
//解释:
//我们可以把它分成两块，例如 [1, 0], [2, 3, 4]。
//然而，分成 [1, 0], [2], [3], [4] 可以得到最多的块数。
// 
//
// 
//
// 提示: 
//
// 
// n == arr.length 
// 1 <= n <= 10 
// 0 <= arr[i] < n 
// arr 中每个元素都 不同 
// 
// Related Topics 栈 贪心 数组 排序 单调栈 👍 180 👎 0

package leetcode.editor.cn;


import java.util.ArrayDeque;
import java.util.Deque;

public class P769MaxChunksToMakeSorted {
    public static void main(String[] args) {
        Solution solution = new P769MaxChunksToMakeSorted().new Solution();
        int[] arr = new int[]{4,3,2,1,0};
        int ans = solution.maxChunksToSorted(arr);

        System.out.println("Hello world " + ans);

        arr = new int[]{1,0,2,3,4};
         ans = solution.maxChunksToSorted(arr);

        System.out.println("Hello world " + ans);
        arr = new int[]{1,2,0,3};
        ans = solution.maxChunksToSorted(arr);

        System.out.println("Hello world " + ans);


        arr = new int[]{0,3,1,2,4};
        ans = solution.maxChunksToSorted(arr);

        System.out.println("Hello world " + ans);
        // [2,0,1,7,3,4,5,6]
        arr = new int[]{2,0,1,7,3,4,5,6};
        ans = solution.maxChunksToSorted(arr);

        System.out.println("Hello world " + ans);
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int maxChunksToSorted(int[] arr) {

        Deque<Integer> deque = new ArrayDeque<>();
        int res = 0;
        for (int i = 0; i < arr.length; i++) {

            if (deque.isEmpty()) {
                deque.push(arr[i]);
            }
            Integer top = deque.peek();

            if(i <= top) {
                if (arr[i] > top) {
                    deque.pop();
                    deque.push(arr[i]);
                }
                if (i == top) {
                    if ( i == arr[i]) {
                        res++;
                        deque.pop();
                    } else if (arr[i] < top) {
                        res++;
                        deque.pop();
                    }
                }
            }

            if (i > top) {
                res++;
                deque.pop();
                if (i == arr[i]) {
                    res++;
                }
            }
        }

        if (!deque.isEmpty()) {
            res++;
        }

        return res;

    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
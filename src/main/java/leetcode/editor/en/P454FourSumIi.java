//Given four lists A, B, C, D of integer values, compute how many tuples (i, j, 
//k, l) there are such that A[i] + B[j] + C[k] + D[l] is zero. 
//
// To make problem a bit easier, all A, B, C, D have same length of N where 0 ≤ 
//N ≤ 500. All integers are in the range of -228 to 228 - 1 and the result is guar
//anteed to be at most 231 - 1. 
//
// Example: 
//
// 
//Input:
//A = [ 1, 2]
//B = [-2,-1]
//C = [-1, 2]
//D = [ 0, 2]
//
//Output:
//2
//
//Explanation:
//The two tuples are:
//1. (0, 0, 0, 1) -> A[0] + B[0] + C[0] + D[1] = 1 + (-2) + (-1) + 2 = 0
//2. (1, 1, 0, 0) -> A[1] + B[1] + C[0] + D[0] = 2 + (-1) + (-1) + 0 = 0
// 
//
// 
// Related Topics Hash Table Binary Search 
// 👍 1397 👎 76

package leetcode.editor.en;
//Java：4Sum II

import java.util.HashMap;

public class P454FourSumIi {
    public static void main(String[] args) {
        Solution solution = new P454FourSumIi().new Solution();
        int[] A= new int[] {1,2};
        int[] B= new int[] {-2,-1};
        int[] C= new int[] {-1,2};
        int[] D= new int[] {0,2};
        System.out.println(solution.fourSumCount(A,B,C,D));
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {

        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < B.length; j++) {
                if (map.containsKey(A[i] + B[j])) {

                    map.put((A[i] + B[j]),map.get(A[i] + B[j]) + 1);

                } else {
                    map.put(A[i] + B[j], 1);
                }
            }
        }
        int totalCnt = 0;
        for (int i = 0; i < C.length; i++) {
            for (int j = 0; j < D.length; j++) {
                if (map.containsKey(- C[i] - D[j])) {
                    totalCnt += map.get(-C[i]-D[j]);
                }
            }
        }
        return totalCnt;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
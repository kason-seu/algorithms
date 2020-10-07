//
//You are given two arrays (without duplicates) nums1 and nums2 where nums1’s el
//ements are subset of nums2. Find all the next greater numbers for nums1's elemen
//ts in the corresponding places of nums2. 
// 
//
// 
//The Next Greater Number of a number x in nums1 is the first greater number to 
//its right in nums2. If it does not exist, output -1 for this number.
// 
//
// Example 1: 
// 
//Input: nums1 = [4,1,2], nums2 = [1,3,4,2].
//Output: [-1,3,-1]
//Explanation:
//    For number 4 in the first array, you cannot find the next greater number f
//or it in the second array, so output -1.
//    For number 1 in the first array, the next greater number for it in the sec
//ond array is 3.
//    For number 2 in the first array, there is no next greater number for it in
// the second array, so output -1.
// 
// 
//
// Example 2: 
// 
//Input: nums1 = [2,4], nums2 = [1,2,3,4].
//Output: [3,-1]
//Explanation:
//    For number 2 in the first array, the next greater number for it in the sec
//ond array is 3.
//    For number 4 in the first array, there is no next greater number for it in
// the second array, so output -1.
// 
// 
//
//
// Note: 
// 
// All elements in nums1 and nums2 are unique. 
// The length of both nums1 and nums2 would not exceed 1000. 
// 
// Related Topics Stack 
// 👍 1832 👎 2384

package leetcode.editor.en;
//Java：Next Greater Element I

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class P496NextGreaterElementI {
    public static void main(String[] args) {
        Solution solution = new P496NextGreaterElementI().new Solution();
        int[] nums1 = new int[]{2,4};
        int[] nums2 = new int[]{1,2,3,4};
        Arrays.stream(solution.nextGreaterElement(nums1, nums2)).forEach(System.out::println);
        System.out.println("----");
        nums1 = new int[]{4,1,2};
        nums2 = new int[]{1,3,4,2};
        Arrays.stream(solution.nextGreaterElement(nums1, nums2)).forEach(System.out::println);
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {

        Map<Integer, Integer> re =new HashMap<>();
        Stack<Integer> stack = new Stack<>();
       for (int i = 0; i < nums2.length; i++) {
           if (stack.empty()) {
               stack.push(nums2[i]);
           } else {
               if (nums2[i] > stack.peek()) {
                   while (!stack.empty() && nums2[i] > stack.peek()) {
                       re.put(stack.pop(), nums2[i]);
                   }
                   stack.push(nums2[i]);
               } else {
                   stack.push(nums2[i]);
               }
           }
       }
       while (!stack.empty()) {
           re.put(stack.pop(), -1);
       }
       int[] sink = new int[nums1.length];
       for (int j = 0; j < nums1.length; j++) {
           sink[j] = re.get(nums1[j]);
       }
       return sink;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
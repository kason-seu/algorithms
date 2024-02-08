package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

/** * @author  kason * @date    2024-01-21 23:12:41 */public class Q0046Permutations{    //给定一个不含重复数字的数组 nums ，返回其 所有可能的全排列 。你可以 按任意顺序 返回答案。
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,2,3]
//输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
// 
//
// 示例 2： 
//
// 
//输入：nums = [0,1]
//输出：[[0,1],[1,0]]
// 
//
// 示例 3： 
//
// 
//输入：nums = [1]
//输出：[[1]]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 6 
// -10 <= nums[i] <= 10 
// nums 中的所有整数 互不相同 
// 
//
// Related Topics 数组 回溯 👍 2797 👎 0
    public static void main(String[] args) {        Solution solution = new Q0046Permutations().new Solution();    }    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {

        public List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> permute(int[] nums) {

        traversal(nums, new ArrayList<>());
        return res;

    }

    private void traversal(int[] nums, List<Integer> oneResult) {

        if (oneResult.size() == nums.length) {
            res.add(new ArrayList<>(oneResult));
            return;
        }

        for (int num : nums) {
            // 先序遍历
            if (!oneResult.contains(num)) {
                oneResult.add(num);
                traversal(nums, oneResult);
                oneResult.remove(oneResult.size()-1);
            }
        }


    }
}
//leetcode submit region end(Prohibit modification and deletion)
}
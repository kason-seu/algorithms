package leetcode.editor.cn;

public class POffer57 {

    public int[] twoSum(int[] nums, int target) {

        if (nums.length == 0) {
            return new int[]{};
        }
        int l = 0; int r = nums.length - 1;

        while (l < r) {

            if (nums[l] + nums[r] > target) {
                r--;
            } else if (nums[l] + nums[r] < target) {
                l++;
            } else {
                return new int[]{l,r};
            }

        }
        return new int[]{};
    }
}

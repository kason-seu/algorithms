package leetcode.editor.cn;

public class Poffer53 {


    public int missingNumber2(int[] nums) {
        int i = 0;
        for (; i < nums.length; i++) {

            if (nums[i] != i) {
                return i;
            }


        }
        return i;
    }

    public int missingNumber(int[] nums) {
        int l = 0, r = nums.length;

        while (l < r) {

            int mid = l + (r - l) /2;

            if (nums[mid] == mid) {
                l = mid + 1;
            } else {
                r = mid ;
            }

        }

        return l;
    }
}

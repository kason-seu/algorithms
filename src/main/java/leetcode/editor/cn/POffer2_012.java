package leetcode.editor.cn;

public class POffer2_012 {


    public static void main(String[] args) {

    }


    public int pivotIndex(int[] nums) {

        int[] sum = new int[nums.length];
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            sum[i] = i > 0 ? sum[i-1] + nums[i] : nums[i];
        }

        for (int i = 0; i <= len; i++) {

            int sumLeft;
            int sumRight;

            if (i == 0) {
                sumLeft =  0;
                sumRight = sum[len-1] - nums[0];
            } else if (i == len -1){
                sumLeft = sum[len-1] - nums[len-1];
                sumRight = 0;
            } else {
                sumLeft = sum[i - 1];
                sumRight = sum[len-1] - sum[i];
            }

            if (sumLeft == sumRight) {
                return i;
            }
        }

        return -1;

    }
}

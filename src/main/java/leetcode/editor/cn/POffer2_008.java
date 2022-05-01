package leetcode.editor.cn;

import java.util.Arrays;

public class POffer2_008 {


    public static void main(String[] args) {

        POffer2_008 p = new POffer2_008();
        int[] nums = new int[]{2,3,1,2,4,3};
//        System.out.println(p.minSubArrayLen(7, nums));
//
//
//        nums = new int[]{1,4,4};
//        System.out.println(p.minSubArrayLen(4, nums));

        nums = new int[]{2,3,1,1,1,1,1};
        System.out.println(p.minSubArrayLen(5, nums));

    }


    private int binarySearch(int[] arr, int l,int r, int value) {
        int mid = -1;
        while (l < r) {

            mid = (l + r) /2;

            if (arr[mid] >= value) {
                r = mid;
            } else if (arr[mid] < value) {
                l = mid + 1;
            }

        }
        return (arr[l] >= value) ? l : -1;

    }

    // sums[i] - sums[j] >= target  =>  sum[i] >= sums[j] + target, 所以可以使用二分查找来找
    public int minSubArrayLen(int s, int[] nums) {
        int n = nums.length;
        if (n == 0) {
            return 0;
        }
        int ans = Integer.MAX_VALUE;
        int[] sums = new int[n + 1];
        sums[0] = 0;
        for (int i = 1; i <= n; i++) {
            sums[i] = sums[i - 1] + nums[i-1];
        }

        if (sums[nums.length] < s) {
            return 0;
        }
        for (int i = 0; i <= n; i++) {
            int target = s + sums[i];
            int bound = binarySearch(sums, 0, sums.length-1,target);
            if (bound != -1 && bound <= n) {
                ans = Math.min(ans, bound - i);
            }
        }
        return ans == Integer.MAX_VALUE ? 0 : ans;

    }
}

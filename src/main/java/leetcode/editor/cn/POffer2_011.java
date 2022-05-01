package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class POffer2_011 {


    public static void main(String[] args) {

        //int[] arr = new int[]{1,1,1,1,1,1,1,0,0,0,0,1,1,0,1,0,0,1,1,1,1,1,1,1,1,1,0,0,0,0,1,0,0,0,0,1,0,1,0,0,0,1,1,0,0,0,0,1,0,0,1,1,1,1,1,0,0,1,0,1,1,0,0,0,1,0,0,0,1,1,1,0,1,1,0,1,0,0,1,1,0,1,0,0,1,1,1,0,0,1,0,1,1,1,0,0,1,0,1,1};
        //int[] arr = new int[]{1,1,0,0,1,0,0};
        int[] arr = new int[]{0,1};
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
        }
        System.out.println(sum);
POffer2_011 p = new POffer2_011();
        System.out.println(p.findMaxLength(arr));
    }

    Map<Integer, Integer> sumIndexMap = new HashMap<>();
    public int findMaxLength(int[] nums) {
        int len = nums.length;
        int[] sum = new int[len+1];
        sumIndexMap.put(0, 0);
        int max = 0;
        for (int i = 1; i < len+1; i++) {
            sum[i] = sum[i-1] + (nums[i-1] == 0 ? -1 : 1);
            if (sumIndexMap.containsKey(sum[i])) {

                max = Math.max(max, i - sumIndexMap.get(sum[i]));
            } else {
                sumIndexMap.put(sum[i], i);
            }
        }

        return max;



    }
}

package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class POffer2_010 {


    public static void main(String[] args) {

        int[] arr = new int[]{1,2,3};
        POffer2_010 p = new POffer2_010();
        int i = p.subarraySum(arr, 3);

        System.out.println(i);

        arr = new int[]{1,1,1};
        System.out.println(p.subarraySum(arr, 2));

        arr = new int[]{-100,-300,-200,-200,-400};
        System.out.println(p.subarraySum(arr, -400));


        arr = new int[]{1};
        System.out.println(p.subarraySum(arr, 0));
    }


    public int subarraySum(int[] nums, int k) {

        Map<Integer, List<Integer>> sumIndexMap = new HashMap<>();
        int[] sum = new int[nums.length + 1];
        sum[0] = 0;
        List<Integer> list = new ArrayList<>();
        list.add(0);
        sumIndexMap.put(0, list);
        for (int i = 1; i <= nums.length; i++) {
            sum[i] = sum[i-1] + nums[i-1];
            if (sumIndexMap.containsKey(sum[i])) {
                sumIndexMap.get(sum[i]).add(i);
            } else {
                List<Integer> l = new ArrayList<>();
                l.add(i);
                sumIndexMap.put(sum[i], l);
            }
        }
        int ans = 0;
        for (int j = nums.length; j >=0 ; j--) {
            int sumJ = sum[j];
            if (sumIndexMap.containsKey(sumJ-k)) {
                List<Integer> matched = sumIndexMap.get(sumJ - k);

                for (int i : matched) {
                    if (j > i) {
                        ans+=1;
                    }
                }
            }
        }
        return ans;
    }

}

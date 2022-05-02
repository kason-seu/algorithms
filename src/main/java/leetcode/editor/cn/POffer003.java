package leetcode.editor.cn;

import java.util.HashSet;
import java.util.Set;

public class POffer003 {


    public int findRepeatNumber(int[] nums) {

        Set<Integer> keys = new HashSet<>();

        for (int i = 0; i < nums.length; i++) {


            if (keys.contains(nums[i])) {
                return nums[i];
            } else {
                keys.add(nums[i]);
            }

        }

        return -1;
    }
}

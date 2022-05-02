package leetcode.editor.cn;

public class POffer21 {


    public static void main(String[] args) {
        int[] nums = new int[]{1,1,4,4,4,3,5,5};
        new POffer21().exchange(nums);
        System.out.println();
        System.out.println();
    }


    public int[] exchange(int[] nums) {

        if (nums.length == 0) {
            return new int[]{};
        }

        int oushu = 0;

        int swapPos = -1;
        while (oushu < nums.length ) {

            if (nums[oushu]%2 == 1) {
                // 交换
                if (swapPos != -1) {
                    swap(nums, swapPos, oushu);
                    swapPos++;
                    oushu++;
                } else {
                    oushu++;
                }
                continue;
            }
            // 偶数位置，也就是需要交换的位置
            swapPos = oushu;

            while (oushu < nums.length && nums[oushu] % 2 == 0) {
                oushu++;
            }

            if (oushu < nums.length) {
                swap(nums, swapPos, oushu);
                swapPos = swapPos + 1;
                oushu = oushu + 1;
            }
        }

//        if (swapPos != -1 && swapPos != oushu && oushu == nums.length) {
//            swap(nums, swapPos, oushu-1);
//        }
        return nums;

    }



    public int[] exchange2(int[] nums) {

        if (nums.length == 0) {
            return new int[]{};
        }

        int jishu = 0, oushu = 0;

        while (jishu < nums.length && oushu < nums.length) {

            while (nums[jishu]%2 == 1) {
                jishu++;
            }
            if (jishu < nums.length && nums[jishu] % 2 == 0) {


                oushu = jishu;

                while (nums[oushu] % 2 == 0) {
                    oushu++;
                }

                if (oushu < nums.length && nums[oushu] % 2 == 1) {
                    swap(nums, jishu, oushu);
                }
            }

        }

        return nums;

    }

    private void swap(int[] nums, int jishu, int oushu) {

        int temp = nums[jishu];
        nums[jishu] = nums[oushu];
        nums[oushu] = temp;

    }
}

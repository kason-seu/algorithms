package leetcode.editor.algorithms;

public class MP19Q3 {


    public static void main(String[] args) {
        int[] arr = new int[] {1,3,5,7};
        //int[] arr = new int[] {1,2,3,7};
        MP19Q3 d = new MP19Q3();
        //int minCantCompose = 0;
        int minCantCompose = d.getMinCantCompose2(arr);

        System.out.println(minCantCompose);

         arr = new int[] {1,2,3,7};
        d = new MP19Q3();
       minCantCompose = d.getMinCantCompose2(arr);

        System.out.println(minCantCompose);

        arr = new int[] {3,2,5};
        d = new MP19Q3();
        minCantCompose = d.getMinCantCompose2(arr);

        System.out.println(minCantCompose);

        arr = new int[] {1,2,4};
        d = new MP19Q3();
        minCantCompose = d.getMinCantCompose2(arr);

        System.out.println(minCantCompose);
    }

    private int getMinCantCompose(int[] arr) {

        int min = Integer.MAX_VALUE;

        int sum = 0;
        for (int i = 0 ; i < arr.length; i++) {
            min = Math.min(min, arr[i]);
            sum += arr[i];
        }
        for (int ans = min + 1; ans < sum; ans ++) {
            if (!decide(-1 , ans, arr)) {
                return ans;
            }
        }
        return sum + 1;

    }

    /**
     * 递归解法: 就是个背包的递归方案
     * @param index
     * @param sum
     * @param arr
     * @return
     */
    private boolean decide(int index, int sum, int[] arr) {
        if (index >= arr.length ) {
            return false;
        }
        if (sum == 0) {
            return true;
        }

        for (int j = index + 1 ; j < arr.length; j++) {
            boolean canCompose = decide(j, sum - arr[j], arr);
            if (canCompose) {
                return true;
            }
        }

        return false;
    }
    private int getMinCantCompose2(int[] arr) {

        int min = Integer.MAX_VALUE;

        int sum = 0;
        for (int i = 0 ; i < arr.length; i++) {
            min = Math.min(min, arr[i]);
            sum += arr[i];
        }

        int[][] stored = new int[arr.length + 1][sum + 1 ];
        for (int i = 0; i < arr.length + 1; i++) {
            for (int j = 0; j < sum + 1; j ++) {
                stored[i][j] = -1;
            }
        }
        for (int ans = min + 1; ans < sum; ans ++) {
            if (dg(0 , ans, arr, stored) != 1) {
                return ans;
            }
        }
        return sum + 1;

    }
    private int dg(int index, int sum, int[] arr, int[][] stored) {
        if (sum == 0 ) {
            stored[index][sum] = 1;
            return 1;
        }
        int fans = 0;
        if (index + 1 <= arr.length && (sum -arr[index]) >= 0 ) {
            int val = stored[index + 1][sum - arr[index]];
            if (val == 1) {
                stored[index][sum] = 1;
                return 1;
            } else if (val == -1) {
                fans = dg(index + 1, sum - arr[index], arr, stored);
                if (fans == 1) {
                    stored[index][sum] = 1;
                    return 1;
                }
            }

        }
        if (index + 1 < arr.length && sum >= 0) {
            int val = stored[index + 1][sum];
            if (val == 1) {
                stored[index][sum] = 1;
                return 1;
            } else if (val == -1) {
                fans = dg(index + 1, sum, arr, stored);
                if (fans == 1) {
                    stored[index][sum] = 1;
                    return 1;
                }
            }
        }
        stored[index][sum] = fans;
        return stored[index][sum];
    }

}

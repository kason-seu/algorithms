package algorithms.digui;

public class 连续最大子数组和 {



    public static void main(String[] args) {

        int[] arr = new int[]{-2,1,-3,4,-1,2,1,-5,4};


        连续最大子数组和 l = new 连续最大子数组和();

        int dg = l.dg(arr, arr.length - 1);

        System.out.println(dg);

    }

    private int dg(int[] arr, int index) {


        if (index == 0) {
            return arr[0];
        }


        return Math.max(arr[index], dg(arr,index-1) + arr[index]);


    }
}

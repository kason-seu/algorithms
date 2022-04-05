package leetcode.editor.cn;

import java.util.ArrayDeque;
import java.util.Deque;

public class P1616 {


    public static void main(String[] args) {
        int[] arr = new int[]{1,2,4,7,10,11,7,12,6,7,16,18,19};

        P1616 p = new P1616();

        int[] ints = p.subSort(arr);

        System.out.println(ints[0] + " " + ints[1]);


        arr = new int[]{1,2,3,4,5,6,7,8};

        p = new P1616();

        ints = p.subSort(arr);

        System.out.println(ints[0] + " " + ints[1]);

    }


    public int[] subSort(int[] array) {

        Deque<Integer> deque = new ArrayDeque<>();
        int start = Integer.MAX_VALUE;
        // start的位置对应的可能被更新后的实际value值
        int startToValue = Integer.MAX_VALUE;
        int end = -1;
        int maxInRange = Integer.MIN_VALUE;

        for (int i = 0; i < array.length; i++) {
            boolean exeSwap = false;
            while (!deque.isEmpty() && array[i] < array[deque.peek()]) {
                exeSwap  = true;
                int popIndex = deque.pop();
                start = Math.min(start, popIndex);
                startToValue = array[i];
                maxInRange = Math.max(maxInRange, array[popIndex]);
            }

            deque.push(i);
            if (exeSwap || (start != Integer.MAX_VALUE && array[i] > startToValue && array[i] < maxInRange)) {
                end = i;
            }
        }

        return start != Integer.MAX_VALUE ? new int[]{start, end} : new int[]{-1,-1};


    }
}

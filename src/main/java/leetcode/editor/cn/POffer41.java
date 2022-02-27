package leetcode.editor.cn;

import java.util.ArrayDeque;
import java.util.Deque;

public class POffer41 {

    class MovingAverage {

        private Deque<Integer> deque;
        private int size;
        private int sum = 0;
        /** Initialize your data structure here. */
        public MovingAverage(int size) {
            deque = new ArrayDeque<>(size);
            this.size = size;

        }

        public double next(int val) {

            if (this.size <= deque.size()) {
                Integer pop = deque.pop();
                sum -= pop;
            }
            sum+= val;
            deque.offer(val);
            return (1.0 * sum) / deque.size();
        }
    }
}

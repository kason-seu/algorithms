package leetcode.editor.cn;

import java.util.Deque;
import java.util.LinkedList;

public class POffer59 {

    class MaxQueue {

        private Deque<Integer> queue1;
        private Deque<Integer> queue2;
        public MaxQueue() {

            queue1 = new LinkedList<>();
            queue2 = new LinkedList<>();
        }

        public int max_value() {

            return queue2.isEmpty() ? -1 : queue2.peek();
        }

        public void push_back(int value) {
            queue1.offer(value);
            if (queue2.isEmpty()) {
                queue2.offer(value);
            } else {

                int len = queue2.size();
                int needUpdate = 1;
                for (int i = 0; i < len; i++) {
                    Integer last = queue2.peekLast();
                    if (last < value) {
                        queue2.pollLast();
                        needUpdate++;
                        //queue2.addLast(value);
                    }

                }

                for (int i = 0; i < needUpdate; i++) {
                    queue2.addLast(value);
                }


            }
        }

        public int pop_front() {

            if (queue1.isEmpty() ) return -1;
            Integer poll = queue1.poll();
            queue2.poll();

            return poll;
        }
    }
}

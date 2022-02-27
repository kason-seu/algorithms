package leetcode.editor;

import com.sun.jmx.remote.internal.ArrayQueue;

import java.util.ArrayDeque;
import java.util.Deque;

public class P933 {


     class RecentCounter {

        private  Deque<Integer> arrayDeauqe;
        private  int size = 0;
        public RecentCounter() {
            arrayDeauqe = new ArrayDeque();
        }

         public int ping(int t) {

            arrayDeauqe.addLast(t);
            size++;

            while (!arrayDeauqe.isEmpty()) {
                Integer peek = arrayDeauqe.peek();

                if (!(peek >= t - 3000 && peek <= t)) {
                    arrayDeauqe.pop();
                    size--;
                } else {
                    break;
                }

            }
            return size;
        }
    }
}

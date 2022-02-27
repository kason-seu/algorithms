package leetcode.editor.cn;

import java.util.Deque;
import java.util.LinkedList;

public class P0306 {


    class AnimalShelf {
        private Deque<int[]> dogDeque ;
        private Deque<int[]> catDeque ;
        public AnimalShelf() {
            dogDeque = new LinkedList<>();
            catDeque = new LinkedList<>();
        }

        public void enqueue(int[] animal) {
            if (animal[1] == 0) {
                catDeque.offer(animal);
            }  else if (animal[1] == 1) {
                dogDeque.offer(animal);
            }
        }

        public int[] dequeueAny() {

            if (dogDeque.isEmpty()) {
                return catDeque.peek() != null ? catDeque.poll() : new int[]{-1,-1};
            }
            if (catDeque.isEmpty()) {
                return dogDeque.peek() != null ? dogDeque.poll() : new int[]{-1,-1};
            }
            return dogDeque.peek()[0] > catDeque.peek()[0] ? catDeque.poll() : dogDeque.poll();
        }

        public int[] dequeueDog() {
            return dogDeque.peek() != null ? dogDeque.poll() : new int[]{-1,-1};
        }

        public int[] dequeueCat() {
            return catDeque.peek() != null ? catDeque.poll() : new int[]{-1,-1};
        }
    }
}

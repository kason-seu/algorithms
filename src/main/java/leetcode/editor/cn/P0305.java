package leetcode.editor.cn;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

public class P0305 {


    class SortedStack {

        private Deque<Integer> stack;
        private Deque<Integer> temp;
        public SortedStack() {

            stack = new ArrayDeque<>();
            temp = new ArrayDeque<>();
        }

        public void push(int val) {

            while (!stack.isEmpty() && val > stack.peek()) {
                Integer pop = stack.pop();
                temp.push(pop);
            }
            stack.push(val);
            while (!temp.isEmpty()) {
                stack.push(temp.pop());
            }
        }

        public void pop() {
            if (!stack.isEmpty()) {
                stack.pop();
            }
        }

        public int peek() {

            return stack.isEmpty() ? -1 : stack.peek();
        }

        public boolean isEmpty() {

            return stack.isEmpty();
        }
    }
}

package leetcode.editor.cn;

import java.util.ArrayDeque;
import java.util.Deque;

public class P03052 {
    class SortedStack {
        private Deque<Integer> stack;
        public SortedStack() {
            stack = new ArrayDeque<>();
        }

        public void push(int val) {


            // 直接可以入栈的
            if (!stack.isEmpty() && val <= stack.peek()) {
                stack.push(val);
                return;
            }

if (stack.isEmpty()) {
    stack.push(val);
    return;
}
            // 递归的进行栈排序
            Integer pop = stack.pop();
            push(val);
            stack.push(pop);
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

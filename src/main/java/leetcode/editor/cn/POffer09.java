package leetcode.editor.cn;

import java.util.Stack;

public class POffer09 {
    class CQueue {

        private Stack<Integer> stack1 ;
        private Stack<Integer> stack2 ;
        public CQueue() {
            stack1 = new Stack<>();
            stack2 = new Stack<>();
        }

        public void appendTail(int value) {
            stack1.push(value);
        }

        public int deleteHead() {
            if (stack2.isEmpty()) {
                while (!stack1.isEmpty()) {
                    stack2.push(stack1.pop());
                }
            }
            return stack2.isEmpty() ? -1 : stack2.pop();
        }
    }
}

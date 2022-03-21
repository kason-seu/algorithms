package leetcode.editor.algorithms;

import java.util.Stack;

public class ReverseStack {

    public static void main(String[] args) {

        ReverseStack reverseStack = new ReverseStack();
        Stack<Integer> stack = new Stack<>();
        stack.push(3);
        stack.push(2);
        stack.push(1);
        System.out.println(stack);
        reverseStack.g(stack);
        System.out.println(stack);


    }

    private int f(Stack<Integer> stack) {

        if (stack.size() == 1) {
            return stack.pop();
        }

        int result = stack.pop();
        int another = f(stack);
        stack.push(result);

        return another;

    }

    private void g(Stack<Integer> stack) {
        if (stack.isEmpty()) {
            return;
        }
        int result = f(stack);
        g(stack);
        stack.push(result);
    }

}

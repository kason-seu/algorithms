//Implement a last in first out (LIFO) stack using only two queues. The implemen
//ted stack should support all the functions of a normal queue (push, top, pop, an
//d empty). 
//
// Implement the MyStack class: 
//
// 
// void push(int x) Pushes element x to the top of the stack. 
// int pop() Removes the element on the top of the stack and returns it. 
// int top() Returns the element on the top of the stack. 
// boolean empty() Returns true if the stack is empty, false otherwise. 
// 
//
// Notes: 
//
// 
// You must use only standard operations of a queue, which means only push to ba
//ck, peek/pop from front, size, and is empty operations are valid. 
// Depending on your language, the queue may not be supported natively. You may 
//simulate a queue using a list or deque (double-ended queue), as long as you use 
//only a queue's standard operations. 
// 
//
// Follow-up: Can you implement the stack such that each operation is amortized 
//O(1) time complexity? In other words, performing n operations will take overall 
//O(n) time even if one of those operations may take longer. 
//
// 
// Example 1: 
//
// 
//Input
//["MyStack", "push", "push", "top", "pop", "empty"]
//[[], [1], [2], [], [], []]
//Output
//[null, null, null, 2, 2, false]
//
//Explanation
//MyStack myStack = new MyStack();
//myStack.push(1);
//myStack.push(2);
//myStack.top(); // return 2
//myStack.pop(); // return 2
//myStack.empty(); // return False
// 
//
// 
// Constraints: 
//
// 
// 1 <= x <= 9 
// At most 100 calls will be made to push, pop, top, and empty. 
// 
// Related Topics Stack Design 
// 👍 800 👎 604

package leetcode.editor.en;
//Java：Implement Stack using Queues

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.BlockingDeque;
import java.util.concurrent.LinkedBlockingQueue;

public class P225ImplementStackUsingQueues {
    public static void main(String[] args) {
        MyStack solution = new P225ImplementStackUsingQueues().new MyStack();
        solution.push(1);
        solution.push(2);
        System.out.println(solution.top());
        int pop = solution.pop();
        System.out.println(pop);
        System.out.println(solution.empty());
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class MyStack {

        private LinkedList<Integer> q1 = new LinkedList<Integer>() {
        };
        private LinkedList<Integer> q2 = new LinkedList<>();


    /** Initialize your data structure here. */
    public MyStack() {
        
    }
    
    /** Push element x onto stack. */
    public void push(int x) {
        if (q1.isEmpty() && q2.isEmpty()) {
            q1.add(x);
            return;
        }
        if (q1.isEmpty() && !q2.isEmpty()) {
            q1.add(x);
            while (!q2.isEmpty()) {
                q1.add(q2.pop());
            }
            return;
        }
        if (q2.isEmpty() && !q1.isEmpty()) {
            q2.add(x);
            while (!q1.isEmpty()) {
                q2.add(q1.pop());
            }
            return;
        }
    }
    
    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        return q1.isEmpty() ? q2.pop() : q1.pop();
    }
    
    /** Get the top element. */
    public int top() {
        return q1.isEmpty() ? q2.peek() : q1.peek();
    }
    
    /** Returns whether the stack is empty. */
    public boolean empty() {
        if (!q1.isEmpty() || !q2.isEmpty()) {
            return false;
        }
        return true;
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */
//leetcode submit region end(Prohibit modification and deletion)

}
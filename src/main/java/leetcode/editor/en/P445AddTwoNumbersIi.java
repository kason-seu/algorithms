//You are given two non-empty linked lists representing two non-negative integer
//s. The most significant digit comes first and each of their nodes contain a sing
//le digit. Add the two numbers and return it as a linked list. 
//
// You may assume the two numbers do not contain any leading zero, except the nu
//mber 0 itself. 
//
// Follow up: 
//What if you cannot modify the input lists? In other words, reversing the lists
// is not allowed.
// 
//
// 
//Example:
// 
//Input: (7 -> 2 -> 4 -> 3) + (5 -> 6 -> 4)
//Output: 7 -> 8 -> 0 -> 7
// 
// Related Topics Linked List 
// 👍 1683 👎 167

package leetcode.editor.en;
//Java：Add Two Numbers II

import common.ListNode;
import common.NodeUtils;

import java.util.Stack;

public class P445AddTwoNumbersIi {
    public static void main(String[] args) {
        Solution solution = new P445AddTwoNumbersIi().new Solution();
        ListNode l1 = new ListNode(7);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(4);
        ListNode l4 = new ListNode(3);
        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        l4.next = null;

        ListNode m1 = new ListNode(5);
        ListNode m2 = new ListNode(6);
        ListNode m3 = new ListNode(4);
        m1.next = m2;
        m2.next = m3;

        ListNode h1  = solution.addTwoNumbers(l1, m1);

        NodeUtils.printNode(h1);

        l1 = new ListNode(7);
        m1 = new ListNode(5);
        ListNode listNode = solution.addTwoNumbers(l1, m1);
        NodeUtils.printNode(listNode);

        System.out.println("----");

        l1 = new ListNode(9);
        l2 = new ListNode(1);
        l3 = new ListNode(6);
        l1.next = l2;
        l2.next = l3;
        m1 = new ListNode(0);
        listNode = solution.addTwoNumbers(l1, m1);
        NodeUtils.printNode(listNode);

        System.out.println("----");

        l1 = new ListNode(8);
        l2 = new ListNode(9);
        l3 = new ListNode(9);
        l1.next = l2;
        l2.next = l3;
        m1 = new ListNode(2);
        listNode = solution.addTwoNumbers(l1, m1);
        NodeUtils.printNode(listNode);
    }
    //leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        Stack<Integer> one = new Stack<>();
        Stack<Integer> two = new Stack<>();
        while (l1 != null) {
            one.push(l1.val);
            l1 = l1.next;
        }
        while (l2 != null) {
            two.push(l2.val);
            l2 = l2.next;
        }
        int tmp = 0;
        ListNode t = null;
        ListNode h = null;
        while (!one.empty() && !two.empty()) {
            Integer onePop = one.pop();
            Integer twoPop = two.pop();

            if (onePop + twoPop + tmp <= 9) {
                if (h == null) {
                    h  = new ListNode(onePop + twoPop + tmp);
                    t = h;
                } else {
                    ListNode temp = new ListNode(onePop + twoPop + tmp);
                    t.next = temp;
                    t = temp;

                }
                tmp = 0;
            } else {
                if (h == null) {
                    h  = new ListNode(onePop + twoPop + tmp - 10);
                    t = h;
                    tmp = 1;
                } else {
                    ListNode temp = new ListNode(onePop + twoPop + tmp - 10);
                    t.next = temp;
                    t = temp;
                    tmp = 1;
                }
            }

        }
        while (!one.empty()) {
            Integer onePop = one.pop();
            ListNode temp;
            if (onePop + tmp <= 9) {
                temp = new ListNode(onePop + tmp);
                tmp = 0;
            } else {
                temp = new ListNode(onePop + tmp - 10);
                tmp = 1;
            }

            t.next =temp;
            t = temp;
        }

        while (!two.empty()) {
            Integer twoPop = two.pop();
            ListNode temp;
            if (twoPop + tmp <= 9) {
                temp = new ListNode(twoPop + tmp);
                tmp = 0;
            } else {
                temp = new ListNode(twoPop + tmp - 10);
                tmp = 1;
            }
            t.next = temp;
            t = temp;
        }

        if (tmp != 0) {
            t.next = new ListNode(tmp);
        }

        return reversNode(h);

    }

    private ListNode reversNode(ListNode l) {
        ListNode pre = null;
        ListNode cur = l;
        ListNode next;
        while (cur != null) {
            next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }

        return pre;

    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
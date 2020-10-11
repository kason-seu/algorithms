//Given a singly linked list L: L0→L1→…→Ln-1→Ln, 
//reorder it to: L0→Ln→L1→Ln-1→L2→Ln-2→… 
//
// You may not modify the values in the list's nodes, only nodes itself may be c
//hanged. 
//
// Example 1: 
//
// 
//Given 1->2->3->4, reorder it to 1->4->2->3. 
//
// Example 2: 
//
// 
//Given 1->2->3->4->5, reorder it to 1->5->2->4->3.
// 
// Related Topics Linked List 
// 👍 2486 👎 129

//Java：Reorder List

import common.ListNode;
import common.NodeUtils;

public class RerverseList {
    public static void main(String[] args) {
        Solution solution = new RerverseList().new Solution();
        ListNode head = NodeUtils.condtructList(new int[]{1, 2, 3, 4, 6});

        solution.reorderList(head);

        NodeUtils.printNode(head);

        head = NodeUtils.condtructList(new int[]{1, 2, 3, 4});

        solution.reorderList(head);

        NodeUtils.printNode(head);


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
    public void reorderList(ListNode head) {
        if (head == null || head.next == null || head.next.next == null) {
            return;
        }
        ListNode pre = null;
        ListNode cur = head.next;
        ListNode next = head.next.next;

        while (next != null) {

            ListNode tmp = next.next;
            next.next = cur;

            if (pre == null) {
                cur.next = tmp;
            } else {
                pre.next = tmp;
            }


            if (pre == null) {
                pre = cur;
            }

            //pre = cur;
            cur = next;
            next = tmp;

        }
        head.next = cur;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
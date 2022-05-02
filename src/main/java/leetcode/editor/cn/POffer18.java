package leetcode.editor.cn;

import common.ListNode;

public class POffer18 {
    //题目保证链表中节点的值互不相同
    public ListNode deleteNode(ListNode head, int val) {

        if (head == null) {
            return null;
        }
        if (head.val == val) {
            return head.next;
        }

        ListNode temp = head;
        while (temp.next != null) {

            ListNode cur = temp.next;
            if (cur.val == val) {
                temp.next = cur.next;
                break;
            }
            temp = cur;
        }
        return head;
    }
}

package leetcode.editor.cn;

import common.ListNode;
import common.NodeUtils;

public class P237 {


    public static void main(String[] args) {


        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(3);
        ListNode l4 = new ListNode(4);
        l1.next = l2;
        l2.next = l3;
        l3.next = l4;

        P237.Solution s = new P237().new Solution();
        s.deleteNode(l1);

        NodeUtils.printNode(l1);

    }
    class Solution {
        public void deleteNode(ListNode node) {

            ListNode cur = node;
            while (cur != null && cur.next != null ) {
                cur.val = cur.next.val;
                if (cur.next.next == null) {

                    cur.next = null;
                    break;
                }
                cur = cur.next;
            }

        }

    }
}

package leetcode.editor.cn;

import common.ListNode;
import common.NodeUtils;

public class P分割链表 {




    public static void main(String[] args) {
        P分割链表.Solution solution = new P分割链表().new Solution();

        ListNode listNode = NodeUtils.condtructList(new int[]{1, 4, 3, 2, 5, 2});


        ListNode partition = solution.partition(listNode, 3);

        NodeUtils.printNode(partition);
        System.out.println("Hello world");

        listNode = NodeUtils.condtructList(new int[]{2,1});


        partition = solution.partition(listNode, 2);

        NodeUtils.printNode(partition);
        System.out.println("Hello world");
        listNode = NodeUtils.condtructList(new int[]{1,2});


        partition = solution.partition(listNode, 2);

        NodeUtils.printNode(partition);

        System.out.println("Hello world");
        listNode = NodeUtils.condtructList(new int[]{});


        partition = solution.partition(listNode, 2);

        NodeUtils.printNode(partition);
    }

    class Solution {
        public ListNode partition(ListNode head, int x) {

            if (head == null) {
                return null;
            }

            ListNode leftstart = null, leftend = null;
            ListNode rightstart = null, rightend = null;

            ListNode cur = head;

            while (cur != null) {
                if (cur.val < x) {
                    if (leftstart == null) {
                        leftstart = cur;
                    }
                    if (leftend == null) {
                        leftend = cur;
                    } else {
                        leftend.next = cur;
                        leftend = cur;
                    }
                } else {
                    if (rightstart == null) {
                        rightstart = cur;
                    }
                    if (rightend == null) {
                        rightend = cur;
                    } else {
                        rightend.next = cur;
                        rightend = cur;
                    }


                }
                cur = cur.next;
            }

            if (leftstart == null) {
                rightend.next = null;
                return rightstart;
            }

            if (rightstart == null) {
                leftend.next = null;
                return leftstart;
            }

            rightend.next = null;
            leftend.next = rightstart;

            return leftstart;
        }
    }
}

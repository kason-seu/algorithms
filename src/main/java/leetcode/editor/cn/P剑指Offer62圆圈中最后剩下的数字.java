package leetcode.editor.cn;

import common.ListNode;

public class P剑指Offer62圆圈中最后剩下的数字 {


    public static void main(String[] args) {
        Solution solution = new P剑指Offer62圆圈中最后剩下的数字().new Solution();


       //int i = solution.lastRemaining(5, 3);


//        System.out.println("Hello world  " + i);
//
//        i = solution.lastRemaining(2, 2);
//
//
//        System.out.println("Hello world  " + i);

        int i = solution.lastRemaining(70866 ,116922);

        //int i = solution.lastRemaining(10000,500000);
        System.out.println("Hello world  " + i);
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
        class ListNode {
            public int val;
            public ListNode next;
            public ListNode() {}
            public ListNode(int val) { this.val = val; }
            public ListNode(int val, ListNode next) { this.val = val; this.next = next; }
        }
        public int lastRemaining(int n, int m) {

            if (m == 1) {
                return n - 1;
            } else {
                ListNode head = new ListNode(0);
                ListNode t = head;
                for(int i = 1; i < n; i++) {

                    t.next = new ListNode(i);
                    t = t.next;
                }
                t.next = head;

                int index = 1;
                ListNode pre = head;
                while (head.next != head) {
                    if (index == m%n) {
                        pre.next = head.next;
                        head = head.next;
                        index = 1;
                    }
                    pre = head;
                    head = head.next;
                    index++;

                }
                return head.val;
            }
        }

        ListNode re = null;
        private void dg(ListNode head, int m, int index) {

            if (head.next == head) {
                re = head;
                return;
            }

            if (index == m - 2) {
                head.next = head.next.next;
                dg(head.next, m, 0);
            } else {
                dg(head.next, m, index + 1);

            }

        }
    }
}

package leetcode.editor.cn;

import common.ListNode;
import common.NodeUtils;

public class P面试题0202返回倒数第k个节点 {

    public static void main(String[] args) {
        Solution solution = new P面试题0202返回倒数第k个节点().new Solution();

        ListNode listNode = NodeUtils.condtructList(new int[]{1});

        int kthFromEnd = solution.kthToLast(listNode, 1);



        System.out.println("Hello world" + kthFromEnd);
    }
    //leetcode submit region begin(Prohibit modification and deletion)
    /**
     * Definition for singly-linked list.
     * public class ListNode {
     *     int val;
     *     ListNode next;
     *     ListNode(int x) { val = x; }
     * }
     */
    class Solution {
        public int kthToLast(ListNode head, int k) {

            return dg(head, k);
        }

        int m = 0;
        private int dg(ListNode cur, int k) {


            if (cur != null) {
                int v = dg(cur.next, k);

                if (m == k-1) {
                    m++;
                    return cur.val;
                } else {
                    m++;
                    return v;
                }

            } else {
                return 0;
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)
}

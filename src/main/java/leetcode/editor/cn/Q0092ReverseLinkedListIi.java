package leetcode.editor.cn;

import java.util.List;

/** * @author  kason * @date    2023-12-27 23:12:19 */public class Q0092ReverseLinkedListIi{    //给你单链表的头指针 head 和两个整数 left 和 right ，其中 left <= right 。请你反转从位置 left 到位置 right 的链
//表节点，返回 反转后的链表 。
//
// 
//
// 示例 1： 
// 
// 
//输入：head = [1,2,3,4,5], left = 2, right = 4
//输出：[1,4,3,2,5]
// 
//
// 示例 2： 
//
// 
//输入：head = [5], left = 1, right = 1
//输出：[5]
// 
//
// 
//
// 提示： 
//
// 
// 链表中节点数目为 n 
// 1 <= n <= 500 
// -500 <= Node.val <= 500 
// 1 <= left <= right <= n 
// 
//
// 
//
// 进阶： 你可以使用一趟扫描完成反转吗？ 
//
// Related Topics 链表 👍 1713 👎 0
    public static void main(String[] args) {        Solution solution = new Q0092ReverseLinkedListIi().new Solution();

    ListNode n1 = new ListNode(1);
    ListNode n2 = new ListNode(2);
    ListNode n3 = new ListNode(3);
    ListNode n4 = new ListNode(4);
    ListNode n5 = new ListNode(5);
    n1.next = n2;
    n2.next = n3;
    n3.next = n4;
    n4.next = n5;

        ListNode listNode = solution.reverseBetween(n1, 4, 5);
        print(listNode);


    }    //leetcode submit region begin(Prohibit modification and deletion)

public static void print(ListNode head) {
        while (head != null) {
            System.out.println(head.val);
            head = head.next;
        }
}
  public static class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }


  }

class Solution {
    public ListNode reverseBetween(ListNode head, int left, int right) {

        if (left == right) {
            return head;
        }

        ListNode preHead = head;
        ListNode cur = head;

        for (int i = 1; i < left; i++) {
            preHead = cur;
            cur = cur.next;
        }
        ListNode tail = cur;
        for (int i = left; i < right; i++) {
            tail = tail.next;
        }
        ListNode tailAfter = tail.next;

        ListNode reverse = reverse(cur, tail);

        if (cur != head) {
            preHead.next = tail;
        } else {
            head = tail;
        }
        reverse.next = tailAfter;
        return head;
    }

    public ListNode reverse(ListNode startNode, ListNode end) {
        if (startNode.next == end) {
            end.next = startNode;
        } else {
            ListNode reverse = reverse(startNode.next, end);
            reverse.next = startNode;
        }
        return startNode;

    }
}
//leetcode submit region end(Prohibit modification and deletion)
}
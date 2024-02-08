package leetcode.editor.cn;
/** * @author  kason * @date    2023-12-29 20:37:19 */public class Q0082RemoveDuplicatesFromSortedListIi{    //给定一个已排序的链表的头 head ， 删除原始链表中所有重复数字的节点，只留下不同的数字 。返回 已排序的链表 。
//
// 
//
// 示例 1： 
// 
// 
//输入：head = [1,2,3,3,4,4,5]
//输出：[1,2,5]
// 
//
// 示例 2： 
// 
// 
//输入：head = [1,1,1,2,3]
//输出：[2,3]
// 
//
// 
//
// 提示： 
//
// 
// 链表中节点数目在范围 [0, 300] 内 
// -100 <= Node.val <= 100 
// 题目数据保证链表已经按升序 排列 
// 
//
// Related Topics 链表 双指针 👍 1220 👎 0
    public static void main(String[] args) {        Solution solution = new Q0082RemoveDuplicatesFromSortedListIi()
            .new Solution();

        ListNode l = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(3);
        ListNode l4 = new ListNode(3);
        ListNode l5 = new ListNode(3);
        l.next = l2;
        l2.next = l3;
        l3.next = l4;
        l4.next = l5;

        ListNode re = solution.deleteDuplicates(l);


        //System.out.println(re);
        print(re);
    }    //leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */static class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}
    public static void print(ListNode head) {
        while (head != null) {
            System.out.println(head.val);
            head = head.next;
        }
    }
class Solution {

    public ListNode deleteDuplicates(ListNode head) {

        if (head == null || head.next == null) {
            return head;
        }

         if (head.val != head.next.val) {
             head.next = deleteDuplicates(head.next);
             return head;
         } else {
             ListNode cur = head;
             while (cur.next!= null && cur.val == cur.next.val) {
                 cur = cur.next;
             }
             return deleteDuplicates(cur.next);
         }

    }
}
//leetcode submit region end(Prohibit modification and deletion)
}
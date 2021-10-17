/**
  * 题目Id：剑指 Offer II 024
  * 题目：反转链表
  * 内容: //给定单链表的头节点 head ，请反转链表，并返回反转后的链表的头节点。 
//
// 
// 
// 
//
// 示例 1： 
//
// 
//输入：head = [1,2,3,4,5]
//输出：[5,4,3,2,1]
// 
//
// 示例 2： 
//
// 
//输入：head = [1,2]
//输出：[2,1]
// 
//
// 示例 3： 
//
// 
//输入：head = []
//输出：[]
// 
//
// 
//
// 提示： 
//
// 
// 链表中节点的数目范围是 [0, 5000] 
// -5000 <= Node.val <= 5000 
// 
//
// 
//
// 进阶：链表可以选用迭代或递归方式完成反转。你能否用两种方法解决这道题？ 
// 
// 
//
// 
//
// 注意：本题与主站 206 题相同： https://leetcode-cn.com/problems/reverse-linked-list/ 
// Related Topics 递归 链表 
// 👍 20 👎 0
	
  * 日期：2021-10-17 13:07:01
*/
//给定单链表的头节点 head ，请反转链表，并返回反转后的链表的头节点。 
//
// 
// 
// 
//
// 示例 1： 
//
// 
//输入：head = [1,2,3,4,5]
//输出：[5,4,3,2,1]
// 
//
// 示例 2： 
//
// 
//输入：head = [1,2]
//输出：[2,1]
// 
//
// 示例 3： 
//
// 
//输入：head = []
//输出：[]
// 
//
// 
//
// 提示： 
//
// 
// 链表中节点的数目范围是 [0, 5000] 
// -5000 <= Node.val <= 5000 
// 
//
// 
//
// 进阶：链表可以选用迭代或递归方式完成反转。你能否用两种方法解决这道题？ 
// 
// 
//
// 
//
// 注意：本题与主站 206 题相同： https://leetcode-cn.com/problems/reverse-linked-list/ 
// Related Topics 递归 链表 
// 👍 20 👎 0

package leetcode.editor.cn;

import common.ListNode;

public class P剑指OfferII024反转链表UHnkqh {
    public static void main(String[] args) {
        Solution solution = new P剑指OfferII024反转链表UHnkqh().new Solution();
        int[] arr = new int[]{1,2,3,4};
        ListNode head = build(arr);


        ListNode listNode = solution.reverseList(head);

        listNode = solution.tailHead;

        while (listNode != null) {
            System.out.println(listNode.val);
            listNode = listNode.next;
        }

        System.out.println("Hello world");
    }

    private static ListNode build(int[] arr) {
        ListNode head = new ListNode(arr[0]);
        if (arr.length > 1) {
            ListNode cycle = head;
            for (int i = 1; i < arr.length; i++) {
                cycle.next = new ListNode(arr[i]);
                cycle = cycle.next;
            }
        }
        return head;
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
    public ListNode reverseList(ListNode head) {

        return reverse_dg(head);
    }

    private ListNode tailHead;

    private ListNode reverse_dg(ListNode head) {
        if (head != null) {
            ListNode listNode = reverse_dg(head.next);
            if (listNode != null) {
                head.next = null;
                listNode.next = head;
            } else {
                tailHead = head;
            }

            return head;
        }

        return null;


    }
}
//leetcode submit region end(Prohibit modification and deletion)

} 
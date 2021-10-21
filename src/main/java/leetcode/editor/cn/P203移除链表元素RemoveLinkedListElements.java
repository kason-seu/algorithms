/**
  * 题目Id：203
  * 题目：移除链表元素
  * 内容: //给你一个链表的头节点 head 和一个整数 val ，请你删除链表中所有满足 Node.val == val 的节点，并返回 新的头节点 。
// 
//
// 示例 1： 
//
// 
//输入：head = [1,2,6,3,4,5,6], val = 6
//输出：[1,2,3,4,5]
// 
//
// 示例 2： 
//
// 
//输入：head = [], val = 1
//输出：[]
// 
//
// 示例 3： 
//
// 
//输入：head = [7,7,7,7], val = 7
//输出：[]
// 
//
// 
//
// 提示： 
//
// 
// 列表中的节点数目在范围 [0, 104] 内 
// 1 <= Node.val <= 50 
// 0 <= val <= 50 
// 
// Related Topics 递归 链表 
// 👍 714 👎 0
	
  * 日期：2021-10-18 23:35:37
*/
//给你一个链表的头节点 head 和一个整数 val ，请你删除链表中所有满足 Node.val == val 的节点，并返回 新的头节点 。
// 
//
// 示例 1： 
//
// 
//输入：head = [1,2,6,3,4,5,6], val = 6
//输出：[1,2,3,4,5]
// 
//
// 示例 2： 
//
// 
//输入：head = [], val = 1
//输出：[]
// 
//
// 示例 3： 
//
// 
//输入：head = [7,7,7,7], val = 7
//输出：[]
// 
//
// 
//
// 提示： 
//
// 
// 列表中的节点数目在范围 [0, 104] 内 
// 1 <= Node.val <= 50 
// 0 <= val <= 50 
// 
// Related Topics 递归 链表 
// 👍 714 👎 0

package leetcode.editor.cn;

import common.ListNode;
import common.NodeUtils;

public class P203移除链表元素RemoveLinkedListElements {
    public static void main(String[] args) {
        Solution solution = new P203移除链表元素RemoveLinkedListElements().new Solution();

        ListNode listNode = NodeUtils.condtructList(new int[]{1, 2, 3, 4, 6, 4, 6, 5, 4});

        ListNode listNode1 = solution.removeElements(listNode, 4);

        NodeUtils.printNode(listNode1);
        System.out.println("Hello world");
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
    public ListNode removeElements(ListNode head, int val) {

        return dg(head, val);
    }

    private ListNode dg(ListNode head, int val) {
        if (head == null) {
            return head;
        }
        if(head.val == val) {
            return dg(head.next, val);
        }
        head.next = dg(head.next, val);

        return head;

    }
}
//leetcode submit region end(Prohibit modification and deletion)

} 
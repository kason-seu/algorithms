/**
 * 题目Id：143
 * 题目：重排链表
 * 内容: //给定一个单链表 L 的头节点 head ，单链表 L 表示为：
 * //
 * // L0 → L1 → … → Ln-1 → Ln
 * //请将其重新排列后变为：
 * //
 * // L0 → Ln → L1 → Ln-1 → L2 → Ln-2 → …
 * //
 * // 不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
 * //
 * //
 * //
 * // 示例 1:
 * //
 * //
 * //
 * //
 * //输入: head = [1,2,3,4]
 * //输出: [1,4,2,3]
 * //
 * // 示例 2:
 * //
 * //
 * //
 * //
 * //输入: head = [1,2,3,4,5]
 * //输出: [1,5,2,4,3]
 * //
 * //
 * //
 * // 提示：
 * //
 * //
 * // 链表的长度范围为 [1, 5 * 104]
 * // 1 <= node.val <= 1000
 * //
 * // Related Topics 栈 递归 链表 双指针
 * // 👍 688 👎 0
 * <p>
 * 日期：2021-10-22 23:43:52
 */
//给定一个单链表 L 的头节点 head ，单链表 L 表示为： 
//
// L0 → L1 → … → Ln-1 → Ln 
//请将其重新排列后变为： 
//
// L0 → Ln → L1 → Ln-1 → L2 → Ln-2 → … 
//
// 不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。 
//
// 
//
// 示例 1: 
//
// 
//
// 
//输入: head = [1,2,3,4]
//输出: [1,4,2,3] 
//
// 示例 2: 
//
// 
//
// 
//输入: head = [1,2,3,4,5]
//输出: [1,5,2,4,3] 
//
// 
//
// 提示： 
//
// 
// 链表的长度范围为 [1, 5 * 104] 
// 1 <= node.val <= 1000 
// 
// Related Topics 栈 递归 链表 双指针 
// 👍 688 👎 0

package leetcode.editor.cn;

import common.ListNode;
import common.NodeUtils;

public class P143重排链表ReorderList {
    public static void main(String[] args) {
        Solution solution = new P143重排链表ReorderList().new Solution();

        ListNode listNode = NodeUtils.condtructList(new int[]{1, 2, 3, 4, 5});

        solution.reorderList(listNode);

        NodeUtils.printNode(listNode);
        System.out.println("Hello world");

        listNode = NodeUtils.condtructList(new int[]{1, 2, 3, 4});

        solution.reorderList(listNode);

        NodeUtils.printNode(listNode);
    }
    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for singly-linked list.
     * public class ListNode {
     * int val;
     * ListNode next;
     * ListNode() {}
     * ListNode(int val) { this.val = val; }
     * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     * }
     */
    class Solution {
        public void reorderList(ListNode head) {

            tmp = head;

            ListNode t2 = head;
            dg(t2);
        }

        ListNode tmp = null;

        private ListNode dg(ListNode cur) {


            if (cur == null) {
                return null;
            }

            ListNode dg = dg(cur.next);
            if (dg != null && dg.val == -1) {
                return cur;
            }
            if ((cur.next == dg && tmp.next == dg)) {
                if (tmp != dg) {
                    cur.next = null;
                } else {
                    tmp.next = null;
                }
                return new ListNode(-1);
            }

            ListNode l = tmp.next;
            if (l != null) {
                tmp.next = cur;
                cur.next = l;
                tmp = l;
            }
            return cur;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

} 
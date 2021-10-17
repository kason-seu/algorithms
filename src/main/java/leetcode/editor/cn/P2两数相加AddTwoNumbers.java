/**
 * 题目Id：2
 * 题目：两数相加
 * 内容: //给你两个 非空 的链表，表示两个非负的整数。它们每位数字都是按照 逆序 的方式存储的，并且每个节点只能存储 一位 数字。
 * //
 * // 请你将两个数相加，并以相同形式返回一个表示和的链表。
 * //
 * // 你可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 * //
 * //
 * //
 * // 示例 1：
 * //
 * //
 * //输入：l1 = [2,4,3], l2 = [5,6,4]
 * //输出：[7,0,8]
 * //解释：342 + 465 = 807.
 * //
 * //
 * // 示例 2：
 * //
 * //
 * //输入：l1 = [0], l2 = [0]
 * //输出：[0]
 * //
 * //
 * // 示例 3：
 * //
 * //
 * //输入：l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
 * //输出：[8,9,9,9,0,0,0,1]
 * //
 * //
 * //
 * //
 * // 提示：
 * //
 * //
 * // 每个链表中的节点数在范围 [1, 100] 内
 * // 0 <= Node.val <= 9
 * // 题目数据保证列表表示的数字不含前导零
 * //
 * // Related Topics 递归 链表 数学
 * // 👍 6909 👎 0
 * <p>
 * 日期：2021-10-16 21:34:18
 */
//给你两个 非空 的链表，表示两个非负的整数。它们每位数字都是按照 逆序 的方式存储的，并且每个节点只能存储 一位 数字。 
//
// 请你将两个数相加，并以相同形式返回一个表示和的链表。 
//
// 你可以假设除了数字 0 之外，这两个数都不会以 0 开头。 
//
// 
//
// 示例 1： 
//
// 
//输入：l1 = [2,4,3], l2 = [5,6,4]
//输出：[7,0,8]
//解释：342 + 465 = 807.
// 
//
// 示例 2： 
//
// 
//输入：l1 = [0], l2 = [0]
//输出：[0]
// 
//
// 示例 3： 
//
// 
//输入：l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
//输出：[8,9,9,9,0,0,0,1]
// 
//
// 
//
// 提示： 
//
// 
// 每个链表中的节点数在范围 [1, 100] 内 
// 0 <= Node.val <= 9 
// 题目数据保证列表表示的数字不含前导零 
// 
// Related Topics 递归 链表 数学 
// 👍 6909 👎 0

package leetcode.editor.cn;

import common.ListNode;

public class P2两数相加AddTwoNumbers {
    public static void main(String[] args) {
        Solution solution = new P2两数相加AddTwoNumbers().new Solution();

        int[] a1 = new int[]{2, 4, 3};
        int[] a2 = new int[]{5, 6, 4};
        test(solution, a1, a2);
        System.out.println("Hello world");

        a1 = new int[]{0};
        a2 = new int[]{0};
        test(solution, a1, a2);
        System.out.println("Hello world");

        //输入：l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
        a1 = new int[]{9, 9, 9, 9, 9, 9, 9};
        a2 = new int[]{9, 9, 9};
        test(solution, a1, a2);
        System.out.println("Hello world");
    }

    private static void test(Solution solution, int[] a1, int[] a2) {
        ListNode l1 = build(a1);

        ListNode l2 = build(a2);

        ListNode listNode = solution.addTwoNumbers(l1, l2);

        while (listNode != null) {
            System.out.println(listNode.val);

            listNode = listNode.next;
        }
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
        public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

            return dg(l1, l2, null, 0);
        }

        private ListNode dg(ListNode l1, ListNode l2, ListNode result, int yushu) {

            if (l1 == null && l2 == null) {
                if (yushu == 0) {
                    return null;
                } else {
                    ListNode n = new ListNode(yushu);
                    result.next = n;
                    return n;
                }
            }

            if (l1 == null) {
                ListNode tmp = l2;
                return calOneListEmpty(result, yushu, tmp);

            }

            if (l2 == null) {
                ListNode tmp = l1;
                return calOneListEmpty(result, yushu, tmp);

            }

            int value = l1.val + l2.val + yushu;

            ListNode current = new ListNode(value % 10);

            current.next = dg(l1.next, l2.next, current, value / 10);

            return current;

        }

        private ListNode calOneListEmpty(ListNode result, int yushu, ListNode tmp) {
            if (yushu == 0) {
                result.next = tmp;
            } else {
                int xunhuan = 0;
                ListNode ttt = result;
                while (tmp != null) {
                    int value = tmp.val + yushu;
                    yushu = value / 10;

                    ListNode current = new ListNode(value % 10);
                    ttt.next = current;
                    tmp = tmp.next;
                    ttt = ttt.next;
                    xunhuan++;

                }
                if (xunhuan > 0 && yushu > 0) {
                    ListNode current = new ListNode(yushu);
                    ttt.next = current;
                }
            }
            return result.next;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

} 
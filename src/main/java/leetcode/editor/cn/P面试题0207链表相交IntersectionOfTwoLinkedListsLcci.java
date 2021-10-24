/**
  * 题目Id：面试题 02.07
  * 题目：链表相交
  * 内容: //给你两个单链表的头节点 headA 和 headB ，请你找出并返回两个单链表相交的起始节点。如果两个链表没有交点，返回 null 。 
//
// 图示两个链表在节点 c1 开始相交： 
//
// 
//
// 题目数据 保证 整个链式结构中不存在环。 
//
// 注意，函数返回结果后，链表必须 保持其原始结构 。 
//
// 
//
// 示例 1： 
//
// 
//
// 
//输入：intersectVal = 8, listA = [4,1,8,4,5], listB = [5,0,1,8,4,5], skipA = 2, sk
//ipB = 3
//输出：Intersected at '8'
//解释：相交节点的值为 8 （注意，如果两个链表相交则不能为 0）。
//从各自的表头开始算起，链表 A 为 [4,1,8,4,5]，链表 B 为 [5,0,1,8,4,5]。
//在 A 中，相交节点前有 2 个节点；在 B 中，相交节点前有 3 个节点。
// 
//
// 示例 2： 
//
// 
//
// 
//输入：intersectVal = 2, listA = [0,9,1,2,4], listB = [3,2,4], skipA = 3, skipB = 
//1
//输出：Intersected at '2'
//解释：相交节点的值为 2 （注意，如果两个链表相交则不能为 0）。
//从各自的表头开始算起，链表 A 为 [0,9,1,2,4]，链表 B 为 [3,2,4]。
//在 A 中，相交节点前有 3 个节点；在 B 中，相交节点前有 1 个节点。
// 
//
// 示例 3： 
//
// 
//
// 
//输入：intersectVal = 0, listA = [2,6,4], listB = [1,5], skipA = 3, skipB = 2
//输出：null
//解释：从各自的表头开始算起，链表 A 为 [2,6,4]，链表 B 为 [1,5]。
//由于这两个链表不相交，所以 intersectVal 必须为 0，而 skipA 和 skipB 可以是任意值。
//这两个链表不相交，因此返回 null 。
// 
//
// 
//
// 提示： 
//
// 
// listA 中节点数目为 m 
// listB 中节点数目为 n 
// 0 <= m, n <= 3 * 104 
// 1 <= Node.val <= 105 
// 0 <= skipA <= m 
// 0 <= skipB <= n 
// 如果 listA 和 listB 没有交点，intersectVal 为 0 
// 如果 listA 和 listB 有交点，intersectVal == listA[skipA + 1] == listB[skipB + 1] 
// 
//
// 
//
// 进阶：你能否设计一个时间复杂度 O(n) 、仅用 O(1) 内存的解决方案？ 
// Related Topics 哈希表 链表 双指针 
// 👍 106 👎 0
	
  * 日期：2021-10-23 18:42:48
*/
//给你两个单链表的头节点 headA 和 headB ，请你找出并返回两个单链表相交的起始节点。如果两个链表没有交点，返回 null 。 
//
// 图示两个链表在节点 c1 开始相交： 
//
// 
//
// 题目数据 保证 整个链式结构中不存在环。 
//
// 注意，函数返回结果后，链表必须 保持其原始结构 。 
//
// 
//
// 示例 1： 
//
// 
//
// 
//输入：intersectVal = 8, listA = [4,1,8,4,5], listB = [5,0,1,8,4,5], skipA = 2, sk
//ipB = 3
//输出：Intersected at '8'
//解释：相交节点的值为 8 （注意，如果两个链表相交则不能为 0）。
//从各自的表头开始算起，链表 A 为 [4,1,8,4,5]，链表 B 为 [5,0,1,8,4,5]。
//在 A 中，相交节点前有 2 个节点；在 B 中，相交节点前有 3 个节点。
// 
//
// 示例 2： 
//
// 
//
// 
//输入：intersectVal = 2, listA = [0,9,1,2,4], listB = [3,2,4], skipA = 3, skipB = 
//1
//输出：Intersected at '2'
//解释：相交节点的值为 2 （注意，如果两个链表相交则不能为 0）。
//从各自的表头开始算起，链表 A 为 [0,9,1,2,4]，链表 B 为 [3,2,4]。
//在 A 中，相交节点前有 3 个节点；在 B 中，相交节点前有 1 个节点。
// 
//
// 示例 3： 
//
// 
//
// 
//输入：intersectVal = 0, listA = [2,6,4], listB = [1,5], skipA = 3, skipB = 2
//输出：null
//解释：从各自的表头开始算起，链表 A 为 [2,6,4]，链表 B 为 [1,5]。
//由于这两个链表不相交，所以 intersectVal 必须为 0，而 skipA 和 skipB 可以是任意值。
//这两个链表不相交，因此返回 null 。
// 
//
// 
//
// 提示： 
//
// 
// listA 中节点数目为 m 
// listB 中节点数目为 n 
// 0 <= m, n <= 3 * 104 
// 1 <= Node.val <= 105 
// 0 <= skipA <= m 
// 0 <= skipB <= n 
// 如果 listA 和 listB 没有交点，intersectVal 为 0 
// 如果 listA 和 listB 有交点，intersectVal == listA[skipA + 1] == listB[skipB + 1] 
// 
//
// 
//
// 进阶：你能否设计一个时间复杂度 O(n) 、仅用 O(1) 内存的解决方案？ 
// Related Topics 哈希表 链表 双指针 
// 👍 106 👎 0

package leetcode.editor.cn;

import common.ListNode;
import common.NodeUtils;

public class P面试题0207链表相交IntersectionOfTwoLinkedListsLcci {
    public static void main(String[] args) {
        Solution solution = new P面试题0207链表相交IntersectionOfTwoLinkedListsLcci().new Solution();

        //ListNode listNode = NodeUtils.condtructList(new int[]{4, 1, 8, 4, 5});

        //ListNode listNode1 = NodeUtils.condtructList(new int[]{5, 0, 1, 8, 4, 5});
        ListNode l1 = new ListNode(4);

        ListNode l2 = new ListNode(1);

        l1.next = l2;
        ListNode l3 = new ListNode(8);

        l2.next = l3;
        ListNode l4 = new ListNode(4);
        l3.next = l4;
        ListNode l5 = new ListNode(5);

        l4.next = l5;


        ListNode ll1 = new ListNode(5);

        ListNode ll2 = new ListNode(0);
        ll1.next = ll2;
        ListNode ll3 = new ListNode(1);

        ll2.next = ll3;

        ll3.next = l3;


        ListNode intersectionNode = solution.getIntersectionNode(l1, ll1);

        if (intersectionNode == null) {
            System.out.println("no jiaocha");
        } else {
            System.out.println("---" + intersectionNode.val);
        }

        System.out.println("Hello world");
    }
    //leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {


        ListNode curA = headA;
        ListNode curB = headB;

        int asize = 0;
        int bsize = 0;

        while (curA != null && curA.next != null) {
            asize++;
            curA = curA.next;
        }
        while (curB != null && curB.next != null) {
            bsize++;
            curB = curB.next;
        }

        if (curA != curB) {
            return null;
        }

        if (asize > bsize) {
            int chazhi = asize - bsize;

            curA= headA;
            for (int i = 0; i < chazhi; i++) {
                curA = curA.next;
            }

            curB = headB;

            while (curA != null && curB != null && curA != curB) {
                curA = curA.next;
                curB = curB.next;
            }
            return curA == curB ? curA : null;
        } else if (asize == bsize) {
            curA = headA;
            curB = headB;
            while (curA != null && curB != null && curA != curB) {
                curA = curA.next;
                curB = curB.next;
            }
            return curA == curB ? curA : null;
        } else {
            int chazhi = bsize - asize;
            curB = headB;
            for (int i = 0; i < chazhi; i++) {
                curB = curB.next;
            }

            curA = headA;
            while (curA != null && curB != null && curA != curB) {
                curA = curA.next;
                curB = curB.next;
            }
            return curA == curB ? curA : null;
        }

        
    }
}
//leetcode submit region end(Prohibit modification and deletion)

} 
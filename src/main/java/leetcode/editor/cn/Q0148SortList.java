package leetcode.editor.cn;
/** * @author  kason * @date    2023-12-30 14:59:41 */public class Q0148SortList{    //给你链表的头结点 head ，请将其按 升序 排列并返回 排序后的链表 。 
//
// 
// 
//
// 
//
// 示例 1： 
// 
// 
//输入：head = [4,2,1,3]
//输出：[1,2,3,4]
// 
//
// 示例 2： 
// 
// 
//输入：head = [-1,5,3,4,0]
//输出：[-1,0,3,4,5]
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
// 链表中节点的数目在范围 [0, 5 * 10⁴] 内 
// -10⁵ <= Node.val <= 10⁵ 
// 
//
// 
//
// 进阶：你可以在 O(n log n) 时间复杂度和常数级空间复杂度下，对链表进行排序吗？ 
//
// Related Topics 链表 双指针 分治 排序 归并排序 👍 2201 👎 0
    public static void main(String[] args) {        Solution solution =
            new Q0148SortList().new Solution();
        ListNode l =  new ListNode(-1);
        ListNode l2 = new ListNode(5);
        ListNode l3 = new ListNode(3);
        ListNode l4 = new ListNode(4);
        ListNode l5 = new ListNode(0);
        l.next = l2;
        l2.next = l3;
        l3.next = l4;
        l4.next = l5;

        ListNode listNode = solution.sortList(l);
        print(listNode);

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
 */
static class ListNode {
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
    public ListNode sortList(ListNode head) {

        if (head == null || head.next == null) {
            return head;
        }

       ListNode fast = head;
       ListNode slow = head.next;
       while (slow != null) {
           ListNode next = slow.next;
           if (next == null) {
               break;
           } else {
               slow = next.next;
               fast = fast.next;
           }
       }

       // 归并排序两个有序链表
        ListNode rightH  = fast.next;
        fast.next = null;
        ListNode sortLeftRoot = sortList(head);
        ListNode sortRightRoot = sortList(rightH);
        return mergeTwoLists(sortLeftRoot, sortRightRoot);
    }

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {

        if (list1 == null) {
            return list2;
        }
        if (list2 == null) {
            return list1;
        }

        if (list1.val <= list2.val) {
           list1.next = mergeTwoLists(list1.next, list2);
           return list1;
        } else {
            list2.next = mergeTwoLists(list1, list2.next);
            return list2;
        }
    }


    public ListNode sortList2(ListNode head) {
        // 负向遍历递归, 后面先排好序列

        if (head == null || head.next == null) {
            return head;
        }
        ListNode subHead = sortList2(head.next);
        if (head.val <= subHead.val) {
            head.next = subHead;
            return head;
        } else {
            ListNode start = subHead;
            while (true) {
                if (start.next != null && start.next.val < head.val) {
                    start = start.next;
                } else {
                    ListNode tmp = start.next;
                    start.next = head;
                    head.next = tmp;
                    return subHead;
                }
            }
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
}
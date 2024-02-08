package leetcode.editor.cn;
/** * @author  kason * @date    2023-12-30 11:37:13 */public class Q0021MergeTwoSortedLists{    //将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。 
//
// 
//
// 示例 1： 
// 
// 
//输入：l1 = [1,2,4], l2 = [1,3,4]
//输出：[1,1,2,3,4,4]
// 
//
// 示例 2： 
//
// 
//输入：l1 = [], l2 = []
//输出：[]
// 
//
// 示例 3： 
//
// 
//输入：l1 = [], l2 = [0]
//输出：[0]
// 
//
// 
//
// 提示： 
//
// 
// 两个链表的节点数目范围是 [0, 50] 
// -100 <= Node.val <= 100 
// l1 和 l2 均按 非递减顺序 排列 
// 
//
// Related Topics 递归 链表 👍 3394 👎 0
    public static void main(String[] args) {        Solution solution = new Q0021MergeTwoSortedLists().new Solution();    }    //leetcode submit region begin(Prohibit modification and deletion)
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
class Solution {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {

        if (list1 == null) {
            return list2;
        }
        if (list2 == null) {
            return list1;
        }

        if (list1.val <= list2.val) {
            ListNode tmp = list1;
            while (tmp.next != null && tmp.next.val <= list2.val) {
                tmp = tmp.next;
            }
            tmp.next = mergeTwoLists(tmp.next, list2);
            return list1;
        } else {
            ListNode tmp = list2;
            while (tmp.next != null && tmp.next.val <= list1.val) {
                tmp = tmp.next;
            }
            tmp.next = mergeTwoLists(list1, tmp.next);
            return list2;
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
}
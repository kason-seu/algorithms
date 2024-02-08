package leetcode.editor.cn;
/** * @author  kason * @date    2023-12-31 00:26:26 */public class Q0328OddEvenLinkedList{    //给定单链表的头节点 head ，将所有索引为奇数的节点和索引为偶数的节点分别组合在一起，然后返回重新排序的列表。 
//
// 第一个节点的索引被认为是 奇数 ， 第二个节点的索引为 偶数 ，以此类推。 
//
// 请注意，偶数组和奇数组内部的相对顺序应该与输入时保持一致。 
//
// 你必须在 O(1) 的额外空间复杂度和 O(n) 的时间复杂度下解决这个问题。 
//
// 
//
// 示例 1: 
//
// 
//
// 
//输入: head = [1,2,3,4,5]
//输出: [1,3,5,2,4] 
//
// 示例 2: 
//
// 
//
// 
//输入: head = [2,1,3,5,6,4,7]
//输出: [2,3,6,7,1,5,4] 
//
// 
//
// 提示: 
//
// 
// n == 链表中的节点数 
// 0 <= n <= 10⁴ 
// -10⁶ <= Node.val <= 10⁶ 
// 
//
// Related Topics 链表 👍 759 👎 0
    public static void main(String[] args) {        Solution solution = new Q0328OddEvenLinkedList().new Solution();    }    //leetcode submit region begin(Prohibit modification and deletion)
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
    public ListNode oddEvenList(ListNode head) {
        ListNode left = head;
        ListNode right = head.next;

        while (left.next != null) {
            ListNode nextnode = left.next.next;
            if (nextnode != null) {
                left.next = left.next.next;
                left = left.next.next;
                if (left.next != null) {
                    right.next = right.next.next;
                    right = right.next.next;
                } else {
                    right.next = null;
                }
            } else {

            }
        }
        left.next = head.next;
        return head;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
}
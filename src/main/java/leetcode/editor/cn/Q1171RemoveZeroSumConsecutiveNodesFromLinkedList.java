package leetcode.editor.cn;
/** * @author  kason * @date    2023-12-30 16:05:09 */public class Q1171RemoveZeroSumConsecutiveNodesFromLinkedList{    //给你一个链表的头节点 head，请你编写代码，反复删去链表中由 总和 值为 0 的连续节点组成的序列，直到不存在这样的序列为止。 
//
// 删除完毕后，请你返回最终结果链表的头节点。 
//
// 
//
// 你可以返回任何满足题目要求的答案。 
//
// （注意，下面示例中的所有序列，都是对 ListNode 对象序列化的表示。） 
//
// 示例 1： 
//
// 输入：head = [1,2,-3,3,1]
//输出：[3,1]
//提示：答案 [1,2,1] 也是正确的。
// 
//
// 示例 2： 
//
// 输入：head = [1,2,3,-3,4]
//输出：[1,2,4]
// 
//
// 示例 3： 
//
// 输入：head = [1,2,3,-3,-2]
//输出：[1]
// 
//
// 
//
// 提示： 
//
// 
// 给你的链表中可能有 1 到 1000 个节点。 
// 对于链表中的每个节点，节点的值：-1000 <= node.val <= 1000. 
// 
//
// Related Topics 哈希表 链表 👍 313 👎 0
    public static void main(String[] args) {        Solution solution = new Q1171RemoveZeroSumConsecutiveNodesFromLinkedList().new Solution();    }    //leetcode submit region begin(Prohibit modification and deletion)
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
    public ListNode removeZeroSumSublists(ListNode head) {

        if (head == null) {
            return head;
        }

        // 找以给node为起点的首歌为0的下一个节点
        ListNode start = head;
        int sum = head.val;
        if (sum == 0) {
            return removeZeroSumSublists(head.next);
        }
        while (start.next != null) {
            sum += start.next.val;
            start = start.next;
            if (sum == 0) {
                return removeZeroSumSublists(start.next);
            }
        }
        // 去除后面节点连续和为0的节点吧
        head.next = removeZeroSumSublists(head.next);
        return head;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
}
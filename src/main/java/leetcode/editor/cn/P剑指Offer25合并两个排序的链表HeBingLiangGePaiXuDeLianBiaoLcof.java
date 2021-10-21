/**
  * 题目Id：剑指 Offer 25
  * 题目：合并两个排序的链表
  * 内容: //输入两个递增排序的链表，合并这两个链表并使新链表中的节点仍然是递增排序的。 
//
// 示例1： 
//
// 输入：1->2->4, 1->3->4
//输出：1->1->2->3->4->4 
//
// 限制： 
//
// 0 <= 链表长度 <= 1000 
//
// 注意：本题与主站 21 题相同：https://leetcode-cn.com/problems/merge-two-sorted-lists/ 
// Related Topics 递归 链表 
// 👍 175 👎 0
	
  * 日期：2021-10-17 23:31:00
*/
//输入两个递增排序的链表，合并这两个链表并使新链表中的节点仍然是递增排序的。 
//
// 示例1： 
//
// 输入：1->2->4, 1->3->4
//输出：1->1->2->3->4->4 
//
// 限制： 
//
// 0 <= 链表长度 <= 1000 
//
// 注意：本题与主站 21 题相同：https://leetcode-cn.com/problems/merge-two-sorted-lists/ 
// Related Topics 递归 链表 
// 👍 175 👎 0

package leetcode.editor.cn;

import common.ListNode;
import common.NodeUtils;

public class P剑指Offer25合并两个排序的链表HeBingLiangGePaiXuDeLianBiaoLcof {
    public static void main(String[] args) {
        Solution solution = new P剑指Offer25合并两个排序的链表HeBingLiangGePaiXuDeLianBiaoLcof().new Solution();

        ListNode l1 = NodeUtils.condtructList(new int[]{1, 2, 4});
        ListNode l2 = NodeUtils.condtructList(new int[]{1, 5,6});
        ListNode listNode = solution.mergeTwoLists(l1, l2);

        NodeUtils.printNode(listNode);


        System.out.println("Hello world");
    }
    //leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {

        ListNode dg = dg(l1, l2);

        return dg;
    }

    private ListNode dg(ListNode l1, ListNode l2) {


        if (l1 == null) {

            return l2;
        }

        if (l2 == null) {
            return l1;
        }

        if (l1.val <= l2.val) {

            l1.next = dg(l1.next, l2);
            return l1;
        } else {
            l2.next = dg(l2.next, l1);
            return l2;
        }

    }
}
//leetcode submit region end(Prohibit modification and deletion)

} 
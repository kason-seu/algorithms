/**
  * 题目Id：剑指 Offer 22
  * 题目：链表中倒数第k个节点
  * 内容: //输入一个链表，输出该链表中倒数第k个节点。为了符合大多数人的习惯，本题从1开始计数，即链表的尾节点是倒数第1个节点。 
//
// 例如，一个链表有 6 个节点，从头节点开始，它们的值依次是 1、2、3、4、5、6。这个链表的倒数第 3 个节点是值为 4 的节点。 
//
// 
//
// 示例： 
//
// 
//给定一个链表: 1->2->3->4->5, 和 k = 2.
//
//返回链表 4->5. 
// Related Topics 链表 双指针 
// 👍 289 👎 0
	
  * 日期：2021-10-19 22:35:49
*/
//输入一个链表，输出该链表中倒数第k个节点。为了符合大多数人的习惯，本题从1开始计数，即链表的尾节点是倒数第1个节点。 
//
// 例如，一个链表有 6 个节点，从头节点开始，它们的值依次是 1、2、3、4、5、6。这个链表的倒数第 3 个节点是值为 4 的节点。 
//
// 
//
// 示例： 
//
// 
//给定一个链表: 1->2->3->4->5, 和 k = 2.
//
//返回链表 4->5. 
// Related Topics 链表 双指针 
// 👍 289 👎 0

package leetcode.editor.cn;

import common.ListNode;
import common.NodeUtils;

public class P剑指Offer22链表中倒数第k个节点LianBiaoZhongDaoShuDiKgeJieDianLcof {
    public static void main(String[] args) {
        Solution solution = new P剑指Offer22链表中倒数第k个节点LianBiaoZhongDaoShuDiKgeJieDianLcof().new Solution();

        ListNode listNode = NodeUtils.condtructList(new int[]{1, 2, 3, 4});

        ListNode kthFromEnd = solution.getKthFromEnd(listNode, 2);

        NodeUtils.printNode(kthFromEnd);

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
    public ListNode getKthFromEnd(ListNode head, int k) {

        return dg(head, k);
    }

    int m = 0;
    private ListNode dg(ListNode cur, int k) {


        if (cur != null) {
            ListNode dg = dg(cur.next, k);

            if (m == k) {
                m++;
                //cur.next = dg.next;
                return dg;
            } else if (m < k){
                cur.next = dg;
                m++;
                return cur;
            } else {
                m++;
                return dg;
            }

        } else {
            return null;
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

} 
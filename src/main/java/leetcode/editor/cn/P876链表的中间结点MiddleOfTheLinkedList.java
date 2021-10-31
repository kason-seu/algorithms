/**
  * 题目Id：876
  * 题目：链表的中间结点
  * 内容: //给定一个头结点为 head 的非空单链表，返回链表的中间结点。 
//
// 如果有两个中间结点，则返回第二个中间结点。 
//
// 
//
// 示例 1： 
//
// 
//输入：[1,2,3,4,5]
//输出：此列表中的结点 3 (序列化形式：[3,4,5])
//返回的结点值为 3 。 (测评系统对该结点序列化表述是 [3,4,5])。
//注意，我们返回了一个 ListNode 类型的对象 ans，这样：
//ans.val = 3, ans.next.val = 4, ans.next.next.val = 5, 以及 ans.next.next.next = 
//NULL.
// 
//
// 示例 2： 
//
// 
//输入：[1,2,3,4,5,6]
//输出：此列表中的结点 4 (序列化形式：[4,5,6])
//由于该列表有两个中间结点，值分别为 3 和 4，我们返回第二个结点。
// 
//
// 
//
// 提示： 
//
// 
// 给定链表的结点数介于 1 和 100 之间。 
// 
// Related Topics 链表 双指针 
// 👍 422 👎 0
	
  * 日期：2021-10-24 20:50:58
*/
//给定一个头结点为 head 的非空单链表，返回链表的中间结点。 
//
// 如果有两个中间结点，则返回第二个中间结点。 
//
// 
//
// 示例 1： 
//
// 
//输入：[1,2,3,4,5]
//输出：此列表中的结点 3 (序列化形式：[3,4,5])
//返回的结点值为 3 。 (测评系统对该结点序列化表述是 [3,4,5])。
//注意，我们返回了一个 ListNode 类型的对象 ans，这样：
//ans.val = 3, ans.next.val = 4, ans.next.next.val = 5, 以及 ans.next.next.next = 
//NULL.
// 
//
// 示例 2： 
//
// 
//输入：[1,2,3,4,5,6]
//输出：此列表中的结点 4 (序列化形式：[4,5,6])
//由于该列表有两个中间结点，值分别为 3 和 4，我们返回第二个结点。
// 
//
// 
//
// 提示： 
//
// 
// 给定链表的结点数介于 1 和 100 之间。 
// 
// Related Topics 链表 双指针 
// 👍 422 👎 0

package leetcode.editor.cn;

import common.ListNode;
import common.NodeUtils;

public class P876链表的中间结点MiddleOfTheLinkedList {
    public static void main(String[] args) {
        Solution solution = new P876链表的中间结点MiddleOfTheLinkedList().new Solution();

        ListNode listNode = NodeUtils.condtructList(new int[]{1, 2, 3, 4, 6});
        ListNode listNode1 = solution.middleNode(listNode);


        System.out.println("Hello world" + listNode1.val);

        listNode = NodeUtils.condtructList(new int[]{1, 2, 3, 4, 6,7});
        listNode1 = solution.middleNode(listNode);


        System.out.println("Hello world" + listNode1.val);


        listNode = NodeUtils.condtructList(new int[]{1,2});
        listNode1 = solution.middleNode(listNode);


        System.out.println("Hello world" + listNode1.val);
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
    public ListNode middleNode(ListNode head) {

        if (head == null || head.next ==null) {
            return head;
        }
        recordNode = head;
        find = false;
        return dg(head);
    }

    private ListNode recordNode;
    private boolean find;
    private ListNode dg(ListNode head) {
        if (head == null) {
            return null;
        }
        dg(head.next);
        if (find) {
            return recordNode;
        }
        if (recordNode == head || recordNode.next == head) {
            find = true;
            recordNode = head;
            return recordNode;
        }
        recordNode = recordNode.next;
        return head;

    }
}
//leetcode submit region end(Prohibit modification and deletion)

} 
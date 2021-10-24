/**
  * 题目Id：面试题 02.05
  * 题目：链表求和
  * 内容: //给定两个用链表表示的整数，每个节点包含一个数位。 
//
// 这些数位是反向存放的，也就是个位排在链表首部。 
//
// 编写函数对这两个整数求和，并用链表形式返回结果。 
//
// 
//
// 示例： 
//
// 输入：(7 -> 1 -> 6) + (5 -> 9 -> 2)，即617 + 295
//输出：2 -> 1 -> 9，即912
// 
//
// 进阶：思考一下，假设这些数位是正向存放的，又该如何解决呢? 
//
// 示例： 
//
// 输入：(6 -> 1 -> 7) + (2 -> 9 -> 5)，即617 + 295
//输出：9 -> 1 -> 2，即912
// 
// Related Topics 递归 链表 数学 
// 👍 95 👎 0
	
  * 日期：2021-10-23 18:23:54
*/
//给定两个用链表表示的整数，每个节点包含一个数位。 
//
// 这些数位是反向存放的，也就是个位排在链表首部。 
//
// 编写函数对这两个整数求和，并用链表形式返回结果。 
//
// 
//
// 示例： 
//
// 输入：(7 -> 1 -> 6) + (5 -> 9 -> 2)，即617 + 295
//输出：2 -> 1 -> 9，即912
// 
//
// 进阶：思考一下，假设这些数位是正向存放的，又该如何解决呢? 
//
// 示例： 
//
// 输入：(6 -> 1 -> 7) + (2 -> 9 -> 5)，即617 + 295
//输出：9 -> 1 -> 2，即912
// 
// Related Topics 递归 链表 数学 
// 👍 95 👎 0

package leetcode.editor.cn;

import common.ListNode;
import common.NodeUtils;

public class P面试题0205链表求和SumListsLcci {
    public static void main(String[] args) {
        Solution solution = new P面试题0205链表求和SumListsLcci().new Solution();

        ListNode listNode = NodeUtils.condtructList(new int[]{7, 1, 16});

        ListNode listNode1 = NodeUtils.condtructList(new int[]{5, 9, 2});

        ListNode listNode2 = solution.addTwoNumbers(listNode, listNode1);

        NodeUtils.printNode(listNode2);
        System.out.println("Hello world");


        listNode = NodeUtils.condtructList(new int[]{7, 1});

        listNode1 = NodeUtils.condtructList(new int[]{5});

        listNode2 = solution.addTwoNumbers(listNode, listNode1);

        NodeUtils.printNode(listNode2);
        System.out.println("Hello world");


        listNode = NodeUtils.condtructList(new int[]{7, 1});

        listNode1 = NodeUtils.condtructList(new int[]{});

        listNode2 = solution.addTwoNumbers(listNode, listNode1);

        NodeUtils.printNode(listNode2);
        System.out.println("Hello world");

        listNode = NodeUtils.condtructList(new int[]{});

        listNode1 = NodeUtils.condtructList(new int[]{});

        listNode2 = solution.addTwoNumbers(listNode, listNode1);

        NodeUtils.printNode(listNode2);
        System.out.println("Hello world");

        listNode = NodeUtils.condtructList(new int[]{9,9});

        listNode1 = NodeUtils.condtructList(new int[]{2});

        listNode2 = solution.addTwoNumbers(listNode, listNode1);

        NodeUtils.printNode(listNode2);
        System.out.println("Hello world");

        listNode = NodeUtils.condtructList(new int[]{});

        listNode1 = NodeUtils.condtructList(new int[]{2,1});

        listNode2 = solution.addTwoNumbers(listNode, listNode1);

        NodeUtils.printNode(listNode2);
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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        ListNode dg = dg(l1, l2, 0);

        return dg;
    }

    private ListNode dg(ListNode l1, ListNode l2, int jiewei) {

        if (l1 == null && l2 == null) {

            if (jiewei > 0) {
                return new ListNode(jiewei, null);
            }
            return null;

        }

        int sum = 0;

        if (l1 != null) {
            sum += l1.val;
        }
        if (l2 != null) {
            sum += l2.val;
        }
        sum += jiewei;

        return new ListNode(sum % 10, dg(l1 == null ? l1 : l1.next, l2 == null ? l2 : l2.next, sum / 10));
    }
}
//leetcode submit region end(Prohibit modification and deletion)

} 
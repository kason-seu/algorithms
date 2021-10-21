/**
  * 题目Id：剑指 Offer 06
  * 题目：从尾到头打印链表
  * 内容: //输入一个链表的头节点，从尾到头反过来返回每个节点的值（用数组返回）。 
//
// 
//
// 示例 1： 
//
// 输入：head = [1,3,2]
//输出：[2,3,1] 
//
// 
//
// 限制： 
//
// 0 <= 链表长度 <= 10000 
// Related Topics 栈 递归 链表 双指针 
// 👍 195 👎 0
	
  * 日期：2021-10-17 21:30:44
*/
//输入一个链表的头节点，从尾到头反过来返回每个节点的值（用数组返回）。 
//
// 
//
// 示例 1： 
//
// 输入：head = [1,3,2]
//输出：[2,3,1] 
//
// 
//
// 限制： 
//
// 0 <= 链表长度 <= 10000 
// Related Topics 栈 递归 链表 双指针 
// 👍 195 👎 0

package leetcode.editor.cn;

import common.ListNode;
import common.NodeUtils;

import java.util.Arrays;

public class P剑指Offer06从尾到头打印链表CongWeiDaoTouDaYinLianBiaoLcof {
    public static void main(String[] args) {
        Solution solution = new P剑指Offer06从尾到头打印链表CongWeiDaoTouDaYinLianBiaoLcof().new Solution();

        ListNode listNode = NodeUtils.condtructList(new int[]{1, 2, 3, 4});

        int[] ints = solution.reversePrint(listNode);

        System.out.println(Arrays.toString(ints));

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
    public int[] reversePrint(ListNode head) {
        int num = 0;
        ListNode t = head;
        while (t != null) {
            num ++;
            t = t.next;
        }

        int[] rs = new int[num];
        dg(head, rs, num - 1);

        return rs;

    }

    private ListNode dg(ListNode node, int[] arr, int index) {

        if (node != null) {

            dg(node.next, arr, index-1);
            System.out.println(node.val);
            arr[index] = node.val;
            return node;
        }

        return node;

    }
}
//leetcode submit region end(Prohibit modification and deletion)

} 
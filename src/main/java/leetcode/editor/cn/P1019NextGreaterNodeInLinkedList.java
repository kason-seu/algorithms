/**
  * 题目Id：1019
  * 题目：链表中的下一个更大节点
  * 内容: //给定一个长度为 n 的链表 head 
//
// 对于列表中的每个节点，查找下一个 更大节点 的值。也就是说，对于每个节点，找到它旁边的第一个节点的值，这个节点的值 严格大于 它的值。 
//
// 返回一个整数数组 answer ，其中 answer[i] 是第 i 个节点( 从1开始 )的下一个更大的节点的值。如果第 i 个节点没有下一个更大的节点
//，设置 answer[i] = 0 。 
//
// 
//
// 示例 1： 
//
// 
//
// 
//输入：head = [2,1,5]
//输出：[5,5,0]
// 
//
// 示例 2： 
//
// 
//
// 
//输入：head = [2,7,4,3,5]
//输出：[7,0,5,5,0]
// 
//
// 
//
// 提示： 
//
// 
// 链表中节点数为 n 
// 1 <= n <= 10⁴ 
// 1 <= Node.val <= 10⁹ 
// 
// Related Topics 栈 数组 链表 单调栈 👍 194 👎 0
	
  * 日期：2022-04-03 18:56:02
*/
//给定一个长度为 n 的链表 head 
//
// 对于列表中的每个节点，查找下一个 更大节点 的值。也就是说，对于每个节点，找到它旁边的第一个节点的值，这个节点的值 严格大于 它的值。 
//
// 返回一个整数数组 answer ，其中 answer[i] 是第 i 个节点( 从1开始 )的下一个更大的节点的值。如果第 i 个节点没有下一个更大的节点
//，设置 answer[i] = 0 。 
//
// 
//
// 示例 1： 
//
// 
//
// 
//输入：head = [2,1,5]
//输出：[5,5,0]
// 
//
// 示例 2： 
//
// 
//
// 
//输入：head = [2,7,4,3,5]
//输出：[7,0,5,5,0]
// 
//
// 
//
// 提示： 
//
// 
// 链表中节点数为 n 
// 1 <= n <= 10⁴ 
// 1 <= Node.val <= 10⁹ 
// 
// Related Topics 栈 数组 链表 单调栈 👍 194 👎 0

package leetcode.editor.cn;

import common.ListNode;

import java.util.*;

public class P1019NextGreaterNodeInLinkedList {
    public static void main(String[] args) {
        Solution solution = new P1019NextGreaterNodeInLinkedList().new Solution();
        System.out.println("Hello world");
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
    public class Pair {
        public int index;
        public int value;
    }
    public int[] nextLargerNodes(ListNode head) {

        Deque<Pair> deque = new ArrayDeque<>();
        int curIndex = 0;
        Map<Integer, Integer> result = new HashMap<>();

        while (head != null) {

            while (!deque.isEmpty() && head.val > deque.peek().value) {
                Pair topPair = deque.pop();
                result.put(topPair.index, head.val);
            }
            Pair p = new Pair();
            p.index = curIndex;
            p.value = head.val;
            head = head.next;
            curIndex++;
            deque.push(p);
        }

        int[] answer = new int[curIndex];
        result.entrySet().stream().forEach(kv -> {
            answer[kv.getKey()] = kv.getValue();
        });
        return answer;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
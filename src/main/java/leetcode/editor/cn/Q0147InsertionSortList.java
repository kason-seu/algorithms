package leetcode.editor.cn;
/** * @author  kason * @date    2023-12-30 12:03:42 */public class Q0147InsertionSortList{    //给定单个链表的头
// head ，使用 插入排序 对链表进行排序，并返回 排序后链表的头 。 
//
// 插入排序 算法的步骤: 
//
// 
// 插入排序是迭代的，每次只移动一个元素，直到所有元素可以形成一个有序的输出列表。 
// 每次迭代中，插入排序只从输入数据中移除一个待排序的元素，找到它在序列中适当的位置，并将其插入。 
// 重复直到所有输入数据插入完为止。 
// 
//
// 下面是插入排序算法的一个图形示例。部分排序的列表(黑色)最初只包含列表中的第一个元素。每次迭代时，从输入数据中删除一个元素(红色)，并就地插入已排序的列表
//中。 
//
// 对链表进行插入排序。 
//
// 
//
// 
//
// 示例 1： 
//
// 
//
// 
//输入: head = [4,2,1,3]
//输出: [1,2,3,4] 
//
// 示例 2： 
//
// 
//
// 
//输入: head = [-1,5,3,4,0]
//输出: [-1,0,3,4,5] 
//
// 
//
// 提示： 
//
// 
// 
//
// 
// 列表中的节点数在 [1, 5000]范围内 
// -5000 <= Node.val <= 5000 
// 
//
// Related Topics 链表 排序 👍 650 👎 0
    public static void main(String[] args) {        Solution solution = new Q0147InsertionSortList()
            .new Solution();
        ListNode l = new ListNode(-1);
        ListNode l2 = new ListNode(5);
        ListNode l3 = new ListNode(3);
        ListNode l4 = new ListNode(4);
        ListNode l5 = new ListNode(0);
        l.next = l2;
        l2.next = l3;
        l3.next = l4;
        l4.next = l5;

        ListNode re = solution.insertionSortList(l);
        print(re);

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



    public ListNode insertionSortList(ListNode head) {

        if (head == null || head.next == null) {
            return head;

        }

       // 准备回溯反向遍历递归，先走到最后的节点，意思是右边保证序列了，看左边的区别
        ListNode listNode = insertionSortList(head.next);

        if (listNode.val >= head.val) {
            head.next = listNode;
            return head;
        } else {
            // 找到head的位置
            ListNode pos = listNode;
            while (true) {
                if (pos.next != null && pos.next.val < head.val) {
                    pos = pos.next;
                } else {
                    ListNode t = pos.next;
                    pos.next = head;
                    head.next = t;
                    break;
                }
            }
            return listNode;
        }

    }


    public ListNode insertionSortListDg(ListNode head) {
        ListNode t = head;
        while (head != null) {
            ListNode wait = head;
            head = wait.next;
            t = insertDG(t, wait);
        }
        return t;
    }

    public ListNode insertDG(ListNode start, ListNode waitInsert) {

        if (start == null) {
            return waitInsert;
        }
        if (waitInsert == null) {
            return start;
        }
        if (start == waitInsert) {
            return waitInsert;
        }
        if (start.val < waitInsert.val) {
            start.next = insertDG(start.next, waitInsert);
            return start;
        } else {
            waitInsert.next = start;
            while (start != null && start.next != waitInsert) {
                start = start.next;
            }
            if (start != null) {
                start.next = null;
            }
            return waitInsert;
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
}
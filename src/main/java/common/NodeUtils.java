package common;

public class NodeUtils {

    public static void printNode(Node node) {
        while (node != null) {
            System.out.println(node.val);
            node = node.next;
        }
    }

    public static void printNode(ListNode node) {
        while (node != null) {
            System.out.println(node.val);
            node = node.next;
        }
    }

    public static ListNode condtructList(int[] arr) {
        ListNode head = null;
        ListNode next = null;
        for (int i = 0; i < arr.length; i++) {
            if (head == null) {
                head = new ListNode(arr[i]);
                next = head;
            } else {
                next.next = new ListNode(arr[i]);
                next = next.next;
            }
        }
        return head;
    }
}

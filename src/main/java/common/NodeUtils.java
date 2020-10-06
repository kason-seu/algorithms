package common;

public class NodeUtils {

    public static void printNode(Node node) {
        while (node != null) {
            System.out.println(node.val);
            node = node.next;
        }
    }
}

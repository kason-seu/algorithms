package common;

public class TreeNodeUtils {


    public static void printPreNodeTree(TreeNode node) {

        if (node == null) {
            return;
        }

        System.out.println(node.val);

        printPreNodeTree(node.left);

        printPreNodeTree(node.right);

    }

    public static String getPreNodeTree(TreeNode node) {

        if (node == null) {
            return "";
        }

        String s= "";

        s += getPreNodeTree(node.left);

        s += getPreNodeTree(node.right);

        return s;
    }

    /*public static String cengPrint(TreeNode node) {

    }*/
}

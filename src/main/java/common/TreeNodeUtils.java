package common;

import java.util.HashMap;
import java.util.Map;

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
    public static Map<Integer, TreeNode> value2Node = new HashMap<>();
    public static TreeNode buildTree(String str) {

        String[] nodes = str.split(",");
        TreeNode root = null;
        Map<Integer, TreeNode> indexNodeMap = new HashMap<>();

        for (int i = 0; i < nodes.length; i++) {
            String value = nodes[i].trim();
            TreeNode treeNode = null;
            if (!value.equals("null")) {
                treeNode = new TreeNode(Integer.parseInt(value));
            } else {
                continue;
            }
            if (root == null) {
                root = treeNode;

            } else {
                TreeNode fatherNode = indexNodeMap.get((i - 1)/ 2);
                if ((i - 1) % 2 == 0) {
                    fatherNode.left = treeNode;
                } else {
                    fatherNode.right = treeNode;
                }

            }
            indexNodeMap.put(i, treeNode);
            value2Node.put(Integer.parseInt(value), treeNode);
        }
        return root;

    }

    public static void main(String[] args) {
        String values = "3,5,1,6,2,9,8,null,null,7,4";
        TreeNode treeNode = buildTree(values);
        printPreNodeTree(treeNode);
    }
}

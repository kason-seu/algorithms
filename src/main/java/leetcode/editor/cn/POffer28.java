package leetcode.editor.cn;

import common.TreeNode;

public class POffer28 {

    public boolean isSymmetric(TreeNode root) {

        if (root == null) {
            return false;
        }

        TreeNode mirror = mirror(root.left);

        return recurCompare(mirror, root.right);


    }


    private TreeNode mirror(TreeNode node) {

        if (node == null) {
            return null;
        }


        TreeNode temp = mirror(node.left);
        node.left = mirror(node.right);
        node.right = temp;

        return node;



    }

    private boolean recurCompare(TreeNode node1, TreeNode node2) {


        if (node1 == null && node2 == null) {
            return true;
        }
        if (node1 == null && node2 != null) {
            return false;
        }
        if (node1 != null && node2 == null) {
            return false;
        }

        if (node1.val == node2.val) {

            return recurCompare(node1.left, node2.left) && recurCompare(node1.right, node2.right);
        } else {
            return false;
        }

    }
}

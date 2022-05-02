package leetcode.editor.cn;

import common.TreeNode;

public class POffer27 {

    public TreeNode mirrorTree(TreeNode root) {

        return mirror(root);

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
}

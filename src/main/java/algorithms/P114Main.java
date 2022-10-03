package algorithms;

import common.TreeNode;

public class P114Main {

    public void flatten(TreeNode root) {

        if (root == null) {
            return;
        }

        preDfs(root);

    }

    /**
     *
     * @param currentNode： 当前节点
     * @return 返回最后的节点
     */
    private TreeNode preDfs(TreeNode currentNode) {

        if (currentNode.left == null && currentNode.right == null) {
            return currentNode;
        }

        TreeNode preNode = null;
        TreeNode right = currentNode.right;
        if (currentNode.left != null) {
            // 拿到左子树作为根节点的先序遍历的最后节点,前驱节点
            preNode = preDfs(currentNode.left);
            currentNode.right = currentNode.left;
            preNode.right = right;
            currentNode.left = null;
        }

        if (right != null) {
            preNode = preDfs(right);
        }

        return preNode;


    }

}

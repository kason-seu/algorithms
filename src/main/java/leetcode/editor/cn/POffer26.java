package leetcode.editor.cn;

import common.TreeNode;

public class POffer26 {

    public boolean isSubStructure(TreeNode A, TreeNode B) {

        if (B == null) {
            return false;
        }
        System.out.println();
        return innerTraversal(A, B);


    }

    private boolean innerTraversal(TreeNode A, TreeNode B) {

        if (A == null && B != null) {
            return false;
        }
        if (A != null && B == null) {
            return false;
        }

        if (A.val == B.val) {
            if (innerTraversal(A.left, B.left) && innerTraversal(A.right, B.right)) {
                return true;
            } else {
                return innerTraversal(A.left, B) || innerTraversal(A.right, B);
            }
        } else {
            return innerTraversal(A.left, B) || innerTraversal(A.right, B);
        }

    }
}

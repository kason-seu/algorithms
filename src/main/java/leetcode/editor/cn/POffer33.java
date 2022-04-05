package leetcode.editor.cn;

public class POffer33 {


    public static void main(String[] args) {

        int[] postorder = new int[]{1,2,5,10,6,9,4,3};

        POffer33 p = new POffer33();
        boolean b = p.verifyPostorder(postorder);

        System.out.println("result " + b);
    }

    public boolean verifyPostorder(int[] postorder) {
        return recursive(postorder, 0, postorder.length - 1);
    }

    // 左子树的值都小于二叉搜索树的根，右子树的值都大于二叉搜索树的根
    private boolean recursive(int[] postorder, int start, int end) {
        if (start >= end) {
            return true;
        }
        // 根 是最后的值.
        int root = postorder[end];
        int mid = -1;
        for (int i = start; i < end; i++) {
            if (postorder[i] > root) {
                // 一旦首次大于根，那么这个值就应该是右子树的数
                mid = i;
                break;
            }
        }
        if (mid == -1 || mid == end - 1) {
            return recursive(postorder, start, end -1 );
        }
        for (int i = mid; i < end; i++) {
            // 右子树理论上应该都会大于根，所以一旦出现小于根的，那么他一定不符合二叉搜索树的后续遍历
            if (postorder[i] < root) {
                return false;
            }
        }
        boolean recursiveLeft = recursive(postorder, start, mid - 1);
        if (!recursiveLeft) {
            return false;
        }
        boolean recursiveRight = recursive(postorder, mid, end - 1);
        if (!recursiveRight) {
            return false;
        }
        return true;

    }
}

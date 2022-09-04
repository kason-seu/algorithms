package algorithms;

import common.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class P99Main {

    public void recoverTree(TreeNode root) {

        List<TreeNode> subList = new ArrayList<>();

        traversal(root, subList);

        // fing root index
        int rootIndex = findRootIndex(root, subList);

        // 左子树和右子树的左右边界
        int LLeft = -1, LRight = rootIndex, RLeft = rootIndex , RRight = -1;


        for (int i = 0; i <= rootIndex - 1; i++) {
            // 错误的位置
            if (subList.get(i).val > subList.get(i+1).val) {
                LLeft = i;
                break;
            }
        }
        for (int i = rootIndex; i >= 1; i--) {
            if (subList.get(i).val < subList.get(i-1).val) {
                LRight = i;
                break;
            }
        }


        for (int i = rootIndex; i < subList.size() - 1; i++) {
            if (subList.get(i).val > subList.get(i+1).val) {
                RLeft = i;
                break;
            }
        }

        for (int i = subList.size() - 1; i >= rootIndex + 1; i--) {
            if (subList.get(i).val < subList.get(i - 1).val) {
                RRight = i;
                break;
            }
        }

        // 判断两个错误节点的具体位置

        if (LLeft != -1 && RRight != -1) {
            // 说明横跨左右子树
            swap(LLeft, RRight, subList);
        } else if (LLeft != -1) {
            swap(LLeft, LRight, subList);
        } else if (RRight != -1 ) {
            swap(RLeft,RRight,subList);
        }


    }

    private void swap(int lLeft, int rRight, List<TreeNode> subList) {

        int temp = subList.get(rRight).val;
        subList.get(rRight).val = subList.get(lLeft).val;
        subList.get(lLeft).val = temp;
    }

    private int findRootIndex(TreeNode root, List<TreeNode> subList) {
        for (int i = 0; i < subList.size(); i++) {
            if (root.val == subList.get(i).val) {
                return i;
            }
        }
        return -1;
    }

    private void traversal(TreeNode root, List<TreeNode> subList) {
        if(root == null) {
            return;
        }
        if (root.left != null) {
            traversal(root, subList);
        }
        subList.add(root);

        if (root.right != null) {
            traversal(root, subList);
        }
    }


}

package leetcode.editor.cn;

import common.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;


public class POffer32_3 {


    public List<List<Integer>> levelOrder(TreeNode root) {

        if (root == null) {
            return new ArrayList<>();
        }
        List<List<Integer>> ans = new ArrayList<>();

        LinkedList<TreeNode> queue = new LinkedList<>();

        queue.add(root);

        int level = 1;

        while (!queue.isEmpty()) {

            List<Integer> childLevelResult = new ArrayList<>();
            int size = queue.size();

            for (int i = 0; i < size; i++) {

                if (level % 2 == 1) {
                    TreeNode poll = queue.poll();
                    childLevelResult.add(poll.val);

                    TreeNode left = poll.left;
                    if (left != null) {
                        queue.add(left);
                    }

                    TreeNode right = poll.right;
                    if (right != null) {
                        queue.add(right);
                    }
                } else {
                    TreeNode p = queue.pollLast();
                    childLevelResult.add(p.val);
                    TreeNode right = p.right;
                    if (right != null) {
                        queue.addFirst(right);
                    }
                    TreeNode left = p.left;
                    if (left != null) {
                        queue.addFirst(left);
                    }

                }

            }
            level++;
            if (childLevelResult.size() > 0) {
                ans.add(childLevelResult);
            }
        }

        return ans;

    }

}

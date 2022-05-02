package leetcode.editor.cn;

import common.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class POffer32_2 {

    public List<List<Integer>> levelOrder(TreeNode root) {

        List<List<Integer>> ans = new ArrayList<>();
        Queue<TreeNode> queue = new ArrayDeque<>();

        if (root == null) {
            return new ArrayList<>();
        }

        queue.add(root);
        List<Integer> l = new ArrayList<>();
        l.add(root.val);
        ans.add(l);
        int levelSize = 1;
        while (!queue.isEmpty()) {
            List<Integer> ll= new ArrayList<>();
            int nexrLevelSize = 0;
            for (int i = 0; i < levelSize; i++) {
                TreeNode pollNode = queue.poll();

                TreeNode left = pollNode.left;

                if (left != null) {
                    nexrLevelSize++;
                    ll.add(left.val);
                    queue.add(left);
                }

                TreeNode right = pollNode.right;

                if (right != null) {
                    nexrLevelSize++;
                    ll.add(right.val);
                    queue.add(right);
                }
            }
            if (ll.size() > 0) {
                ans.add(ll);
            }
            levelSize = nexrLevelSize;

        }

        return ans;

    }
}

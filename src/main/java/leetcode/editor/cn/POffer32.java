package leetcode.editor.cn;


import common.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class POffer32 {

    public int[] levelOrder(TreeNode root) {

        List<Integer> ans = new ArrayList<>();
       Queue<TreeNode> queue = new ArrayDeque<>();

       if (root == null) {
           return new int[]{};
       }

       queue.add(root);
       while (!queue.isEmpty()) {

           TreeNode pollNode = queue.poll();
           ans.add(pollNode.val);
           TreeNode left = pollNode.left;

           if (left != null) {
               queue.add(left);
           }

           TreeNode right = pollNode.right;

           if (right != null) {

               queue.add(right);
           }

       }

       return ans.stream().mapToInt(Integer::valueOf).toArray();

    }
}

package algorithms;

import common.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class P199Main {

    public List<Integer> rightSideView(TreeNode root) {

        List<Integer> ans = new ArrayList<>();
        if (root == null) {
            return ans;
        }

        Queue<TreeNode> queueNode = new ArrayDeque<>();
        queueNode.add(root);
        int currentLevelSize = 1;
        int nextLevelSize = 0;
        int currentLevelPoolSize = 0;

        while (!queueNode.isEmpty()) {

            TreeNode poll = queueNode.poll();
            currentLevelPoolSize++;
            if (poll.left != null) {
                queueNode.offer(poll.left);
                nextLevelSize++;
            }
            if (poll.right != null) {
                queueNode.offer(poll.right);
                nextLevelSize++;
            }
            // 说明已经找到了最右的那个数据，应该加到那个List结果之中
            if (currentLevelPoolSize == currentLevelSize) {
                ans.add(poll.val);
                currentLevelSize = nextLevelSize;
                nextLevelSize = 0;
                currentLevelPoolSize = 0;
            }
        }
        return ans;
    }
}

package leetcode.editor.algorithms;

import org.checkerframework.checker.units.qual.K;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class MP18Q4 {


    public static void main(String[] args) {
        int [] arr1 = new int[]{1,2,3,4,5};
        int [] arr2 = new int[]{3,5,7,9,11};
        MP18Q4 mp = new MP18Q4();
        int[] ints = mp.queryMaxKTop(arr1, arr2, 4);
        int[] ints2 = mp.queryMaxKTop2(arr1, arr2, 4);

        Arrays.stream(ints2).forEach(System.out::println);
    }
    class Node {
        public int index1;
        public int index2;
        public int sum;

        public Node(int index1, int index2, int sum) {
            this.index1 = index1;
            this.index2 = index2;
            this.sum = sum;
        }
    }

    public int[] queryMaxKTop(int[] arr1, int[] arr2, int K) {


        int len1 = arr1.length;
        int len2 = arr2.length;
        K = Math.min(K, len1 * len2);
        int[] ans = new int[K];
        PriorityQueue<Node> priorityQueue = new PriorityQueue<Node>(new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                return o2.sum - o1.sum;
            }
        });
        // 记录是否某些元素被访问过
        boolean[][] recordVisited = new boolean[len1][len2];
        int visitIndex = 0;
        priorityQueue.add(new Node(len1 - 1, len2 - 1, arr1[len1 - 1] + arr2[len2 - 1]));
        recordVisited[len1 - 1][len2 - 1] = true;

        while (!priorityQueue.isEmpty() && visitIndex < K) {
            Node poll = priorityQueue.poll();
            ans[visitIndex++] = poll.sum;
            int pollIndex1 = poll.index1;
            int pollIndex2 = poll.index2;
            // 左边的没访问过
            if (pollIndex1 - 1 >= 0 && !recordVisited[pollIndex1 - 1][pollIndex2]) {
                recordVisited[pollIndex1 - 1][pollIndex2] = true;
                priorityQueue.add(new Node(pollIndex1 - 1, pollIndex2, arr1[pollIndex1 - 1] + arr2[pollIndex2]));
            }
            // 上面的没访问过
            if (pollIndex2 - 1 >= 0 && !recordVisited[pollIndex1][pollIndex2 - 1]) {
                recordVisited[pollIndex1][pollIndex2 - 1] = true;
                priorityQueue.add(new Node(pollIndex1, pollIndex2 - 1, arr1[pollIndex1] + arr2[pollIndex2 - 1]));
            }
        }

        return ans;

    }



    public int[] queryMaxKTop2(int[] arr1, int[] arr2, int K) {


        int len1 = arr1.length;
        int len2 = arr2.length;
        K = Math.min(K, len1 * len2);
        int[] ans = new int[K];
        PriorityQueue<Node> priorityQueue = new PriorityQueue<Node>(new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                return o2.sum - o1.sum;
            }
        });

        int visitIndex = 0;
        for (int i = 0; i < K; i++) {
            priorityQueue.add(new Node(len1 - 1 - i, len2 - 1, arr1[len1 - 1 - i] + arr2[len2 - 1]));
        }


        while (!priorityQueue.isEmpty() && visitIndex < K) {
            Node poll = priorityQueue.poll();
            ans[visitIndex++] = poll.sum;
            int pollIndex1 = poll.index1;
            int pollIndex2 = poll.index2;

            if (pollIndex2 - 1 >= 0)  {
                priorityQueue.add(new Node(pollIndex1, pollIndex2 - 1, arr1[pollIndex1] + arr2[pollIndex2 - 1]));
            }

        }

        return ans;

    }

}

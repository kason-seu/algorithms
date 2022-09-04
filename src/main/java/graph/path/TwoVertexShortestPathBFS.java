package graph.path;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayDeque;
import java.util.Queue;

public class TwoVertexShortestPathBFS {

    private int[][]matrix;
    private int V;
    private int E;
    // 最短距离
    private int twoVertexShortestPath;
    class Node {
        int startToCurrentPath;
        int currentId;

        public Node(int path, int id) {
            this.startToCurrentPath = path;
            this.currentId = id;
        }
    }
    private Queue<Node> queue = new ArrayDeque<>();

    public static void main(String[] args) throws Exception {
        // 1 buildGraph， 从文件读取图
        TwoVertexShortestPathBFS twoVertexShortestPath1 = new TwoVertexShortestPathBFS();
        twoVertexShortestPath1.buildGraph("graph/src/main/resources/gpath.txt");
        // 2 计算两点最短距离，通过dfs

        int twoVertexShortestPathBfs = twoVertexShortestPath1.findTwoVertexShortestPathBfs(1, 5);

        System.out.println(twoVertexShortestPathBfs);

        twoVertexShortestPathBfs = twoVertexShortestPath1.findTwoVertexShortestPathBfs(2, 1);

        System.out.println(twoVertexShortestPathBfs);


        twoVertexShortestPathBfs = twoVertexShortestPath1.findTwoVertexShortestPathBfs(2, 5);

        System.out.println(twoVertexShortestPathBfs);
    }

    private void buildGraph(String path) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new FileReader(path));

        String line1 = bufferedReader.readLine();
        V = Integer.parseInt(line1.trim().split(" ")[0]);
        E = Integer.parseInt(line1.trim().split(" ")[1]);

        matrix = new int[V][V];

        // 距离权重
        for (int i = 0; i < V; i++) {
            for (int j = 0; j < V; j++) {
                matrix[i][j] = i == j ? 0 : Integer.MAX_VALUE;
            }
        }

        // 应该读取文件取覆盖具体的权重值
        String s;
        while ((s = bufferedReader.readLine()) != null) {
            String[] line = s.trim().split(" ");

            matrix[Integer.parseInt(line[0]) - 1][Integer.parseInt(line[1]) - 1] =  Integer.parseInt(line[2]);
        }

        bufferedReader.close();
    }

    private int findTwoVertexShortestPathBfs(int start, int end) {
        // 一开始最短距离其实赋值为初值
        twoVertexShortestPath = matrix[start-1][end-1];

        Node node = new Node(0, start-1);
        queue.add(node);
        while (!queue.isEmpty()) {

            Node poll = queue.poll();

            if (poll.currentId == end-1) {
                // 找到符合终点的值了
                twoVertexShortestPath = Math.min(twoVertexShortestPath, poll.startToCurrentPath);
                continue;
            }
            // 通过poll节点，查看邻居节点，append 到Queue
            for (int i = 0; i < V; i++) {
                if (i != poll.currentId && matrix[poll.currentId][i] != Integer.MAX_VALUE) {
                    int pollTOIpath = poll.startToCurrentPath + matrix[poll.currentId][i];
                    if (pollTOIpath > twoVertexShortestPath) {
                        continue;
                    }
                    queue.add(new Node(pollTOIpath, i));
                }
            }


        }

        return twoVertexShortestPath;
    }



}

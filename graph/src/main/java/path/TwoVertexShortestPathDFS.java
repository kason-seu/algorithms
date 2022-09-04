package path;

import java.io.BufferedReader;
import java.io.FileReader;

public class TwoVertexShortestPathDFS {

    private int[][]matrix;
    private int V;
    private int E;
    // 最短距离
    private int twoVertexShortestPath;
    private boolean[] visited;
    public static void main(String[] args) throws Exception {
        // 1 buildGraph， 从文件读取图
        TwoVertexShortestPathDFS twoVertexShortestPath1 = new TwoVertexShortestPathDFS();
        twoVertexShortestPath1.buildGraph("graph/src/main/resources/gpath.txt");
        // 2 计算两点最短距离，通过dfs
        int twoVertexShortestPath2 = twoVertexShortestPath1.findTwoVertexShortestPath(1, 5);

        System.out.println(twoVertexShortestPath2);

        twoVertexShortestPath2 = twoVertexShortestPath1.findTwoVertexShortestPath(2, 1);

        System.out.println(twoVertexShortestPath2);
    }

    private void buildGraph(String path) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new FileReader(path));

        String line1 = bufferedReader.readLine();
        V = Integer.parseInt(line1.trim().split(" ")[0]);
        E = Integer.parseInt(line1.trim().split(" ")[1]);

        matrix = new int[V][V];
        visited = new boolean[V];

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

    private int findTwoVertexShortestPath(int start, int end) {
        // 一开始最短距离其实赋值为初值
        twoVertexShortestPath = matrix[start-1][end-1];
        dfs(start - 1, end - 1, 0);
        return twoVertexShortestPath;
    }

    private void dfs(int start, int end, int path) {

        if (path > twoVertexShortestPath) {
            return;
        }
        if (start == end) {
            twoVertexShortestPath = path;
            return;
        }

        for (int i =0 ; i < V; i++) {
            if (start != i && matrix[start][i] != Integer.MAX_VALUE && !visited[i]) {
                visited[i] = true;
                dfs(i, end, path + matrix[start][i]);
                visited[i] = false;
            }
        }

    }

}

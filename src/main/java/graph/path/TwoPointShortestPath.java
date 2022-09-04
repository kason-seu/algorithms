package graph.path;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class TwoPointShortestPath {

    private int[][] matrix;
    private int V;
    private int E;

    private boolean[] visited;

    private int shortestPath;
    public static void main(String[] args) throws Exception {
        TwoPointShortestPath twoPointShortestPath = new TwoPointShortestPath();
        twoPointShortestPath.buildGraph();
        int shortestPath1 = twoPointShortestPath.findShortestPath(1,5);

        System.out.println(shortestPath1);

    }

    private void buildGraph() throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new FileReader("src/main/resources/graph/gpath.txt"));
        String s = bufferedReader.readLine();
        V = Integer.parseInt(s.trim().split(" ")[0]);
        E = Integer.parseInt(s.trim().split(" ")[1]);

        matrix = new int[V][V];
        visited = new boolean[V];
        for (int i = 0; i < V; i++) {
            for (int j = 0; j < V; j++) {
                matrix[i][j] = i == j ? 0 : Integer.MAX_VALUE;
            }
        }
        while ((s = bufferedReader.readLine()) != null) {
            String[] splitStr = s.trim().split(" ");
            matrix[Integer.parseInt(splitStr[0]) - 1][Integer.parseInt(splitStr[1]) - 1] = Integer.parseInt(splitStr[2]);
        }
    }


    private int findShortestPath(int start, int end) {
        // 初始化
        shortestPath = matrix[start-1][end-1];
        dfs(start-1, end - 1, 0);

        return shortestPath;
    }

    private void dfs(int start, int end, int path) {

        // 特殊处理剪纸，在递归下去只会更大，没意义
        if (path > shortestPath) {
            return;
        }

        if (start == end) {
            shortestPath = path;
            return;
        }

        for (int i = 0; i < V; i++) {
            if (start!= i && matrix[start][i] != Integer.MAX_VALUE && !visited[i]) {
                visited[i] = true;
                dfs(i, end, path + matrix[start][i]);
                visited[i] = false;
            }
        }

    }

}

package graph.path;

import java.io.BufferedReader;
import java.io.FileReader;

public class Floyd {

    private int[][] matrix;
    private int V;

    public static void main(String[] args) throws Exception {
        Floyd twoPointShortestPath = new Floyd();
        twoPointShortestPath.buildGraph();
        twoPointShortestPath.floyd();

        twoPointShortestPath.print();
    }

    private void buildGraph() throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new FileReader("src/main/resources/graph/gpath.txt"));
        String s = bufferedReader.readLine();
        V = Integer.parseInt(s.trim().split(" ")[0]);
        matrix = new int[V][V];
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


    private void floyd() {

        for (int k = 0; k < V; k++) {
            for (int i = 0; i < V; i++) {
                for (int j = 0; j < V; j++) {
                    if (matrix[i][k] == Integer.MAX_VALUE || matrix[k][j] == Integer.MAX_VALUE) {
                        continue;
                    }else if (matrix[i][j] > matrix[i][k] + matrix[k][j]) {
                        // 最短距离需要经过k节点
                        matrix[i][j] = matrix[i][k] + matrix[k][j];
                    }
                }
            }
        }


    }

    private void print() {
        for (int i = 0; i < V; ++i) {
            for (int j = 0; j < V; ++j) {
                if (matrix[i][j] == Integer.MAX_VALUE)
                    System.out.print("INF ");
                else
                    System.out.print(matrix[i][j] + "  ");
            }
            System.out.println();
        }
    }


}

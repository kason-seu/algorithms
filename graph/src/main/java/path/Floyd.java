package path;

import java.io.BufferedReader;
import java.io.FileReader;

public class Floyd {

    private int[][]matrix;
    private int V;

    public static void main(String[] args) throws Exception {
        // 1 buildGraph， 从文件读取图
        Floyd floyd = new Floyd();
        floyd.buildGraph("graph/src/main/resources/gpath.txt");
        floyd.floyd();
        floyd.printGraph();

    }

    private void buildGraph(String path) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new FileReader(path));

        String line1 = bufferedReader.readLine();
        V = Integer.parseInt(line1.trim().split(" ")[0]);


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

    private void floyd() {
        for (int k = 0; k < V; k++) {
            for (int i = 0; i < V; i++) {
                for (int j = 0; j < V; j++) {
                    if (matrix[i][k] == Integer.MAX_VALUE || matrix[k][j] == Integer.MAX_VALUE) {

                    } else if (matrix[i][j] > matrix[i][k] + matrix[k][j]) {
                        matrix[i][j] = matrix[i][k] + matrix[k][j];
                    }

                }

            }
        }
    }


    private void printGraph() {
        for (int i =0; i<V;i++) {
            for (int j = 0; j<V;j++) {
                if (matrix[i][j] == Integer.MAX_VALUE) {
                    System.out.print("INF ");
                } else {
                    System.out.print(matrix[i][j] + " ");
                }
            }
            System.out.println();
        }
    }

}

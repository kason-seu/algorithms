package graph.dfs;

/**
 * 二分图检测
 */
public class GraphBipartitionDetection {

    private Graph G;

    private final int[] colors; //染色
    private boolean isBiPartition = true;

    public GraphBipartitionDetection(Graph g) {
        this.G = g;

        this.colors = new int[G.V()];
        for (int i = 0; i < G.V(); i++) {
            colors[i] = -1;
        }
        for (int v = 0; v < G.V(); v++) {
            if (colors[v] == -1) {
                if (!dfs(v, 0)) {
                    isBiPartition = false;
                    break;
                }
            }
        }
    }

    private boolean dfs(int v, int color) {
        //visited[v] = true;
        colors[v] = color;
        for (int w : G.adj(v)) {
            if (colors[w] == -1) {
                if (!dfs(w, 1 - color)) {
                    return false;
                }
            } else {
                if (colors[w] == colors[v]) { // 颜色撞上了
                    return false;
                }
            }
        }
        return true;
    }

    public boolean isBiPartition() {
        return isBiPartition;
    }


    public static void main(String[] args) {
        Graph graph = new Graph("g4.txt");
        GraphBipartitionDetection graphDFS = new GraphBipartitionDetection(graph);
        System.out.println(graphDFS.isBiPartition());


        graph = new Graph("g3.txt");
        graphDFS = new GraphBipartitionDetection(graph);
        System.out.println(graphDFS.isBiPartition());
    }
}

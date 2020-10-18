package graph;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class GraphCC {

    private Graph G;
    private final boolean[] visited;
    private int cccount;

    public GraphCC(Graph g) {
        this.G = g;
        this.visited = new boolean[G.V()];
        for (int v = 0; v < G.V(); v++) {
            if (!visited[v]) {
                cccount++;
                dfs(v);
            }
        }
    }

    private void dfs(int v) {
        visited[v] = true;

        for (int w : G.adj(v)) {
            if (!visited[w]) {
                dfs(w);
            }
        }

    }

    public int getCccount() {
        return cccount;
    }


    public static void main(String[] args) {
        Graph graph = new Graph("g1.txt");
        GraphCC graphDFS = new GraphCC(graph);

        System.out.println(String.format("联通分量个数(connected component count) %d", graphDFS.getCccount()));
    }
}

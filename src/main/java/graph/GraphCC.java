package graph;

import com.google.common.collect.Lists;

import java.util.*;
import java.util.stream.Collectors;

public class GraphCC {

    private Graph G;
    private final int[] visited;
    private int cccount;

    public GraphCC(Graph g) {
        this.G = g;
        this.visited = new int[G.V()];
        Arrays.fill(visited, -1);
        for (int v = 0; v < G.V(); v++) {
            if (visited[v] == -1) {

                dfs(v,cccount++);
            }
        }
    }

    private void dfs(int v, int ccid) {
        visited[v] = ccid;
        for (int w : G.adj(v)) {
            if (visited[w] == -1) {
                dfs(w,ccid);
            }
        }

    }

    public int getCccount() {
        return cccount;
    }

    public int[] getVisited() {
        return visited;
    }

    public static void main(String[] args) {
        Graph graph = new Graph("g1.txt");
        GraphCC graphDFS = new GraphCC(graph);

        System.out.println(String.format("联通分量个数(connected component count) %d", graphDFS.getCccount()));
        Arrays.stream(graphDFS.getVisited()).forEach(System.out::println);
        System.out.println();
    }
}

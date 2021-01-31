package graph.dfs;

import java.util.*;

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

    public boolean isConnected(int v, int w) {
        G.validVertex(v);
        G.validVertex(w);
        return visited[v] == visited[w];
    }

    public List<Integer>[] component() {

        List<Integer>[] res = new ArrayList[cccount];
        for (int i = 0 ; i < cccount; i++) {
            res[i] = new ArrayList<>();
        }
        for (int i = 0; i < G.V(); i++) {
            res[visited[i]].add(i);
        }
        return res;
    }

    public static void main(String[] args) {
        Graph graph = new Graph("g1.txt");
        GraphCC graphDFS = new GraphCC(graph);

        System.out.println(String.format("联通分量个数(connected component count) %d", graphDFS.getCccount()));

        System.out.println(graphDFS.visited);

        System.out.println(graphDFS.isConnected(1,2));
        System.out.println(graphDFS.isConnected(0,5));

        List<Integer>[] component = graphDFS.component();

        for (List<Integer> one : component) {
           for (int i : one) {
               System.out.print(i + " ");
           }
            System.out.println();
        }


    }
}

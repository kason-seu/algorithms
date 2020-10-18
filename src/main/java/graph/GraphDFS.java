package graph;

import java.util.ArrayList;

public class GraphDFS {

    private Graph G;
    private final boolean[] visited;
    private ArrayList<Integer> pre = new ArrayList<>();
    private ArrayList<Integer> after = new ArrayList<>();

    public GraphDFS(Graph g) {
        this.G = g;
        this.visited = new boolean[G.V()];
        for (int v = 0; v < G.V(); v++) {
            if (!visited[v]) {
                dfs(v);
            }
        }
    }

    private void dfs(int v) {
        visited[v] = true;
        pre.add(v);
        for (int w : G.adj(v)) {
            if (!visited[w]) {
                dfs(w);
            }
        }
        after.add(v);
    }

    public Iterable<Integer> preOrder() {
        return pre;
    }

    public Iterable<Integer> afterOrder() {
        return after;
    }

    public static void main(String[] args) {
        Graph graph = new Graph("g1.txt");
        GraphDFS graphDFS = new GraphDFS(graph);

        graphDFS.preOrder().forEach(System.out::println);
        System.out.println("========");
        graphDFS.afterOrder().forEach(System.out::println);
    }
}

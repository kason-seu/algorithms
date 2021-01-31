package graph.bfs;

import graph.dfs.Graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class GraphBFS {

    private Graph G;
    private final boolean[] visited;
    private LinkedList<Integer> queue;
    private List<Integer> result = new ArrayList<>();

    public GraphBFS(Graph g) {
        this.G = g;
        this.visited = new boolean[G.V()];
        queue = new LinkedList<>();
        for (int v = 0; v < G.V(); v++) {
            if (!visited[v]) {
                bfs(v);
            }
        }
    }

    private void bfs(int v) {
        queue.addLast(v);
        visited[v] = true;
        while (!queue.isEmpty()) {
            // 取出队列的头
            Integer first = queue.removeFirst();
            result.add(first);
            if (first != null) {
                for (int w : G.adj(first)) {
                    if (!visited[w]) {
                        queue.addLast(w);
                        visited[w] = true;
                    }
                }
            }
        }


    }

    public List<Integer> getBfsResult() {
        return result;
    }


    public static void main(String[] args) {
        Graph graph = new Graph("g1.txt");
        GraphBFS graphBFS = new GraphBFS(graph);
        graphBFS.getBfsResult().stream().forEach(res -> {
            System.out.print(res + " ");
        });
        System.out.println();
    }
}

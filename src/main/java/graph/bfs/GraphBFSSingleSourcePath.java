package graph.bfs;

import graph.dfs.Graph;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class GraphBFSSingleSourcePath {

    private Graph G;
    private final boolean[] visited;
    private LinkedList<Integer> queue;
    private int srcId;
    private int[] pre;

    public GraphBFSSingleSourcePath(Graph g, int srcId) {
        this.G = g;
        this.visited = new boolean[G.V()];
        this.srcId = srcId;
        this.pre = new int[G.V()];
        queue = new LinkedList<>();
        bfs(this.srcId);
    }

    private void bfs(int v) {
        queue.addLast(v);
        visited[v] = true;
        pre[v] = v;
        while (!queue.isEmpty()) {
            // 取出队列的头
            Integer first = queue.removeFirst();

            if (first != null) {
                for (int w : G.adj(first)) {
                    if (!visited[w]) {
                        queue.addLast(w);
                        visited[w] = true;
                        pre[w] = first;
                    }
                }
            }
        }
    }

    public boolean isConnectedTo(int targetId) {
        G.validVertex(targetId);
        return visited[targetId];
    }

    public Iterable<Integer> getPath(int targetId) {
        List<Integer> paths = new ArrayList<>();
        if (!isConnectedTo(targetId)) {
            return paths;
        }
        int curr = targetId;
        while (curr != srcId) {
            paths.add(curr);
            curr = pre[curr];
        }
        paths.add(srcId);
        Collections.reverse(paths);
        return paths;
    }

    public static void main(String[] args) {
        Graph graph = new Graph("g5.txt");
        GraphBFSSingleSourcePath graphBFS = new GraphBFSSingleSourcePath(graph, 0);

        System.out.println("0 --> 6 : " + graphBFS.getPath(6));

    }
}

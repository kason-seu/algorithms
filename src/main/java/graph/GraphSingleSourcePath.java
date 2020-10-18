package graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class GraphSingleSourcePath {

    private final Graph G;
    private final int[] visited;
    private int srcId;
    private final int[] pre; // 记录顶点的父亲定点

    public GraphSingleSourcePath(Graph g, int srcId) {
        this.G = g;
        this.visited = new int[G.V()];
        Arrays.fill(visited, -1);

        pre = new int[G.V()];
        Arrays.fill(pre, -1);

        this.srcId = srcId;
        dfs(srcId, srcId);
    }

    private void dfs(int v, int parentId) {
        visited[v] = 1;
        pre[v] = parentId;
        for (int w : G.adj(v)) {
            if (visited[w] == -1) { // 没访问过
                dfs(w,v);
            }
        }
    }

    public boolean isConnectedTo(int w) {
        G.validVertex(w);
        return visited[w] == 1;
    }

    public List<Integer> path(int targetId) {
        List<Integer> res = new ArrayList<>();
        if (!isConnectedTo(targetId)) {
            return res;
        }
        while (targetId != srcId) {
            res.add(targetId);
            targetId = pre[targetId];
        }
        res.add(srcId);
        Collections.reverse(res);
        return res;
    }

    public static void main(String[] args) {
        Graph graph = new Graph("g1.txt");
        GraphSingleSourcePath graphDFS = new GraphSingleSourcePath(graph, 1);

        List<Integer> path = graphDFS.path(4);

        path.stream().forEach(res -> {
            System.out.print(res + " ");
        });
        System.out.println();


        path = graphDFS.path(5);

        path.stream().forEach(res -> {
            System.out.print(res + " ");
        });
        System.out.println();


    }
}

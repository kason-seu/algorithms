package graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class GraphSingleSourcePathRemoveVisited {

    private final Graph G;
    private int srcId;
    private final int[] pre; // 记录顶点的父亲定点

    public GraphSingleSourcePathRemoveVisited(Graph g, int srcId) {
        this.G = g;

        pre = new int[G.V()];
        Arrays.fill(pre, -1);

        this.srcId = srcId;
        dfs(srcId, srcId);
    }

    private void dfs(int v, int parentId) {
        pre[v] = parentId;
        for (int w : G.adj(v)) {
            if (pre[w] == -1) { // 没访问过
                dfs(w,v);
            }
        }
    }

    public boolean isConnectedTo(int w) {
        G.validVertex(w);
        return pre[w] != -1;
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

    public int[] getPre() {
        return pre;
    }

    public static void main(String[] args) {
        Graph graph = new Graph("g1.txt");
        GraphSingleSourcePathRemoveVisited graphDFS = new GraphSingleSourcePathRemoveVisited(graph, 1);

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

        path = graphDFS.path(2);

        path.stream().forEach(res -> {
            System.out.print(res + " ");
        });
        System.out.println();


    }
}

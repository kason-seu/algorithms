package graph.dfs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * 计算从srcId 到 targetId 是否存在路径
 */
public class AnyTwoPointPath {

    private final Graph G;
    private final int[] visited;
    private int srcId;
    private int targetId;
    private final int[] pre; // 记录顶点的父亲定点

    public AnyTwoPointPath(Graph g, int srcId, int targetId) {
        this.G = g;
        this.visited = new int[G.V()];
        Arrays.fill(visited, -1);

        pre = new int[G.V()];
        Arrays.fill(pre, -1);

        this.srcId = srcId;
        this.targetId = targetId;
        dfs(srcId, srcId);
    }

    private boolean dfs(int v, int parentId) {
        visited[v] = 1;
        pre[v] = parentId;
        if (v == targetId) {
            return true;
        }
        for (int w : G.adj(v)) {
            if (visited[w] == -1) { // 没访问过
                if (dfs(w,v) ) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean isConnected() {
        G.validVertex(targetId);
        Arrays.stream(visited).forEach(res -> {
            System.out.print(res + " ");
        });
        System.out.println();
        return visited[targetId] == 1;
    }

    public List<Integer> path() {
        List<Integer> res = new ArrayList<>();
        if (!isConnected()) {
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
        AnyTwoPointPath graphDFS = new AnyTwoPointPath(graph, 1, 4);

        if (graphDFS.isConnected()) {
            System.out.println("联通");
        }
        List<Integer> path = graphDFS.path();

        path.stream().forEach(res -> {
            System.out.print(res + " ");
        });
        System.out.println();


        graphDFS = new AnyTwoPointPath(graph, 1, 5);

        if (graphDFS.isConnected()) {
            System.out.println("联通");
        } else {
            System.out.println("不联通");
        }
        path = graphDFS.path();

        path.stream().forEach(res -> {
            System.out.print(res + " ");
        });
        System.out.println();


    }
}

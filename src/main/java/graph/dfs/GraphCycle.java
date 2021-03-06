package graph.dfs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * 计算从srcId 到 targetId 是否存在路径
 */
public class GraphCycle {

    private final Graph G;
    private final int[] visited;

    private final int[] pre; // 记录顶点的父亲定点

    // 存储环的起终id值
    private int loopid = -1;
    public GraphCycle(Graph g) {
        this.G = g;
        this.visited = new int[G.V()];
        Arrays.fill(visited, -1);

        pre = new int[G.V()];
        Arrays.fill(pre, -1);

        for (int v = 0; v < G.V(); v++) {
            if (visited[v] == -1) {
                int target = dfs(v, -1);
                if (target != -1) {
                    System.out.println("loop start and end " + target);
                    loopid = target;
                    break;
                }
            }
        }
    }

    public int getLoopid () {
        return loopid;
    }
    private int dfs(int v, int parentId) {
        visited[v] = 1;
        pre[v] = parentId;
        for (int w : G.adj(v)) {
            if (visited[w] == -1) { // 没访问过
                int target = dfs(w, v);
                if ( target != -1) {
                    return target;
                }
            } else {
                if (pre[v] != w) {
                    System.out.println("Loop Find");
                    // 形成了闭环，则将环的父亲节点更新
                    pre[w] = v;
                    return w;
                }
            }
        }
        return -1;
    }

    public boolean isConnected() {

        return loopid >=0 && visited[loopid] == 1;
    }

    public List<Integer> path() {
        List<Integer> res = new ArrayList<>();
        int tmp = loopid;
        if (!isConnected()) {
            return res;
        }
        while (true) {
            res.add(tmp);
            tmp = pre[tmp];
            if (tmp == loopid) {
                break;
            }
        }
        res.add(loopid);
        Collections.reverse(res);
        return res;
    }

    public static void main(String[] args) {
        Graph graph = new Graph("g2.txt");
        GraphCycle graphDFS = new GraphCycle(graph);


        if (!graphDFS.isConnected()) {
            System.out.println("无环");
        } else {
            System.out.println("有环");
            graphDFS.path().stream().forEach(res -> {
                System.out.print(res + " ");
            });
            System.out.println();
        }

        graph = new Graph("g1.txt");
        graphDFS = new GraphCycle(graph);


        if (!graphDFS.isConnected()) {
            System.out.println("无环");
        } else {
            System.out.println("有环");
            graphDFS.path().stream().forEach(res -> {
                System.out.print(res + " ");
            });
            System.out.println();
        }


    }
}

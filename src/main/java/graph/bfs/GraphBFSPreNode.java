package graph.bfs;

import graph.Graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class GraphBFSPreNode {

    private Graph G;
    private final boolean[] visited;
    private LinkedList<Integer> queue;
    private List<Integer> result = new ArrayList<>();
    private int[] pre;

    public GraphBFSPreNode(Graph g) {
        this.G = g;
        this.visited = new boolean[G.V()];
        this.pre = new int[G.V()];
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
        pre[v] = v;
        while (!queue.isEmpty()) {
            // 取出队列的头
            Integer first = queue.removeFirst();
            result.add(first);
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

    public List<Integer> getBfsResult() {
        return result;
    }


    public void printNodeAndFather() {
        for (int i : result) {
            System.out.println(String.format("current node is %s, pre = %s", i, pre[i]));
        }
    }
    public static void main(String[] args) {
        Graph graph = new Graph("g1.txt");
        GraphBFSPreNode graphBFS = new GraphBFSPreNode(graph);
        graphBFS.getBfsResult().stream().forEach(res -> {
            System.out.print(res + " ");
        });
        System.out.println();


        graphBFS.printNodeAndFather();
    }
}

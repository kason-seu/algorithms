package graph;

import com.google.common.base.Preconditions;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Graph implements IGraph<Integer> {


    private int V;
    private int E;
    private TreeSet<Integer>[] adj;

    public Graph(String fileName) {
        File file = new File(fileName);

        try {
            Scanner scanner = new Scanner(file);

            V = scanner.nextInt();
            Preconditions.checkArgument(V > 0, "V must be positive");
            E = scanner.nextInt();
            Preconditions.checkArgument(E > 0, "E must be postive");
            adj = new TreeSet[V];
            for (int i = 0; i < V; i++) {
                adj[i] = new TreeSet<>();
            }
            for (int i = 0; i < E; i++) {
                int a = scanner.nextInt();
                validVertex(a);
                int b = scanner.nextInt();
                validVertex(b);
                Preconditions.checkArgument(a != b, "Self edge detected");
                Preconditions.checkArgument(!adj[a].contains(b), "平行边detected");
                adj[a].add(b);
                adj[b].add(a);
            }


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void validVertex(int a) {
        Preconditions.checkArgument(a >= 0 && a < V, "vertex id invalid");
    }

    @Override
    public boolean hasEdge(Integer v, Integer w) {
        validVertex(v);
        validVertex(w);
        return adj[v].contains(w);
    }

    @Override
    public Iterable<Integer> adj(Integer v) {
        validVertex(v);
        return adj[v];
    }

    @Override
    public int degree(Integer v) {
        validVertex(v);
        return adj[v].size();
    }
    public int V() {
        return V;
    }

    public int E() {
        return E;
    }

    @Override
    public Iterable<Integer> preOrder() {
        boolean[] visited = new boolean[V];
        List<Integer> pre = new ArrayList<>();
        for (int v = 0; v < V; v++) {
            if (!visited[v]) {
                preDFS(v, visited, pre);
            }
        }
        return pre;
    }

    private void preDFS(int curV, boolean[] visited, List<Integer> pre) {

        visited[curV] = true;
        pre.add(curV);

        for (int w : adj(curV)) {
            if (!visited[w]) {
                preDFS(w, visited, pre);
            }
        }
    }
    @Override
    public Iterable<Integer> afterOrder() {
        boolean[] visited = new boolean[V];
        List<Integer> after = new ArrayList<>();
        for (int v = 0; v < V; v++) {
            if (!visited[v]) {
                afterDFS(v, visited, after);
            }
        }
        return after;
    }

    @Override
    public Iterable<Integer> preOrderWithLoop() {
        Stack<Integer> stack = new Stack<>();
        List<Integer> preWithLoop = new ArrayList<>();
        boolean[] newVisited = new boolean[V];
        for (int v = 0; v < V; v++) {
            if (!newVisited[v]) {
                newVisited[v] = true;
                preWithLoop.add(v);
                for (int w : adj(v)) {
                    stack.push(w);
                }
                while (!stack.empty()) {
                    int w = stack.pop();
                    if (!newVisited[w]) {
                        newVisited[w] = true;
                        preWithLoop.add(w);
                        for (int ww : adj(w)) {
                            stack.push(ww);
                        }
                    }

                }
            }
        }
        return preWithLoop;
    }

    private void afterDFS(int curV, boolean[] visited, List<Integer> after) {
        visited[curV] = true;
        for (int w : adj(curV)) {
            if (!visited[w]) {
                afterDFS(w, visited, after);
            }
        }
        after.add(curV);
    }

    public static void main(String[] args) {
        Graph adjMatrix = new Graph("g1.txt");
        System.out.println(adjMatrix);
        System.out.println("-===============");
        // 遍历
        adjMatrix.preOrder().forEach(System.out::println);
        System.out.println("-===============");
        adjMatrix.afterOrder().forEach(System.out::println);
        System.out.println("===for loop pre order =====");
        adjMatrix.preOrderWithLoop().forEach(System.out::println);
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(String.format("V = %d, E = %d\n", V, E));
        for (int v = 0 ; v < V; v++) {
            stringBuilder.append(String.format("%d :", v));
            for (int w : adj[v]) {
                stringBuilder.append(String.format("%d ", w));
            }
            stringBuilder.append("\n");
        }
        return stringBuilder.toString();
    }
}

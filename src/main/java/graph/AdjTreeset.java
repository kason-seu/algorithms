package graph;

import com.google.common.base.Preconditions;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.TreeSet;

public class AdjTreeset implements IGraph<Integer> {


    private int V;
    private int E;
    private TreeSet<Integer>[] adj;

    public AdjTreeset(String fileName) {
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

    private void validVertex(int a) {
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
    public static void main(String[] args) {
        AdjTreeset adjMatrix = new AdjTreeset("g.txt");
        System.out.println(adjMatrix);
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

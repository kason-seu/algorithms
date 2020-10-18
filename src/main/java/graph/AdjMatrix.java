package graph;


import com.google.common.base.Preconditions;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AdjMatrix implements IGraph<Integer>{

    private int V;
    private int E;
    private int[][] adj;


   public AdjMatrix(String fileName) {
       File file = new File(fileName);

       try {
           Scanner scanner = new Scanner(file);

               V = scanner.nextInt();
               Preconditions.checkArgument(V > 0, "V must be positive");
               E = scanner.nextInt();
               Preconditions.checkArgument(E > 0, "E must be postive");
               adj = new int[V][V];
               for (int i = 0; i < E; i++) {
                   int a = scanner.nextInt();
                   validVertex(a);
                   int b = scanner.nextInt();
                   validVertex(b);
                   Preconditions.checkArgument(a != b, "Self edge detected");
                   Preconditions.checkArgument(adj[a][b] != 1, "平行边detected");
                   adj[a][b] = 1;
                   adj[b][a] = 1;
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
        return adj[v][w] == 1;
    }

    @Override
    public Iterable<Integer> adj(Integer v) {
        validVertex(v);
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            if (adj[v][i] == 1) {
                res.add(i);
            }
        }
        return res;
    }

    @Override
    public int degree(Integer v) {
        validVertex(v);
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            if (adj[v][i] == 1) {
                res.add(i);
            }
        }
        return res.size();
    }

    public int V() {
       return V;
    }

    public int E() {
       return E;
    }

    public static void main(String[] args) {
        AdjMatrix adjMatrix = new AdjMatrix("g.txt");
        System.out.println(adjMatrix);
    }

   @Override
    public String toString() {
       StringBuilder stringBuilder = new StringBuilder();
       stringBuilder.append(String.format("V = %d, E = %d\n", V, E));
       for (int i = 0 ; i < V; i++) {
           for (int j = 0; j < V; j++) {
               stringBuilder.append(String.format("%d ", adj[i][j]));
           }
           stringBuilder.append("\n");
       }
       return stringBuilder.toString();
   }

}

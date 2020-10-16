package graph;


import com.google.common.base.Preconditions;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class AdjLinkedList {

    private int V;
    private int E;
    private LinkedList<Integer>[] adj;


   public AdjLinkedList(String fileName) {
       File file = new File(fileName);

       try {
           Scanner scanner = new Scanner(file);

               V = scanner.nextInt();
               Preconditions.checkArgument(V > 0, "V must be positive");
               E = scanner.nextInt();
               Preconditions.checkArgument(E > 0, "E must be postive");
               adj = new LinkedList[V];
               for (int i = 0; i < V; i++) {
                   adj[i] = new LinkedList<>();
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

    public int V() {
       return V;
    }

    public int E() {
       return E;
    }

    public boolean hasEdge(int v, int w) {
       validVertex(v);
       validVertex(w);
       return adj[v].contains(w);
    }

    /**
     * 求一个定点的邻接边
     * @param v
     * @return
     */
    public LinkedList<Integer> adj(int v) {
       validVertex(v);
       return adj[v];

    }

    public int degree(int v) {

        return adj(v).size();

    }
    public static void main(String[] args) {
        AdjLinkedList adjMatrix = new AdjLinkedList("g.txt");
        System.out.println(adjMatrix);
    }

   @Override
    public String toString() {
       StringBuilder stringBuilder = new StringBuilder();
       stringBuilder.append(String.format("V = %d, E = %d\n", V, E));
       for (int v = 0 ; v < V; v++) {
           stringBuilder.append(String.format("%d :", v));
           for (int w = 0; w < adj[v].size(); w++) {
               stringBuilder.append(String.format("%d ", adj[v].get(w)));
           }
           stringBuilder.append("\n");
       }
       return stringBuilder.toString();
   }

}

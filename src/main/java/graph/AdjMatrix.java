package graph;


import com.google.common.base.Preconditions;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

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

    @Override
    public Iterable<Integer> preOrder() {
       boolean[] visited = new boolean[V];
       List<Integer> pre = new ArrayList<>();
       for (int i = 0; i < V; i++) {
           if (!visited[i]) {
               preDFS(i, visited, pre);
           }
       }
        return pre;
    }

    private void preDFS(int curV, boolean[] visited, List<Integer> pre) {
       visited[curV] = true;
       pre.add(curV);
       for (int w = 0; w < V; w++) {
           if (adj[curV][w] == 1) {
               if (!visited[w]) {
                   preDFS(w, visited, pre);
               }
           }
       }
    }

    @Override
    public Iterable<Integer> afterOrder() {
        boolean[] visited = new boolean[V];
        List<Integer> after = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                afterDFS(i, visited, after);
            }
        }
        return after;
    }

    private void afterDFS(int curV, boolean[] visited, List<Integer> after) {
        visited[curV] = true;

        for (int w = 0; w < V; w++) {
            if (adj[curV][w] == 1) {
                if (!visited[w]) {
                    afterDFS(w, visited, after);
                }
            }
        }
        after.add(curV);
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
                for (int w = 0; w < V; w++) {
                    if (adj[v][w] == 1) {
                        stack.push(w);
                    }
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

    public static void main(String[] args) {
        AdjMatrix adjMatrix = new AdjMatrix("g1.txt");
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
       for (int i = 0 ; i < V; i++) {
           for (int j = 0; j < V; j++) {
               stringBuilder.append(String.format("%d ", adj[i][j]));
           }
           stringBuilder.append("\n");
       }
       return stringBuilder.toString();
   }

}

public class GraphMatrixDemo {


    // 邻接矩阵
    private int adj[][];

    // 顶点个数
    private int V;

    public GraphMatrixDemo(int V) {

        this.V = V;
        adj = new int[V][V];

    }

    public void addEdge(int i, int j) {
        adj[i][j] = 1;
        adj[j][i] = 1;
    }


    public String toString() {
        StringBuilder s = new StringBuilder();
        for (int i = 0; i < V; i++) {
            s.append(i).append(": ");
            for (int j : adj[i]) {
                s.append(j == 1 ? 1 : 0).append(" ");
            }
            s.append("\n");
        }
        return s.toString();
    }

    public static void main(String[] args) {
        GraphMatrixDemo g = new GraphMatrixDemo(4);

        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 2);
        g.addEdge(2, 0);
        g.addEdge(0, 3);

        System.out.print(g.toString());
    }
}

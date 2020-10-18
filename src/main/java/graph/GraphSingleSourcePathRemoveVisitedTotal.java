package graph;

import java.util.*;

// 任意两点之间的路径
public class GraphSingleSourcePathRemoveVisitedTotal {

    private Map<Integer, GraphSingleSourcePathRemoveVisited> totalPrePath = new HashMap<>();
    private Graph G;
    public GraphSingleSourcePathRemoveVisitedTotal(Graph G) {
        this.G = G;

        for (int v = 0; v < G.V(); v++) {
            GraphSingleSourcePathRemoveVisited graphSingleSourcePathRemoveVisited = new GraphSingleSourcePathRemoveVisited(G, v);
            totalPrePath.put(v, graphSingleSourcePathRemoveVisited);
        }
    }

    public List<Integer> getPath(int srcId, int targetId) {
        if (totalPrePath.containsKey(srcId)) {
            return totalPrePath.get(srcId).path(targetId);
        }
        return new ArrayList<>();
    }

    public static void main(String[] args) {
        Graph graph = new Graph("g1.txt");
        GraphSingleSourcePathRemoveVisitedTotal graphSingleSourcePathRemoveVisitedTotal = new GraphSingleSourcePathRemoveVisitedTotal(graph);

        List<Integer> path = graphSingleSourcePathRemoveVisitedTotal.getPath(2, 4);
        path.stream().forEach(res -> {
            System.out.print(res + " ");
        });
        System.out.println();


        path = graphSingleSourcePathRemoveVisitedTotal.getPath(1, 3);
        path.stream().forEach(res -> {
            System.out.print(res + " ");
        });
        System.out.println();
    }
}

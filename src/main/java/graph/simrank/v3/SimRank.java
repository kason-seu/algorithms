package graph.simrank.v3;

import graph.model.Graph;
import graph.model.GraphEdge;
import graph.model.GraphNode;
import graph.simrank.v2.ScoreTable;
import org.jgrapht.graph.DefaultEdge;

import java.util.ArrayList;
import java.util.Map;
import java.util.Set;

public class SimRank {

    private Graph<String, Map<String,Object>,Map<String,Object>> graph;
    private ArrayList<GraphNode<String,Map<String,Object>>> nomi;
    private ArrayList<String> keys;
    private ScoreTable coeff;
    private ScoreTable score;
    private int size;


    public SimRank() {
        graph = new Graph<>();
        nomi = new ArrayList<>();
        coeff = new ScoreTable();
        score = new ScoreTable();
        size = 0;
    }

    public void initNomi(String s) {
        String[] nodes = new String[2];
        nodes = s.split(",");
        if (!keys.contains(nodes[0])) {
            GraphNode<String, Map<String,Object>> graphNode = new GraphNode<>();
            graphNode.setId(nodes[0]);
            graph.addVertex(graphNode);
            keys.add(nodes[0]);
        }
        if (!nomi.contains(nodes[1])) {
            GraphNode<String, Map<String,Object>> graphNode = new GraphNode<>();
            graphNode.setId(nodes[1]);
            graph.addVertex(graphNode);
            keys.add(nodes[1]);
        }
        size = nomi.size();

        GraphEdge<String, Map<String,Object>> graphEdge = new GraphEdge<>();
        graphEdge.setSrcId(nodes[0]);
        graphEdge.setDstId(nodes[1]);
        graph.addEdge(graphEdge);
    }

    public void initScore(float c) {
        int i, j = 0;
        float coef = 0.0f;
        String key = "";
        Set<GraphEdge<String, Map<String, Object>>> indexA;
        Set<GraphEdge<String, Map<String, Object>>> indexB;
        for (i = 0; i < size; i++) {
            for (j = 0; j < size; j++) {
                key = nomi.get(i) + "," + nomi.get(j);
                score.put(key, assignValue(keys.get(i), keys.get(j)));
                indexA = graph.getInEdges(keys.get(i));
                indexB = graph.getInEdges(keys.get(j));
                coef = c / (indexA.size() * indexB.size());
                coeff.put(key, coef);
            }
        }
    }

    private float assignValue(String a, String b) {
        float toReturn = 0;
        if (a.equals(b)) toReturn = 1;
        return toReturn;
    }
}

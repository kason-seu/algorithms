package graph.model;

import lombok.Getter;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Graph<K,VV,EV> {


    private Set<GraphNode<K,VV>> nodes;

    private Set<GraphEdge<K,EV>> edges;

    private Map<K, Set<GraphEdge<K,EV>>> inEdges;
    private Map<K, Set<GraphEdge<K,EV>>> outEdges;
    @Getter
    private int nodeSize;
    @Getter
    private int edgeSize;

    public Graph() {
        
        this.nodes = new HashSet<>();
        this.edges = new HashSet<>();
        this.inEdges = new HashMap<>();
        this.outEdges = new HashMap<>();
    }

    public void addVertex(GraphNode<K,VV> graphNode) {
        if (nodes.add(graphNode)) {
            nodeSize++;
        }
    }

    public void addEdge(GraphEdge<K,EV> graphEdge) {

        if (edges.add(graphEdge)) {
            edgeSize++;
            updateInOrOutEdges(graphEdge, graphEdge.getSrcId(), outEdges);
            updateInOrOutEdges(graphEdge, graphEdge.getDstId(), inEdges);
        }

    }

    private void updateInOrOutEdges(GraphEdge<K, EV> graphEdge, K nodeId, Map<K, Set<GraphEdge<K, EV>>> outEdges) {
        if (outEdges.containsKey(nodeId)) {
            Set<GraphEdge<K, EV>> graphEdges = outEdges.get(nodeId);
            graphEdges.add(graphEdge);
        } else {
            Set<GraphEdge<K, EV>> graphEdges = new HashSet<>();
            graphEdges.add(graphEdge);
            outEdges.put(nodeId, graphEdges);
        }
    }


    public Set<GraphEdge<K,EV>> getInEdges(K nodeId) {
        return inEdges.get(nodeId);
    }
    public Set<GraphEdge<K,EV>> getOutEdges(K nodeId) {
        return outEdges.get(nodeId);
    }
}

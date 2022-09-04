package entity;

public class Edge<K,EV> {

    private K srcId;
    private K dstId;
    private EV properties;

    public Edge() {
    }

    public Edge(K srcId, K dstId) {
        this.srcId = srcId;
        this.dstId = dstId;
    }
}

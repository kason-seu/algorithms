package graph.model;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Objects;

@Setter
@Getter
public class GraphEdge<K,EV> implements Serializable {


    @JSONField(name = "srcId", alternateNames = {"srcId", "srcid"})
    private K srcId;

    @JSONField(name = "dstId", alternateNames = {"tarId", "dstId", "tarid"})
    private K dstId;

    @JSONField(name = "edgeType", alternateNames = {"edgeType", "type"})
    private String edgeType = "default";

    @JSONField(name = "ts", alternateNames = {"ts", "time"}, defaultValue = "-1")
    private Long ts;

    @JSONField(name = "properties", alternateNames = {"properties"})
    private EV properties;

    public GraphEdge() {
    }

    public GraphEdge(K srcId, K dstId, EV properties) {
        this.srcId = srcId;
        this.dstId = dstId;
        this.properties = properties;
    }

    public GraphEdge(K srcId, K dstId, String edgeType, EV properties) {
        this.srcId = srcId;
        this.dstId = dstId;
        this.edgeType = edgeType;
        this.properties = properties;
    }

    public GraphEdge(K srcId, K dstId, String edgeType, Long ts, EV properties) {
        this.srcId = srcId;
        this.dstId = dstId;
        this.edgeType = edgeType;
        this.ts = ts;
        this.properties = properties;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GraphEdge<?, ?> graphEdge = (GraphEdge<?, ?>) o;
        return Objects.equals(srcId, graphEdge.srcId) && Objects.equals(dstId, graphEdge.dstId) && Objects.equals(edgeType, graphEdge.edgeType) && Objects.equals(ts, graphEdge.ts);
    }

    @Override
    public int hashCode() {
        return Objects.hash(srcId, dstId, edgeType, ts);
    }

    @Override
    public String toString() {
        return "GraphEdge{" +
                "srcId=" + srcId +
                ", dstId=" + dstId +
                ", edgeType='" + edgeType + '\'' +
                ", ts=" + ts +
                ", properties=" + properties +
                '}';
    }
}

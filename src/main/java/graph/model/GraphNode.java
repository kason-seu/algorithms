package graph.model;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Objects;

@Setter
@Getter
public class GraphNode <K,VV> implements Serializable {

    @JSONField(name = "id", alternateNames = {"nodeId", "id"})
    private K id;

    @JSONField(name = "nodeType", alternateNames = {"nodeType", "type"})
    private String nodeType = "default";

    @JSONField(name = "properties", alternateNames = {"properties"})
    private VV properties;


    public GraphNode() {

    }

    public GraphNode(K nodeId, VV properties) {
        this.id = nodeId;
        this.properties = properties;
    }

    public GraphNode(K nodeId, String nodeType, VV properties) {
        this.id = nodeId;
        this.nodeType = nodeType;
        this.properties = properties;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GraphNode<?, ?> graphNode = (GraphNode<?, ?>) o;
        return id.equals(graphNode.id) && nodeType.equals(graphNode.nodeType);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nodeType);
    }

    @Override
    public String toString() {
        return "GraphNode{" +
                "id=" + id +
                ", nodeType='" + nodeType + '\'' +
                ", properties=" + properties +
                '}';
    }
}

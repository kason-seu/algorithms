package entity;

import lombok.Data;

@Data
public class Vertex<K,VV> {
    private K id;
    private VV properties;

    public Vertex(K id) {
        this.id = id;
    }

    public Vertex() {
    }
}

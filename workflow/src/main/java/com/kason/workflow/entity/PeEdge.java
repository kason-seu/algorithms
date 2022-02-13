package com.kason.workflow.entity;

import java.io.Serializable;

public class PeEdge implements Serializable {
    public String id;
    public PeNode from;
    public PeNode to;

    public PeEdge(String id) {
        this.id = id;
    }
}

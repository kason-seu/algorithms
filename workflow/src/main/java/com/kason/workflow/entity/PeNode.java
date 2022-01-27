package com.kason.workflow.entity;

import java.io.Serializable;

public class PeNode implements Serializable {
    private String id;

    public String type;
    public PeEdge in;
    public PeEdge out;

    public PeNode(String id) {
        this.id=id;
    }
}

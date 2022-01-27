package com.kason.workflow.entity;

import java.io.Serializable;

public class PeProcess implements Serializable {
    public String id;
    public PeNode start;

    public PeProcess(String id, PeNode start) {
        this.id = id;
        this.start = start;
    }
}

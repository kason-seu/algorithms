package com.kason.workflow.entity;

import java.io.Serializable;

/**
 * 一个流程(PeProcess)由多个节点(PeNode)与边(PeEdge)组成，节点有出边(out)、入边(in)，边有流入节点(from)、流出节点(to)
 */
public class PeProcess implements Serializable {
    public String id;
    public PeNode start;

    public PeProcess(String id, PeNode start) {
        this.id = id;
        this.start = start;
    }

    /**
     * 更新走向下一个流程
     */
    private void updateProcess() {
        this.id = id;
        this.start = start.out.to;
    }
    public PeNode peNodeWithID(String id) {
        updateProcess();
        return start;
    }
}

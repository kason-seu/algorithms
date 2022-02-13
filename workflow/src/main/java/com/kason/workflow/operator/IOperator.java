package com.kason.workflow.operator;

import com.kason.workflow.data.PeContext;
import com.kason.workflow.engine.ProcessEngine;
import com.kason.workflow.entity.PeNode;

public interface IOperator {
    //引擎可以据此来找到本算子
    String getType();

    //引擎调度本算子
    void doTask(ProcessEngine processEngine, PeNode node, PeContext peContext);
}


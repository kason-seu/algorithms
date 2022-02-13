package com.kason.workflow.operator.approval;

import com.kason.workflow.data.PeContext;
import com.kason.workflow.engine.ProcessEngine;
import com.kason.workflow.entity.PeNode;
import com.kason.workflow.operator.IOperator;

/**
 * 审批
 */
public class OperatorOfApproval implements IOperator {
    @Override
    public String getType() {
        return "approval";
    }

    @Override
    public void doTask(ProcessEngine processEngine, PeNode node, PeContext peContext) {
        peContext.putValue("approver", "经理");
        peContext.putValue("message", "审批通过");

        processEngine.nodeFinished(node.getId());
    }
}

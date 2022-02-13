package com.kason.workflow.operator.approval;

import com.kason.workflow.data.PeContext;
import com.kason.workflow.engine.ProcessEngine;
import com.kason.workflow.entity.PeNode;
import com.kason.workflow.operator.IOperator;

/**
 * 提交申请单
 */
public class OperatorOfApprovalApply implements IOperator {
    @Override
    public String getType() {
        return "approvalApply";
    }

    @Override
    public void doTask(ProcessEngine processEngine, PeNode node, PeContext peContext) {
        peContext.putValue("form", "formInfo");
        peContext.putValue("applicant", "小张");

        processEngine.nodeFinished(node.getId());
    }
}

package com.kason.workflow.operator.approval;

import com.kason.workflow.data.PeContext;
import com.kason.workflow.engine.ProcessEngine;
import com.kason.workflow.entity.PeEdge;
import com.kason.workflow.entity.PeNode;
import com.kason.workflow.operator.IOperator;
import com.kason.workflow.utils.XmlUtil;
import org.openjdk.nashorn.api.scripting.NashornScriptEngineFactory;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

/**
 * 简单是非判断
 */
public class OperatorOfSimpleGateway implements IOperator {
    @Override
    public String getType() {
        return "simpleGateway";
    }

    @Override
    public void doTask(ProcessEngine processEngine, PeNode node, PeContext peContext) {
        ScriptEngineManager scriptEngineManager = new ScriptEngineManager();
        scriptEngineManager.registerEngineName("test",new NashornScriptEngineFactory());
        ScriptEngine engine = scriptEngineManager.getEngineByName("js");

        engine.put("approvalResult", peContext.getValue("approvalResult"));

        String expression = XmlUtil.childTextByName(node.xmlNode, "expr");
        String trueOutGoingEdgeID = XmlUtil.childTextByName(node.xmlNode, "trueOutGoing");

        PeEdge outPeEdge = null;
        try {
            outPeEdge = (Boolean) engine.eval(expression) ?
                    node.outWithID(trueOutGoingEdgeID) : node.outWithOutID(trueOutGoingEdgeID);
        } catch (ScriptException e) {
            e.printStackTrace();
        }

        processEngine.nodeFinished(outPeEdge);
    }
}

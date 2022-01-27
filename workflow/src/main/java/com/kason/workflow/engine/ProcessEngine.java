package com.kason.workflow.engine;

import com.kason.workflow.builder.XmlPeProcessBuilder;
import com.kason.workflow.entity.PeNode;
import com.kason.workflow.entity.PeProcess;

public class ProcessEngine {

    private String xmlStr;

    public ProcessEngine(String xmlStr) {
        this.xmlStr = xmlStr;
    }

    public void run() throws Exception {
        PeProcess peProcess = new XmlPeProcessBuilder(xmlStr).build();

        PeNode node = peProcess.start;
        while (!node.type.equals("endEvent")) {
            if ("printHello".equals(node.type))
                System.out.print("Hello ");
            if ("printProcessEngine".equals(node.type))
                System.out.print("ProcessEngine ");

            node = node.out.to;
        }
    }
}

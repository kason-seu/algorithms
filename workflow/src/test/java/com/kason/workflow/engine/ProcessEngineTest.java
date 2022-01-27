package com.kason.workflow.engine;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ProcessEngineTest {
    public static String xml = "";
    @Before
    public void before() {
        xml = "<definitions>\n" +
                "    <process id=\"process_1\" name=\"hello\">\n" +
                "        <startEvent id=\"startEvent_1\">\n" +
                "            <outgoing>flow_1</outgoing>\n" +
                "        </startEvent>\n" +
                "        <sequenceFlow id=\"flow_1\" sourceRef=\"startEvent_1\" targetRef=\"printHello_1\" />\n" +
                "        <printHello id=\"printHello_1\" name=\"hello\">\n" +
                "            <incoming>flow_1</incoming>\n" +
                "            <outgoing>flow_2</outgoing>\n" +
                "        </printHello>\n" +
                "        <sequenceFlow id=\"flow_2\" sourceRef=\"printHello_1\" targetRef=\"printProcessEngine_1\" />\n" +
                "        <printProcessEngine id=\"printProcessEngine_1\" name=\"processEngine\">\n" +
                "            <incoming>flow_2</incoming>\n" +
                "            <outgoing>flow_3</outgoing>\n" +
                "        </printProcessEngine>\n" +
                "        <sequenceFlow id=\"flow_3\" sourceRef=\"printProcessEngine_1\" targetRef=\"endEvent_1\"/>\n" +
                "        <endEvent id=\"endEvent_1\">\n" +
                "            <incoming>flow_3</incoming>\n" +
                "        </endEvent>\n" +
                "    </process>\n" +
                "</definitions>";
    }
    @Test
    public void run() throws Exception {
        ProcessEngine processEngine = new ProcessEngine(xml);
        processEngine.run();
    }
}
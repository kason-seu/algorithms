package com.kason.workflow.engine;

import com.kason.workflow.operator.approval.OperatorOfApproval;
import com.kason.workflow.operator.approval.OperatorOfApprovalApply;
import com.kason.workflow.operator.approval.OperatorOfNotify;
import org.junit.Before;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.net.URL;

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
    public void testRun() throws Exception {
        //读取文件内容到字符串
        URL url = this.getClass().getClassLoader().getResource("approval.xml");
        BufferedReader reader = new BufferedReader(new FileReader(new File(url.getPath())));
        StringBuilder sb = new StringBuilder();
        String line  = "";
        while ((line = reader.readLine()) != null) {
            sb.append(line);
            sb.append("\n");
        }
        String modelStr = sb.toString();
        System.out.println("========= get the dag task ====" + modelStr);
        ProcessEngine processEngine = new ProcessEngine(modelStr);

        processEngine.registNodeProcessor(new OperatorOfApproval());
        processEngine.registNodeProcessor(new OperatorOfApprovalApply());
        processEngine.registNodeProcessor(new OperatorOfNotify());

        processEngine.start();

        Thread.sleep(1000 * 1000);

    }
}
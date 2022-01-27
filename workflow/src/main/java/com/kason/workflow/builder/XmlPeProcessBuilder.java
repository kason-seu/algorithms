package com.kason.workflow.builder;

import com.kason.workflow.entity.PeEdge;
import com.kason.workflow.entity.PeNode;
import com.kason.workflow.entity.PeProcess;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import java.util.HashMap;
import java.util.Map;

public class XmlPeProcessBuilder {
    private String xmlStr;
    private final Map<String, PeNode> id2PeNode = new HashMap<>();
    private final Map<String, PeEdge> id2PeEdge = new HashMap<>();

    public XmlPeProcessBuilder(String xmlStr) {
        this.xmlStr = xmlStr;
    }

    public PeProcess build() throws Exception {
        //strToNode : 把一段xml转换为org.w3c.dom.Node

        Node definations = XmlUtil.strToNode(xmlStr);
        //childByName : 找到definations子节点中nodeName为process的那个Node
        Node process = XmlUtil.childByName(definations, "process");
        NodeList childNodes = process.getChildNodes();

        for (int j = 0; j < childNodes.getLength(); j++) {
            Node node = childNodes.item(j);
            //#text node should be skip
            if (node.getNodeType() == Node.TEXT_NODE) continue;

            if ("sequenceFlow".equals(node.getNodeName()))
                buildPeEdge(node);
            else
                buildPeNode(node);
        }
        Map.Entry<String, PeNode> startEventEntry = id2PeNode.entrySet().stream().filter(entry -> "startEvent".equals(entry.getValue().type)).findFirst().get();
        return new PeProcess(startEventEntry.getKey(), startEventEntry.getValue());
    }

    private void buildPeEdge(Node node) {
        //attributeValue : 找到node节点上属性为id的值
        PeEdge peEdge = id2PeEdge.computeIfAbsent(XmlUtil.attributeValue(node, "id"), id -> new PeEdge(id));
        peEdge.from = id2PeNode.computeIfAbsent(XmlUtil.attributeValue(node, "sourceRef"), id -> new PeNode(id));
        peEdge.to = id2PeNode.computeIfAbsent(XmlUtil.attributeValue(node, "targetRef"), id -> new PeNode(id));
    }

    private void buildPeNode(Node node) {
        PeNode peNode = id2PeNode.computeIfAbsent(XmlUtil.attributeValue(node, "id"), id -> new PeNode(id));
        peNode.type = node.getNodeName();

        Node inPeEdgeNode = XmlUtil.childByName(node, "incoming");
        if (inPeEdgeNode != null)
            //text : 得到inPeEdgeNode的nodeValue
            peNode.in = id2PeEdge.computeIfAbsent(XmlUtil.text(inPeEdgeNode), id -> new PeEdge(id));

        Node outPeEdgeNode = XmlUtil.childByName(node, "outgoing");
        if (outPeEdgeNode != null)
            peNode.out = id2PeEdge.computeIfAbsent(XmlUtil.text(outPeEdgeNode), id -> new PeEdge(id));
    }
}
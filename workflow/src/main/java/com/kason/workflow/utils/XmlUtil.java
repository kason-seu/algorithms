package com.kason.workflow.utils;

import com.google.common.collect.Lists;
import lombok.extern.slf4j.Slf4j;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import java.util.List;

@Slf4j
public class XmlUtil {


    /**
     *
     * @param xml xml 文件字符串
     * @return xml节点
     */
    public static Node strToNode(String xml) {

        return XmlReader.getDocParent(xml);
    }

    public static List<Node> childsByName(Node node, String childName) {

        List<Node> nodes = Lists.newArrayList();
        NodeList childNodes = node.getChildNodes();
        for (int i = 0; i < childNodes.getLength(); i++) {
            if (childNodes.item(i).getNodeType() == Node.TEXT_NODE) continue;
            if (childNodes.item(i).getNodeName().equals(childName)) {
                nodes.add(childNodes.item(i));
            }
        }
        return nodes;
    }
    public static Node childByName(Node node, String childName) {

        NodeList childNodes = node.getChildNodes();
        for (int i = 0; i < childNodes.getLength(); i++) {
            if (childNodes.item(i).getNodeType() == Node.TEXT_NODE) continue;
            if (childNodes.item(i).getNodeName().equals(childName)) {
                return childNodes.item(i);
            }
        }
        return null;
    }

    public static String attributeValue(Node node, String propName) {

        NamedNodeMap attrs = node.getAttributes();

        for (int i = 0; i < attrs.getLength(); i++) {
            Node attr = attrs.item(i);
            if (attr.getNodeName().equals(propName)) {
                return attr.getNodeValue();
            }
        }
        return null;
    }


    /**
     * text : 得到inPeEdgeNode的nodeValue
     * @param node inPeEdgeNode
     * @return 得到inPeEdgeNode的nodeValue
     */
    public static String text(Node node) {
        return node.getTextContent();
    }

    public static String childTextByName(Node xmlNode, String expr) {

        NodeList childNodes = xmlNode.getChildNodes();
        for (int i = 0; i < childNodes.getLength(); i++) {
            if (childNodes.item(i).getNodeType() == Node.TEXT_NODE) continue;
            if (childNodes.item(i).getNodeName().equals(expr)) {
                return text(childNodes.item(i));
            }
        }
        return null;

    }
}

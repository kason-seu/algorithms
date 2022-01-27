package com.kason.workflow.utils;

import lombok.extern.slf4j.Slf4j;
import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

@Slf4j
public class XmlReader {

    public static DocumentBuilder db;

    static {
        try {
            //创建一个DocumentBuilderFactory的对象
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            //创建DocumentBuilder对象
            db = dbf.newDocumentBuilder();
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        }
    }

    public static Node getDocParent(String uri) {
        try {
            Document doc = db.parse(uri);
            NodeList childNodes = doc.getChildNodes();
            return childNodes.item(0);
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }


}

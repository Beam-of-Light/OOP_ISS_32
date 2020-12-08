package parsers;

import org.w3c.dom.NodeList;
import targetClasses.*;
import com.sun.org.slf4j.internal.Logger;
import com.sun.org.slf4j.internal.LoggerFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

public class ParserDOM implements Parser {
    private static final Logger log = LoggerFactory.getLogger(ParserDOM.class);

    private void parseElementsRecursive(Node element, Orangery orangery) {
        for (int i = 0; i < element.getAttributes().getLength(); ++i) {
            Node attribute = element.getAttributes().item(i);
            OrangeryHandler.setField(orangery, attribute.getNodeName(), attribute.getNodeValue());
        }
        OrangeryHandler.setField(orangery, element.getNodeName(), element.getTextContent());

        NodeList children = element.getChildNodes();
        for (int i = 0; i < children.getLength(); ++i) {
            Node child = children.item(i);
            if (child.getNodeType() == Node.ELEMENT_NODE)
                parseElementsRecursive(child, orangery);
        }
    }

    @Override
    public Orangery parse(String xmlFilePath) {
        try {
            DocumentBuilder documentBuilder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
            Document document = documentBuilder.parse(xmlFilePath);
            Node root = document.getDocumentElement();
            root.normalize();

            Orangery orangery = new Orangery();
            parseElementsRecursive(root, orangery);
            return orangery;
        } catch (IOException | SAXException | ParserConfigurationException ex) {
            log.error(ex.getMessage());
        }
        return null;
    }
}
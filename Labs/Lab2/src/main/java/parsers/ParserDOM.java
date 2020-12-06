package parsers;

import org.w3c.dom.Element;
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
    private Orangery orangery;
    private Flower currentFlower;

    @Override
    public Orangery parse(String xmlFilePath) {
        try {
            DocumentBuilder documentBuilder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
            Document document = documentBuilder.parse(xmlFilePath);
            Node root = document.getDocumentElement();
            root.normalize();

            orangery = new Orangery();
            NodeList nodeListFlowers = document.getElementsByTagName(OrangeryHandler.FLOWER);
            for (int i = 0; i < nodeListFlowers.getLength(); ++i) {
                currentFlower = OrangeryHandler.createFlower();

                Node nodeFlower = nodeListFlowers.item(i);
                if (nodeFlower.getNodeType() == Node.ELEMENT_NODE) {
                    Element element = (Element) nodeFlower;
                    OrangeryHandler.setField(currentFlower, OrangeryHandler.ID,
                            element.getAttributes().item(0).getNodeValue());
                    setField(currentFlower, element, OrangeryHandler.NAME);
                    setField(currentFlower, element, OrangeryHandler.SOIL);
                    setField(currentFlower, element, OrangeryHandler.ORIGIN);
                    setField(currentFlower, element, OrangeryHandler.MULTIPLYiNG);

                    Element childElement = (Element) element.getElementsByTagName(OrangeryHandler.VISUAL_PARAMETERS).item(0);
                    setField(currentFlower, childElement, OrangeryHandler.STALK_COLOR);
                    setField(currentFlower, childElement, OrangeryHandler.LEAVES_COLOR);
                    setField(currentFlower, childElement, OrangeryHandler.AVERAGE_SIZE);

                    childElement = (Element) element.getElementsByTagName(OrangeryHandler.GROWING_TIPS).item(0);
                    setField(currentFlower, childElement, OrangeryHandler.TEMPERATURE);
                    setField(currentFlower, childElement, OrangeryHandler.LIGHT_LOVING);
                    setField(currentFlower, childElement, OrangeryHandler.WATERING);
                }
                orangery.getFlower().add(currentFlower);
            }
            return orangery;
        } catch (IOException | SAXException | ParserConfigurationException ex) {
            log.error(ex.getMessage());
        }
        return null;
    }

    private static void setField(Flower flower, Element element, String name) {
        OrangeryHandler.setField(flower, name, element.getElementsByTagName(name).item(0).getTextContent());
    }
}
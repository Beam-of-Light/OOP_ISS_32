package parsers;

import com.sun.org.slf4j.internal.Logger;
import com.sun.org.slf4j.internal.LoggerFactory;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import targetClasses.*;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.IOException;
import java.math.BigInteger;

public class ParserSAXHandler extends DefaultHandler {
    private static final Logger log = LoggerFactory.getLogger(ParserSAXHandler.class);
    private Orangery orangery;
    private Flower currentFlower;
    private String tagContent;

    public static void main(String[] args) {
        Orangery resultOrangery = parse("src/main/resources/orangery.xml");
        for (Flower flower : resultOrangery.getFlower()) {
            flower.print();
            System.out.println();
        }
    }

    public static Orangery parse(String xmlFilePath) {
        try {
            SAXParserFactory factory = SAXParserFactory.newInstance();
            SAXParser saxParser = factory.newSAXParser();
            ParserSAXHandler parserSAXHandler = new ParserSAXHandler();
            saxParser.parse(xmlFilePath, parserSAXHandler);
            return parserSAXHandler.getOrangery();
        } catch (SAXException | ParserConfigurationException | IOException ex) {
            log.error(ex.getMessage());
        }
        return null;
    }

    public Orangery getOrangery() {
        return orangery;
    }

    @Override
    public void startDocument() {
        orangery = new Orangery();
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        switch (qName) {
            case "tar:flower":
                currentFlower = new Flower();
                currentFlower.setId(attributes.getValue(0));
                orangery.getFlower().add(currentFlower);    // Adding new flower to list
                break;
            case "tar:visualParameters":
                currentFlower.setVisualParameters(new VisualParameters());
                break;
            case "tar:growingTips":
                currentFlower.setGrowingTips(new GrowingTips());
                break;
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        tagContent = new String(ch, start, length);
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        switch (qName) {
            case "tar:name":
                currentFlower.setName(tagContent);
                break;
            case "tar:soil":
                currentFlower.setSoil(Soil.valueOf(tagContent));
                break;
            case "tar:origin":
                currentFlower.setOrigin(Country.valueOf(tagContent));
                break;
            case "tar:multiplying":
                currentFlower.setMultiplying(Multiplying.valueOf(tagContent));
                break;
            case "tar:temperature":
                currentFlower.getGrowingTips().setTemperature(BigInteger.valueOf(Long.parseLong(tagContent)));
                break;
            case "tar:lightLoving":
                currentFlower.getGrowingTips().setLightLoving(Boolean.parseBoolean(tagContent));
                break;
            case "tar:watering":
                currentFlower.getGrowingTips().setWatering(Integer.parseInt(tagContent));
                break;
            case "tar:stalkColor":
                currentFlower.getVisualParameters().setStalkColor(StalkColor.valueOf(tagContent));
                break;
            case "tar:leavesColor":
                currentFlower.getVisualParameters().setLeavesColor(LeavesColor.valueOf(tagContent));
                break;
            case "tar:averageSize":
                currentFlower.getVisualParameters().setAverageSize(Integer.parseInt(tagContent));
                break;
        }
    }
}

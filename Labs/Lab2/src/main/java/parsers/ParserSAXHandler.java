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

public class ParserSAXHandler extends DefaultHandler implements Parser {
    private static final Logger log = LoggerFactory.getLogger(ParserSAXHandler.class);
    private Orangery orangery;
    private String tagContent;


    @Override
    public Orangery parse(String xmlFilePath) {
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
        for (int i = 0; i < attributes.getLength(); ++i) {
            OrangeryHandler.setField(orangery, attributes.getLocalName(i), attributes.getValue(i));
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        tagContent = new String(ch, start, length);
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        OrangeryHandler.setField(orangery, qName, tagContent);
    }
}

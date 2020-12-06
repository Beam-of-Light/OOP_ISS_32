package parsers;

import com.sun.org.slf4j.internal.Logger;
import com.sun.org.slf4j.internal.LoggerFactory;
import targetClasses.Flower;
import targetClasses.Orangery;

import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.events.Attribute;
import javax.xml.stream.events.EndElement;
import javax.xml.stream.events.StartElement;
import javax.xml.stream.events.XMLEvent;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class ParserStAX implements Parser {
    private static final Logger log = LoggerFactory.getLogger(ParserDOM.class);

    @Override
    public Orangery parse(String xmlFilePath) {
        Orangery orangery = new Orangery();
        try {
            XMLEventReader reader = XMLInputFactory.newInstance().createXMLEventReader(new FileInputStream(xmlFilePath));

            Flower currentFlower = null;
            while (reader.hasNext()) {
                XMLEvent currEvent = reader.nextEvent();
                if (currEvent.isStartElement()) {
                    StartElement startElement = currEvent.asStartElement();
                    if ((OrangeryHandler.PREFIX + startElement.getName().getLocalPart()).equals(OrangeryHandler.FLOWER)) {
                        currentFlower = OrangeryHandler.createFlower();
                        String attribute = ((Attribute) startElement.getAttributes().next()).getValue();
                        OrangeryHandler.setField(currentFlower, OrangeryHandler.ID, attribute);
                    }

                    XMLEvent nextEvent = reader.peek();
                    if (nextEvent.isCharacters()) {
                        setField(currentFlower, startElement, nextEvent);
                    }
                }
                if (currEvent.isEndElement()) {
                    EndElement endElement = currEvent.asEndElement();
                    if ((OrangeryHandler.PREFIX + endElement.getName().getLocalPart()).equals(OrangeryHandler.FLOWER)) {
                        orangery.getFlower().add(currentFlower);
                    }
                }
            }
        } catch (FileNotFoundException | XMLStreamException ex) {
            log.error(ex.getMessage());
        }
        return orangery;
    }

    private void setField(Flower currentFlower, StartElement startElement, XMLEvent event) {
        if (event.isCharacters()) {
            String field = OrangeryHandler.PREFIX + startElement.getName().getLocalPart();
            OrangeryHandler.setField(currentFlower, field, event.asCharacters().getData());
        }
    }
}

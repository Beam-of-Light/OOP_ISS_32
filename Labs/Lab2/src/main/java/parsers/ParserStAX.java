package parsers;

import com.sun.org.slf4j.internal.Logger;
import com.sun.org.slf4j.internal.LoggerFactory;
import targetClasses.Orangery;

import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.events.Attribute;
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

            while (reader.hasNext()) {
                XMLEvent currEvent = reader.nextEvent();
                if (currEvent.isStartElement()) {
                    StartElement startElement = currEvent.asStartElement();
                    if (startElement.getAttributes().hasNext()) {
                        Attribute attribute = (Attribute) startElement.getAttributes().next();
                        OrangeryHandler.setField(orangery, attribute.getName().getLocalPart(), attribute.getValue());
                    }

                    XMLEvent nextEvent = reader.peek();
                    if (nextEvent.isCharacters()) {
                        setField(orangery, startElement, nextEvent);
                    }
                }
            }
        } catch (FileNotFoundException | XMLStreamException ex) {
            log.error(ex.getMessage());
        }
        return orangery;
    }

    private void setField(Orangery orangery, StartElement startElement, XMLEvent event) {
        String field = startElement.getName().getLocalPart();
        OrangeryHandler.setField(orangery, field, event.asCharacters().getData());
    }
}

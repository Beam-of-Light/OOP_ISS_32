package parsers;

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

    @Override
    public Orangery parse(String xmlFilePath) {
        try {
            DocumentBuilder documentBuilder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
            Document document = documentBuilder.parse("BookCatalog.xml");
            Node root = document.getDocumentElement();

        } catch (IOException | SAXException | ParserConfigurationException ex) {
            log.error(ex.getMessage());
        }
        return null;
    }
}

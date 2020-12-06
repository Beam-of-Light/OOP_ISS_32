package validator;

import com.sun.org.slf4j.internal.Logger;
import com.sun.org.slf4j.internal.LoggerFactory;
import org.xml.sax.SAXException;
import parsers.OrangeryHandler;

import javax.xml.XMLConstants;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;
import java.io.File;
import java.io.IOException;

public class ValidatorXML {
    private static final Logger log = LoggerFactory.getLogger(ValidatorXML.class);
    private final SchemaFactory schemaFactory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);


    public static void main(String[] args) {
        System.out.println(new ValidatorXML().isValid(OrangeryHandler.XML_FILE_PATH, OrangeryHandler.XSD_FILE_PATH));
    }

    public boolean isValid(String xmlFilename, String xsdFilename) {
        Schema schema = null;
        try {
            schema = schemaFactory.newSchema(new File(xsdFilename));
        } catch (SAXException ex) {
            log.error(ex.getMessage());
            return false;
        }

        Validator validator = schema.newValidator();
        try {
            validator.validate(new StreamSource(xmlFilename));
        } catch (SAXException | IOException ex) {
            log.error(ex.getMessage());
            return false;
        }
        return true;
    }
}

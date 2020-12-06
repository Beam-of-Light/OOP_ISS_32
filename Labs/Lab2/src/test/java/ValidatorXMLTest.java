import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import validator.ValidatorXML;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ValidatorXMLTest {
    public static final String NOT_VALID_XML_FILE_PATH = "src/main/resources/notValidOrangery.xml";
    public static final String XML_FILE_PATH = "src/main/resources/orangery.xml";
    public static final String XSD_FILE_PATH = "src/main/resources/orangery.xsd";
    private ValidatorXML xmlValidator = new ValidatorXML();

    @Test
    @DisplayName("Check for valid xml file")
    void validXMLFileCheck() {
        assertTrue(xmlValidator.isValid(XML_FILE_PATH, XSD_FILE_PATH));
    }

    @Test
    @DisplayName("Check for not valid xml file")
    void notValidXMLFileCheck() {
        assertFalse(xmlValidator.isValid(NOT_VALID_XML_FILE_PATH, XSD_FILE_PATH));
    }
}
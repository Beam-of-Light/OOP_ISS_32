
package targetClasses;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for Country.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="Country">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="UKRAINE"/>
 *     &lt;enumeration value="JAPAN"/>
 *     &lt;enumeration value="NETHERLANDS"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "Country", namespace = "targetClasses")
@XmlEnum
public enum Country {

    UKRAINE,
    JAPAN,
    NETHERLANDS;

    public String value() {
        return name();
    }

    public static Country fromValue(String v) {
        return valueOf(v);
    }

}

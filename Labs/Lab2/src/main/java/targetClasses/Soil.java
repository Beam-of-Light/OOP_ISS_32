
package targetClasses;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for Soil.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="Soil">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="PODZOLIC"/>
 *     &lt;enumeration value="SOIL"/>
 *     &lt;enumeration value="SODPODZOLIC"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "Soil", namespace = "targetClasses")
@XmlEnum
public enum Soil {

    PODZOLIC,
    SOIL,
    SODPODZOLIC;

    public String value() {
        return name();
    }

    public static Soil fromValue(String v) {
        return valueOf(v);
    }

}

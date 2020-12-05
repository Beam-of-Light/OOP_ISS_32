
package targetClasses;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for StalkColor.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="StalkColor">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="GREEN"/>
 *     &lt;enumeration value="YELLOW"/>
 *     &lt;enumeration value="BROWN"/>
 *     &lt;enumeration value="PURPLE"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "StalkColor", namespace = "targetClasses")
@XmlEnum
public enum StalkColor {

    GREEN,
    YELLOW,
    BROWN,
    PURPLE;

    public String value() {
        return name();
    }

    public static StalkColor fromValue(String v) {
        return valueOf(v);
    }

}

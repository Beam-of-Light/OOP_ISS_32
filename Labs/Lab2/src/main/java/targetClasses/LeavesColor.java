
package targetClasses;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for LeavesColor.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="LeavesColor">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="GREEN"/>
 *     &lt;enumeration value="YELLOW"/>
 *     &lt;enumeration value="ORANGE"/>
 *     &lt;enumeration value="RED"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "LeavesColor")
@XmlEnum
public enum LeavesColor {

    GREEN,
    YELLOW,
    ORANGE,
    RED;

    public String value() {
        return name();
    }

    public static LeavesColor fromValue(String v) {
        return valueOf(v);
    }

}


package targetClasses;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import java.util.Objects;


/**
 * <p>Java class for VisualParameters complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="VisualParameters">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="stalkColor" type="{targetClasses}StalkColor"/>
 *         &lt;element name="leavesColor" type="{targetClasses}LeavesColor"/>
 *         &lt;element name="averageSize" type="{targetClasses}FlowerSize"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "VisualParameters", namespace = "targetClasses", propOrder = {
    "stalkColor",
    "leavesColor",
    "averageSize"
})
public class VisualParameters {

    @XmlElement(namespace = "targetClasses", required = true)
    @XmlSchemaType(name = "string")
    protected StalkColor stalkColor;
    @XmlElement(namespace = "targetClasses", required = true)
    @XmlSchemaType(name = "string")
    protected LeavesColor leavesColor;
    @XmlElement(namespace = "targetClasses")
    @XmlSchemaType(name = "integer")
    protected int averageSize;

    /**
     * Gets the value of the stalkColor property.
     * 
     * @return
     *     possible object is
     *     {@link StalkColor }
     *     
     */
    public StalkColor getStalkColor() {
        return stalkColor;
    }

    /**
     * Sets the value of the stalkColor property.
     * 
     * @param value
     *     allowed object is
     *     {@link StalkColor }
     *     
     */
    public void setStalkColor(StalkColor value) {
        this.stalkColor = value;
    }

    /**
     * Gets the value of the leavesColor property.
     * 
     * @return
     *     possible object is
     *     {@link LeavesColor }
     *     
     */
    public LeavesColor getLeavesColor() {
        return leavesColor;
    }

    /**
     * Sets the value of the leavesColor property.
     * 
     * @param value
     *     allowed object is
     *     {@link LeavesColor }
     *     
     */
    public void setLeavesColor(LeavesColor value) {
        this.leavesColor = value;
    }

    /**
     * Gets the value of the averageSize property.
     * 
     */
    public int getAverageSize() {
        return averageSize;
    }

    /**
     * Sets the value of the averageSize property.
     * 
     */
    public void setAverageSize(int value) {
        this.averageSize = value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof VisualParameters)) return false;
        VisualParameters that = (VisualParameters) o;
        return getAverageSize() == that.getAverageSize()
                && getStalkColor() == that.getStalkColor()
                && getLeavesColor() == that.getLeavesColor();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getStalkColor(), getLeavesColor(), getAverageSize());
    }
}

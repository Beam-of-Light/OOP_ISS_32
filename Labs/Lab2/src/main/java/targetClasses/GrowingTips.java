
package targetClasses;

import java.math.BigInteger;
import java.util.Objects;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for GrowingTips complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="GrowingTips">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="temperature" type="{http://www.w3.org/2001/XMLSchema}integer"/>
 *         &lt;element name="lightLoving" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="watering" type="{targetClasses}WateringAmount"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "GrowingTips", namespace = "targetClasses", propOrder = {
    "temperature",
    "lightLoving",
    "watering"
})
public class GrowingTips {

    @XmlElement(namespace = "targetClasses", required = true)
    protected BigInteger temperature;
    @XmlElement(namespace = "targetClasses")
    protected boolean lightLoving;
    @XmlElement(namespace = "targetClasses")
    @XmlSchemaType(name = "integer")
    protected int watering;

    /**
     * Gets the value of the temperature property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getTemperature() {
        return temperature;
    }

    /**
     * Sets the value of the temperature property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setTemperature(BigInteger value) {
        this.temperature = value;
    }

    /**
     * Gets the value of the lightLoving property.
     * 
     */
    public boolean isLightLoving() {
        return lightLoving;
    }

    /**
     * Sets the value of the lightLoving property.
     * 
     */
    public void setLightLoving(boolean value) {
        this.lightLoving = value;
    }

    /**
     * Gets the value of the watering property.
     * 
     */
    public int getWatering() {
        return watering;
    }

    /**
     * Sets the value of the watering property.
     * 
     */
    public void setWatering(int value) {
        this.watering = value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof GrowingTips)) return false;
        GrowingTips that = (GrowingTips) o;
        return isLightLoving() == that.isLightLoving() &&
                getWatering() == that.getWatering() &&
                Objects.equals(getTemperature(), that.getTemperature());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getTemperature(), isLightLoving(), getWatering());
    }
}

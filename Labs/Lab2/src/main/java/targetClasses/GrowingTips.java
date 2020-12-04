
package targetClasses;

import java.math.BigInteger;
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
 *         &lt;element name="lightloving" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
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
@XmlType(name = "GrowingTips", propOrder = {
    "temperature",
    "lightloving",
    "watering"
})
public class GrowingTips {

    @XmlElement(required = true)
    protected BigInteger temperature;
    protected boolean lightloving;
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
     * Gets the value of the lightloving property.
     * 
     */
    public boolean isLightloving() {
        return lightloving;
    }

    /**
     * Sets the value of the lightloving property.
     * 
     */
    public void setLightloving(boolean value) {
        this.lightloving = value;
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

}

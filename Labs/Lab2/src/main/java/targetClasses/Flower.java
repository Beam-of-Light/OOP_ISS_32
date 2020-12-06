
package targetClasses;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlID;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.CollapsedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;


/**
 * <p>Java class for Flower complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="Flower">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="name" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="soil" type="{targetClasses}Soil"/>
 *         &lt;element name="origin" type="{targetClasses}Country"/>
 *         &lt;element name="visualParameters" type="{targetClasses}VisualParameters"/>
 *         &lt;element name="growingTips" type="{targetClasses}GrowingTips"/>
 *         &lt;element name="multiplying" type="{targetClasses}Multiplying"/>
 *       &lt;/sequence>
 *       &lt;attribute name="id" type="{http://www.w3.org/2001/XMLSchema}ID" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Flower", namespace = "targetClasses", propOrder = {
    "name",
    "soil",
    "origin",
    "visualParameters",
    "growingTips",
    "multiplying"
})
public class Flower {

    @XmlElement(namespace = "targetClasses", required = true)
    protected String name;
    @XmlElement(namespace = "targetClasses", required = true)
    @XmlSchemaType(name = "string")
    protected Soil soil;
    @XmlElement(namespace = "targetClasses", required = true)
    @XmlSchemaType(name = "string")
    protected Country origin;
    @XmlElement(namespace = "targetClasses", required = true)
    protected VisualParameters visualParameters;
    @XmlElement(namespace = "targetClasses", required = true)
    protected GrowingTips growingTips;
    @XmlElement(namespace = "targetClasses", required = true)
    @XmlSchemaType(name = "string")
    protected Multiplying multiplying;
    @XmlAttribute(name = "id")
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlID
    @XmlSchemaType(name = "ID")
    protected String id;

    /**
     * Gets the value of the name property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the value of the name property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setName(String value) {
        this.name = value;
    }

    /**
     * Gets the value of the soil property.
     * 
     * @return
     *     possible object is
     *     {@link Soil }
     *     
     */
    public Soil getSoil() {
        return soil;
    }

    /**
     * Sets the value of the soil property.
     * 
     * @param value
     *     allowed object is
     *     {@link Soil }
     *     
     */
    public void setSoil(Soil value) {
        this.soil = value;
    }

    /**
     * Gets the value of the origin property.
     * 
     * @return
     *     possible object is
     *     {@link Country }
     *     
     */
    public Country getOrigin() {
        return origin;
    }

    /**
     * Sets the value of the origin property.
     * 
     * @param value
     *     allowed object is
     *     {@link Country }
     *     
     */
    public void setOrigin(Country value) {
        this.origin = value;
    }

    /**
     * Gets the value of the visualParameters property.
     * 
     * @return
     *     possible object is
     *     {@link VisualParameters }
     *     
     */
    public VisualParameters getVisualParameters() {
        return visualParameters;
    }

    /**
     * Sets the value of the visualParameters property.
     * 
     * @param value
     *     allowed object is
     *     {@link VisualParameters }
     *     
     */
    public void setVisualParameters(VisualParameters value) {
        this.visualParameters = value;
    }

    /**
     * Gets the value of the growingTips property.
     * 
     * @return
     *     possible object is
     *     {@link GrowingTips }
     *     
     */
    public GrowingTips getGrowingTips() {
        return growingTips;
    }

    /**
     * Sets the value of the growingTips property.
     * 
     * @param value
     *     allowed object is
     *     {@link GrowingTips }
     *     
     */
    public void setGrowingTips(GrowingTips value) {
        this.growingTips = value;
    }

    /**
     * Gets the value of the multiplying property.
     * 
     * @return
     *     possible object is
     *     {@link Multiplying }
     *     
     */
    public Multiplying getMultiplying() {
        return multiplying;
    }

    /**
     * Sets the value of the multiplying property.
     * 
     * @param value
     *     allowed object is
     *     {@link Multiplying }
     *     
     */
    public void setMultiplying(Multiplying value) {
        this.multiplying = value;
    }

    /**
     * Gets the value of the id property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getId() {
        return id;
    }

    /**
     * Sets the value of the id property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setId(String value) {
        this.id = value;
    }

}

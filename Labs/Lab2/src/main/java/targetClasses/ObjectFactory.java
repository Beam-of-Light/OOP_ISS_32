
package targetClasses;

import javax.xml.bind.annotation.XmlRegistry;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the targetClasses package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {


    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: targetClasses
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link Orangery }
     * 
     */
    public Orangery createOrangery() {
        return new Orangery();
    }

    /**
     * Create an instance of {@link Flower }
     * 
     */
    public Flower createFlower() {
        return new Flower();
    }

    /**
     * Create an instance of {@link GrowingTips }
     * 
     */
    public GrowingTips createGrowingTips() {
        return new GrowingTips();
    }

    /**
     * Create an instance of {@link VisualParameters }
     * 
     */
    public VisualParameters createVisualParameters() {
        return new VisualParameters();
    }

}

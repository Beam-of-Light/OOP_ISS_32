import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import parsers.*;
import targetClasses.*;

import java.math.BigInteger;

import static org.junit.jupiter.api.Assertions.assertTrue;


public class ParserTest {
    public static final String XML_FILE_PATH = "src/main/resources/orangery.xml";
    static Orangery orangery;

    @BeforeAll
    static void init() {
        orangery = new Orangery();

        Flower flower = OrangeryHandler.createFlower();
        flower.setName("Tulip");
        flower.setId("ID-1");
        flower.setSoil(Soil.valueOf("SODPODZOLIC"));
        flower.setOrigin(Country.valueOf("NETHERLANDS"));
        flower.setMultiplying(Multiplying.valueOf("SEEDS"));
        flower.getGrowingTips().setTemperature(BigInteger.valueOf(Long.parseLong("18")));
        flower.getGrowingTips().setLightLoving(false);
        flower.getGrowingTips().setWatering(Integer.parseInt("80"));
        flower.getVisualParameters().setStalkColor(StalkColor.valueOf("GREEN"));
        flower.getVisualParameters().setLeavesColor(LeavesColor.valueOf("GREEN"));
        flower.getVisualParameters().setAverageSize(Integer.parseInt("60"));
        orangery.getFlower().add(flower);

        flower = OrangeryHandler.createFlower();
        flower.setName("Orchidaceae");
        flower.setId("ID-2");
        flower.setSoil(Soil.valueOf("SOIL"));
        flower.setOrigin(Country.valueOf("JAPAN"));
        flower.setMultiplying(Multiplying.valueOf("SEEDS"));
        flower.getGrowingTips().setTemperature(BigInteger.valueOf(Long.parseLong("22")));
        flower.getGrowingTips().setLightLoving(true);
        flower.getGrowingTips().setWatering(Integer.parseInt("40"));
        flower.getVisualParameters().setStalkColor(StalkColor.valueOf("GREEN"));
        flower.getVisualParameters().setLeavesColor(LeavesColor.valueOf("GREEN"));
        flower.getVisualParameters().setAverageSize(Integer.parseInt("50"));
        orangery.getFlower().add(flower);

        flower = OrangeryHandler.createFlower();
        flower.setName("Lily");
        flower.setId("ID-3");
        flower.setSoil(Soil.valueOf("PODZOLIC"));
        flower.setOrigin(Country.valueOf("UKRAINE"));
        flower.setMultiplying(Multiplying.valueOf("STALKS"));
        flower.getGrowingTips().setTemperature(BigInteger.valueOf(Long.parseLong("15")));
        flower.getGrowingTips().setLightLoving(true);
        flower.getGrowingTips().setWatering(Integer.parseInt("90"));
        flower.getVisualParameters().setStalkColor(StalkColor.valueOf("GREEN"));
        flower.getVisualParameters().setLeavesColor(LeavesColor.valueOf("YELLOW"));
        flower.getVisualParameters().setAverageSize(Integer.parseInt("35"));
        orangery.getFlower().add(flower);
    }

    @Test
    @DisplayName("Check for correct SAX parser")
    void parserSAX() {
        Parser parserSAXHandler = new ParserSAXHandler();
        Orangery resultOrangery = parserSAXHandler.parse(XML_FILE_PATH);
        assertTrue(orangery.equals(resultOrangery));
    }

    @Test
    @DisplayName("Check for correct StAX parser")
    void parserStAX() {
        Parser parserStAX = new ParserStAX();
        Orangery resultOrangery = parserStAX.parse(XML_FILE_PATH);
        assertTrue(orangery.equals(resultOrangery));
    }

    @Test
    @DisplayName("Check for correct DOM parser")
    void parserDOM() {
        Parser parserDOM = new ParserDOM();
        Orangery resultOrangery = parserDOM.parse(XML_FILE_PATH);
        assertTrue(orangery.equals(resultOrangery));
    }
}

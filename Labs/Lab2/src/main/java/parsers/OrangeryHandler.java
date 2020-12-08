package parsers;

import targetClasses.*;

import java.math.BigInteger;

public class OrangeryHandler {
    public static final String XML_FILE_PATH = "src/main/resources/orangery.xml";
    public static final String XSD_FILE_PATH = "src/main/resources/orangery.xsd";

    public static final String PREFIX = "tar:";
    public static final String FLOWER = "flower";
    public static final String VISUAL_PARAMETERS = "visualParameters";
    public static final String GROWING_TIPS = "growingTips";
    public static final String NAME = "name";
    public static final String ID = "id";
    public static final String SOIL = "soil";
    public static final String ORIGIN = "origin";
    public static final String MULTIPLYiNG = "multiplying";
    public static final String TEMPERATURE = "temperature";
    public static final String LIGHT_LOVING = "lightLoving";
    public static final String WATERING = "watering";
    public static final String STALK_COLOR = "stalkColor";
    public static final String LEAVES_COLOR = "leavesColor";
    public static final String AVERAGE_SIZE = "averageSize";


    public static void main(String[] args) {
//        Parser parserSAXHandler = new ParserSAXHandler();
//        Orangery resultOrangery = parserSAXHandler.parse(XML_FILE_PATH);
//        OrangeryHandler.sortAndPrint(resultOrangery);

//        Parser parserDOM = new ParserDOM();
//        Orangery resultOrangery = parserDOM.parse(XML_FILE_PATH);
//        OrangeryHandler.sortAndPrint(resultOrangery);

        Parser parserStAX = new ParserStAX();
        Orangery resultOrangery = parserStAX.parse(XML_FILE_PATH);
        OrangeryHandler.sortAndPrint(resultOrangery);
    }

    public static void setField(Orangery orangery, String field, String value) {
        Flower flower;
        field = removePrefix(field);
        if (field.equals(ID)) {
            flower = createFlower();
            orangery.getFlower().add(flower);   // Adding new flower to list
        } else if (orangery.getFlower().size() == 0) {
            return;
        } else {
            flower = orangery.getFlower().get(orangery.getFlower().size() - 1);
        }
        switch (field) {
//            case FLOWER:
//                flower = createFlower();
//                break;
            case NAME:
                flower.setName(value);
                break;
            case ID:
                flower.setId(value);
                break;
            case SOIL:
                flower.setSoil(Soil.valueOf(value));
                break;
            case ORIGIN:
                flower.setOrigin(Country.valueOf(value));
                break;
            case MULTIPLYiNG:
                flower.setMultiplying(Multiplying.valueOf(value));
                break;
            case TEMPERATURE:
                flower.getGrowingTips().setTemperature(BigInteger.valueOf(Long.parseLong(value)));
                break;
            case LIGHT_LOVING:
                flower.getGrowingTips().setLightLoving(Boolean.parseBoolean(value));
                break;
            case WATERING:
                flower.getGrowingTips().setWatering(Integer.parseInt(value));
                break;
            case STALK_COLOR:
                flower.getVisualParameters().setStalkColor(StalkColor.valueOf(value));
                break;
            case LEAVES_COLOR:
                flower.getVisualParameters().setLeavesColor(LeavesColor.valueOf(value));
                break;
            case AVERAGE_SIZE:
                flower.getVisualParameters().setAverageSize(Integer.parseInt(value));
                break;
        }
    }

//    public static void setAttribute(Flower flower, String attribute, String value) {
//        attribute = removePrefix(attribute);
//        switch (attribute) {
//            case ID:
//                flower.setId(value);
//                break;
//        }
//    }

    private static String removePrefix(String tag) {
        return tag.replace(PREFIX, "");
    }

    public static Flower createFlower() {
        Flower flower = new Flower();
        flower.setVisualParameters(new VisualParameters());
        flower.setGrowingTips(new GrowingTips());
        return flower;
    }

    public static void print(Flower flower) {
        System.out.println("Name: " + flower.getName());
        System.out.println("ID: " + flower.getId());
        System.out.println("Soil: " + flower.getSoil());
        System.out.println("Origin: " + flower.getOrigin());
        System.out.println("Visual parameters:");
        System.out.println("\tStalk color: " + flower.getVisualParameters().getStalkColor());
        System.out.println("\tLeaves color: " + flower.getVisualParameters().getLeavesColor());
        System.out.println("\tAverage size: " + flower.getVisualParameters().getAverageSize() + " cm");
        System.out.println("Growing tips:");
        System.out.println("\tTemperature: " + flower.getGrowingTips().getTemperature() + " °C");
        System.out.println("\tLight-loving: " + flower.getGrowingTips().isLightLoving());
        System.out.println("\tWatering: " + flower.getGrowingTips().getWatering() + " ml per week");
        System.out.println("multiplying: " + flower.getMultiplying());
    }

    public static void sortAndPrint(Orangery orangery) {
        orangery.getFlower().sort(new FlowerComparator());
        for (Flower flower : orangery.getFlower()) {
            print(flower);
            System.out.println();
        }
    }
}

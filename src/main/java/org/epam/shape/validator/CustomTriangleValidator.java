package org.epam.shape.validator;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

public class CustomTriangleValidator {
    private static final Logger LOGGER = LogManager.getLogger();
    private static final String SEPARATOR = ",";

    public static boolean isDoubleValue(String value) {
        //boolean is false by default but IntelliJ wants this mark, other way it says might not have been initialized
        boolean flag = false;

        try {
            Double.parseDouble(value);
            flag = true;
        } catch (NumberFormatException exception) {
            LOGGER.info("Couldn't parse to double: " + value);
        }
        return flag;
    }

    public static boolean isListCorrect(List<String> listOfStrings){
        boolean flag = true;

        if(listOfStrings == null){
            flag = false;
        }
        else if(listOfStrings.size() == 0){
            flag = false;
        }

        return flag;
    }

    public static boolean isDoublesValues(String line){
        boolean flag = true;

        String[] values =line.split(SEPARATOR);

        int currentIndex = 0;

        while(values.length != currentIndex){
            String currentValue = values[currentIndex++];
            if(!isDoubleValue(currentValue)){
                flag = false;
                break;
            }
        }

        return flag;
    }


}

package org.example.shape.parser;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.example.shape.exception.CustomException;
import org.example.shape.validator.CustomTriangleValidator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CustomTriangleParser {
    private static final Logger LOGGER = LogManager.getLogger();

    private static final int AMOUNT_OF_VALUES = 6;
    private static final String SEPARATOR = ",";
    public double[] parseStringToDoubleArray(List<String> listOfValues) throws CustomException {

        if(!CustomTriangleValidator.isListCorrect(listOfValues)){
            LOGGER.warn("Incorrect input data: null or empty list");
            throw new CustomException("Null or empty list");
        }


        double[] currentArray = null;

        for(String currentLine: listOfValues){
            if(CustomTriangleValidator.isDoublesValues(currentLine)){
                String[] values = currentLine.split(SEPARATOR);

                currentArray = new double[AMOUNT_OF_VALUES];

                for(int i=0;i<values.length;++i){
                    currentArray[i] = Double.parseDouble(values[i]);
                }
                LOGGER.info("Correct array found: " + Arrays.toString(currentArray));
                break;
            }
        }


        return currentArray;
    }
}

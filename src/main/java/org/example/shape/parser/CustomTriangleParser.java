package org.example.shape.parser;

import org.example.shape.exception.CustomException;
import org.example.shape.validator.CustomTriangleValidator;

import java.util.ArrayList;
import java.util.List;

public class CustomTriangleParser {
    private static final int AMOUNT_OF_VALUES = 6;
    private static final String SEPARATOR = ",";
    //todo logger
    public double[] parseStringToDoubleArray(List<String> listOfValues) throws CustomException {

        if(!CustomTriangleValidator.isListCorrect(listOfValues)){
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
                break;
            }
        }


        return currentArray;
    }
}

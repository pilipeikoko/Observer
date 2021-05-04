package org.example.shape.factory;

import org.example.shape.entity.CustomPoint;
import org.example.shape.entity.CustomTriangle;
import org.example.shape.exception.CustomException;

public class CustomTriangleFactory {
    private static final int AMOUNT_OF_VALUES = 6;

    public CustomTriangle createCustomTriangle(CustomPoint firstPoint,CustomPoint secondPoint,CustomPoint thirdPoint){
        CustomTriangle triangle = new CustomTriangle(firstPoint,secondPoint,thirdPoint);

        return triangle;
    }

    public CustomTriangle createCustomTriangle(double[] values) throws CustomException {
        if(values.length != AMOUNT_OF_VALUES){
            throw  new CustomException("Wrong amount of values");
        }

        CustomPoint firstPoint = new CustomPoint(values[0],values[1]);
        CustomPoint secondPoint = new CustomPoint(values[2],values[3]);
        CustomPoint thirdPoint = new CustomPoint(values[4],values[5]);

        CustomTriangle triangle = createCustomTriangle(firstPoint,secondPoint,thirdPoint);

        return triangle;
    }

}

package org.epam.shape.factory;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.epam.shape.entity.CustomPoint;
import org.epam.shape.entity.CustomTriangle;
import org.epam.shape.exception.CustomException;

public class CustomTriangleFactory {
    private static final Logger LOGGER = LogManager.getLogger();
    private static final int AMOUNT_OF_VALUES = 6;

    public CustomTriangle createCustomTriangle(CustomPoint firstPoint,CustomPoint secondPoint,CustomPoint thirdPoint){
        CustomTriangle triangle = new CustomTriangle(firstPoint,secondPoint,thirdPoint);
        LOGGER.info("Triangle created: " + triangle.toString());
        return triangle;
    }

    public CustomTriangle createCustomTriangle(double[] values) throws CustomException {
        if(values.length != AMOUNT_OF_VALUES){
            LOGGER.warn("Incorrect amount of values! " + values.length);
            throw  new CustomException("Wrong amount of values");
        }

        CustomPoint firstPoint = new CustomPoint(values[0],values[1]);
        CustomPoint secondPoint = new CustomPoint(values[2],values[3]);
        CustomPoint thirdPoint = new CustomPoint(values[4],values[5]);

        CustomTriangle triangle = createCustomTriangle(firstPoint,secondPoint,thirdPoint);

        LOGGER.info("Triangle created: " + triangle.toString());

        return triangle;
    }

}

package org.example.shape.service;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.example.shape.entity.CustomPoint;
import org.example.shape.entity.CustomTriangle;

import static java.lang.Math.abs;
import static java.lang.Math.sqrt;
import static java.lang.Math.pow;

public class CustomTriangleService {
    private static final Logger LOGGER = LogManager.getLogger();

    public double getTrianglePerimeter(CustomTriangle triangle) {
        double firstSideLength = getSegmentLength(triangle.getFirstPoint(), triangle.getSecondPoint());
        double secondSideLength = getSegmentLength(triangle.getSecondPoint(), triangle.getThirdPoint());
        double thirdSideLength = getSegmentLength(triangle.getThirdPoint(), triangle.getFirstPoint());

        double perimeter = firstSideLength + secondSideLength + thirdSideLength;

        LOGGER.info("Perimeter found: " + perimeter);
        return perimeter;
    }


    public double getTriangleArea(CustomTriangle triangle) {
        double firstSideLength = getSegmentLength(triangle.getFirstPoint(), triangle.getSecondPoint());
        double secondSideLength = getSegmentLength(triangle.getSecondPoint(), triangle.getThirdPoint());
        double thirdSideLength = getSegmentLength(triangle.getThirdPoint(), triangle.getFirstPoint());

        double trianglePerimeter = getTrianglePerimeter(triangle);
        double semiPerimeter = trianglePerimeter / 2d;

        double area = sqrt(semiPerimeter * (semiPerimeter - firstSideLength)
                * (semiPerimeter - secondSideLength) * (semiPerimeter - thirdSideLength));


        LOGGER.info("Area found: " + area);
        return area;

    }

    public boolean isTriangle(CustomTriangle triangle) {
        CustomPoint firstPoint = triangle.getFirstPoint();
        CustomPoint secondPoint = triangle.getSecondPoint();
        CustomPoint thirdPoint = triangle.getThirdPoint();

        boolean flag = (firstPoint.getFirstNumber() == secondPoint.getFirstNumber()
                && firstPoint.getFirstNumber() == thirdPoint.getFirstNumber())
                || (firstPoint.getSecondNumber() == secondPoint.getSecondNumber()
                && firstPoint.getSecondNumber() == thirdPoint.getSecondNumber());

        LOGGER.info("Is triangle: " + triangle.toString() + flag);

        return !flag;
    }

    public boolean isRectangularTriangle(CustomTriangle triangle) {
        double firstSideLength = getSegmentLength(triangle.getFirstPoint(), triangle.getSecondPoint());
        double secondSideLength = getSegmentLength(triangle.getSecondPoint(), triangle.getThirdPoint());
        double thirdSideLength = getSegmentLength(triangle.getThirdPoint(), triangle.getFirstPoint());

        double firstSideLengthSquared = pow(firstSideLength, 2);
        double secondSideLengthSquared = pow(secondSideLength, 2);
        double thirdSideLengthSquared = pow(thirdSideLength, 2);

        boolean flag = (firstSideLengthSquared == secondSideLengthSquared + thirdSideLengthSquared)
                || (secondSideLengthSquared == (firstSideLengthSquared + thirdSideLengthSquared))
                || (thirdSideLengthSquared == (firstSideLengthSquared + secondSideLengthSquared));

        LOGGER.info("Is rectangular triangle: " + triangle.toString() + flag);

        return flag;
    }

    public boolean isIsoscelesTriangle(CustomTriangle triangle) {
        double firstSideLength = getSegmentLength(triangle.getFirstPoint(), triangle.getSecondPoint());
        double secondSideLength = getSegmentLength(triangle.getSecondPoint(), triangle.getThirdPoint());
        double thirdSideLength = getSegmentLength(triangle.getThirdPoint(), triangle.getFirstPoint());

        boolean flag = firstSideLength == secondSideLength
                || firstSideLength == thirdSideLength
                || secondSideLength == thirdSideLength;

        LOGGER.info("Is isosceles triangle: " + triangle.toString() + flag);

        return flag;
    }

    public boolean isEquilateralTriangle(CustomTriangle triangle) {
        double firstSideLength = getSegmentLength(triangle.getFirstPoint(), triangle.getSecondPoint());
        double secondSideLength = getSegmentLength(triangle.getSecondPoint(), triangle.getThirdPoint());
        double thirdSideLength = getSegmentLength(triangle.getThirdPoint(), triangle.getFirstPoint());

        boolean flag = firstSideLength == secondSideLength && firstSideLength == thirdSideLength;

        LOGGER.info("Is equilateral triangle: " + triangle.toString() + flag);


        return flag;
    }

    public boolean isAcuteAngleTriangle(CustomTriangle triangle) {
        double firstSideLength = getSegmentLength(triangle.getFirstPoint(), triangle.getSecondPoint());
        double secondSideLength = getSegmentLength(triangle.getSecondPoint(), triangle.getThirdPoint());
        double thirdSideLength = getSegmentLength(triangle.getThirdPoint(), triangle.getFirstPoint());

        if (firstSideLength < secondSideLength) {
            double temp = firstSideLength;
            firstSideLength = secondSideLength;
            secondSideLength = temp;
        }

        if (firstSideLength < thirdSideLength) {
            double temp = firstSideLength;
            firstSideLength = thirdSideLength;
            thirdSideLength = temp;
        }

        double firstSideLengthSquared = pow(firstSideLength, 2);
        double secondSideLengthSquared = pow(secondSideLength, 2);
        double thirdSideLengthSquared = pow(thirdSideLength, 2);

        boolean flag = firstSideLengthSquared < secondSideLengthSquared + thirdSideLengthSquared;

        LOGGER.info("Is acute angle triangle: " + triangle.toString() + flag);

        return flag;
    }

    public boolean isObtuseTriangle(CustomTriangle triangle) {
        double firstSideLength = getSegmentLength(triangle.getFirstPoint(), triangle.getSecondPoint());
        double secondSideLength = getSegmentLength(triangle.getSecondPoint(), triangle.getThirdPoint());
        double thirdSideLength = getSegmentLength(triangle.getThirdPoint(), triangle.getFirstPoint());

        if (firstSideLength < secondSideLength) {
            double temp = firstSideLength;
            firstSideLength = secondSideLength;
            secondSideLength = temp;
        }

        if (firstSideLength < thirdSideLength) {
            double temp = firstSideLength;
            firstSideLength = thirdSideLength;
            thirdSideLength = temp;
        }

        double firstSideLengthSquared = pow(firstSideLength, 2);
        double secondSideLengthSquared = pow(secondSideLength, 2);
        double thirdSideLengthSquared = pow(thirdSideLength, 2);

        boolean flag = firstSideLengthSquared > secondSideLengthSquared + thirdSideLengthSquared;

        LOGGER.info("Is obtuse triangle: " + triangle.toString() + flag);


        return flag;
    }

    private double getSegmentLength(CustomPoint firstPoint, CustomPoint secondPoint) {
        double dx = abs(firstPoint.getFirstNumber() - secondPoint.getFirstNumber());
        double dy = abs(firstPoint.getSecondNumber() - secondPoint.getSecondNumber());

        double result = sqrt(pow(dx, 2d) + pow(dy, 2d));

        return result;
    }
}

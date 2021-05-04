package org.example.shape.entity;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class CustomPoint implements Cloneable {
    private static final Logger LOGGER = LogManager.getLogger();

    private double firstNumber;
    private double secondNumber;

    public CustomPoint(double firstNumber, double secondNumber) {
        this.firstNumber = firstNumber;
        this.secondNumber = secondNumber;
    }

    public double getFirstNumber() {
        return firstNumber;
    }

    public double getSecondNumber() {
        return secondNumber;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || this.getClass() != obj.getClass()) {
            return false;
        }

        CustomPoint point = (CustomPoint) obj;

        boolean flag = this.firstNumber == point.getFirstNumber()
                && this.secondNumber == point.getSecondNumber();

        return flag;
    }

    @Override
    public int hashCode() {
        int result = (int) (7 * firstNumber + 31 * secondNumber);
        return result;
    }

    @Override
    public String toString() {
        final StringBuilder stringBuilder = new StringBuilder("CustomPoint{");
        stringBuilder.append("firstNumber=").append(firstNumber);
        stringBuilder.append(", secondNumber=").append(secondNumber);
        stringBuilder.append('}');
        return stringBuilder.toString();
    }

    @Override
    public CustomPoint clone() {
        CustomPoint point = null;

        try {
            point = (CustomPoint) super.clone();
        } catch (CloneNotSupportedException exception) {
            LOGGER.warn("Clone is not supported", exception.getCause());
        }

        return point;
    }
}

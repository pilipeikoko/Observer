package org.epam.shape.specification.sort;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.epam.shape.service.CustomTriangleService;
import org.epam.shape.entity.CustomTriangle;

import java.util.Comparator;

public class SortSpecificationByArea implements Comparator<CustomTriangle> {
    private static final Logger LOGGER = LogManager.getLogger();
    @Override
    public int compare(CustomTriangle firstTriangle, CustomTriangle secondTriangle) {
        CustomTriangleService triangleService = new CustomTriangleService();

        double areaOfFirstTriangle = triangleService.getTriangleArea(firstTriangle);
        double areaOfSecondTriangle = triangleService.getTriangleArea(secondTriangle);

        int result = 0;

        if (areaOfFirstTriangle > areaOfSecondTriangle) {
            result = 1;
        } else if (areaOfFirstTriangle < areaOfSecondTriangle) {
            result = -1;
        }

        LOGGER.info("Compare result: " + result);


        return result;
    }
}

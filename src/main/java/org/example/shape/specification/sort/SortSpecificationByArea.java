package org.example.shape.specification.sort;

import org.example.shape.entity.CustomTriangle;
import org.example.shape.service.CustomTriangleService;

import java.util.Comparator;

public class SortSpecificationByArea implements Comparator<CustomTriangle> {
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

        return result;
    }
}

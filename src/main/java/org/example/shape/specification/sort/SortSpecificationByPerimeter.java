package org.example.shape.specification.sort;

import org.example.shape.entity.CustomTriangle;
import org.example.shape.service.CustomTriangleService;

import java.util.Comparator;

public class SortSpecificationByPerimeter implements Comparator<CustomTriangle> {
    @Override
    public int compare(CustomTriangle firstTriangle, CustomTriangle secondTriangle) {

        CustomTriangleService triangleService = new CustomTriangleService();

        double perimeterOfFirstTriangle = triangleService.getTrianglePerimeter(firstTriangle);
        double perimeterOfSecondTriangle = triangleService.getTrianglePerimeter(secondTriangle);

        int result = 0;

        if (perimeterOfFirstTriangle > perimeterOfSecondTriangle) {
            result = 1;
        } else if (perimeterOfFirstTriangle < perimeterOfSecondTriangle) {
            result = -1;
        }

        return result;
    }
}

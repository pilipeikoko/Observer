package org.example.shape.specification.find.impl;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.example.shape.entity.CustomTriangle;
import org.example.shape.service.CustomTriangleService;
import org.example.shape.specification.find.FindSpecification;

public class FindSpecificationByPerimeter implements FindSpecification {
    private static Logger LOGGER = LogManager.getRootLogger();

    private final double minimalPerimeter;
    private final double maximalPerimeter;

    public FindSpecificationByPerimeter(double minPerimeter, double maxPerimeter) {
        this.minimalPerimeter = minPerimeter;
        this.maximalPerimeter = maxPerimeter;
    }


    @Override
    public boolean specified(CustomTriangle triangle) {
        CustomTriangleService triangleService = new CustomTriangleService();

        double currentPerimeter = triangleService.getTrianglePerimeter(triangle);

        boolean flag = currentPerimeter >=minimalPerimeter && currentPerimeter <=maximalPerimeter;

        LOGGER.info("Is specified: " + flag + triangle.toString() );

        return flag;
    }
}

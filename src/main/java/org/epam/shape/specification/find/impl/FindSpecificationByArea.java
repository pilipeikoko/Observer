package org.epam.shape.specification.find.impl;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.epam.shape.service.CustomTriangleService;
import org.epam.shape.specification.find.FindSpecification;
import org.epam.shape.entity.CustomTriangle;

public class FindSpecificationByArea implements FindSpecification {

    private static Logger LOGGER = LogManager.getRootLogger();

    private final double minimalArea;
    private final double maximalArea;

    public FindSpecificationByArea(double minimalArea, double maximalArea) {
        this.minimalArea = minimalArea;
        this.maximalArea = maximalArea;
    }


    @Override
    public boolean specified(CustomTriangle triangle) {
        CustomTriangleService triangleService = new CustomTriangleService();

        double currentArea = triangleService.getTriangleArea(triangle);

        boolean flag = currentArea >= minimalArea && currentArea <= maximalArea;

        LOGGER.info("Is specified: " + flag + triangle.toString() );

        return flag;
    }
}

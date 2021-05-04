package org.example.shape.specification.find.impl;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.example.shape.entity.CustomTriangle;
import org.example.shape.service.CustomTriangleService;
import org.example.shape.specification.find.FindSpecification;

public class FindSpecificationByArea implements FindSpecification {

    private static Logger LOGGER = LogManager.getRootLogger();

    private double minimalArea;
    private double maximalArea;

    public FindSpecificationByArea(double minimalArea, double maximalArea) {
        this.minimalArea = minimalArea;
        this.maximalArea = maximalArea;
    }


    @Override
    public boolean specified(CustomTriangle triangle) {
        CustomTriangleService triangleService = new CustomTriangleService();

        double currentArea = triangleService.getTriangleArea(triangle);

        boolean flag = currentArea >= minimalArea && currentArea <= maximalArea;
//todo logger
        return flag;
    }
}

package org.example.shape.observer.impl;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.example.shape.entity.CustomTriangle;
import org.example.shape.entity.CustomTriangleProperties;
import org.example.shape.exception.CustomException;
import org.example.shape.observer.CustomTriangleEvent;
import org.example.shape.observer.CustomTriangleObserver;
import org.example.shape.service.CustomTriangleService;
import org.example.shape.warehouse.CustomTriangleWarehouse;

public class CustomTriangleObserverImpl implements CustomTriangleObserver {
    private static final Logger LOGGER = LogManager.getLogger();
    @Override
    public void parameterChanged(CustomTriangleEvent event) {
        CustomTriangle triangle = event.getSource();
        CustomTriangleWarehouse triangleWarehouse = CustomTriangleWarehouse.getInstance();

        CustomTriangleService triangleService = new CustomTriangleService();
        double perimeter = triangleService.getTrianglePerimeter(triangle);
        double area = triangleService.getTriangleArea(triangle);

        CustomTriangleProperties newProperties = new CustomTriangleProperties(area,perimeter);

        triangleWarehouse.updateProperties(triangle.getId(),newProperties);

        LOGGER.info("Parameters updated: " + triangle.getId() + newProperties.toString());
    }
}

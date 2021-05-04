package org.epam.shape.observer.impl;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.epam.shape.service.CustomTriangleService;
import org.epam.shape.entity.CustomTriangle;
import org.epam.shape.entity.CustomTriangleProperties;
import org.epam.shape.observer.CustomTriangleEvent;
import org.epam.shape.observer.CustomTriangleObserver;
import org.epam.shape.warehouse.CustomTriangleWarehouse;

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

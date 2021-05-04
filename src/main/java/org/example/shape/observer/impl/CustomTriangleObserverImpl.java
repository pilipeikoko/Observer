package org.example.shape.observer.impl;

import org.example.shape.entity.CustomTriangle;
import org.example.shape.entity.CustomTriangleProperties;
import org.example.shape.exception.CustomException;
import org.example.shape.observer.CustomTriangleEvent;
import org.example.shape.observer.CustomTriangleObserver;
import org.example.shape.service.CustomTriangleService;
import org.example.shape.warehouse.CustomTriangleWarehouse;

public class CustomTriangleObserverImpl implements CustomTriangleObserver {
    @Override
    public void parameterChanged(CustomTriangleEvent event) {
        CustomTriangle triangle = event.getSource();
        CustomTriangleWarehouse triangleWarehouse = CustomTriangleWarehouse.getInstance();

        CustomTriangleService triangleService = new CustomTriangleService();
        double perimeter = triangleService.getTrianglePerimeter(triangle);
        double area = triangleService.getTriangleArea(triangle);

        CustomTriangleProperties newProperties = new CustomTriangleProperties(area,perimeter);

        triangleWarehouse.updateProperties(triangle.getId(),newProperties);

        //todo if throws just set the parameters
    }
}

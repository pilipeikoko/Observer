package org.example.shape.warehouse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.example.shape.entity.CustomTriangleProperties;

import java.util.HashMap;
import java.util.Map;

public class CustomTriangleWarehouse {
    private static final Logger LOGGER = LogManager.getLogger();
    private static final CustomTriangleWarehouse instance = new CustomTriangleWarehouse();

    private final Map<Long,CustomTriangleProperties> trianglePropertiesMap;

    {
        trianglePropertiesMap = new HashMap<>();
    }

    public static CustomTriangleWarehouse getInstance() {
        return instance;
    }

    public void setProperty(long id, CustomTriangleProperties newProperties) {
        trianglePropertiesMap.put(id,newProperties);
    }

    public CustomTriangleProperties getProperty(long id) {
        CustomTriangleProperties currentProperties = trianglePropertiesMap.get(id);
        //todo logger
        return currentProperties;
    }

    public void updateProperties(long id, CustomTriangleProperties newProperties) {
        CustomTriangleProperties currentProperties = getProperty(id);
        //todo null check and put into map

        currentProperties.setPerimeter(newProperties.getPerimeter());
        currentProperties.setArea(newProperties.getArea());
        //todo logger
    }
}

package org.epam.shape.warehouse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.epam.shape.entity.CustomTriangleProperties;

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
        LOGGER.info("Properties are set: " + newProperties.toString());
    }

    public CustomTriangleProperties getProperty(long id) {
        CustomTriangleProperties currentProperties = trianglePropertiesMap.get(id);
        LOGGER.info("Get property: " + id);
        return currentProperties;
    }

    public void updateProperties(long id, CustomTriangleProperties newProperties) {
        CustomTriangleProperties currentProperties = getProperty(id);

        if(currentProperties == null){
            setProperty(id,newProperties);
            return;
        }
        currentProperties.setPerimeter(newProperties.getPerimeter());
        currentProperties.setArea(newProperties.getArea());
        LOGGER.info("Properties updated: " + newProperties);
    }
}

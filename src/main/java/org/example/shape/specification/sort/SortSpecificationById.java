package org.example.shape.specification.sort;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.example.shape.entity.CustomTriangle;

import java.util.Comparator;

public class SortSpecificationById implements Comparator<CustomTriangle> {
    private static final Logger LOGGER = LogManager.getLogger();

    @Override
    public int compare(CustomTriangle firstTriangle, CustomTriangle secondTriangle) {

        long idOfFirstTriangle = firstTriangle.getId();
        long idOfSecondTriangle = secondTriangle.getId();

        int result =0;

        if (idOfFirstTriangle > idOfSecondTriangle) {
            result = 1;
        } else if (idOfFirstTriangle < idOfSecondTriangle) {
            result = -1;
        }

        LOGGER.info("Compare result: " + result);

        return result;
    }
}

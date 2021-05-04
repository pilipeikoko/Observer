package org.example.shape.specification.find.impl;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.example.shape.entity.CustomTriangle;
import org.example.shape.specification.find.FindSpecification;

public class FindSpecificationById implements FindSpecification {

    private static final Logger LOGGER = LogManager.getLogger();
    private final long id;

    public FindSpecificationById(long id){
        this.id = id;
    }


    @Override
    public boolean specified(CustomTriangle triangle) {
        boolean flag = (id == triangle.getId());

        LOGGER.info("Is specified: " + flag + triangle.toString() );

        return flag;
    }
}

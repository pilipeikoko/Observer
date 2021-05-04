package org.example.shape.specification.find.impl;

import org.example.shape.entity.CustomTriangle;
import org.example.shape.specification.find.FindSpecification;

public class FindSpecificationById implements FindSpecification {

    private final long id;

    public FindSpecificationById(long id){
        this.id = id;
    }


    @Override
    public boolean specified(CustomTriangle triangle) {
        boolean flag = (Long.compare(id,triangle.getId()) == 0);

        return flag;
    }
}

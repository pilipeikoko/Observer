package org.epam.shape.specification.find;

import org.epam.shape.entity.CustomTriangle;

@FunctionalInterface
public interface FindSpecification {
    boolean specified(CustomTriangle triangle);
}
package org.example.shape.specification.find;

import org.example.shape.entity.CustomTriangle;

@FunctionalInterface
public interface FindSpecification {
    boolean specified(CustomTriangle triangle);
}
package org.epam.shape.observer;

import org.epam.shape.exception.CustomException;

@FunctionalInterface
public interface CustomTriangleObserver {
    void parameterChanged(CustomTriangleEvent event) throws CustomException;
}

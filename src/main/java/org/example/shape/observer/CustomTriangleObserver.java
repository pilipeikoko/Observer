package org.example.shape.observer;

import org.example.shape.exception.CustomException;

@FunctionalInterface
public interface CustomTriangleObserver {
    void parameterChanged(CustomTriangleEvent event) throws CustomException;
}

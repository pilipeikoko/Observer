package org.example.shape.observer;

import org.example.shape.exception.CustomException;

public interface CustomTriangleObserver {
    void parameterChanged(CustomTriangleEvent event) throws CustomException;
}

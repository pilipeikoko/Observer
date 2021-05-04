package org.epam.shape.observer;

import org.epam.shape.entity.CustomTriangle;

import java.util.EventObject;

public class CustomTriangleEvent extends EventObject {
    public CustomTriangleEvent(Object source) {
        super(source);
    }

    @Override
    public CustomTriangle getSource(){
        return (CustomTriangle) super.getSource();
    }
}

package org.example.shape.observer;

import org.example.shape.entity.CustomTriangle;

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

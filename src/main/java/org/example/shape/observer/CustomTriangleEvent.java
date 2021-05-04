package org.example.shape.observer;

import org.example.shape.entity.CustomTriangle;

import java.util.EventObject;

public class CustomTriangleEvent extends EventObject {
    /**
     * Constructs a prototypical Event.
     *
     * @param source the object on which the Event initially occurred
     * @throws IllegalArgumentException if source is null
     */
    public CustomTriangleEvent(Object source) {
        super(source);
    }

    @Override
    public CustomTriangle getSource(){
        return (CustomTriangle) super.getSource();
    }
}

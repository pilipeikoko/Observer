package org.example.shape.entity;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.example.shape.exception.CustomException;
import org.example.shape.observer.CustomTriangleEvent;
import org.example.shape.observer.CustomTriangleObservable;
import org.example.shape.observer.CustomTriangleObserver;
import org.example.shape.util.IdGenerator;

import java.util.ArrayList;
import java.util.List;

public class CustomTriangle implements CustomTriangleObservable {
    private static final Logger LOGGER = LogManager.getLogger();

    private final long id;

    private CustomPoint firstPoint;
    private CustomPoint secondPoint;
    private CustomPoint thirdPoint;

    private final List<CustomTriangleObserver> observer;

    {
        id = IdGenerator.generateId();
        observer = new ArrayList<>();
    }

    public CustomTriangle(CustomPoint firstPoint, CustomPoint secondPoint, CustomPoint thirdPoint) {
        this.firstPoint = firstPoint;
        this.secondPoint = secondPoint;
        this.thirdPoint = thirdPoint;
       // notifyObservers();
    }

    public CustomPoint getFirstPoint() {
        return firstPoint;
    }

    public CustomPoint getSecondPoint() {
        return secondPoint;
    }

    public CustomPoint getThirdPoint() {
        return thirdPoint;
    }

    public long getId() {
        return id;
    }

    public List<CustomTriangleObserver> getObserver() {
        return observer;
    }

    public void setFirstPoint(CustomPoint firstPoint) {
        this.firstPoint = firstPoint;
        notifyObservers();
    }

    public void setSecondPoint(CustomPoint secondPoint) {
        this.secondPoint = secondPoint;
        notifyObservers();
    }

    public void setThirdPoint(CustomPoint thirdPoint) {
        this.thirdPoint = thirdPoint;
        notifyObservers();
    }

    @Override
    public void attach(CustomTriangleObserver triangleObserver) {
        if (triangleObserver != null) {
            this.observer.add(triangleObserver);
        }
    }

    @Override
    public void detach(CustomTriangleObserver triangleObserver) {
        if (triangleObserver != null) {
            this.observer.remove(triangleObserver);
        }
    }

    @Override
    public void notifyObservers() {
        CustomTriangleEvent event = new CustomTriangleEvent(this);
        for (CustomTriangleObserver customTriangleObserver : observer) {
            try {
                customTriangleObserver.parameterChanged(event);
            } catch (CustomException e) {
                LOGGER.warn("Couldn't notify observer: " + e.getMessage());
            }
        }
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }

        if (obj == null || obj.getClass() != this.getClass()) {
            return false;
        }

        CustomTriangle triangle = (CustomTriangle) obj;

        boolean flag = (triangle.firstPoint != null && this.firstPoint == triangle.firstPoint)
                && (triangle.secondPoint != null && this.secondPoint == triangle.secondPoint)
                && (triangle.thirdPoint != null && this.thirdPoint == triangle.thirdPoint)
                && this.id == triangle.id
                && (triangle.observer != null && this.observer == triangle.observer);

        return flag;
    }


    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 7 * result + (firstPoint != null ? firstPoint.hashCode() : 0);
        result = 11 * result + (secondPoint != null ? secondPoint.hashCode() : 0);
        result = 17 * result + (thirdPoint != null ? thirdPoint.hashCode() : 0);
        result = 31 * result + (observer != null ? observer.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        final StringBuilder stringBuilder = new StringBuilder("CustomTriangle{");
        stringBuilder.append("id=").append(id);
        stringBuilder.append(", firstPoint=").append(firstPoint);
        stringBuilder.append(", secondPoint=").append(secondPoint);
        stringBuilder.append(", thirdPoint=").append(thirdPoint);
        stringBuilder.append(", observer=").append(observer);
        stringBuilder.append('}');
        return stringBuilder.toString();
    }

}

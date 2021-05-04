package org.example.shape.observer;

public interface CustomTriangleObservable {
    void attach(CustomTriangleObserver observer);

    void detach(CustomTriangleObserver observer);

    void notifyObservers();
}
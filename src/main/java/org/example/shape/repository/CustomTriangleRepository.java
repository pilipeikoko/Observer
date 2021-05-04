package org.example.shape.repository;

import org.example.shape.entity.CustomTriangle;
import org.example.shape.specification.find.FindSpecification;

import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public interface CustomTriangleRepository {
    void add(CustomTriangle triangle);
    void addAll(Collection<CustomTriangle> triangles);

    boolean remove(CustomTriangle figure);
    boolean removeAll(Collection<CustomTriangle> collection);

    void clear();

    CustomTriangle get(int index);
    CustomTriangle set(int index, CustomTriangle figure);

    List<CustomTriangle> query(FindSpecification specification);
    List<CustomTriangle> sort(Comparator<CustomTriangle> comparator);
}

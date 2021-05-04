package org.epam.shape.repository;

import org.epam.shape.specification.find.FindSpecification;
import org.epam.shape.entity.CustomTriangle;

import java.util.Comparator;
import java.util.List;

public interface CustomTriangleRepository {
    void add(CustomTriangle triangle);

    boolean remove(CustomTriangle figure);

    void clear();

    CustomTriangle get(int index);
    CustomTriangle set(int index, CustomTriangle figure);

    List<CustomTriangle> query(FindSpecification specification);
    List<CustomTriangle> sort(Comparator<CustomTriangle> comparator);
}

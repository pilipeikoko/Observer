package org.epam.shape.repository.impl;

import org.epam.shape.repository.CustomTriangleRepository;
import org.epam.shape.specification.find.FindSpecification;
import org.epam.shape.entity.CustomTriangle;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class CustomTriangleRepositoryImpl implements CustomTriangleRepository {
    private static final CustomTriangleRepository instance = new CustomTriangleRepositoryImpl();
    private final List<CustomTriangle> listOfTriangles;

    private CustomTriangleRepositoryImpl(){
        listOfTriangles = new ArrayList<>();
    }

    public static CustomTriangleRepository getInstance() {
        return instance;
    }

    public List<CustomTriangle> getListOfTriangles() {
        return listOfTriangles;
    }

    @Override
    public void add(CustomTriangle triangle) {
        listOfTriangles.add(triangle);
    }

    @Override
    public boolean remove(CustomTriangle triangle) {
        boolean flag = listOfTriangles.remove(triangle);

        return flag;
    }

    @Override
    public void clear() {
        listOfTriangles.clear();
    }

    @Override
    public CustomTriangle get(int index) {
        CustomTriangle triangle = listOfTriangles.get(index);

        return triangle;
    }

    @Override
    public CustomTriangle set(int index, CustomTriangle triangle) {
        CustomTriangle result = listOfTriangles.set(index,triangle);

        return result;
    }

    @Override
    public List<CustomTriangle> query(FindSpecification specification) {
        List<CustomTriangle> result = listOfTriangles.stream()
                .filter(specification::specified)
                .collect(Collectors.toList());

        return result;
    }

    @Override
    public List<CustomTriangle> sort(Comparator<CustomTriangle> comparator) {
        List<CustomTriangle> result = listOfTriangles.stream()
                .sorted(comparator)
                .collect(Collectors.toList());

        return result;
    }
}

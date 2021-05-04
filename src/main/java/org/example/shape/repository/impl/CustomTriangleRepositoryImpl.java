package org.example.shape.repository.impl;

import org.example.shape.entity.CustomTriangle;
import org.example.shape.repository.CustomTriangleRepository;
import org.example.shape.specification.find.FindSpecification;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class CustomTriangleRepositoryImpl implements CustomTriangleRepository {
    private static final CustomTriangleRepository instance = new CustomTriangleRepositoryImpl();
    private List<CustomTriangle> listOfTriangles;

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
    public void addAll(Collection<CustomTriangle> triangles) {
        listOfTriangles.addAll(triangles);
    }

    @Override
    public boolean remove(CustomTriangle triangle) {
        boolean flag = listOfTriangles.remove(triangle);

        return flag;
    }

    @Override
    public boolean removeAll(Collection<CustomTriangle> collection) {
        boolean flag = listOfTriangles.removeAll(collection);

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

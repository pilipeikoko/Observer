package org.epam.shape.main;

import org.epam.shape.factory.CustomTriangleFactory;
import org.epam.shape.observer.impl.CustomTriangleObserverImpl;
import org.epam.shape.parser.CustomTriangleParser;
import org.epam.shape.reader.CustomDataReader;
import org.epam.shape.service.CustomTriangleService;
import org.epam.shape.entity.CustomPoint;
import org.epam.shape.entity.CustomTriangle;
import org.epam.shape.exception.CustomException;
import org.epam.shape.repository.CustomTriangleRepository;
import org.epam.shape.repository.impl.CustomTriangleRepositoryImpl;

import java.util.List;

public class Run {
    public static void main(String[] args) {
        try {
            CustomDataReader reader = new CustomDataReader();
            List<String> data = reader.readDataFromFile("src/main/resources/data/test1.txt");

            CustomTriangleParser parser = new CustomTriangleParser();
            double[] doubleArrayOfData = parser.parseStringToDoubleArray(data);


            CustomTriangleFactory factory = new CustomTriangleFactory();
            CustomTriangle triangle = factory.createCustomTriangle(doubleArrayOfData);
            CustomTriangleRepository repository = CustomTriangleRepositoryImpl.getInstance();
            repository.add(triangle);
            triangle.attach(new CustomTriangleObserverImpl());

            CustomTriangleService service = new CustomTriangleService();

            double perimeter = service.getTrianglePerimeter(triangle);
            System.out.println(perimeter);

            triangle.setFirstPoint(new CustomPoint(5.5d,2.2d));


            perimeter = service.getTrianglePerimeter(triangle);
            System.out.println(perimeter);

        } catch (CustomException exception) {
            exception.printStackTrace();
        }
    }
}

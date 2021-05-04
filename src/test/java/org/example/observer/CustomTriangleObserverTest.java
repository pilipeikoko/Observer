package org.example.observer;

import org.example.shape.entity.CustomPoint;
import org.example.shape.entity.CustomTriangle;
import org.example.shape.entity.CustomTriangleProperties;
import org.example.shape.observer.impl.CustomTriangleObserverImpl;
import org.example.shape.service.CustomTriangleService;
import org.example.shape.warehouse.CustomTriangleWarehouse;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class CustomTriangleObserverTest {
    private CustomTriangle triangle;
    private final CustomTriangleWarehouse warehouse = CustomTriangleWarehouse.getInstance();

    @BeforeTest
    public void beforeTestSetUp()  {
        CustomPoint firstPoint = new CustomPoint(5.3d,2.3d);
        CustomPoint secondPoint = new CustomPoint(2.3d,1.3d);
        CustomPoint thirdPoint = new CustomPoint(2.5d,6.2d);

        triangle = new CustomTriangle(firstPoint,secondPoint,thirdPoint);
        triangle.attach(new CustomTriangleObserverImpl());
        CustomTriangleService service = new CustomTriangleService();

        double area = service.getTriangleArea(triangle);
        double perimeter = service.getTrianglePerimeter(triangle);

        warehouse.setProperty(triangle.getId(),new CustomTriangleProperties(area,perimeter));

    }

    @Test
    public void firstSideChangedTest(){
        triangle.setFirstPoint(new CustomPoint(1d,1d));

        CustomTriangleService service = new CustomTriangleService();

        double expectedPerimeter = service.getTrianglePerimeter(triangle);
        double actualPerimeter = warehouse.getProperty(triangle.getId()).getPerimeter();

        Assert.assertEquals(expectedPerimeter,actualPerimeter);
    }

    @Test
    public void secondSideChangedTest(){
        triangle.setSecondPoint(new CustomPoint(1.2d,2.3d));

        CustomTriangleService service = new CustomTriangleService();

        double expectedPerimeter = service.getTrianglePerimeter(triangle);
        double actualPerimeter = warehouse.getProperty(triangle.getId()).getPerimeter();

        Assert.assertEquals(expectedPerimeter,actualPerimeter);
    }

    @Test
    public void thirdSideChangedTest(){
        triangle.setSecondPoint(new CustomPoint(5d,12d));

        CustomTriangleService service = new CustomTriangleService();

        double expectedPerimeter = service.getTrianglePerimeter(triangle);
        double actualPerimeter = warehouse.getProperty(triangle.getId()).getPerimeter();

        Assert.assertEquals(expectedPerimeter,actualPerimeter);
    }
}

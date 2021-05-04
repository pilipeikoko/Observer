package org.example.repository;

import org.example.shape.entity.CustomPoint;
import org.example.shape.entity.CustomTriangle;
import org.example.shape.repository.CustomTriangleRepository;
import org.example.shape.repository.impl.CustomTriangleRepositoryImpl;
import org.example.shape.service.CustomTriangleService;
import org.example.shape.specification.find.FindSpecification;
import org.example.shape.specification.find.impl.FindSpecificationByArea;
import org.example.shape.specification.find.impl.FindSpecificationById;
import org.example.shape.specification.find.impl.FindSpecificationByPerimeter;
import org.example.shape.specification.sort.SortSpecificationByArea;
import org.example.shape.specification.sort.SortSpecificationById;
import org.example.shape.specification.sort.SortSpecificationByPerimeter;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class CustomTriangleRepositoryTest {
    private CustomTriangleRepository repository;
    private CustomTriangle firstTriangle;
    private CustomTriangle secondTriangle;
    private CustomTriangle thirdTriangle;

    @BeforeClass
    public void beforeClassSetUp() {
        repository = CustomTriangleRepositoryImpl.getInstance();

        CustomPoint firstPoint = new CustomPoint(5.3d,2.3d);
        CustomPoint secondPoint = new CustomPoint(2.3d,1.3d);
        CustomPoint thirdPoint = new CustomPoint(2.5d,6.2d);

        firstTriangle = new CustomTriangle(firstPoint,secondPoint,thirdPoint);

        firstPoint = new CustomPoint(6.2d,2.3d);
        secondPoint = new CustomPoint(4.2d,5.7d);
        thirdPoint = new CustomPoint(1.2d,5.8d);

        secondTriangle = new CustomTriangle(firstPoint,secondPoint,thirdPoint);

        firstPoint = new CustomPoint(4.2d,8.1d);
        secondPoint = new CustomPoint(5.2d,6.1d);
        thirdPoint = new CustomPoint(6.2d,12.3d);

        thirdTriangle = new CustomTriangle(firstPoint,secondPoint,thirdPoint);

        repository.add(firstTriangle);
        repository.add(secondTriangle);
        repository.add(thirdTriangle);
    }

    @Test
    public void findByPerimeterSpecificationTest(){
        FindSpecification specification = new FindSpecificationByPerimeter(12d,13d);

        List<CustomTriangle> actualList = repository.query(specification);
        List<CustomTriangle> expectedList = Collections.singletonList(firstTriangle);

        Assert.assertEquals(actualList,expectedList);
    }

    @Test
    public void findByAreaSpecificationTest(){
        FindSpecification specification = new FindSpecificationByArea(1d,6d);

        CustomTriangleService service = new CustomTriangleService();

        double area1 = service.getTriangleArea(firstTriangle);
        double area2 = service.getTriangleArea(secondTriangle);
        double area3 = service.getTriangleArea(thirdTriangle);

        List<CustomTriangle> actualList = repository.query(specification);
        List<CustomTriangle> expectedList = Arrays.asList(secondTriangle,thirdTriangle);

        Assert.assertEquals(actualList,expectedList);
    }

    @Test
    public void findByIdSpecificationTest(){
        FindSpecification specification = new FindSpecificationById(2);


        List<CustomTriangle> actualList = repository.query(specification);
        List<CustomTriangle> expectedList = Arrays.asList(thirdTriangle);

        Assert.assertEquals(actualList,expectedList);
    }

    @Test
    public void sortByAreaSpecificationTest(){
        Comparator<CustomTriangle> comparator = new SortSpecificationByArea();

        List<CustomTriangle> actualList = repository.sort(comparator);
        List<CustomTriangle> expectedList = Arrays.asList(thirdTriangle,secondTriangle,firstTriangle);

        Assert.assertEquals(actualList,expectedList);
    }

    @Test
    public void sortByPerimeterSpecificationTest(){
        Comparator<CustomTriangle> comparator = new SortSpecificationByPerimeter();

        List<CustomTriangle> actualList = repository.sort(comparator);
        List<CustomTriangle> expectedList = Arrays.asList(firstTriangle,secondTriangle,thirdTriangle);

        Assert.assertEquals(actualList,expectedList);
    }

    @Test
    public void sortByIdSpecificationTest(){
        Comparator<CustomTriangle> comparator = new SortSpecificationById();

        List<CustomTriangle> actualList = repository.sort(comparator);
        List<CustomTriangle> expectedList = Arrays.asList(firstTriangle,secondTriangle,thirdTriangle);

        Assert.assertEquals(actualList,expectedList);
    }
}

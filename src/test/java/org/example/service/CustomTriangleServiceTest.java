package org.example.service;

import org.epam.shape.entity.CustomPoint;
import org.epam.shape.entity.CustomTriangle;
import org.epam.shape.service.CustomTriangleService;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class CustomTriangleServiceTest {
    private CustomTriangle rectangularTriangle;
    private CustomTriangle acuteTriangle;
    private CustomTriangle obtuseTriangle;

    @BeforeClass
    public void beforeClassSetUp() {
        CustomPoint firstPoint = new CustomPoint(1d,1d);
        CustomPoint secondPoint = new CustomPoint(5d,1d);
        CustomPoint thirdPoint = new CustomPoint(5d,4d);

        rectangularTriangle = new CustomTriangle(firstPoint,secondPoint,thirdPoint);

        secondPoint = new CustomPoint(4d,1d);

        obtuseTriangle = new CustomTriangle(firstPoint,secondPoint,thirdPoint);

        secondPoint = new CustomPoint(6d,1d);

        acuteTriangle = new CustomTriangle(firstPoint,secondPoint,thirdPoint);
    }

    @Test
    public void perimeterTest(){
        CustomTriangleService service = new CustomTriangleService();

        double expectedPerimeter = 12d;
        double actualPerimeter = service.getTrianglePerimeter(rectangularTriangle);

        Assert.assertEquals(expectedPerimeter,actualPerimeter);
    }

    @Test
    public void AreaTest(){
        CustomTriangleService service = new CustomTriangleService();

        double expectedPerimeter = 6d;
        double actualPerimeter = service.getTriangleArea(rectangularTriangle);

        Assert.assertEquals(expectedPerimeter,actualPerimeter);
    }

    @Test
    public void isTriangleTest(){
        CustomTriangleService service = new CustomTriangleService();

        boolean expected = true;
        boolean actual = service.isTriangle(rectangularTriangle);

        Assert.assertEquals(expected,actual);
    }

    @Test
    public void isRectangularTriangleTrueTest(){
        CustomTriangleService service = new CustomTriangleService();

        boolean expected = true;
        boolean actual = service.isRectangularTriangle(rectangularTriangle);

        Assert.assertEquals(expected,actual);
    }

    @Test
    public void isRectangularTriangleFalseTest(){
        CustomTriangleService service = new CustomTriangleService();

        boolean expected = false;
        boolean actual = service.isRectangularTriangle(acuteTriangle);

        Assert.assertEquals(expected,actual);
    }

    @Test
    public void isIsoscelesTriangleFalseTest(){
        CustomTriangleService service = new CustomTriangleService();

        boolean expected = false;
        boolean actual = service.isIsoscelesTriangle(rectangularTriangle);

        Assert.assertEquals(expected,actual);
    }

    @Test
    public void isEquilateralTriangleTest(){
        CustomTriangleService service = new CustomTriangleService();

        boolean expected = false;
        boolean actual = service.isEquilateralTriangle(rectangularTriangle);

        Assert.assertEquals(expected,actual);
    }

    @Test
    public void isAcuteAngleTriangleFalseTest(){
        CustomTriangleService service = new CustomTriangleService();

        boolean expected = false;
        boolean actual = service.isAcuteAngleTriangle(rectangularTriangle);

        Assert.assertEquals(expected,actual);
    }

    @Test
    public void isAcuteAngleTriangleTrueTest(){
        CustomTriangleService service = new CustomTriangleService();

        boolean expected = true;
        boolean actual = service.isAcuteAngleTriangle(acuteTriangle);

        Assert.assertEquals(expected,actual);
    }

    @Test
    public void isObtuseTriangleFalseTest(){
        CustomTriangleService service = new CustomTriangleService();

        boolean expected = false;
        boolean actual = service.isObtuseTriangle(rectangularTriangle);

        Assert.assertEquals(expected,actual);
    }

    @Test
    public void isObtuseTriangleTrueTest(){
        CustomTriangleService service = new CustomTriangleService();

        boolean expected = true;
        boolean actual = service.isObtuseTriangle(obtuseTriangle);

        Assert.assertEquals(expected,actual);
    }
}

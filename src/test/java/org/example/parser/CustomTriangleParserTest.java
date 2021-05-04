package org.example.parser;

import org.example.shape.exception.CustomException;
import org.example.shape.parser.CustomTriangleParser;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class CustomTriangleParserTest {
    @Test
    public void parserCorrectTest() throws CustomException {
        List<String> triangles = new ArrayList<>();

        double[] expectedArray = {1.5,2.6,3.5,8.2,6.2,9.1};

        triangles.add("wrongLine");
        triangles.add("1.5,2.6,3.5,8.2,6.2,9.1");

        CustomTriangleParser parser = new CustomTriangleParser();
        double[] actualArray = parser.parseStringToDoubleArray(triangles);

        Assert.assertEquals(actualArray,expectedArray);

    }

    @Test(expectedExceptions = CustomException.class)
    public void parserEmptyThrowsTest() throws CustomException {
        List<String> triangles = new ArrayList<>();

        CustomTriangleParser parser = new CustomTriangleParser();
        parser.parseStringToDoubleArray(triangles);

    }

    @Test(expectedExceptions = CustomException.class)
    public void parserNullThrowsTest() throws CustomException {

        CustomTriangleParser parser = new CustomTriangleParser();
        parser.parseStringToDoubleArray(null);
    }
}

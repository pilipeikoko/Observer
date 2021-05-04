package org.example.validator;

import org.example.shape.entity.CustomTriangle;
import org.example.shape.validator.CustomTriangleValidator;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class CustomTriangleValidatorTest {

    @Test
    public void isDoubleValueTrueTest(){
        String value = "3.1415";

        boolean expected = true;
        boolean actual = CustomTriangleValidator.isDoubleValue(value);

        Assert.assertEquals(expected,actual);
    }

    @Test
    public void isDoubleValueFalseTest(){
        String value = "Hello world";

        boolean expected = false;
        boolean actual = CustomTriangleValidator.isDoubleValue(value);

        Assert.assertEquals(expected,actual);
    }

    @Test
    public void isListCorrectEmptyTest(){
        List<String> arrayList = new ArrayList<>();

        boolean expected = false;
        boolean actual = CustomTriangleValidator.isListCorrect(arrayList);

        Assert.assertEquals(expected,actual);
    }

    @Test
    public void isListCorrectNullTest(){
        List<String> arrayList = null;

        boolean expected = false;
        boolean actual = CustomTriangleValidator.isListCorrect(arrayList);

        Assert.assertEquals(expected,actual);
    }

    @Test
    public void isListCorrectTrueTest(){
        List<String> arrayList = new ArrayList<>();

        arrayList.add("Hello world");

        boolean expected = true;
        boolean actual = CustomTriangleValidator.isListCorrect(arrayList);

        Assert.assertEquals(expected,actual);
    }

    @Test
    public void isDoubleValuesTrueTest(){
        String line = "3.5,2.12,12.7";

        boolean expected = true;
        boolean actual = CustomTriangleValidator.isDoublesValues(line);

        Assert.assertEquals(expected,actual);
    }

    @Test
    public void isDoubleValuesFalseTest(){
        String line = "not double values";

        boolean expected = false;
        boolean actual = CustomTriangleValidator.isDoublesValues(line);

        Assert.assertEquals(expected,actual);
    }
}

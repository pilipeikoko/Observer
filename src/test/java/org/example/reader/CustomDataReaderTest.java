package org.example.reader;

import org.epam.shape.exception.CustomException;
import org.epam.shape.reader.CustomDataReader;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;

public class CustomDataReaderTest {

    @Test(expectedExceptions = CustomException.class)
    public void incorrectPathTest() throws CustomException {
        CustomDataReader reader = new CustomDataReader();

        String incorrectPath = "incorrectPath";

        reader.readDataFromFile(incorrectPath);
    }

    @Test
    public void correctReaderTest() throws CustomException {
        List<String> expectedList = Arrays.asList(
                "2.5 6.2 3.5 7",
                "line",
                "0 4 6 4 2.4"
        );

        CustomDataReader dataReader = new CustomDataReader();

        String path = "src/test/resources/data/test1.txt";

        List<String> actualList = dataReader.readDataFromFile(path);

        Assert.assertEquals(expectedList,actualList);
    }
}

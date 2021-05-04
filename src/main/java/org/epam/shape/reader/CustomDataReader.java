package org.epam.shape.reader;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.epam.shape.exception.CustomException;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CustomDataReader {
    private static final Logger LOGGER = LogManager.getLogger();

    public CustomDataReader() {

    }

    public List<String> readDataFromFile(String nameOfFile) throws CustomException {
        List<String> result;

        Path path = Paths.get(nameOfFile);


        if (Files.notExists(path)) {
            LOGGER.warn("File doesn't exist: " + path);
            throw new CustomException("File not found");
        }

        try (Stream<String> strings = Files.lines(path)) {
            result = strings.collect(Collectors.toList());
        } catch (IOException e) {
            LOGGER.warn("Couldn't read data from file: " + e.getMessage());
            throw new CustomException("Couldn't read from file");
        }

        LOGGER.info("File is read: " + result.toString());
        return result;
    }
}

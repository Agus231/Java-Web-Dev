package edu.epam.first.reader;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class SphereFileReader {
    private static final Logger logger = LogManager.getLogger();

    public List<String> readAll(String path) {
        try(Stream<String> stream = Files.lines(Paths.get(path))){
            return stream.collect(Collectors.toList());
        } catch (IOException e){
            logger.fatal("Impossible to read file: " + path, e);
            throw new RuntimeException("File can't be read.", e);
        }
    }

    public List<String> readAll(File file) {
        return readAll(file.getAbsolutePath());
    }
}

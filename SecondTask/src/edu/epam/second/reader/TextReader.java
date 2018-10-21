package edu.epam.second.reader;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class TextReader {
    private static final Logger logger = LogManager.getLogger();

    //todo: read question
    public String fileToString(String filePath){
        StringBuilder contentBuilder = new StringBuilder();
        try (Stream<String> stream = Files.lines(Paths.get(filePath))) {
            stream.forEach(s -> contentBuilder.append(s).append("\n"));
        }
        catch (IOException e) {
            logger.fatal("Can't find file: " + filePath, e);
            throw new RuntimeException("Impossible to read file: " + filePath, e);
        }
        return contentBuilder.toString();
    }

    public String fileToString(File file){
        return fileToString(file.getAbsolutePath());
    }
}

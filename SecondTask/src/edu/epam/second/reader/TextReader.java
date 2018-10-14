package edu.epam.second.reader;

import edu.epam.second.localiztion.ResourceManager;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class TextReader {
    private ResourceManager manager = ResourceManager.INSTANCE;

    public String readFileToString(String path){
        String result = "";
        List<String> lines;
        try (Stream<String> stringStream = Files.lines(Paths.get(path))){
            lines = stringStream.collect(Collectors.toList());
        } catch (IOException e) {
            throw new RuntimeException(manager.getString(ResourceManager.ERROR_KEY), e);
        }
        for (String line: lines) {
            result = result + line + '\n';
        }

        return result;
    }
}

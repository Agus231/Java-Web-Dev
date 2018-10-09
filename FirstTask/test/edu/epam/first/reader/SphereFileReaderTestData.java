package edu.epam.first.reader;

import org.testng.annotations.DataProvider;

import java.util.stream.Collectors;
import java.util.stream.Stream;

public class SphereFileReaderTestData {
    @DataProvider(name = "readAllData")
    public static Object[][] readAllData(){
        return new Object[][]{
                {"./data/input.txt", Stream.of("10 10 10 10",
                                                "10.5 10 10 10",
                                                "10 10.5 10 10",
                                                "10 10 10.5 10",
                                                "10.5 10.7 10.9 10",
                                                "-10.45 10 -10.5 15",
                                                "10 10 10 -20",
                                                "wasd 10 10 15",
                                                "10 wasd 10 15",
                                                "10 10 wasd 15",
                                                "wasd wasd wassd wad",
                                                "10.5 15 20 25 230",
                                                "10.34e+01 -20.4789E+03 10564.5e-3 20.6",
                                                "",
                                                "wasd",
                                                "12.5").collect(Collectors.toList())}
        };
    }
}

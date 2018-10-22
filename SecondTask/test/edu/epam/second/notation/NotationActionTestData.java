package edu.epam.second.notation;

import org.testng.annotations.DataProvider;

public class NotationActionTestData {
    @DataProvider(name = "dataNotationAction")
    public static Object[][] dataNotationAction(){
        return new Object[][]{
                {"13<<2", 52},
                {"(8^5|1&2<<(2|5>>2&71))|1200", 1213},
                {"3>>5", 0},
                {"6&9|(3&4)", 0},
                {"5|(1&2&(3|(4&(2^5|6&47)|3)|2)|1)", 5},
                {"(71&(2&3|(3|(2&1>>2|2)&2)|10&2))|78", 79}
        };
    }
}

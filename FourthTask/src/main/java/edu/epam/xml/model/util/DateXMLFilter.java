package edu.epam.xml.model.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateXMLFilter {
    private static final String DEFAULT_PATTERN = "yyyy-MM-dd";

    private static SimpleDateFormat dateFormat = new SimpleDateFormat(DEFAULT_PATTERN);

    private DateXMLFilter(){}

    public static void applyPattern(String pattern) {
        dateFormat.applyPattern(pattern);
    }

    public static Date parseDate(String date) throws ParseException {
        return dateFormat.parse(date);
    }
}

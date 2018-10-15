package edu.epam.second.localiztion;

import java.util.Locale;
import java.util.ResourceBundle;

public enum ResourceManager {
    INSTANCE;
    private ResourceBundle resourceBundle;
    private final String resourceName = "bundle";

    public static final String FIRST_SORT_KEY = "sort1";
    public static final String SECOND_SORT_KEY = "sort2";
    public static final String TEXT_KEY = "text";
    public static final String ERROR_KEY = "error";

    ResourceManager() {
        resourceBundle = ResourceBundle.getBundle(resourceName, Locale.getDefault());
    }

    public void changeResource(Locale locale) {
        resourceBundle = ResourceBundle.getBundle(resourceName, locale);
    }

    public String getString(String key) {
        return resourceBundle.getString(key);
    }
}

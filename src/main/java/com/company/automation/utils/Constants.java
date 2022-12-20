package com.company.automation.utils;

import java.io.File;

public class Constants {
    public static final String SEP = File.separator;
    public static final String USER_DIR = System.getProperty("user.dir");

    public static final String RESOURCES_MAIN_DIR = USER_DIR + SEP + "src" + SEP + "main" + SEP + "resources" + SEP;

    public static final String LOF4J2_PARALLEL_XML_FILE = RESOURCES_MAIN_DIR + "log4j2_parallel.xml";
    public static final String LOF4J2_SERIAL_XML_FILE = RESOURCES_MAIN_DIR + "log4j2_serial.xml";

    public static final String RESOURCES_TEST_DIR = USER_DIR + SEP + "src" + SEP + "test" + SEP + "resources" + SEP;

    public static final String RESOURCES_TEST_CONFIGURATIONS_DIR = RESOURCES_TEST_DIR + "Configurations" + SEP;
    public static final String TESTNG_SUITES_DIR = RESOURCES_TEST_DIR + "TestNGSuites" + SEP;
    public static final String DATA_DIR = RESOURCES_TEST_DIR + "DataRepository" + SEP;
    public static final String LOCATORS_DIR = RESOURCES_TEST_DIR + "Locators" + SEP;

    public static final String APPLICATION_LAUNCH_SUCCESSFUL = "Application URL \"%s\" opened successfully";
    public static final String APPLICATION_LAUNCH_FAILURE = "Application URL \"%s\" could not be opened due to exception: \"%s\"";

    public static final String ELEMENT_CLICK_SUCCESS = "Element \"%s\" clicked successfully";
    public static final String ELEMENT_CLICK_FAILURE = "Element \"%s\" could not be clicked due to exception: \"%s\"";

    public static final String ELEMENT_TEXT_ENTER_SUCCESS = "Text \"%s\" entered into element \"%s\" successfully";
    public static final String ELEMENT_TEXT_ENTER_FAILURE = "Text \"%s\" could not be entered into element \"%s\"  due to exception: \"%s\"";

    public static final String ELEMENT_PRESENT_SUCCESS = "Element \"%s\" found successfully";
    public static final String ELEMENT_PRESENT_FAILURE = "Element \"%s\" could not be found due to exception: \"%s\"";

    public static final String BROWSER_CLOSE_SUCCESS = "Browser closed successfully";
    public static final String BROWSER_CLOSE_FAILURE = "Browser could not be closed due to exception: \"%s\"";
}

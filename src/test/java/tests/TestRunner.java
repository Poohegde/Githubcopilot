package tests;

import org.testng.TestNG;
import org.testng.xml.XmlSuite;

import java.util.Collections;

public class TestRunner {
    public static void main(String[] args) {
        TestNG testNG = new TestNG();
        XmlSuite suite = new XmlSuite();
        suite.setName("AI Test Automation Suite");
        suite.setSuiteFiles(Collections.singletonList("src/test/resources/testng.xml"));
        testNG.setXmlSuites(Collections.singletonList(suite));
        testNG.run();
    }
}
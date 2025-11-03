package org.example;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import tools.jackson.core.type.TypeReference;
import tools.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.List;

public class Basetest {


    public WebDriver initiateDriver() {

        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();

        return driver;
    }

    public List<HashMap<String, String>> getJsonData(String jsonFilePath) throws IOException {

        String jsonContent= FileUtils.readFileToString(new File(jsonFilePath), StandardCharsets.UTF_8);

        ObjectMapper maper = new ObjectMapper();
        List<HashMap<String, String>> data = maper.readValue(jsonContent,new TypeReference<List<HashMap<String, String>>>(){});

        return data;

    }
}

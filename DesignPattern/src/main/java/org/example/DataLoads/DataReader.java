package org.example.DataLoads;

import org.apache.commons.io.FileUtils;
import tools.jackson.core.type.TypeReference;
import tools.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.List;

public class DataReader {

    public DataReader() throws IOException {

    }
    // convert json to json String

   /* File file = new File("C:\\Users\\HP\\IdeaProjects\\DesignPattern\\src\\test\\java\\org\\example\\DataLoads\\ReservationDetails.json"); // or give full path
    String data = FileUtils.readFileToString(file, StandardCharsets.UTF_8);*/

    //String jsonString = FileUtils.readFileToString(new File("ReservationDetails.json"), StandardCharsets.UTF_8);

    //ObjectMapper maper = new ObjectMapper();

    public List<HashMap<String, String>> getJsonData(String jsonFilePath) throws IOException {

        String jsonContent= FileUtils.readFileToString(new File("ReservationDetails.json"), StandardCharsets.UTF_8);

        ObjectMapper maper = new ObjectMapper();
        List<HashMap<String, String>> data = maper.readValue(jsonContent,new TypeReference<List<HashMap<String, String>>>(){});

        return data;

        }



}


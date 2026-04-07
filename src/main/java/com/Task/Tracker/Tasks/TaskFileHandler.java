package com.Task.Tracker.Tasks;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class TaskFileHandler {

    private final String PATH = "tasks.json";
    private final ObjectMapper mapper = new ObjectMapper();

    public void save(List<Task> tasks){
        try{
            mapper.writeValue(new File(PATH), tasks);
            System.out.println("Tasks saved in JSON file");
        } catch (IOException e) {
            System.out.println("Error in save: " + e.getMessage());
        }
    }

    public List<Task> load(){
        File file = new File(PATH);
        if (!file.exists()){ return new ArrayList<>(); }

        try{
            return mapper.readValue(file, new TypeReference<List<Task>>(){});
        } catch (IOException e){
            System.out.println("Error in load: " + e.getMessage());
            return new ArrayList<>();
        }
    }

}

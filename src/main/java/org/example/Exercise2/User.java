package org.example.Exercise2;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.*;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;


public class User {
    private String name;
    private int age;
    public User(String name, int age){
        this.name = name;
        this.age = age;
    }
    public String getName(){
        return name;
    }
    public int getAge() {
        return age;
    }
}


class processFile{
    public static void readWriteFile(String readFile, String writeFile){
        try (BufferedReader reader = new BufferedReader(new FileReader(readFile));
        BufferedWriter writer = new BufferedWriter(new FileWriter(writeFile))){
          String line;
          Gson gson = new GsonBuilder().setPrettyPrinting().create();
          reader.readLine();
          line = reader.readLine();
          List<User> users = new ArrayList<>();
          while (line != null){
            String[] columns = line.split(" ");
            User user = new User(columns[0], Integer.parseInt(columns[1]));
            users.add(user);
            line = reader.readLine();
          }
          String json = gson.toJson(users);
            writer.write(json);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
        readWriteFile("src/main/java/org/example/Exercise2/file.txt", "user.json");
    }
}
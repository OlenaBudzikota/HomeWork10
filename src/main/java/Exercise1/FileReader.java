package Exercise1;

import java.io.BufferedReader;
import java.io.IOException;

public class FileReader {
    public static boolean isValid(String input) {
        String regex1 = "\\(\\d{3}\\) \\d{3}-\\d{4}";
        String regex2 = "\\d{3}-\\d{3}-\\d{4}";
        return input.matches(regex1) || input.matches(regex2) ;
    }
    public static void main(String[] args) {
        BufferedReader reader;

        try {
            reader = new BufferedReader(new java.io.FileReader("src/main/java/Exercise1/file.txt"));
            String line = reader.readLine();

            while (line!= null){
                if (isValid(line)){
                    System.out.println(line);}
                line= reader.readLine();
            }

            reader.close();
        } catch (IOException e) {
            e.getMessage();
        }
    }
}
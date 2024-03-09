package Exercise3;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class WordsCounter {
    public static Map<String, Integer> countWordFrequency(String fileName) {
        StringBuilder fileDataInString = new StringBuilder();
        Map<String, Integer> sortedWords = new HashMap<>();
        try {
            BufferedReader br = new BufferedReader(new FileReader(fileName));
            int data;
            while ((data = br.read()) != -1){
                fileDataInString.append((char) data);
            }
            br.close();

            String[] wordArray = fileDataInString.toString().split("\\s+|\\n+ ");
            for (String word : wordArray) {
                sortedWords.put(word, sortedWords.getOrDefault(word, 0)+1);
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return sortedWords;
    }

    public static void main(String[] args) {
        Map<String, Integer> wordFrequency = countWordFrequency("src/main/java/Exercise3/words.txt");
        List<Map.Entry<String, Integer>> sortedList = new ArrayList<>(wordFrequency.entrySet());

        sortedList.sort((e1, e2) -> e2.getValue().compareTo(e1.getValue()));

        for(Map.Entry<String, Integer> entry : sortedList){
            System.out.println(entry.getKey() + " " + entry.getValue());
        }
    }
}
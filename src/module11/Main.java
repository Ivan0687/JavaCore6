package module11;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by root on 16.04.2017.
 */
public class Main {

    public static void main(String[] args) {

        // Task 1
        System.out.println(Task1.replacer(mapToReplace()));
        System.out.println();

        // Task 2
        System.out.println(Task2.fileContentReplacer(mapToReplace()));

        // Task 3
        Task3.fileContentMerger(mapToReplace());


        // Task 4
//        String word = "пробужденье";
//        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
//            System.out.println("Enter word to check");
//            word = reader.readLine();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        System.out.println("The word " + word + " occurs " + Task4.checkWord(word) + " times in file");

    }

    public static Map<String, String> mapToReplace() {
        Map<String, String> map = new HashMap<>();
        map.put("line", "string");
        map.put("should", "must");
        map.put("some", "certain");
        map.put("replace", "change");
        map.put("words", "information");
        map.put("using", "with");
        map.put("my", "own");
        map.put("method", "process");
        return map;
    }

    public static Map<String, String> mapToReplace1() {
        Map<String, String> map = new HashMap<>();
        map.put("string", "line");
        map.put("must", "should");
        map.put("certain", "some");
        map.put("change", "replace");
        map.put("information", "words");
        map.put("with", "using");
        map.put("own", "my");
        map.put("process", "method");
        return map;
    }

}

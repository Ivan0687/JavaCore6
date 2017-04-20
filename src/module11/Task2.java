package module11;

import java.io.*;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Created by root on 16.04.2017.
 */
public class Task2 {

    /* Task 2
    You should create method which replace words in the File and rewrite File content with new values
        a) read file, save to string var
        b) replace words
        c) rewrite file with string
    File fileContentReplacer(Map<String, String> map)
    */
    public static File fileContentReplacer(Map<String, String> map) {

        String pathname = "string.txt";
        String pathname1 = "string1.txt";
        File file = new File(pathname);
        File file1 = new File(pathname1);
        List<String> lines = null;

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            lines = reader.lines().collect(Collectors.toList());
        } catch (FileNotFoundException e) {
            System.out.println("File " + pathname + " is not found");
        } catch (IOException e) {
            System.out.println("Some I/O Exception");
        }

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file1))) {
            lines.forEach(line -> {
                try {
                    for (String key : map.keySet()) {
                        line = line.replaceAll(key, map.get(key));
                    }
                    writer.write(line);
                    writer.newLine();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });
        } catch (FileNotFoundException e) {
            System.out.println("File " + pathname1 + " is not found");
        } catch (IOException e) {
            System.out.println("Some I/O Exception");
        }

        return file1;
    }
}

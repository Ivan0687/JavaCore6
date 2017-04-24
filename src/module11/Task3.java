package module11;

import java.io.*;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Created by root on 16.04.2017.
 */
public class Task3 {

    /* Task 3
    You should create method which replace words in the File and write result to existing File content
        a) read file, save to string var
        b) replace words
        c) add string to the existing file content
    File fileContentMerger(Map<String, String> map)
     */
    public static File fileContentMerger(Map<String, String> map) {

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
                    writer.newLine();
                    writer.append(line);
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

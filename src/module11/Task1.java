package module11;

import java.io.*;
import java.util.Map;

/**
 * Created by root on 16.04.2017.
 */
public class Task1 {
    /* Task 1
    You should create method which replace words in the File and returns String with replaced values
        a) read file, save to string var
        b) replace words
        c) return new string
    String replacer(Map<String, String> map)
    */
    public static String replacer(Map<String, String> map) {
        String var = "";
        String pathname = "string.txt";

        try (BufferedReader reader = new BufferedReader(new FileReader(pathname))) {
            var = reader.readLine();
            for (String key : map.keySet()) {
                var = var.replaceAll(key, map.get(key));
            }
        } catch (FileNotFoundException e) {
            System.out.println("File " + pathname + " is not found");
        } catch (IOException e) {
            System.out.println("Some I/O Exception");
        }
        return var;
    }
}

package module11;

import java.io.*;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Created by root on 17.04.2017.
 */
public class Homework11 {

    static String pathname = "string3.txt";

    /* Task 1
   You should create method which replace words in the File and returns String with replaced values
       a) read file, save to string var
       b) replace words
       c) return new string
   String replacer(Map<String, String> map)
   */
    public static List<String> replacer(String pathname, Map<String, String> map) {

        List<String> var = getLinesFromFile(pathname);
        return replaceWordsInLines(var, map);
    }

    /* Task 2
    You should create method which replace words in the File and rewrite File content with new values
        a) read file, save to string var
        b) replace words
        c) rewrite file with string
    File fileContentReplacer(Map<String, String> map)
    */
    public static File fileContentReplacer(String pathname, Map<String, String> map) {

        List<String> lines = replacer(pathname, map);
        return writeLinesToFile(lines, pathname);
    }

    /* Task 3
    You should create method which replace words in the File and write result to existing File content
        a) read file, save to string var
        b) replace words
        c) add string to the existing file content
    File fileContentMerger(Map<String, String> map)
     */
    public static File fileContentMerger(String pathname, Map<String, String> map) {

        List<String> lines = replacer(pathname, map);
        return appendLinesToFile(lines, pathname);
    }

    /* Task 4
   Check if file contains particular word. Print 0 if no. Print number n which equals number of times it is contained in the file
       a) read file, save to string var
       b) calculate how many time the word occurs
       c) print result
   int checkWord(String word)
   Write this task with usual try and try with resources (two versions)
    */
    public static long checkWord(String pathname, String word) {

        return getLinesFromFile(pathname).stream()
                .filter(line -> line.toLowerCase().contains(word.toLowerCase()))
                .mapToLong(line -> Arrays
                        .stream(line.toLowerCase().split("[\\p{P} \\t\\n\\r]"))
                        .filter(s -> s.equals(word.toLowerCase()))
                        .count())
                .sum();
    }

    public static List<String> getLinesFromFile(String pathname) {

        List<String> lines = null;

        try (BufferedReader reader = new BufferedReader(new FileReader(pathname))) {
            lines = reader.lines().collect(Collectors.toList());
        } catch (FileNotFoundException e) {
            System.out.println("File " + pathname + " is not found");
        } catch (IOException e) {
            System.out.println("Some I/O Exception");
        }
        return lines;


    }

    // Без трая с ресурсами

    public static List<String> getLinesFromFileClassic(String pathname) {

        List<String> lines = null;
        FileReader fileReader = null;
        BufferedReader bufferedReader = null;
        try  {
            fileReader = new FileReader(pathname);
            bufferedReader = new BufferedReader(fileReader);
            lines = bufferedReader.lines().collect(Collectors.toList());
        } catch (FileNotFoundException e) {
            System.out.println("File " + pathname + " is not found");
        } finally {
            try {
                if (fileReader != null)
                    fileReader.close();
                if (bufferedReader != null)
                    bufferedReader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return lines;


    }


    public static List<String> replaceWordsInLines(List<String> lines, Map<String, String> map) {

        return lines.stream().map(line -> {
            for (String key : map.keySet()) {
                line = line.replaceAll(key, map.get(key));
            }
            return line;
        }).collect(Collectors.toList());

    }

    public static File writeLinesToFile(List<String> lines, String pathname) {
        File file = new File(pathname);
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
            lines.forEach(line -> {
                try {
                    writer.write(line);
                    writer.newLine();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });
        } catch (FileNotFoundException e) {
            System.out.println("File " + pathname + " is not found");
        } catch (IOException e) {
            System.out.println("Some I/O Exception");
        }
        return file;
    }

    public static File appendLinesToFile(List<String> lines, String pathname) {
        File file = new File(pathname);
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file, true))) {
            lines.forEach(line -> {
                try {
                    writer.newLine();
                    writer.write(line);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });
        } catch (FileNotFoundException e) {
            System.out.println("File " + pathname + " is not found");
        } catch (IOException e) {
            System.out.println("Some I/O Exception");
        }
        return file;
    }
}

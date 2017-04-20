package module11;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

/**
 * Created by root on 16.04.2017.
 */
public class Task4 {

    /* Task 4
    Check if file contains particular word. Print 0 if no. Print number n which equals number of times it is contained in the file
        a) read file, save to string var
        b) calculate how many time the word occurs
        c) print result
    int checkWord(String word)
    Write this task with usual try and try with resources (two versions)
     */
    public static int checkWord(String word) {
        long count = 0;
        String pathname = "poem.txt";

        BufferedReader bufferedReader = null;
        FileReader fileReader = null;

        try {
            fileReader = new FileReader(pathname);
            bufferedReader = new BufferedReader(fileReader);
            count = bufferedReader.lines()
                    .filter(line -> line.toLowerCase().contains(word.toLowerCase()))
                    .mapToLong(line -> Arrays
                            .stream(line.toLowerCase().split("[\\p{P} \\t\\n\\r]"))
                            .filter(s -> s.equals(word.toLowerCase()))
                            .count())
                    .sum();
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
        return (int) count;
    }

    public static int checkWordWithRes(String word) {
        long count = 0;
        String pathname = "poem.txt";

        try (BufferedReader reader = new BufferedReader(new FileReader(pathname))) {
            count = reader.lines()
                    .filter(line -> line.toLowerCase().contains(word.toLowerCase()))
                    .mapToLong(line -> Arrays
                            .stream(line.toLowerCase().split("[\\p{P} \\t\\n\\r]"))
                            .filter(s -> s.equals(word.toLowerCase()))
                            .count())
                    .sum();
        } catch (FileNotFoundException e) {
            System.out.println("File " + pathname + " is not found");
        } catch (IOException e) {
            System.out.println("Some I/O Exception");
        }

        return (int) count;
    }
}

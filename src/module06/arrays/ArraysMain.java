package module06.arrays;

import java.util.Arrays;

/**
 * Created by root on 06.03.2017.
 */
public class ArraysMain {

    public static void main(String[] args) {

        int[] array = new int[11];

        for (int i = 0; i < array.length; i++) {
            array[i] = i * 2 + 1;
        }

        int sumArray = ArraysUtils.sum(array);
        System.out.println("Sum = " + sumArray);

        int min = ArraysUtils.min(array);
        System.out.println("Min = " + min);

        int max = ArraysUtils.max(array);
        System.out.println("Max = " + max);

        int maxpositive = ArraysUtils.maxPositive(array);
        System.out.println("Max positive = " + maxpositive);

        int multiplication = ArraysUtils.multiplication(array);
        System.out.println("Multiplication = " + multiplication);

        int modulus = ArraysUtils.modulus(array);
        System.out.println("Modulus = " + modulus);

        int secondLargest = ArraysUtils.secondLargest(array);
        System.out.println("Second largest = " + secondLargest);

        int[] reverseArray = ArraysUtils.reverse(array);
        System.out.println("Reverse array = " + Arrays.toString(reverseArray));

        int[] evenElements = ArraysUtils.findEvenElements(array);
        System.out.println("Even elements = " + Arrays.toString(evenElements));

    }
}

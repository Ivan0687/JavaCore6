package module02;

import module06.ArraysUtils;

import java.util.Arrays;

/**
 * Created by root on 27.01.2017.
 */
public class Homework1 {

    public static void main(String[] args) {

        int[] array = new int[10];

        for (int i = 0; i < array.length; i++) {
            array[i] = i + 1;
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

    private static int sum (int array[]){

        int sum = 0;

        for (int arrayElement : array) {
            sum += arrayElement;
        }

        return sum;
    }

    private static int min (int array[]){

        int min = array[0];

        for (int arrayElement : array) {
            min = min > arrayElement ? arrayElement : min;
        }

        return min;
    }

    private static int max (int array[]){

        int max = array[0];

        for (int arrayElement : array) {
            max = max < arrayElement ? arrayElement : max;

        }

        return max;
    }

    private static int maxPositive (int array[]){

        int max = 0;

        for (int arrayElement : array) {
            if (arrayElement > 0)
                max = max < arrayElement ? arrayElement : max;
        }

        return max;
    }

    private static int multiplication (int array[]){

        int multi = 1;

        for (int arrayElement : array) {
            multi *= arrayElement;
        }

        return multi;
    }

    private static int modulus (int array[]){
        // если последний элемент равен нулю будет ошибка. Можно ее ловить или ставить условия

        return array[0] % array[array.length - 1];
    }

    private static int secondLargest (int array[]){

        // можно отсортировать массив, но у нас же задание только найти второй наибольший элемент

        int secondLargest = array[0] < array[1] ? array[0] : array[1];
        int max = array[0] > array[1] ? array[0] : array[1];

        for (int i = 2; i < array.length; i++) {

            if (array[i]> max){
                secondLargest = max;
                max = array[i];
            } else {
                if (array[i] > secondLargest && max > array[i])
                    secondLargest = array[i];
            }
        }

        return secondLargest;
    }


}

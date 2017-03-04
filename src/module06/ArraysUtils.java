package module06;

import java.util.Arrays;

/**
 * Created by root on 04.03.2017.
 */
public final class ArraysUtils {

    private ArraysUtils() {
    }

    public static int sum (int array[]){

        int sum = 0;

        for (int arrayElement : array) {
            sum += arrayElement;
        }

        return sum;
    }

    public static int min (int array[]){

        int min = array[0];

        for (int arrayElement : array) {
            min = min > arrayElement ? arrayElement : min;
        }

        return min;
    }

    public static int max (int array[]){

        int max = array[0];

        for (int arrayElement : array) {
            max = max < arrayElement ? arrayElement : max;

        }

        return max;
    }

    public static int maxPositive (int array[]){

        int max = 0;

        for (int arrayElement : array) {
            if (arrayElement > 0)
                max = max < arrayElement ? arrayElement : max;
        }

        return max;
    }

    public static int multiplication (int array[]){

        int multi = 1;

        for (int arrayElement : array) {
            multi *= arrayElement;
        }

        return multi;
    }

    public static int modulus (int array[]){

        return array[0] % array[array.length - 1];
    }

    public static int secondLargest (int array[]){

        if (array.length == 1)
            return array[0];

        int secondLargest = array[0] < array[1] ? array[0] : array[1];
        int max = array[0] > array[1] ? array[0] : array[1];

        for (int i = 2; i < array.length; i++) {

            if (array[i]> max){
                secondLargest = max;
                max = array[i];

            } else if (array[i] > secondLargest && array[i] != max)
                secondLargest = array[i];
        }
        return secondLargest;
    }


    public static int[] reverse(int[] array){

        int[] reverseArray = new int[array.length];

        for (int i = 0; i <= array.length/2; i++) {

            reverseArray[i] = array[array.length - i - 1];
            reverseArray[array.length - i - 1] = array[i];
        }

        return reverseArray;
    }

    public static int[] findEvenElements(int[] array){

        int[] evens = new int[1];
        int count = 0;

        for (int anArray : array) {

            if (anArray % 2 == 0) {
                count++;
                evens = Arrays.copyOf(evens, count);
                evens[evens.length - 1] = anArray;
            }
        }
        return evens;
    }

}

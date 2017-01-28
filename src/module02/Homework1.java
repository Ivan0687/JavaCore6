package module02;

/**
 * Created by root on 27.01.2017.
 */
public class Homework1 {

    public static void main(String[] args) {

        int[] myArray = new int[10];

        sum(myArray);
        min(myArray);
        max(myArray);
        maxPositive(myArray);
        multiplication(myArray);
        modulus(myArray);
        secondLargest(myArray);

    }

    private static int sum (int array[]){

        int sum = 0;

        for (int i : array) {
            sum += i;
        }

        return sum;
    }

    private static int min (int array[]){

        int min = array[0];

        for (int i : array) {
            min = min > i ? i : min;
        }

        return min;
    }

    private static int max (int array[]){

        int max = array[0];

        for (int i : array) {
            max = max < i ? i : max;

        }

        return max;
    }

    private static int maxPositive (int array[]){

        int max = 0;

        for (int i : array) {
            if (i > 0)
                max = max < i ? i : max;
        }

        return max;
    }

    private static int multiplication (int array[]){

        int multi = 1;

        for (int i : array) {
            multi *= i;
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

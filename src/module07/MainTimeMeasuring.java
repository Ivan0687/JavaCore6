package module07;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * Created by root on 09.03.2017.
 */
public class MainTimeMeasuring {

    public static void main(String[] args) {

        ArrayList<Integer> intArrayList1000 = new ArrayList<>();
        ArrayList<String> stringArrayList1000 = new ArrayList<>();

        ArrayList<Integer> intArrayList10000 = new ArrayList<>();
        ArrayList<String> stringArrayList10000 = new ArrayList<>();

        LinkedList<Integer> intLinkedList1000 = new LinkedList<>();
        LinkedList<String> stringLinkedList1000 = new LinkedList<>();

        LinkedList<Integer> intLinkedList10000 = new LinkedList<>();
        LinkedList<String> stringLinkedList10000 = new LinkedList<>();

        long start, finish;

        //Generating 1000
        System.out.println("Generate ArrayList and LinkedList with 1000 elements:");
        System.out.println("Integer");
        start = System.nanoTime();
        for (int i = 0; i < 1000; i++) {
            intArrayList1000.add(i);
        }
        finish = System.nanoTime();
        System.out.println("ArrayList = " + (finish - start) + " nano seconds");

        start = System.nanoTime();
        for (int i = 0; i < 1000; i++) {
            intLinkedList1000.add(i);
        }
        finish = System.nanoTime();
        System.out.println("LinkedList = " + (finish - start) + " nano seconds");

        System.out.println("String:");
        start = System.nanoTime();
        for (int i = 0; i < 1000; i++) {
            stringArrayList1000.add("" + i);
        }
        finish = System.nanoTime();
        System.out.println("ArrayList = " + (finish - start) + " nano seconds");

        start = System.nanoTime();
        for (int i = 0; i < 1000; i++) {
            stringLinkedList1000.add("" + i);
        }
        finish = System.nanoTime();
        System.out.println("LinkedList = " + (finish - start) + " nano seconds");
        System.out.println();


        //Generating 10000
        System.out.println("Generate ArrayList and LinkedList with 10000 elements:");
        System.out.println("Integer");
        start = System.nanoTime();
        for (int i = 0; i < 10000; i++) {
            intArrayList10000.add(i);
        }
        finish = System.nanoTime();
        System.out.println("ArrayList = " + (finish - start) + " nano seconds");

        start = System.nanoTime();
        for (int i = 0; i < 10000; i++) {
            intLinkedList10000.add(i);
        }
        finish = System.nanoTime();
        System.out.println("LinkedList = " + (finish - start) + " nano seconds");

        System.out.println("String:");
        start = System.nanoTime();
        for (int i = 0; i < 10000; i++) {
            stringArrayList10000.add("" + i);
        }
        finish = System.nanoTime();
        System.out.println("ArrayList = " + (finish - start) + " nano seconds");

        start = System.nanoTime();
        for (int i = 0; i < 10000; i++) {
            stringLinkedList10000.add("" + i);
        }
        finish = System.nanoTime();
        System.out.println("LinkedList = " + (finish - start) + " nano seconds");
        System.out.println();

        // Add to 1000
        System.out.println("Execution of method add to ArrayList and LinkedList with 1000 elements:");
        System.out.println("Integer");
        start = System.nanoTime();
            intArrayList1000.add(0);
        finish = System.nanoTime();
        System.out.println("ArrayList = " + (finish - start) + " nano seconds");

        start = System.nanoTime();
            intLinkedList1000.add(0);
        finish = System.nanoTime();
        System.out.println("LinkedList = " + (finish - start) + " nano seconds");

        System.out.println("String:");
        start = System.nanoTime();
            stringArrayList1000.add("0");
        finish = System.nanoTime();
        System.out.println("ArrayList = " + (finish - start) + " nano seconds");

        start = System.nanoTime();
            stringLinkedList1000.add("0");
        finish = System.nanoTime();
        System.out.println("LinkedList = " + (finish - start) + " nano seconds");
        System.out.println();

        // Add to 10000
        System.out.println("Execution of method add to ArrayList and LinkedList with 10000 elements:");
        System.out.println("Integer");
        start = System.nanoTime();
            intArrayList10000.add(0);
        finish = System.nanoTime();
        System.out.println("ArrayList = " + (finish - start) + " nano seconds");

        start = System.nanoTime();
            intLinkedList10000.add(0);
        finish = System.nanoTime();
        System.out.println("LinkedList = " + (finish - start) + " nano seconds");

        System.out.println("String:");
        start = System.nanoTime();
            stringArrayList10000.add("0");
        finish = System.nanoTime();
        System.out.println("ArrayList = " + (finish - start) + " nano seconds");

        start = System.nanoTime();
            stringLinkedList10000.add("0");
        finish = System.nanoTime();
        System.out.println("LinkedList = " + (finish - start) + " nano seconds");
        System.out.println();

// Set to 1000
        System.out.println("Execution of method set to ArrayList and LinkedList with 1000 elements:");
        System.out.println("Integer");
        start = System.nanoTime();
            intArrayList1000.set(500, 0);
        finish = System.nanoTime();
        System.out.println("ArrayList = " + (finish - start) + " nano seconds");

        start = System.nanoTime();
            intLinkedList1000.set(500, 0);
        finish = System.nanoTime();
        System.out.println("LinkedList = " + (finish - start) + " nano seconds");

        System.out.println("String:");
        start = System.nanoTime();
            stringArrayList1000.set(500, "0");
        finish = System.nanoTime();
        System.out.println("ArrayList = " + (finish - start) + " nano seconds");

        start = System.nanoTime();
            stringLinkedList1000.set(500, "0");
        finish = System.nanoTime();
        System.out.println("LinkedList = " + (finish - start) + " nano seconds");
        System.out.println();

        // Set to 10000
        System.out.println("Execution of method set to ArrayList and LinkedList with 10000 elements:");
        System.out.println("Integer");
        start = System.nanoTime();
            intArrayList10000.set(5000, 0);
        finish = System.nanoTime();
        System.out.println("ArrayList = " + (finish - start) + " nano seconds");

        start = System.nanoTime();
            intLinkedList10000.set(5000, 0);
        finish = System.nanoTime();
        System.out.println("LinkedList = " + (finish - start) + " nano seconds");

        System.out.println("String:");
        start = System.nanoTime();
            stringArrayList10000.set(5000, "0");
        finish = System.nanoTime();
        System.out.println("ArrayList = " + (finish - start) + " nano seconds");

        start = System.nanoTime();
            stringLinkedList10000.set(5000, "0");
        finish = System.nanoTime();
        System.out.println("LinkedList = " + (finish - start) + " nano seconds");
        System.out.println();

// Get of 1000
        System.out.println("Execution of method get of ArrayList and LinkedList with 1000 elements:");
        System.out.println("Integer");
        start = System.nanoTime();
            intArrayList1000.get(500);
        finish = System.nanoTime();
        System.out.println("ArrayList = " + (finish - start) + " nano seconds");

        start = System.nanoTime();
            intLinkedList1000.get(500);
        finish = System.nanoTime();
        System.out.println("LinkedList = " + (finish - start) + " nano seconds");

        System.out.println("String:");
        start = System.nanoTime();
            stringArrayList1000.get(500);
        finish = System.nanoTime();
        System.out.println("ArrayList = " + (finish - start) + " nano seconds");

        start = System.nanoTime();
            stringLinkedList1000.get(500);
        finish = System.nanoTime();
        System.out.println("LinkedList = " + (finish - start) + " nano seconds");
        System.out.println();

        // Get of 10000
        System.out.println("Execution of method get of ArrayList and LinkedList with 10000 elements:");
        System.out.println("Integer");
        start = System.nanoTime();
            intArrayList10000.get(5000);
        finish = System.nanoTime();
        System.out.println("ArrayList = " + (finish - start) + " nano seconds");

        start = System.nanoTime();
            intLinkedList10000.get(5000);
        finish = System.nanoTime();
        System.out.println("LinkedList = " + (finish - start) + " nano seconds");

        System.out.println("String:");
        start = System.nanoTime();
            stringArrayList10000.get(5000);
        finish = System.nanoTime();
        System.out.println("ArrayList = " + (finish - start) + " nano seconds");

        start = System.nanoTime();
            stringLinkedList10000.get(5000);
        finish = System.nanoTime();
        System.out.println("LinkedList = " + (finish - start) + " nano seconds");
        System.out.println();

        // Remove from 1000
        System.out.println("Execution of method remove from ArrayList and LinkedList with 1000 elements:");
        System.out.println("Integer");
        start = System.nanoTime();
            intArrayList1000.remove(500);
        finish = System.nanoTime();
        System.out.println("ArrayList = " + (finish - start) + " nano seconds");

        start = System.nanoTime();
            intLinkedList1000.remove(500);
        finish = System.nanoTime();
        System.out.println("LinkedList = " + (finish - start) + " nano seconds");

        System.out.println("String:");
        start = System.nanoTime();
            stringArrayList1000.remove(500);
        finish = System.nanoTime();
        System.out.println("ArrayList = " + (finish - start) + " nano seconds");

        start = System.nanoTime();
            stringLinkedList1000.remove(500);
        finish = System.nanoTime();
        System.out.println("LinkedList = " + (finish - start) + " nano seconds");
        System.out.println();

        // remove from 10000
        System.out.println("Execution of method remove from ArrayList and LinkedList with 10000 elements:");
        System.out.println("Integer");
        start = System.nanoTime();
            intArrayList10000.remove(5000);
        finish = System.nanoTime();
        System.out.println("ArrayList = " + (finish - start) + " nano seconds");

        start = System.nanoTime();
            intLinkedList10000.remove(5000);
        finish = System.nanoTime();
        System.out.println("LinkedList = " + (finish - start) + " nano seconds");

        System.out.println("String:");
        start = System.nanoTime();
            stringArrayList10000.remove(5000);
        finish = System.nanoTime();
        System.out.println("ArrayList = " + (finish - start) + " nano seconds");

        start = System.nanoTime();
            stringLinkedList10000.remove(5000);
        finish = System.nanoTime();
        System.out.println("LinkedList = " + (finish - start) + " nano seconds");
        System.out.println();


    }

}

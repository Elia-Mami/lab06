package it.unibo.collections;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * Example class using {@link List} and {@link Map}.
 *
 */
public final class UseListsAndMaps {

    private static final int ELEMS = 100_000;

    private UseListsAndMaps() {
    }

    

    /**
     * @param s
     *            unused
     */
    public static void main(final String... s) {
        /*
         * 1) Create a new ArrayList<Integer>, and populate it with the numbers
         * from 1000 (included) to 2000 (excluded).
         */
        ArrayList<Integer> arrayList = new ArrayList<>(1000);
        for(int i = 1000; i < 2000; i++){
            arrayList.add(i);
        }

        /*
         * 2) Create a new LinkedList<Integer> and, in a single line of code
         * without using any looping construct (for, while), populate it with
         * the same contents of the list of point 1.
         */
        LinkedList<Integer> linkedList = new LinkedList<>();
        for(int i = 1000; i < 2000; i++){
            linkedList.add(i);
        }

        /*
         * 3) Using "set" and "get" and "size" methods, swap the first and last
         * element of the first list. You can not use any "magic number".
         * (Suggestion: use a temporary variable)
         */
        int tmp = arrayList.get(0);
        arrayList.set(0, arrayList.get(arrayList.size()-1));
        arrayList.set(arrayList.size()-1, tmp);

        /*
         * 4) Using a single for-each, print the contents of the arraylist.
         */
        for (Integer currentElement : arrayList) {
            System.out.println("Current int from arrayList: " + currentElement);
        }

        /*
         * 5) Measure the performance of inserting new elements in the head of
         * the collection: measure the time required to add 100.000 elements as
         * first element of the collection for both ArrayList and LinkedList,
         * using the previous lists. In order to measure times, use as example
         * TestPerformance.java.
         */
        long time = System.nanoTime();
        for (int i = 1; i <= ELEMS; i++) {
            arrayList.addFirst(i);
        }
        time = System.nanoTime() - time;
        var millis = TimeUnit.NANOSECONDS.toMillis(time);
        System.out.println(
        "Adding 100_000 element to ArrayList took "
            + time
            + "ns ("
            + millis
            + "ms)"
        );
        
        time = System.nanoTime();
        for (int i = 1; i <= ELEMS; i++) {
            linkedList.addFirst(i);
        }
        time = System.nanoTime() - time;
        millis = TimeUnit.NANOSECONDS.toMillis(time);
        System.out.println(
        "Adding 100_000 element to linkedList took "
            + time
            + "ns ("
            + millis
            + "ms)"
        );

        /*
         * 6) Measure the performance of reading 1000 times an element whose
         * position is in the middle of the collection for both ArrayList and
         * LinkedList, using the collections of point 5. In order to measure
         * times, use as example TestPerformance.java.
         */

        time = System.nanoTime();
        for (int i = 0; i <= 1000; i++) {
            arrayList.get(arrayList.size()/2);
        }
        time = System.nanoTime() - time;
        millis = TimeUnit.NANOSECONDS.toMillis(time);
        System.out.println(
        "Adding 100_000 element to ArrayList took "
            + time
            + "ns ("
            + millis
            + "ms)"
        );
        
        time = System.nanoTime();
        for (int i = 0; i <= 1000; i++) {
            linkedList.get(linkedList.size()/2);
        }
        time = System.nanoTime() - time;
        millis = TimeUnit.NANOSECONDS.toMillis(time);
        System.out.println(
        "Adding 100_000 element to linkedList took "
            + time
            + "ns ("
            + millis
            + "ms)"
        );

        /*
         * 7) Build a new Map that associates to each continent's name its
         * population:
         *
         * Africa -> 1,110,635,000
         *
         * Americas -> 972,005,000
         *
         * Antarctica -> 0
         *
         * Asia -> 4,298,723,000
         *
         * Europe -> 742,452,000
         *
         * Oceania -> 38,304,000
         */

        Map<String, Long> map = new HashMap<String,Long>();
        map.put("Africa", 1110635000L);
        map.put("Americas", 1110635000L);
        map.put("Antarctica", 0L);
        map.put("Asia", 4298723000L);
        map.put("Europe", 742452000L);
        map.put("Oceania", 38304000L);


        /*
         * 8) Compute the population of the world
         */
        time = System.nanoTime();
        long population = 0L;
        for(Long currentPopulation : map.values()){
            population += currentPopulation;
        }
        time = System.nanoTime() - time;
        millis = TimeUnit.NANOSECONDS.toMillis(time);
        System.out.println(
        "Adding 100_000 element to linkedList took "
            + time
            + "ns ("
            + millis
            + "ms). World population is "
            + population
        );
    }
}

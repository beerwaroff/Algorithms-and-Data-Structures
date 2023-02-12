package org.beerwaroff.Algorithms;

public class Search {

    public static int binarySearch(int[] array, int key) {
        int low = 0;
        int high = array.length - 1;
        int middle;

        while (low <= high) {
            middle = low + (high - low) / 2;
            if (key > array[middle]) low = middle + 1;
            else if (key < array[middle]) high = middle - 1;
            else return middle;
        }

        return -1;
    }
}

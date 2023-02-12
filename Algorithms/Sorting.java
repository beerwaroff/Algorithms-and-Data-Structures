package org.beerwaroff.Algorithms;


public class Sorting {
    public void bubble(int[] array) {
        boolean sorted = false;
        while (!sorted) {
            sorted = true;
            for (int i = 1; i < array.length; i++) {
                if (array[i] < array[i-1]) {
                    swap(array, i-1, i );
                    sorted = false;
                }
            }
        }
    }
    private void swap(int[] array, int index1, int index2) {
        int temp = array[index1];
        array[index1] = array[index2];
        array[index2] = temp;
    }
}

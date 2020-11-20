package ru.vsu.num6.GUI.model;

public class Model {

    public static int getSumOfElements(int[] array) {
        int sumElements = 0;
        int maxIndex = findLargestValueOfArray(array);
        int minIndex = findMinimumValueOfArray(array);

        for (int i = maxIndex + 1; i < minIndex; i++) {
            sumElements += array[i];
        }
        return sumElements;
    }

    private static int findLargestValueOfArray(int[] array) {
        int maxIndex = 0;

        for (int i = 0; i < array.length; i++) {
            if (array[i] > array[maxIndex]) {
                maxIndex = i;
            }
        }
        return maxIndex;
    }

    private static int findMinimumValueOfArray(int[] array) {
        int minIndex = 0;

        for (int i = 0; i < array.length; i++) {
            if (array[i] < array[minIndex]) {
                minIndex = i;
            }
        }
        return minIndex;
    }
}

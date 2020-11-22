package ru.vsu.num6.console;

import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

public class MainConsole {

    public static void main(String[] args) {
        startProgram();
    }

    private static void startProgram() {
        try {
            System.out.println("PROGRAM");
            int sizeArray = readInteger("size array --> ");
            int[] array = new int[sizeArray];
            fillArrayWithValues(sizeArray, array);
            printResults(
                    findMinimumValueOfArray(array), findLargestValueOfArray(array),
                    calculateSumOfElements(findMinimumValueOfArray(array), findLargestValueOfArray(array), array),
                    array
            );
        } catch (InputMismatchException | NegativeArraySizeException e) {
            System.out.println(
                    "An error has occurred! You may have entered a negative array size or an invalid character."
            );
        }
    }

    private static int calculateSumOfElements(int minIndex, int maxIndex, int[] array) {
        int sumElements = 0;

        for (int i = maxIndex + 1; i < minIndex; i++) {
            sumElements += array[i];
        }
        return sumElements;
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

    private static int findLargestValueOfArray(int[] array) {
        int maxIndex = 0;

        for (int i = 0; i < array.length; i++) {
            if (array[i] > array[maxIndex]) {
                maxIndex = i;
            }
        }
        return maxIndex;
    }

    private static void fillArrayWithValues(int sizeArray, int[] array) {
        for (int i = 0; i < sizeArray; i++) {
            array[i] = readInteger("put integers into array --> ");
        }
    }

    private static void printTest(int calc, int rightSum, boolean checkResult) {
        System.out.printf("Calculated amount: %d; Correct amount: %d; Result: %b\n", calc, rightSum, checkResult);
        System.out.println("-----------");
    }

    private static void printResults(int minIndex, int maxIndex, int sumElements, int[] array) {
        String arr = Arrays.toString(array);
        System.out.println("Injected array: " + arr + "\n");

        if (maxIndex > minIndex) {
            System.out.println("The maximum element runs after the smallest element. Try again.");
        } else if (minIndex > maxIndex) {
            System.out.printf(
                    "Sum of elements between the last minimum element and the first maximum: %d \n", sumElements
            );
        }
    }

    private static int readInteger(String phrase) {
        Scanner scanner = new Scanner(System.in);
        System.out.printf("Enter %s", phrase);
        return scanner.nextInt();
    }
}

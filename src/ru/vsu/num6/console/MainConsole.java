package ru.vsu.num6.console;

import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

public class MainConsole {

    public static void main(String[] args) {
        if (test()) {
            startProgram();
        } else {
            System.out.println("The tests did not work correctly. The program will not start.");
        }
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

    private static boolean test() {
        boolean result = true;

        TestCase[] testCases = new TestCase[]{
                new TestCase(new int[]{1000, 2, 3, 4, 0}, 9), //1
                new TestCase(new int[]{0, 15, 1700, 121, 74, 197, 1600, -10, 0, -1}, 1992), //2
                new TestCase(new int[]{0, 1, 2, 3, 4}, 0), //3
                new TestCase(new int[]{10, 10, 10, 10, 10}, 0), //4
                new TestCase(new int[]{0, 1500, 0, -10, 115, -1548, -10500}, -1443), //5
                new TestCase(new int[]{154, 2, -1051, 5, 10}, 2), //6
                new TestCase(new int[]{10, 0, 1, 2, 3, 4, 5, -1}, 15), //7
                new TestCase(new int[]{-10, 2, 3, 40, -20}, 0), //8
                new TestCase(new int[]{0, -1, 0, -2, 0}, -1), //9
                new TestCase(new int[]{10, 9, 8, 7, 6, 5, 4, 3, 2, 1, 0}, 45), //10
        };

        for (int i = 0; i < testCases.length; i++) {
            TestCase testing = testCases[i];

            int calc = calculateSumOfElements(findMinimumValueOfArray(testing.getArray()),
                    findLargestValueOfArray(testing.getArray()), testing.getArray());
            int rightSum = testing.getSum();

            boolean check = checkResult(calc, rightSum);
            result = check && result;

            printTest(calc, rightSum, result);
        }
        return result;
    }

    private static boolean checkResult(int calc, int rightSum) {
        return calc == rightSum;
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
